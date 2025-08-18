package engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.UUID;
import java.util.function.BiPredicate;

import engine.objects.IObject;
import engine.operation.COLOR;
import engine.operation.CURVE;
import engine.operation.FILL_COLOR;
import engine.operation.LINE;
import engine.operation.MOVE;
import engine.operation.SMALL_CURVE;
import engine.operation.iterfaces.IOperation;

public class Painter {
    private double currentX = 0;
    private double currentY = 0;
    private double startX = 0;
    private double startY = 0;
    private double lastControlX = 0;
    private double lastControlY = 0;
    public boolean visible = true;

    private final List<IOperation> stroke_plans;
    private final List<FILL_COLOR> fill_plans;

    private final BufferedImage canvasImage;
    private final Graphics2D g2d;
    private final int width;
    private final int height;

    public Painter(
            int width,
            int height,
            List<IOperation> stroke_plans,
            List<FILL_COLOR> fill_plans
    //
    ) {
        this(width, height, stroke_plans, fill_plans, new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB));
    }

    public Painter(
            int width,
            int height,
            List<IOperation> stroke_plans,
            List<FILL_COLOR> fill_plans,
            BufferedImage image
    //
    ) {
        this.width = width;
        this.height = height;
        this.stroke_plans = stroke_plans;
        this.fill_plans = fill_plans;
        this.canvasImage = image;
        this.g2d = this.canvasImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    }

    public void clear() {
        g2d.setColor(java.awt.Color.WHITE);
        g2d.fillRect(0, 0, canvasImage.getWidth(), canvasImage.getHeight());
    }

    public void draw(IObject object) {
        if (object.isVisible()) {
            object.render(g2d);
        }
    }

    public Graphics2D getGraphics() {
        return g2d;
    }

    public void dispose() {
        g2d.dispose();
    }

    public void dot(double cx, double cy, double size) {
        g2d.fillRect((int) cx - 2, (int) cy - 2, 4, 4);
    }

    public void line(
            double x1,
            double y1,
            double x2,
            double y2,
            double strokeWidth
    //
    ) {
        double dx = Math.abs(x2 - x1);
        double dy = Math.abs(y2 - y1);
        double sx = (x1 < x2) ? 1 : -1;
        double sy = (y1 < y2) ? 1 : -1;

        boolean swap = false;
        if (dy > dx) {
            double temp = dx;
            dx = dy;
            dy = temp;
            swap = true;
        }
        double D = 2 * dy - dx;
        double x = x1;
        double y = y1;

        for (int i = 0; i < dx; i++) {
            dot(x, y, strokeWidth);
            while (D >= 0) {
                if (swap)
                    x += sx;
                else
                    y += sy;
                D -= 2 * dx;
            }
            if (swap)
                y += sy;
            else
                x += sx;
            D += 2 * dy;
        }
        dot(x2, y2, strokeWidth);
    }

    public void bezier(
            double x1,
            double y1,
            double x2,
            double y2,
            double x3,
            double y3,
            double x4,
            double y4,
            double strokeWidth
    //
    ) {
        double length = Math.hypot(x1 - x2, y1 - y2) + Math.hypot(x2 - x3, y2 - y3) +
                Math.hypot(x3 - x4, y3 - y4);
        int steps = Math.max(1, (int) Math.round(length));

        for (int i = 0; i <= steps; i++) {
            double t = (double) i / steps;
            double v = 1 - t;
            double xt = v * v * v * x1 + 3 * t * v * v * x2 + 3 * t * t * v * x3 + t * t
                    * t * x4;
            double yt = v * v * v * y1 + 3 * t * v * v * y2 + 3 * t * t * v * y3 + t * t
                    * t * y4;
            dot(Math.round(xt), Math.round(yt), strokeWidth);
        }
    }

    public void fill(double startX, double startY, Color fillColor, int tolerance, int kernelSize) {
        int sx = (int) Math.floor(startX);
        int sy = (int) Math.floor(startY);
        if (sx < 0 || sx >= width || sy < 0 || sy >= height)
            return;

        int[] pixels = new int[width * height];
        canvasImage.getRGB(0, 0, width, height, pixels, 0, width);

        int startIdx = sy * width + sx;
        int targetPixel = pixels[startIdx];
        int targetA = (targetPixel >> 24) & 0xff;
        int targetR = (targetPixel >> 16) & 0xff;
        int targetG = (targetPixel >> 8) & 0xff;
        int targetB = targetPixel & 0xff;

        long[] diffs = new long[width * height];
        for (int i = 0; i < pixels.length; i++) {
            int currentPixel = pixels[i];
            long da = targetA - ((currentPixel >> 24) & 0xff);
            long dr = targetR - ((currentPixel >> 16) & 0xff);
            long dg = targetG - ((currentPixel >> 8) & 0xff);
            long db = targetB - (currentPixel & 0xff);
            diffs[i] = dr * dr + dg * dg + db * db + (da * da * 2);
        }

        long tolSq = (long) tolerance * tolerance;
        byte[] visited = new byte[width * height];
        int half = kernelSize / 2;

        BiPredicate<Integer, Integer> pixelMatches = (x, y) -> {
            if (x < 0 || x >= width || y < 0 || y >= height)
                return false;
            if (kernelSize <= 1) {
                return diffs[y * width + x] <= tolSq;
            } else {
                long tdiff = 0;
                int count = 0;
                for (int ky = -half; ky <= half; ky++) {
                    int py = y + ky;
                    if (py < 0 || py >= height)
                        continue;
                    for (int kx = -half; kx <= half; kx++) {
                        int px = x + kx;
                        if (px < 0 || px >= width)
                            continue;
                        tdiff += diffs[py * width + px];
                        count++;
                    }
                }
                return count > 0 && (tdiff / count) <= tolSq;
            }
        };

        if (!pixelMatches.test(sx, sy))
            return;

        Deque<Point> stack = new ArrayDeque<>();
        stack.push(new Point(sx, sy));
        int fillPixel = fillColor.getRGB();

        while (!stack.isEmpty()) {
            Point p = stack.pop();
            int x = p.x;
            int y = p.y;
            int yOffset = y * width;
            if (visited[yOffset + x] == 1)
                continue;

            int currentX = x;
            while (currentX >= 0 && visited[yOffset + currentX] == 0 && pixelMatches.test(currentX, y)) {
                currentX--;
            }
            currentX++;

            boolean spanAbove = false;
            boolean spanBelow = false;
            while (currentX < width && visited[yOffset + currentX] == 0 && pixelMatches.test(currentX, y)) {
                pixels[yOffset + currentX] = fillPixel;
                visited[yOffset + currentX] = 1;

                if (y > 0) {
                    if (!spanAbove && visited[(y - 1) * width + currentX] == 0 && pixelMatches.test(currentX, y - 1)) {
                        stack.push(new Point(currentX, y - 1));
                        spanAbove = true;
                    } else if (spanAbove
                            && (visited[(y - 1) * width + currentX] == 1 || !pixelMatches.test(currentX, y - 1))) {
                        spanAbove = false;
                    }
                }
                if (y < height - 1) {
                    if (!spanBelow && visited[(y + 1) * width + currentX] == 0 && pixelMatches.test(currentX, y + 1)) {
                        stack.push(new Point(currentX, y + 1));
                        spanBelow = true;
                    } else if (spanBelow
                            && (visited[(y + 1) * width + currentX] == 1 || !pixelMatches.test(currentX, y + 1))) {
                        spanBelow = false;
                    }
                }
                currentX++;
            }
        }
        canvasImage.setRGB(0, 0, width, height, pixels, 0, width);
    }

    public BufferedImage paint() {
        for (IOperation op : this.stroke_plans) {
            if (op instanceof COLOR) {
                COLOR c = (COLOR) op;
                g2d.setColor(c.color);
            }
            if (op instanceof MOVE) {
                MOVE m = (MOVE) op;
                this.currentX = m.x1;
                this.currentY = m.y1;
                this.startX = this.currentX;
                this.startY = this.currentY;
            }
            if (op instanceof LINE) {
                LINE l = (LINE) op;
                this.line(this.currentX, this.currentY, l.x1, l.y1, l.getStrokeWidth());
                this.currentX = l.x1;
                this.currentY = l.y1;
            }
            if (op instanceof CURVE) {
                CURVE c = (CURVE) op;
                this.bezier(
                        this.currentX,
                        this.currentY,
                        c.x1,
                        c.y1,
                        c.x2,
                        c.y2,
                        c.x3,
                        c.y3,
                        c.getStrokeWidth()
                // this message is here to f*ck with vscode java fomatter
                );
                this.lastControlX = c.x2;
                this.lastControlY = c.y2;
                this.currentX = c.x3;
                this.currentY = c.y3;
            }
            if (op instanceof SMALL_CURVE) {
                SMALL_CURVE sc = (SMALL_CURVE) op;
                this.bezier(
                        this.currentX,
                        this.currentY,
                        this.currentX,
                        this.currentY,
                        sc.x1,
                        sc.y1,
                        sc.x2,
                        sc.y2,
                        sc.getStrokeWidth()
                // this message is here to f*ck with vscode java fomatter
                );
                this.lastControlX = sc.x1;
                this.lastControlY = sc.y1;
                this.currentX = sc.x2;
                this.currentY = sc.y2;
            }
        }
        for (FILL_COLOR op : this.fill_plans) {
            this.fill(op.x, op.y, op.color, op.tolerance, op.kernelSize);
        }
        return canvasImage;
    }
}
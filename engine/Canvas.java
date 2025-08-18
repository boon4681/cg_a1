package engine;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.UUID;
import java.util.function.BiPredicate;

import javax.swing.JFrame;
import javax.swing.JPanel;

import engine.tick.Tickable;
import engine.objects.IObject;

public class Canvas extends JPanel implements Tickable {
    protected ArrayList<Canvas> canvas_list = new ArrayList<>();
    protected ArrayList<IObject> objects = new ArrayList<>();
    protected boolean running = true;
    private final int width;
    private final int height;
    private final BufferedImage canvasImage;
    private final Graphics2D g2d;

    private final String name;
    public final Window window;

    public Canvas(Window window, String name) {
        this(window, name, 400, 400);
    }

    public Canvas(Window window, String name, int width, int height) {
        this.width = width;
        this.height = height;
        setSize(width, height);
        setLocation(0, 0);
        setLayout(null);
        // setBackground(null);
        setOpaque(false);
        this.name = name;
        this.window = window;
        this.canvasImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        this.g2d = this.canvasImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        // clear();
    }

    public BufferedImage getImage() {
        return canvasImage;
    }

    public void clear() {
        g2d.setComposite(AlphaComposite.Src);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
    }

    public void setColor(Color color) {
        g2d.setColor(color);
    }

    public void put(Image image) {
        g2d.drawImage(image, 0, 0, null);
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
        for(double t = 0; t <= 1; t += 0.01) {
            double xt = Math.pow(1 - t, 3) * x1 + 3 * Math.pow(1 - t, 2) * t * x2
                    + 3 * (1 - t) * Math.pow(t, 2) * x3 + Math.pow(t, 3) * x4;
            double yt = Math.pow(1 - t, 3) * y1 + 3 * Math.pow(1 - t, 2) * t * y2
                    + 3 * (1 - t) * Math.pow(t, 2) * y3 + Math.pow(t, 3) * y4;
            dot(xt, yt, strokeWidth);
        }
        // double length = Math.hypot(x1 - x2, y1 - y2) + Math.hypot(x2 - x3, y2 - y3) + Math.hypot(x3 - x4, y3 - y4);
        // int steps = Math.max(1, (int) Math.round(length));

        // for (int i = 0; i <= steps; i++) {
        //     double t = (double) i / steps;
        //     double v = 1 - t;
        //     double xt = v * v * v * x1 + 3 * t * v * v * x2 + 3 * t * t * v * x3 + t * t * t * x4;
        //     double yt = v * v * v * y1 + 3 * t * v * v * y2 + 3 * t * t * v * y3 + t * t * t * y4;
        //     dot(Math.round(xt), Math.round(yt), strokeWidth);
        // }
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

    @Override
    public void tick(double dt) {
        if (!this.isVisible())
            return;
        if (!this.running)
            return;
        // System.out.println(dt);
        // update(0.6);
        update(dt);
        for (Canvas canvas : canvas_list) {
            canvas.tick(dt);
        }
        repaint();
    }

    public void update(double dt) {
        for (IObject object : this.objects.toArray(new IObject[0])) {
            object.update(dt);
        }
    }

    public void render(Graphics2D g) {
        for (IObject object : this.objects.toArray(new IObject[0])) {
            if (object != null) {
                if (object.isVisible()) {
                    object.render(g);
                }
            }
        }
    }

    public UUID add(IObject object) {
        this.objects.add(object);
        return object.getID();
    }

    public void add(Canvas canvas) {
        this.canvas_list.add(canvas);
        super.add(canvas);
    }

    public void remove(IObject object) {
        this.objects.remove(object);
    }

    public void remove(Canvas canvas) {
        this.canvas_list.remove(canvas);
        super.remove(canvas);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        // RenderingHints rh = new RenderingHints(
        // RenderingHints.KEY_TEXT_ANTIALIASING,
        // RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        // g2d.setRenderingHints(rh);
        this.render(g2d);
        super.paintComponent(g);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}

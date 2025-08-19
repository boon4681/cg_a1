import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.UUID;
import java.util.function.BiPredicate;

public class Assignment1_66050170_66050331 {
    public static void main(String[] args) {
        Frame frame = new Frame("WHAT THE HEYYYY!!");
        frame.setSize(600, 600 + 37);
        Animation animtion = new Animation(true);

        animtion.addFrame(Frame1.render(), 200);
        animtion.addFrame(Frame2.render(), 100);
        animtion.addFrame(Frame3.render(), 100);
        animtion.addFrame(Frame4.render(), 200);
        animtion.addFrame(Frame5.render(), 200);
        animtion.addFrame(Frame6.render(), 200);
        animtion.addFrame(Frame7.render(), 100);
        animtion.addFrame(Frame8.render(), 100);
        animtion.addFrame(Frame9.render(), 100);
        animtion.addFrame(Frame10.render(), 200);
        animtion.addFrame(Frame11.render(), 200);
        animtion.addFrame(Frame12.render(), 200);

        animtion.addFrame(Frame13.render(), 100);
        animtion.addFrame(Frame14.render(), 100);
        animtion.addFrame(Frame15.render(), 100);
        animtion.addFrame(Frame16.render(), 100);
        animtion.addFrame(Frame13.render(), 100);
        animtion.addFrame(Frame14.render(), 100);
        animtion.addFrame(Frame15.render(), 100);
        animtion.addFrame(Frame16.render(), 100);
        animtion.addFrame(Frame13.render(), 100);
        animtion.addFrame(Frame14.render(), 100);
        animtion.addFrame(Frame15.render(), 100);
        animtion.addFrame(Frame16.render(), 100);
        animtion.addFrame(Frame13.render(), 100);
        animtion.addFrame(Frame14.render(), 100);
        animtion.addFrame(Frame15.render(), 100);
        animtion.addFrame(Frame16.render(), 100);

        Ticker animationCanvas = new Ticker(animtion);

        frame.add(animationCanvas);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static interface IOperation {
        double getStrokeWidth();
    }

    public static class COLOR implements IOperation {
        public final double strokeWidth = 4;
        public final Color color;

        public COLOR(Color color) {
            this.color = color;
        }

        @Override
        public double getStrokeWidth() {
            return strokeWidth;
        }
    }

    public static class CURVE implements IOperation {
        public final double strokeWidth = 4;
        public final double x1;
        public final double y1;
        public final double x2;
        public final double y2;
        public final double x3;
        public final double y3;

        public CURVE(double x1, double y1, double x2, double y2, double x3, double y3) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }

        @Override
        public double getStrokeWidth() {
            return strokeWidth;
        }
    }

    public static class FILL_COLOR {
        public final double x;
        public final double y;
        public final Color color;
        public final int tolerance;
        public final int kernelSize;

        public FILL_COLOR(
                double x,
                double y,
                Color color) {
            this(x, y, color, 250, 2);
        }

        public FILL_COLOR(
                double x,
                double y,
                Color color,
                int tolerance,
                int kernelSize
        //
        ) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.tolerance = tolerance;
            this.kernelSize = kernelSize;
        }
    }

    public static class LINE implements IOperation {
        public final double strokeWidth = 4;
        public final double x1;
        public final double y1;

        public LINE(double x1, double y1) {
            this.x1 = x1;
            this.y1 = y1;
        }

        @Override
        public double getStrokeWidth() {
            return strokeWidth;
        }
    }

    public static class MOVE implements IOperation {
        public final double strokeWidth = 4;
        public final double x1;
        public final double y1;

        public MOVE(double x1, double y1) {
            this.x1 = x1;
            this.y1 = y1;
        }

        @Override
        public double getStrokeWidth() {
            return strokeWidth;
        }
    }

    public static class SMALL_CURVE implements IOperation {
        public final double strokeWidth = 4;
        public final double x1;
        public final double y1;
        public final double x2;
        public final double y2;

        public SMALL_CURVE(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public double getStrokeWidth() {
            return strokeWidth;
        }
    }

    public static interface IObject {
        public boolean isVisible();

        public UUID getID();

        public void render(Graphics2D g);

        public void update(double dt);
    }

    public static class Ticker extends Canvas implements Runnable {

        private final Animation animation;
        private Thread animationThread;
        private volatile boolean running = false;

        private static final int TARGET_FPS = 60;
        private static final long OPTIMAL_TIME = 1000 / TARGET_FPS;

        public Ticker(Animation animation) {
            this.animation = animation;
            setSize(new Dimension(600, 600));
        }

        @Override
        public void addNotify() {
            super.addNotify();
            start();
        }

        @Override
        public void removeNotify() {
            stop();
            super.removeNotify();
        }

        private void start() {
            if (running)
                return;
            running = true;
            animationThread = new Thread(this);
            animationThread.start();
        }

        private void stop() {
            if (!running)
                return;
            running = false;
            try {
                animationThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            long lastUpdateTime = System.currentTimeMillis();

            while (running) {
                long now = System.currentTimeMillis();
                long deltaTime = now - lastUpdateTime;
                lastUpdateTime = now;

                animation.update(deltaTime);
                render();

                long loopTime = System.currentTimeMillis() - lastUpdateTime;
                if (loopTime < OPTIMAL_TIME) {
                    try {
                        Thread.sleep(OPTIMAL_TIME - loopTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void render() {
            BufferStrategy bs = getBufferStrategy();
            if (bs == null) {
                createBufferStrategy(2);
                return;
            }

            Graphics g = bs.getDrawGraphics();
            g.clearRect(0, 0, getWidth(), getHeight());

            BufferedImage currentFrame = animation.getCurrentImage();
            if (currentFrame != null) {
                g.drawImage(currentFrame, 0, 0, 600, 600, null);
            }

            g.dispose();
            bs.show();
        }
    }

    public static class Animation {
        private final List<IFrame> frames;
        private int currentFrameIndex;
        private long timeSinceLastFrame;
        private boolean isLooping;

        public Animation(boolean isLooping) {
            this.frames = new ArrayList<>();
            this.isLooping = isLooping;
            this.currentFrameIndex = 0;
            this.timeSinceLastFrame = 0;
        }

        public void addFrame(BufferedImage image, long duration) {
            frames.add(new IFrame(image, duration));
        }

        public void addFrame(ArrayList<BufferedImage> image, long duration) {
            frames.add(new IFrame(image, duration));
        }

        public void update(long deltaTime) {
            if (frames.isEmpty()) {
                return;
            }

            timeSinceLastFrame += deltaTime;
            long currentFrameDuration = frames.get(currentFrameIndex).getDuration();
            if (timeSinceLastFrame >= currentFrameDuration) {
                timeSinceLastFrame -= currentFrameDuration;
                currentFrameIndex++;

                if (currentFrameIndex >= frames.size()) {
                    if (isLooping) {
                        currentFrameIndex = 0;
                    } else {
                        currentFrameIndex = frames.size() - 1;
                    }
                }
            }
        }

        public BufferedImage getCurrentImage() {
            if (frames.isEmpty()) {
                return null;
            }
            return frames.get(currentFrameIndex).getImage();
        }

        public void reset() {
            this.currentFrameIndex = 0;
            this.timeSinceLastFrame = 0;
        }
    }

    public static class IFrame {
        private final BufferedImage image;
        private final long duration; // in milliseconds

        public IFrame(BufferedImage image, long duration) {
            this.image = image;
            this.duration = duration;
        }

        public IFrame(ArrayList<BufferedImage> list, long duration) {
            BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();

            for (BufferedImage buffer : list) {
                g2d.drawImage(buffer, 0, 0, 600, 600, null);
            }
            this.image = image;
            this.duration = duration;
        }

        public BufferedImage getImage() {
            return image;
        }

        public long getDuration() {
            return duration;
        }
    }

    public static class Painter {
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
            this(width, height, stroke_plans, fill_plans,
                    new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB));
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
                        if (!spanAbove && visited[(y - 1) * width + currentX] == 0
                                && pixelMatches.test(currentX, y - 1)) {
                            stack.push(new Point(currentX, y - 1));
                            spanAbove = true;
                        } else if (spanAbove
                                && (visited[(y - 1) * width + currentX] == 1 || !pixelMatches.test(currentX, y - 1))) {
                            spanAbove = false;
                        }
                    }
                    if (y < height - 1) {
                        if (!spanBelow && visited[(y + 1) * width + currentX] == 0
                                && pixelMatches.test(currentX, y + 1)) {
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

    public static class Frame1 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(new Color(136, 103, 139, 255));
                g2d.fillRect(0, 0, 600, 600);
                list.add(image);
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(182, 0),
                        new SMALL_CURVE(179, 13, 193, 19),
                        new SMALL_CURVE(197, 109, 266, 95),
                        new SMALL_CURVE(359, 139, 378, 39),
                        new SMALL_CURVE(401, 21, 396, 0)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(332, 77, new Color(217, 186, 179, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(316, 0),
                        new SMALL_CURVE(312, 9, 334, 15),
                        new CURVE(330, 45, 311, 25, 298, 41),
                        new SMALL_CURVE(269, 32, 269, 25),
                        new SMALL_CURVE(267, 19, 268, 0),
                        new MOVE(281, 0),
                        new CURVE(268, 10, 302, 37, 303, 0)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(309, 19, new Color(157, 133, 168, 255))
                //
                );
                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(220, 23),
                        new LINE(245, 55),
                        new LINE(244, 15),
                        new CURVE(256, 54, 316, 64, 336, 35),
                        new CURVE(350, 38, 360, 17, 343, 15),
                        new SMALL_CURVE(345, 7, 340, 0),
                        new MOVE(328, 0),
                        new CURVE(332, 3, 337, 11, 327, 31),
                        new CURVE(314, 27, 300, 27, 298, 42),
                        new CURVE(266, 32, 256, 13, 249, 0),
                        new MOVE(234, 0),
                        new LINE(235, 30),
                        new LINE(222, 24)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(336, 27, new Color(117, 85, 107, 255))
                //
                );
                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }
    }

    public static class Frame2 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(new Color(136, 103, 139, 255));
                g2d.fillRect(0, 0, 600, 600);
                list.add(image);
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(259, 74),
                        new CURVE(274, 111, 200, 135, 200, 178),
                        new CURVE(184, 214, 197, 223, 211, 243),
                        new CURVE(207, 244, 210, 280, 256, 279),
                        new CURVE(280, 282, 296, 316, 352, 274),
                        new CURVE(385, 239, 417, 228, 387, 147),
                        new CURVE(368, 112, 324, 139, 346, 75),
                        new CURVE(352, 26, 253, 42, 261, 76)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(344, 131, new Color(220, 185, 189, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(201, 0),
                        new CURVE(199, 14, 211, 19, 223, 23),
                        new CURVE(221, 43, 223, 47, 229, 59),
                        new CURVE(231, 87, 215, 98, 238, 99),
                        new CURVE(260, 86, 224, 81, 250, 71),
                        new CURVE(272, 79, 261, 109, 285, 111),
                        new CURVE(313, 115, 313, 71, 342, 67),
                        new CURVE(367, 63, 330, 101, 359, 98),
                        new CURVE(379, 92, 355, 75, 367, 64),
                        new CURVE(381, 55, 364, 42, 372, 30),
                        new CURVE(372, 11, 387, 9, 392, 0),
                        new MOVE(264, 119),
                        new SMALL_CURVE(272, 105, 280, 124),
                        new SMALL_CURVE(269, 131, 265, 120)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(304, 62, new Color(233, 206, 188, 255)),
                        new FILL_COLOR(272, 119, new Color(233, 206, 188, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(256, 0),
                        new CURVE(256, 7, 262, 14, 279, 16),
                        new CURVE(279, 35, 284, 41, 304, 42),
                        new CURVE(308, 40, 324, 37, 328, 16),
                        new CURVE(334, 9, 354, 15, 357, 0)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(307, 16, new Color(254, 232, 195, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(248, 207),
                        new LINE(262, 171),
                        new CURVE(262, 167, 277, 158, 285, 209),
                        new CURVE(292, 212, 305, 213, 308, 199),
                        new LINE(291, 171),
                        new LINE(300, 135),
                        new SMALL_CURVE(283, 116, 308, 117),
                        new SMALL_CURVE(324, 118, 308, 137),
                        new LINE(300, 171),
                        new LINE(320, 195),
                        new LINE(336, 194),
                        new LINE(347, 206),
                        new LINE(306, 237),
                        new LINE(277, 227),
                        new LINE(268, 191),
                        new LINE(259, 217),
                        new LINE(248, 207),
                        new MOVE(332, 187),
                        new LINE(325, 174),
                        new LINE(357, 151),
                        new SMALL_CURVE(373, 152, 364, 167),
                        new SMALL_CURVE(357, 167, 356, 163),
                        new LINE(338, 177),
                        new LINE(346, 191),
                        new LINE(334, 187)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(319, 207, new Color(157, 133, 168, 255)),
                        new FILL_COLOR(334, 171, new Color(157, 133, 168, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(228, 232),
                        new LINE(260, 255),
                        new LINE(251, 218),
                        new CURVE(271, 247, 317, 256, 346, 216),
                        new CURVE(356, 214, 364, 196, 347, 194),
                        new LINE(339, 181),
                        new LINE(329, 185),
                        new CURVE(328, 196, 348, 203, 321, 216),
                        new CURVE(314, 216, 306, 217, 308, 231),
                        new CURVE(267, 232, 265, 210, 236, 199),
                        new LINE(246, 237),
                        new LINE(228, 231)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(316, 223, new Color(117, 85, 107, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(396, 17),
                        new SMALL_CURVE(380, 3, 381, 25),
                        new SMALL_CURVE(392, 32, 396, 19)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(386, 19, new Color(220, 185, 189, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }
    }

    public static class Frame3 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(new Color(136, 103, 139, 255));
                g2d.fillRect(0, 0, 600, 600);
                list.add(image);
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(213, 200),
                        new CURVE(209, 212, 199, 235, 211, 251),
                        new CURVE(204, 255, 188, 323, 273, 360),
                        new CURVE(317, 377, 312, 351, 344, 348),
                        new CURVE(404, 343, 403, 259, 407, 246),
                        new CURVE(404, 220, 399, 220, 406, 199),
                        new CURVE(401, 183, 383, 188, 394, 208),
                        new CURVE(391, 241, 381, 182, 363, 174),
                        new CURVE(352, 167, 340, 162, 325, 142),
                        new LINE(272, 152),
                        new CURVE(266, 155, 256, 167, 253, 190),
                        new CURVE(250, 239, 223, 221, 244, 204),
                        new CURVE(260, 160, 230, 173, 228, 215),
                        new CURVE(228, 181, 211, 190, 209, 212),
                        new MOVE(374, 122),
                        new CURVE(364, 112, 360, 139, 360, 148),
                        new CURVE(363, 163, 372, 151, 380, 146),
                        new CURVE(384, 136, 380, 129, 375, 122)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(348, 195, new Color(220, 185, 189, 255)),
                        new FILL_COLOR(368, 137, new Color(220, 185, 189, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(165, 0),
                        new CURVE(164, 7, 176, 16, 192, 19),
                        new CURVE(172, 31, 196, 55, 203, 33),
                        new SMALL_CURVE(204, 48, 220, 55),
                        new CURVE(200, 67, 207, 118, 221, 144),
                        new CURVE(223, 179, 208, 179, 211, 202),
                        new SMALL_CURVE(216, 207, 224, 203),
                        new CURVE(249, 134, 204, 100, 235, 67),
                        new CURVE(240, 92, 284, 86, 271, 149),
                        new CURVE(250, 178, 276, 171, 280, 191),
                        new CURVE(288, 197, 303, 198, 308, 181),
                        new CURVE(313, 166, 327, 179, 339, 161),
                        new CURVE(318, 143, 321, 117, 343, 95),
                        new CURVE(354, 83, 360, 67, 360, 53),
                        new CURVE(358, 33, 384, 27, 368, 71),
                        new CURVE(345, 102, 387, 111, 378, 76),
                        new CURVE(376, 58, 399, 58, 400, 24),
                        new SMALL_CURVE(393, 15, 418, 0),
                        new MOVE(192, 97),
                        new CURVE(177, 99, 173, 111, 187, 119),
                        new CURVE(199, 124, 209, 107, 193, 98),
                        new MOVE(410, 146),
                        new CURVE(400, 149, 398, 174, 420, 166),
                        new CURVE(444, 150, 419, 136, 408, 147)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(297, 144, new Color(233, 206, 188, 255)),
                        new FILL_COLOR(413, 153, new Color(233, 206, 188, 255)),
                        new FILL_COLOR(188, 107, new Color(233, 206, 188, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(224, 0),
                        new CURVE(213, 21, 257, 17, 254, 36),
                        new CURVE(259, 63, 284, 49, 296, 65),
                        new CURVE(318, 79, 324, 29, 352, 27),
                        new SMALL_CURVE(378, 24, 383, 0),
                        new MOVE(284, 75),
                        new CURVE(269, 77, 280, 102, 291, 94),
                        new CURVE(296, 81, 284, 67, 280, 77),
                        new MOVE(324, 76),
                        new CURVE(299, 71, 319, 96, 323, 77)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(312, 15, new Color(254, 232, 195, 255)),
                        new FILL_COLOR(285, 87, new Color(254, 232, 195, 255)),
                        new FILL_COLOR(316, 79, new Color(254, 232, 195, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(340, 255),
                        new CURVE(317, 262, 311, 246, 302, 241),
                        new LINE(297, 207),
                        new CURVE(308, 207, 301, 183, 294, 187),
                        new CURVE(277, 187, 285, 203, 291, 209),
                        new LINE(292, 247),
                        new LINE(312, 266),
                        new CURVE(319, 269, 309, 286, 298, 281),
                        new LINE(281, 257),
                        new CURVE(263, 233, 260, 252, 259, 299),
                        new LINE(275, 300),
                        new LINE(272, 272),
                        new LINE(302, 310),
                        new LINE(340, 296),
                        new LINE(353, 259),
                        new LINE(339, 255),
                        new MOVE(346, 245),
                        new LINE(336, 238),
                        new LINE(348, 221),
                        new CURVE(368, 232, 362, 209, 360, 207),
                        new CURVE(354, 201, 343, 208, 339, 219),
                        new LINE(324, 239),
                        new LINE(338, 253),
                        new LINE(346, 246)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(325, 275, new Color(157, 133, 168, 255)),
                        new FILL_COLOR(352, 218, new Color(157, 133, 168, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(251, 322),
                        new LINE(287, 335),
                        new LINE(268, 303),
                        new CURVE(312, 326, 333, 315, 358, 273),
                        new CURVE(374, 263, 360, 236, 352, 251),
                        new LINE(342, 241),
                        new LINE(335, 244),
                        new CURVE(346, 259, 344, 262, 338, 282),
                        new CURVE(330, 280, 324, 282, 326, 296),
                        new CURVE(298, 303, 270, 291, 261, 287),
                        new CURVE(239, 274, 255, 299, 268, 322),
                        new LINE(254, 319)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(351, 261, new Color(117, 85, 107, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }
    }

    public static class Frame4 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(new Color(136, 103, 139, 255));
                g2d.fillRect(0, 0, 600, 600);
                list.add(image);
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(111, 499),
                        new CURVE(140, 463, 172, 460, 200, 459),
                        new CURVE(236, 444, 223, 419, 262, 406),
                        new CURVE(269, 387, 326, 405, 364, 422),
                        new CURVE(436, 430, 434, 387, 456, 391),
                        new CURVE(466, 383, 496, 365, 474, 451),
                        new MOVE(404, 423),
                        new CURVE(399, 418, 416, 445, 430, 431),
                        new SMALL_CURVE(436, 406, 456, 392),
                        new MOVE(481, 388),
                        new CURVE(471, 375, 514, 324, 548, 361),
                        new CURVE(575, 354, 566, 281, 600, 284),
                        new MOVE(444, 600),
                        new CURVE(502, 533, 535, 599, 600, 488),
                        new MOVE(261, 523),
                        new CURVE(328, 441, 356, 522, 399, 499),
                        new MOVE(295, 600),
                        new SMALL_CURVE(280, 584, 309, 549),
                        new MOVE(159, 600),
                        new CURVE(137, 548, 106, 534, 112, 499),
                        new CURVE(98, 479, 77, 421, 67, 418),
                        new CURVE(49, 383, 42, 371, 25, 357),
                        new SMALL_CURVE(11, 325, 0, 323),
                        new MOVE(104, 485),
                        new CURVE(142, 472, 146, 447, 176, 448),
                        new CURVE(248, 432, 224, 365, 344, 397),
                        new CURVE(403, 443, 375, 359, 432, 368),
                        new CURVE(428, 372, 473, 410, 472, 366),
                        new SMALL_CURVE(458, 369, 433, 369),
                        new CURVE(426, 372, 447, 330, 472, 333),
                        new CURVE(475, 352, 477, 347, 466, 367),
                        new MOVE(473, 335),
                        new SMALL_CURVE(456, 317, 444, 336),
                        new SMALL_CURVE(429, 315, 455, 311),
                        new SMALL_CURVE(438, 298, 451, 297),
                        new CURVE(452, 285, 424, 264, 410, 263),
                        new CURVE(393, 263, 378, 266, 360, 295),
                        new LINE(356, 292),
                        new CURVE(330, 305, 334, 357, 369, 369),
                        new SMALL_CURVE(360, 387, 339, 396),
                        new MOVE(408, 263),
                        new CURVE(400, 251, 414, 230, 423, 247),
                        new CURVE(420, 238, 438, 242, 436, 262),
                        new CURVE(447, 235, 444, 267, 460, 285),
                        new CURVE(480, 275, 463, 309, 472, 332),
                        new MOVE(69, 419),
                        new CURVE(92, 381, 140, 364, 188, 393),
                        new CURVE(207, 403, 239, 343, 273, 371),
                        new MOVE(267, 393),
                        new CURVE(255, 380, 276, 356, 296, 376),
                        new CURVE(329, 397, 327, 347, 346, 349),
                        new MOVE(313, 391),
                        new SMALL_CURVE(321, 368, 361, 366),
                        new MOVE(265, 367),
                        new CURVE(252, 310, 311, 322, 308, 330),
                        new CURVE(316, 331, 329, 325, 341, 331),
                        new MOVE(194, 394),
                        new CURVE(178, 368, 148, 369, 141, 328),
                        new CURVE(130, 307, 120, 294, 100, 269),
                        new CURVE(111, 256, 154, 235, 146, 201),
                        new SMALL_CURVE(152, 195, 160, 211),
                        new CURVE(173, 209, 175, 204, 173, 230),
                        new CURVE(186, 197, 223, 219, 209, 277),
                        new CURVE(243, 247, 308, 298, 303, 325),
                        new MOVE(106, 415),
                        new CURVE(136, 406, 135, 447, 174, 434),
                        new MOVE(109, 260),
                        new LINE(41, 180),
                        new SMALL_CURVE(17, 144, 44, 161),
                        new CURVE(25, 139, 44, 128, 54, 144),
                        new CURVE(40, 127, 58, 121, 71, 139),
                        new CURVE(61, 115, 75, 113, 94, 145),
                        new CURVE(92, 133, 123, 127, 104, 167),
                        new LINE(146, 217),
                        new MOVE(102, 270),
                        new SMALL_CURVE(89, 263, 100, 250),
                        new MOVE(136, 203),
                        new SMALL_CURVE(138, 194, 150, 202),
                        new MOVE(0, 550),
                        new CURVE(11, 576, 5, 591, 20, 600)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(533, 425, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(207, 404, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(311, 349, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(284, 377, new Color(97, 74, 102, 255)),
                        new FILL_COLOR(337, 357, new Color(97, 74, 102, 255)),
                        new FILL_COLOR(452, 377, new Color(97, 74, 102, 255)),
                        new FILL_COLOR(404, 394, new Color(113, 90, 116, 255)),
                        new FILL_COLOR(420, 426, new Color(97, 74, 102, 255)),
                        new FILL_COLOR(457, 353, new Color(160, 137, 158, 255)),
                        new FILL_COLOR(412, 328, new Color(190, 169, 185, 255)),
                        new FILL_COLOR(76, 486, new Color(89, 62, 84, 255)),
                        new FILL_COLOR(4, 592, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(458, 301, new Color(167, 139, 167, 255)),
                        new FILL_COLOR(338, 377, new Color(145, 123, 147, 255)),
                        new FILL_COLOR(111, 211, new Color(190, 169, 185, 255)),
                        new FILL_COLOR(102, 258, new Color(106, 83, 111, 255)),
                        new FILL_COLOR(140, 204, new Color(110, 86, 116, 255)),
                        new FILL_COLOR(208, 330, new Color(138, 122, 160, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(190, 317),
                        new CURVE(126, 317, 135, 233, 161, 230),
                        new CURVE(178, 215, 196, 254, 204, 267),
                        new CURVE(211, 283, 228, 303, 188, 316),
                        new MOVE(220, 254),
                        new CURVE(182, 247, 204, 199, 224, 215),
                        new CURVE(236, 224, 239, 247, 220, 253),
                        new MOVE(600, 278),
                        new CURVE(579, 275, 576, 285, 590, 306),
                        new CURVE(592, 343, 564, 355, 546, 346),
                        new CURVE(502, 329, 512, 276, 533, 263),
                        new CURVE(505, 243, 545, 144, 600, 162),
                        new MOVE(504, 358),
                        new CURVE(490, 355, 497, 331, 514, 341),
                        new CURVE(527, 346, 510, 364, 505, 359),
                        new MOVE(515, 600),
                        new CURVE(516, 579, 559, 551, 571, 600),
                        new MOVE(232, 395),
                        new CURVE(220, 386, 248, 375, 252, 391),
                        new CURVE(255, 405, 232, 408, 231, 395),
                        new MOVE(0, 277),
                        new CURVE(12, 282, 13, 296, 0, 295),
                        new MOVE(40, 440),
                        new CURVE(57, 434, 32, 403, 31, 419),
                        new CURVE(17, 429, 31, 448, 43, 440),
                        new MOVE(265, 311),
                        new CURVE(244, 313, 253, 279, 269, 293),
                        new CURVE(272, 299, 272, 307, 265, 310),
                        new MOVE(181, 551),
                        new CURVE(196, 542, 205, 561, 191, 569),
                        new CURVE(180, 579, 164, 548, 186, 551),
                        new MOVE(225, 570),
                        new CURVE(221, 555, 194, 569, 208, 583),
                        new CURVE(220, 598, 235, 571, 225, 568)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(549, 282, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(508, 352, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(181, 267, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(220, 230, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(261, 299, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(239, 392, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(32, 430, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(188, 556, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(216, 575, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(543, 591, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(2, 286, new Color(220, 181, 178, 255))
                //
                );
                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }
    }

    public static class Frame5 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(new Color(136, 103, 139, 255));
                g2d.fillRect(0, 0, 600, 600);
                list.add(image);
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(111, 499),
                        new CURVE(140, 463, 172, 460, 200, 459),
                        new CURVE(236, 444, 223, 419, 262, 406),
                        new CURVE(269, 387, 326, 405, 364, 422),
                        new CURVE(436, 430, 434, 387, 449, 384),
                        new CURVE(460, 368, 496, 365, 474, 451),
                        new MOVE(404, 423),
                        new CURVE(399, 418, 416, 445, 423, 429),
                        new SMALL_CURVE(420, 396, 460, 375),
                        new MOVE(481, 388),
                        new CURVE(447, 357, 497, 320, 533, 338),
                        new CURVE(569, 343, 566, 281, 600, 254),
                        new MOVE(444, 600),
                        new CURVE(502, 533, 530, 566, 600, 476),
                        new MOVE(261, 523),
                        new CURVE(328, 441, 356, 522, 399, 499),
                        new MOVE(295, 600),
                        new SMALL_CURVE(280, 584, 309, 549),
                        new MOVE(159, 600),
                        new CURVE(137, 548, 106, 534, 112, 499),
                        new CURVE(98, 479, 77, 421, 67, 418),
                        new CURVE(49, 383, 42, 371, 25, 357),
                        new SMALL_CURVE(11, 325, 0, 323),
                        new MOVE(104, 485),
                        new CURVE(142, 472, 146, 447, 176, 448),
                        new CURVE(248, 432, 224, 365, 344, 397),
                        new CURVE(403, 443, 375, 359, 429, 365),
                        new CURVE(428, 372, 443, 398, 470, 367),
                        new SMALL_CURVE(456, 367, 433, 369),
                        new CURVE(426, 372, 447, 330, 472, 333),
                        new CURVE(475, 352, 477, 347, 466, 367),
                        new MOVE(473, 335),
                        new SMALL_CURVE(456, 317, 444, 336),
                        new SMALL_CURVE(429, 315, 455, 311),
                        new SMALL_CURVE(438, 298, 451, 297),
                        new CURVE(452, 285, 424, 264, 410, 263),
                        new CURVE(393, 263, 378, 266, 360, 295),
                        new LINE(356, 292),
                        new CURVE(330, 305, 334, 357, 369, 369),
                        new SMALL_CURVE(360, 387, 339, 396),
                        new MOVE(408, 263),
                        new CURVE(400, 251, 414, 230, 423, 247),
                        new CURVE(420, 238, 438, 242, 436, 262),
                        new CURVE(447, 235, 444, 267, 460, 285),
                        new CURVE(480, 275, 463, 309, 472, 332),
                        new MOVE(69, 419),
                        new CURVE(92, 381, 140, 364, 188, 393),
                        new CURVE(207, 403, 239, 343, 273, 371),
                        new MOVE(267, 393),
                        new CURVE(255, 380, 276, 356, 296, 376),
                        new CURVE(329, 397, 327, 347, 346, 349),
                        new MOVE(313, 391),
                        new SMALL_CURVE(321, 368, 361, 366),
                        new MOVE(265, 367),
                        new CURVE(252, 310, 311, 322, 308, 330),
                        new CURVE(316, 331, 329, 325, 341, 331),
                        new MOVE(194, 394),
                        new CURVE(199, 373, 190, 360, 184, 350),
                        new CURVE(172, 339, 160, 324, 164, 299),
                        new CURVE(160, 255, 154, 235, 146, 201),
                        new SMALL_CURVE(180, 237, 219, 167),
                        new CURVE(215, 194, 254, 166, 229, 207),
                        new CURVE(231, 186, 287, 199, 244, 262),
                        new CURVE(259, 247, 326, 295, 317, 330),
                        new MOVE(106, 415),
                        new CURVE(136, 406, 135, 447, 174, 434),
                        new MOVE(162, 211),
                        new LINE(139, 151),
                        new SMALL_CURVE(105, 67, 139, 93),
                        new CURVE(123, 80, 138, 57, 153, 83),
                        new CURVE(140, 75, 161, 51, 169, 80),
                        new CURVE(164, 63, 181, 51, 190, 98),
                        new CURVE(200, 85, 210, 95, 192, 122),
                        new LINE(212, 185),
                        new MOVE(163, 210),
                        new SMALL_CURVE(135, 210, 153, 189),
                        new MOVE(206, 165),
                        new SMALL_CURVE(225, 160, 212, 183),
                        new MOVE(0, 550),
                        new CURVE(11, 576, 5, 591, 20, 600)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(533, 425, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(207, 404, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(311, 349, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(284, 377, new Color(97, 74, 102, 255)),
                        new FILL_COLOR(337, 357, new Color(97, 74, 102, 255)),
                        // new FILL_COLOR(428, 377, new Color(97, 74, 102, 255)),
                        new FILL_COLOR(404, 394, new Color(113, 90, 116, 255)),
                        new FILL_COLOR(420, 426, new Color(97, 74, 102, 255)),
                        new FILL_COLOR(457, 353, new Color(160, 137, 158, 255)),
                        new FILL_COLOR(412, 328, new Color(190, 169, 185, 255)),
                        new FILL_COLOR(76, 486, new Color(89, 62, 84, 255)),
                        new FILL_COLOR(4, 592, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(338, 377, new Color(145, 123, 147, 255)),
                        new FILL_COLOR(179, 147, new Color(189, 168, 184, 255)),
                        new FILL_COLOR(209, 240, new Color(137, 122, 159, 255)),
                        new FILL_COLOR(421, 257, new Color(167, 139, 167, 255)),
                        new FILL_COLOR(211, 169, new Color(110, 87, 116, 255)),
                        new FILL_COLOR(153, 200, new Color(110, 87, 116, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(359, 298),
                        new CURVE(365, 266, 406, 291, 398, 323),
                        new SMALL_CURVE(388, 304, 357, 297),
                        new MOVE(144, 172),
                        new CURVE(132, 167, 113, 189, 115, 226),
                        new CURVE(113, 271, 180, 259, 165, 212),
                        new CURVE(152, 201, 168, 177, 146, 172),
                        new MOVE(600, 287),
                        new SMALL_CURVE(584, 287, 588, 295),
                        new CURVE(600, 397, 496, 333, 538, 285),
                        new CURVE(520, 263, 508, 194, 572, 163),
                        new SMALL_CURVE(581, 156, 600, 156),
                        new MOVE(549, 499),
                        new CURVE(527, 494, 514, 539, 526, 542),
                        new CURVE(524, 562, 546, 579, 571, 566),
                        new CURVE(600, 561, 582, 513, 564, 523),
                        new CURVE(566, 516, 563, 497, 548, 500),
                        new MOVE(194, 198),
                        new CURVE(170, 195, 188, 164, 199, 177),
                        new CURVE(210, 179, 206, 197, 192, 198),
                        new MOVE(230, 352),
                        new CURVE(218, 349, 218, 371, 224, 371),
                        new CURVE(244, 381, 251, 345, 230, 351),
                        new MOVE(260, 259),
                        new CURVE(248, 249, 229, 277, 243, 279),
                        new CURVE(251, 284, 270, 276, 260, 259),
                        new MOVE(506, 299),
                        new CURVE(501, 293, 489, 316, 504, 314),
                        new CURVE(525, 319, 512, 295, 507, 297),
                        new MOVE(48, 422),
                        new CURVE(63, 408, 73, 442, 59, 443),
                        new CURVE(44, 450, 28, 416, 53, 419),
                        new MOVE(225, 303),
                        new CURVE(220, 298, 227, 279, 242, 291),
                        new CURVE(244, 295, 242, 309, 225, 303),
                        new MOVE(0, 284),
                        new CURVE(11, 287, 16, 264, 0, 265),
                        new MOVE(187, 519),
                        new CURVE(198, 509, 201, 541, 185, 537),
                        new CURVE(181, 543, 173, 519, 187, 519),
                        new MOVE(211, 552),
                        new CURVE(172, 557, 210, 527, 216, 535),
                        new CURVE(231, 541, 221, 550, 206, 553)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(568, 231, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(382, 298, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(507, 307, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(565, 547, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(185, 527, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(212, 545, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(52, 434, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(3, 274, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(231, 363, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(227, 295, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(254, 268, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(128, 221, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(199, 186, new Color(220, 181, 178, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }
    }

    public static class Frame6 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(new Color(136, 103, 139, 255));
                g2d.fillRect(0, 0, 600, 600);
                list.add(image);
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(111, 499),
                        new CURVE(140, 463, 172, 460, 200, 459),
                        new CURVE(236, 444, 223, 419, 262, 406),
                        new CURVE(269, 387, 326, 405, 364, 422),
                        new CURVE(436, 430, 425, 388, 440, 383),
                        new CURVE(441, 354, 484, 369, 468, 440),
                        new MOVE(404, 423),
                        new CURVE(399, 418, 416, 445, 423, 429),
                        new SMALL_CURVE(420, 396, 449, 370),
                        new MOVE(464, 369),
                        new CURVE(442, 323, 491, 318, 520, 316),
                        new CURVE(498, 196, 584, 223, 600, 215),
                        new MOVE(444, 600),
                        new CURVE(514, 544, 530, 554, 600, 467),
                        new MOVE(261, 523),
                        new CURVE(328, 441, 356, 522, 399, 499),
                        new MOVE(295, 600),
                        new SMALL_CURVE(280, 584, 309, 549),
                        new MOVE(159, 600),
                        new CURVE(137, 548, 106, 534, 112, 499),
                        new CURVE(98, 479, 77, 421, 67, 418),
                        new CURVE(49, 383, 42, 371, 25, 357),
                        new SMALL_CURVE(11, 325, 0, 323),
                        new MOVE(104, 485),
                        new CURVE(142, 472, 146, 447, 176, 448),
                        new CURVE(248, 432, 224, 365, 344, 397),
                        new CURVE(403, 443, 375, 359, 431, 368),
                        new SMALL_CURVE(464, 371, 436, 369),
                        new CURVE(426, 372, 447, 330, 469, 334),
                        new CURVE(449, 343, 467, 365, 460, 373),
                        new MOVE(470, 331),
                        new SMALL_CURVE(450, 319, 444, 336),
                        new SMALL_CURVE(429, 315, 455, 311),
                        new SMALL_CURVE(438, 298, 451, 297),
                        new CURVE(452, 285, 424, 264, 410, 263),
                        new CURVE(393, 263, 378, 266, 360, 295),
                        new LINE(356, 292),
                        new CURVE(330, 305, 334, 357, 369, 369),
                        new SMALL_CURVE(360, 387, 339, 396),
                        new MOVE(408, 263),
                        new CURVE(400, 251, 414, 230, 423, 247),
                        new CURVE(420, 238, 438, 242, 436, 262),
                        new CURVE(447, 235, 444, 267, 460, 285),
                        new CURVE(480, 275, 463, 309, 469, 332),
                        new MOVE(69, 419),
                        new CURVE(92, 381, 140, 364, 188, 393),
                        new CURVE(207, 403, 239, 343, 273, 371),
                        new MOVE(267, 393),
                        new CURVE(255, 380, 276, 356, 296, 376),
                        new CURVE(329, 397, 327, 347, 346, 349),
                        new MOVE(313, 391),
                        new SMALL_CURVE(321, 368, 361, 366),
                        new MOVE(265, 367),
                        new CURVE(252, 310, 311, 322, 308, 330),
                        new CURVE(316, 331, 329, 325, 341, 331),
                        new MOVE(194, 394),
                        new CURVE(199, 373, 190, 360, 184, 350),
                        new CURVE(172, 339, 160, 324, 164, 299),
                        new CURVE(171, 257, 158, 234, 156, 204),
                        new SMALL_CURVE(220, 206, 229, 164),
                        new CURVE(227, 187, 276, 174, 229, 207),
                        new CURVE(247, 187, 304, 196, 244, 262),
                        new CURVE(259, 247, 326, 295, 317, 330),
                        new MOVE(106, 415),
                        new CURVE(136, 406, 135, 447, 174, 434),
                        new MOVE(170, 203),
                        new LINE(156, 136),
                        new SMALL_CURVE(124, 49, 156, 83),
                        new CURVE(148, 67, 164, 41, 173, 77),
                        new CURVE(171, 66, 183, 37, 191, 76),
                        new CURVE(186, 55, 206, 47, 207, 92),
                        new CURVE(211, 84, 243, 84, 208, 111),
                        new LINE(223, 182),
                        new MOVE(157, 206),
                        new SMALL_CURVE(150, 196, 166, 186),
                        new MOVE(221, 160),
                        new SMALL_CURVE(227, 154, 230, 173),
                        new MOVE(0, 550),
                        new CURVE(11, 576, 5, 591, 20, 600)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(533, 425, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(207, 404, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(311, 349, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(284, 377, new Color(97, 74, 102, 255)),
                        new FILL_COLOR(337, 357, new Color(97, 74, 102, 255)),
                        // new FILL_COLOR(457, 353, new Color(160, 137, 158, 255)),
                        new FILL_COLOR(412, 328, new Color(190, 169, 185, 255)),
                        new FILL_COLOR(4, 592, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(338, 377, new Color(145, 123, 147, 255)),
                        new FILL_COLOR(179, 147, new Color(189, 168, 184, 255)),
                        new FILL_COLOR(209, 240, new Color(137, 122, 159, 255)),
                        new FILL_COLOR(187, 140, new Color(190, 169, 185, 255)),
                        new FILL_COLOR(224, 167, new Color(110, 88, 117, 255)),
                        new FILL_COLOR(163, 197, new Color(110, 88, 117, 255)),
                        new FILL_COLOR(82, 515, new Color(89, 62, 84, 255)),
                        new FILL_COLOR(414, 390, new Color(113, 90, 116, 255)),
                        new FILL_COLOR(416, 425, new Color(97, 74, 102, 255)),
                        new FILL_COLOR(432, 265, new Color(167, 139, 167, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(352, 295),
                        new CURVE(353, 278, 346, 219, 390, 234),
                        new CURVE(411, 244, 400, 271, 414, 295),
                        new CURVE(414, 311, 416, 315, 396, 322),
                        new SMALL_CURVE(385, 303, 353, 296),
                        new MOVE(165, 189),
                        new CURVE(128, 192, 138, 150, 129, 135),
                        new CURVE(108, 111, 140, 90, 164, 114),
                        new CURVE(190, 146, 207, 167, 164, 191),
                        new MOVE(224, 145),
                        new CURVE(184, 163, 188, 95, 217, 109),
                        new CURVE(219, 103, 244, 129, 223, 145),
                        new MOVE(542, 247),
                        new CURVE(519, 244, 499, 179, 534, 167),
                        new CURVE(495, 155, 491, 91, 544, 90),
                        new CURVE(556, 71, 560, 43, 600, 49),
                        new MOVE(600, 196),
                        new CURVE(589, 204, 569, 192, 574, 207),
                        new CURVE(576, 231, 565, 251, 540, 246),
                        new MOVE(500, 506),
                        new CURVE(482, 489, 500, 434, 532, 438),
                        new CURVE(544, 445, 540, 469, 553, 495),
                        new CURVE(559, 526, 515, 525, 500, 507),
                        new MOVE(0, 267),
                        new CURVE(36, 277, 29, 221, 0, 237),
                        new MOVE(232, 316),
                        new CURVE(243, 291, 283, 315, 255, 345),
                        new CURVE(247, 355, 214, 333, 233, 315),
                        new MOVE(43, 357),
                        new CURVE(60, 351, 56, 385, 49, 379),
                        new CURVE(15, 389, 26, 339, 51, 361),
                        new MOVE(201, 481),
                        new CURVE(206, 478, 219, 503, 200, 503),
                        new CURVE(173, 504, 189, 472, 204, 483),
                        new MOVE(233, 529),
                        new CURVE(203, 526, 234, 488, 242, 509),
                        new CURVE(252, 514, 245, 529, 232, 529),
                        new MOVE(202, 555),
                        new CURVE(181, 559, 188, 591, 210, 577),
                        new CURVE(226, 568, 214, 542, 200, 555),
                        new MOVE(249, 259),
                        new CURVE(233, 247, 232, 275, 241, 277),
                        new CURVE(259, 283, 264, 263, 247, 259),
                        new MOVE(275, 224),
                        new CURVE(248, 216, 252, 242, 260, 240),
                        new CURVE(264, 246, 284, 243, 276, 226),
                        new MOVE(420, 215),
                        new CURVE(404, 211, 406, 231, 421, 233),
                        new CURVE(424, 236, 440, 215, 420, 215),
                        new MOVE(493, 249),
                        new CURVE(488, 247, 499, 231, 509, 239),
                        new CURVE(523, 243, 512, 268, 492, 247)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(531, 135, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(419, 223, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(505, 248, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(377, 267, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(512, 481, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(250, 324, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(240, 267, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(269, 234, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(160, 150, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(12, 249, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(38, 371, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(195, 491, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(240, 516, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(210, 562, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(223, 127, new Color(220, 181, 178, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }

    }

    public static class Frame7 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(new Color(136, 103, 139, 255));
                g2d.fillRect(0, 0, 600, 600);
                list.add(image);
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(111, 499),
                        new CURVE(140, 463, 172, 460, 200, 459),
                        new CURVE(236, 444, 223, 419, 260, 407),
                        new CURVE(272, 391, 326, 405, 364, 422),
                        new CURVE(436, 430, 425, 388, 432, 379),
                        new CURVE(438, 344, 476, 371, 468, 440),
                        new MOVE(404, 423),
                        new CURVE(399, 418, 416, 445, 423, 429),
                        new SMALL_CURVE(420, 396, 435, 377),
                        new MOVE(457, 378),
                        new CURVE(435, 314, 477, 298, 504, 305),
                        new CURVE(467, 189, 562, 184, 600, 198),
                        new MOVE(444, 600),
                        new CURVE(512, 539, 536, 542, 600, 447),
                        new MOVE(261, 523),
                        new CURVE(328, 441, 356, 522, 399, 499),
                        new MOVE(295, 600),
                        new SMALL_CURVE(280, 584, 309, 549),
                        new MOVE(159, 600),
                        new CURVE(137, 548, 106, 534, 112, 499),
                        new CURVE(98, 479, 77, 421, 67, 418),
                        new CURVE(49, 383, 42, 371, 25, 357),
                        new SMALL_CURVE(11, 325, 0, 323),
                        new MOVE(104, 485),
                        new CURVE(142, 472, 146, 447, 176, 448),
                        new CURVE(248, 432, 224, 365, 344, 397),
                        new CURVE(403, 443, 375, 359, 431, 368),
                        new SMALL_CURVE(424, 364, 436, 369),
                        new CURVE(426, 372, 447, 330, 453, 334),
                        new CURVE(449, 343, 452, 361, 456, 372),
                        new MOVE(453, 332),
                        new SMALL_CURVE(446, 333, 444, 336),
                        new SMALL_CURVE(429, 315, 455, 311),
                        new SMALL_CURVE(438, 298, 451, 297),
                        new CURVE(452, 285, 424, 264, 410, 263),
                        new CURVE(393, 263, 378, 266, 360, 295),
                        new LINE(356, 292),
                        new CURVE(330, 305, 334, 357, 369, 369),
                        new SMALL_CURVE(360, 387, 339, 396),
                        new MOVE(408, 263),
                        new CURVE(400, 251, 414, 230, 423, 247),
                        new CURVE(420, 238, 438, 242, 436, 262),
                        new CURVE(447, 235, 444, 267, 460, 285),
                        new CURVE(480, 275, 468, 295, 468, 311),
                        new MOVE(69, 419),
                        new CURVE(92, 381, 140, 364, 188, 393),
                        new CURVE(207, 403, 239, 343, 273, 371),
                        new MOVE(267, 393),
                        new CURVE(255, 380, 276, 356, 296, 376),
                        new CURVE(329, 397, 327, 347, 346, 349),
                        new MOVE(313, 391),
                        new SMALL_CURVE(321, 368, 361, 366),
                        new MOVE(265, 367),
                        new CURVE(252, 310, 311, 322, 308, 330),
                        new CURVE(316, 331, 329, 325, 341, 331),
                        new MOVE(194, 394),
                        new CURVE(196, 374, 197, 368, 196, 344),
                        new CURVE(182, 332, 179, 310, 183, 294),
                        new CURVE(195, 258, 197, 239, 194, 195),
                        new SMALL_CURVE(228, 215, 280, 179),
                        new CURVE(287, 187, 303, 207, 268, 212),
                        new CURVE(280, 203, 344, 214, 274, 269),
                        new CURVE(289, 275, 333, 303, 328, 329),
                        new MOVE(106, 415),
                        new CURVE(136, 406, 135, 447, 174, 434),
                        new MOVE(209, 201),
                        new LINE(210, 140),
                        new SMALL_CURVE(196, 44, 220, 75),
                        new CURVE(213, 62, 233, 44, 240, 72),
                        new CURVE(234, 56, 254, 47, 258, 79),
                        new CURVE(249, 59, 276, 47, 266, 97),
                        new CURVE(281, 90, 298, 103, 263, 120),
                        new LINE(267, 188),
                        new MOVE(197, 195),
                        new SMALL_CURVE(185, 197, 210, 179),
                        new MOVE(267, 165),
                        new SMALL_CURVE(277, 167, 281, 179),
                        new MOVE(0, 550),
                        new CURVE(11, 576, 5, 591, 20, 600)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(207, 404, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(432, 265, new Color(167, 139, 167, 255)),
                        new FILL_COLOR(84, 479, new Color(89, 62, 84, 255)),
                        new FILL_COLOR(301, 429, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(412, 393, new Color(113, 90, 116, 255)),
                        new FILL_COLOR(384, 331, new Color(190, 169, 185, 255)),
                        new FILL_COLOR(232, 289, new Color(135, 123, 157, 255)),
                        new FILL_COLOR(227, 150, new Color(189, 167, 184, 255)),
                        new FILL_COLOR(204, 190, new Color(109, 89, 118, 255)),
                        new FILL_COLOR(268, 172, new Color(109, 89, 118, 255)),
                        new FILL_COLOR(304, 351, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(415, 425, new Color(88, 67, 92, 255)),
                        new FILL_COLOR(447, 355, new Color(160, 137, 158, 255)),
                        new FILL_COLOR(338, 385, new Color(145, 123, 147, 255)),
                        new FILL_COLOR(284, 378, new Color(97, 74, 102, 255)),
                        new FILL_COLOR(6, 591, new Color(150, 132, 170, 255)),
                        new FILL_COLOR(341, 364, new Color(97, 74, 102, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(353, 294),
                        new CURVE(344, 285, 340, 267, 352, 267),
                        new CURVE(327, 255, 333, 220, 356, 208),
                        new CURVE(351, 172, 434, 163, 414, 242),
                        new CURVE(423, 248, 433, 255, 419, 281),
                        new CURVE(406, 298, 432, 315, 410, 328),
                        new CURVE(396, 325, 373, 280, 354, 295),
                        new MOVE(432, 175),
                        new CURVE(425, 169, 406, 186, 427, 196),
                        new CURVE(446, 191, 436, 179, 432, 175),
                        new MOVE(600, 176),
                        new CURVE(560, 167, 596, 209, 559, 221),
                        new CURVE(494, 219, 527, 163, 524, 143),
                        new CURVE(499, 111, 515, 82, 542, 66),
                        new CURVE(559, 55, 585, 15, 600, 24),
                        new MOVE(503, 371),
                        new CURVE(525, 383, 551, 393, 550, 435),
                        new CURVE(526, 465, 487, 463, 494, 413),
                        new CURVE(461, 388, 490, 363, 505, 373),
                        new MOVE(203, 506),
                        new CURVE(191, 503, 183, 546, 223, 531),
                        new CURVE(259, 503, 225, 485, 200, 507),
                        new MOVE(43, 311),
                        new CURVE(62, 310, 56, 340, 37, 336),
                        new CURVE(7, 330, 21, 295, 48, 312),
                        new MOVE(0, 219),
                        new CURVE(29, 211, 23, 187, 0, 181),
                        new MOVE(133, 96),
                        new CURVE(121, 98, 117, 123, 133, 150),
                        new CURVE(120, 154, 126, 188, 167, 184),
                        new CURVE(176, 180, 204, 153, 173, 125),
                        new CURVE(163, 112, 160, 83, 134, 95),
                        new MOVE(208, 99),
                        new CURVE(173, 99, 177, 138, 205, 139),
                        new CURVE(216, 141, 237, 98, 204, 99),
                        new MOVE(280, 187),
                        new CURVE(250, 187, 257, 213, 282, 212),
                        new CURVE(292, 219, 294, 183, 277, 188),
                        new MOVE(243, 300),
                        new CURVE(237, 288, 255, 265, 274, 290),
                        new CURVE(281, 302, 252, 329, 243, 299),
                        new MOVE(243, 247),
                        new CURVE(228, 240, 239, 208, 264, 223),
                        new CURVE(267, 231, 271, 256, 244, 247),
                        new MOVE(210, 446),
                        new CURVE(224, 446, 229, 474, 212, 475),
                        new CURVE(177, 478, 194, 437, 210, 446)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(560, 102, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(397, 226, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(430, 186, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(515, 423, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(260, 293, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(10, 197, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(35, 320, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(169, 136, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(248, 230, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(280, 196, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(200, 115, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(211, 462, new Color(220, 181, 178, 255)),
                        new FILL_COLOR(218, 515, new Color(220, 181, 178, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }
    }

    public static class Frame8 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(new Color(136, 103, 139, 255));
                g2d.fillRect(0, 0, 600, 600);
                list.add(image);
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        // new COLOR(new Color(213, 196, 211, 255)),
                        new MOVE(470, 600),
                        new LINE(392, 471),
                        new COLOR(new Color(0, 0, 0)),
                        new CURVE(357, 435, 259, 447, 220, 397),
                        new CURVE(192, 367, 168, 329, 177, 327),
                        new CURVE(201, 319, 213, 352, 238, 375),
                        new CURVE(271, 400, 254, 355, 235, 339),
                        new CURVE(129, 264, 155, 232, 172, 234),
                        new CURVE(191, 243, 197, 279, 248, 310),
                        new CURVE(254, 307, 280, 311, 194, 227),
                        new SMALL_CURVE(177, 195, 218, 212),
                        new CURVE(218, 211, 227, 200, 260, 221),
                        new CURVE(262, 204, 300, 204, 351, 263),
                        new CURVE(400, 309, 428, 346, 454, 386),
                        new CURVE(480, 423, 534, 483, 600, 521)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(368, 360, new Color(190, 169, 185, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        // new MOVE(472, 600),
                        // new CURVE(450, 555, 404, 485, 384, 463),
                        // new CURVE(409, 480, 462, 537, 500, 600),
                        new MOVE(246, 309),
                        new CURVE(258, 320, 273, 315, 251, 291),
                        new SMALL_CURVE(256, 307, 246, 309),
                        new MOVE(251, 382),
                        new CURVE(266, 395, 277, 384, 250, 355),
                        new SMALL_CURVE(257, 368, 252, 384),
                        new MOVE(245, 239),
                        new SMALL_CURVE(263, 255, 274, 271),
                        new CURVE(289, 278, 282, 257, 250, 242),
                        new MOVE(280, 236),
                        new SMALL_CURVE(297, 249, 309, 262),
                        new SMALL_CURVE(331, 257, 287, 239)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                // new FILL_COLOR(306, 254, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(269, 259, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(256, 308, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(260, 379, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(456, 548, new Color(213, 196, 211, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }
    }

    public static class Frame9 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(new Color(136, 103, 139, 255));
                g2d.fillRect(0, 0, 600, 600);
                list.add(image);
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(470, 600),
                        new LINE(392, 471),
                        new CURVE(357, 435, 259, 447, 220, 397),
                        new CURVE(192, 367, 168, 329, 177, 327),
                        new CURVE(201, 319, 213, 352, 238, 375),
                        new CURVE(271, 400, 254, 355, 235, 339),
                        new CURVE(129, 264, 155, 232, 172, 234),
                        new CURVE(191, 243, 197, 279, 248, 310),
                        new CURVE(254, 307, 280, 311, 194, 227),
                        new SMALL_CURVE(177, 195, 218, 212),
                        new CURVE(218, 211, 227, 200, 260, 221),
                        new CURVE(262, 204, 300, 204, 351, 263),
                        new CURVE(400, 309, 428, 346, 454, 386),
                        new CURVE(480, 423, 534, 483, 600, 521)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(368, 360, new Color(190, 169, 185, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        // new MOVE(472, 600),
                        // new CURVE(450, 555, 404, 485, 384, 463),
                        // new CURVE(409, 480, 462, 537, 500, 600),
                        new MOVE(246, 309),
                        new CURVE(258, 320, 273, 315, 251, 291),
                        new SMALL_CURVE(256, 307, 246, 309),
                        new MOVE(251, 382),
                        new CURVE(266, 395, 277, 384, 250, 355),
                        new SMALL_CURVE(257, 368, 252, 384),
                        new MOVE(245, 239),
                        new SMALL_CURVE(263, 255, 274, 271),
                        new CURVE(289, 278, 282, 257, 250, 242),
                        new MOVE(280, 236),
                        new SMALL_CURVE(297, 249, 309, 262),
                        new SMALL_CURVE(331, 257, 287, 239)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                // new FILL_COLOR(306, 254, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(269, 259, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(256, 308, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(260, 379, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(456, 548, new Color(213, 196, 211, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }

    }

    public static class Frame10 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(new Color(136, 103, 139, 255));
                g2d.fillRect(0, 0, 600, 600);
                list.add(image);
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(455, 600),
                        new LINE(417, 512),
                        new CURVE(342, 374, 332, 455, 227, 395),
                        new CURVE(192, 355, 165, 337, 172, 332),
                        new CURVE(197, 322, 210, 347, 232, 362),
                        new CURVE(261, 371, 255, 351, 236, 332),
                        new CURVE(141, 247, 152, 224, 166, 232),
                        new CURVE(191, 243, 197, 279, 234, 298),
                        new CURVE(245, 298, 274, 291, 181, 210),
                        new SMALL_CURVE(177, 195, 208, 206),
                        new CURVE(225, 219, 223, 189, 251, 215),
                        new CURVE(262, 204, 304, 214, 348, 276),
                        new CURVE(382, 327, 418, 360, 448, 394),
                        new CURVE(480, 423, 534, 483, 600, 530)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(368, 360, new Color(190, 169, 185, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        // new MOVE(451, 600),
                        // new CURVE(447, 562, 407, 491, 373, 446),
                        // new CURVE(409, 480, 464, 539, 498, 600),
                        new MOVE(230, 295),
                        new CURVE(252, 308, 264, 306, 244, 275),
                        new SMALL_CURVE(251, 300, 235, 296),
                        new MOVE(232, 364),
                        new CURVE(256, 387, 273, 374, 245, 340),
                        new SMALL_CURVE(256, 369, 235, 365),
                        new MOVE(240, 233),
                        new SMALL_CURVE(263, 255, 268, 262),
                        new CURVE(281, 264, 273, 251, 242, 233),
                        new MOVE(280, 236),
                        new SMALL_CURVE(297, 249, 309, 262),
                        new SMALL_CURVE(326, 257, 286, 238)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                // new FILL_COLOR(439, 529, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(252, 367, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(248, 298, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(267, 256, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(303, 251, new Color(213, 196, 211, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }
    }

    public static class Frame11 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(new Color(136, 103, 139, 255));
                g2d.fillRect(0, 0, 600, 600);
                list.add(image);
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(455, 600),
                        new LINE(417, 515),
                        new CURVE(320, 354, 330, 447, 226, 388),
                        new CURVE(189, 358, 165, 337, 172, 332),
                        new CURVE(197, 322, 206, 348, 232, 362),
                        new CURVE(257, 368, 255, 339, 228, 323),
                        new CURVE(156, 255, 146, 223, 162, 226),
                        new CURVE(185, 231, 197, 279, 234, 298),
                        new CURVE(245, 298, 267, 283, 180, 219),
                        new SMALL_CURVE(177, 195, 203, 211),
                        new CURVE(211, 221, 201, 191, 244, 217),
                        new CURVE(263, 212, 284, 210, 326, 258),
                        new CURVE(368, 287, 406, 364, 445, 400),
                        new CURVE(480, 423, 534, 483, 600, 534)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(368, 360, new Color(190, 169, 185, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        // new MOVE(451, 600),
                        // new CURVE(443, 561, 403, 492, 364, 436),
                        // new CURVE(410, 482, 461, 541, 498, 600),
                        new MOVE(229, 292),
                        new CURVE(252, 308, 264, 306, 244, 275),
                        new SMALL_CURVE(251, 300, 235, 296),
                        new MOVE(230, 359),
                        new CURVE(254, 379, 278, 361, 248, 337),
                        new SMALL_CURVE(256, 369, 232, 360),
                        new MOVE(240, 233),
                        new SMALL_CURVE(256, 250, 268, 262),
                        new CURVE(281, 264, 273, 251, 242, 233),
                        new MOVE(268, 231),
                        new SMALL_CURVE(293, 249, 302, 259),
                        new SMALL_CURVE(323, 255, 271, 231)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                // new FILL_COLOR(439, 529, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(254, 358, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(248, 295, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(263, 251, new Color(213, 196, 211, 255)),
                // new FILL_COLOR(301, 252, new Color(213, 196, 211, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }
    }

    public static class Frame12 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(new Color(136, 103, 139, 255));
                g2d.fillRect(0, 0, 600, 600);
                list.add(image);
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(454, 600),
                        new CURVE(432, 540, 411, 490, 353, 411),
                        new SMALL_CURVE(337, 398, 323, 390),
                        new CURVE(268, 391, 219, 375, 176, 376),
                        new CURVE(168, 375, 173, 351, 213, 360),
                        new CURVE(240, 363, 261, 344, 249, 323),
                        new CURVE(206, 279, 183, 259, 156, 229),
                        new SMALL_CURVE(132, 204, 161, 214),
                        new CURVE(184, 234, 194, 255, 230, 278),
                        new CURVE(239, 289, 248, 271, 225, 253),
                        new CURVE(188, 217, 176, 201, 165, 194),
                        new CURVE(157, 188, 168, 168, 209, 215),
                        new CURVE(237, 241, 282, 284, 241, 231),
                        new CURVE(196, 188, 185, 185, 201, 179),
                        new SMALL_CURVE(222, 189, 236, 203),
                        new CURVE(225, 184, 250, 192, 280, 213),
                        new CURVE(347, 266, 391, 335, 444, 392),
                        new CURVE(494, 455, 548, 494, 600, 542)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(378, 359, new Color(190, 169, 185, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(249, 217),
                        new LINE(280, 246),
                        new CURVE(286, 245, 272, 226, 252, 219),
                        new MOVE(232, 359),
                        new CURVE(260, 363, 270, 349, 250, 327),
                        new SMALL_CURVE(261, 343, 232, 357),
                        new MOVE(454, 600),
                        new CURVE(432, 538, 410, 487, 361, 425),
                        new CURVE(427, 491, 452, 523, 504, 600)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(427, 500, new Color(212, 196, 211, 255)),
                        new FILL_COLOR(251, 352, new Color(212, 196, 211, 255)),
                        new FILL_COLOR(269, 233, new Color(212, 196, 211, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }
    }

    public static class Frame13 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(84, 424),
                        new LINE(571, 421),
                        new MOVE(342, 423),
                        new CURVE(332, 405, 350, 330, 416, 322),
                        new CURVE(402, 305, 428, 291, 437, 314),
                        new CURVE(445, 290, 472, 299, 467, 323),
                        new CURVE(502, 328, 525, 363, 525, 422),
                        new MOVE(442, 422),
                        new CURVE(417, 413, 444, 382, 466, 407),
                        new MOVE(380, 423),
                        new CURVE(401, 410, 374, 384, 361, 403),
                        new MOVE(382, 401),
                        new SMALL_CURVE(378, 383, 392, 382),
                        new SMALL_CURVE(399, 391, 407, 383),
                        new SMALL_CURVE(416, 391, 419, 382),
                        new SMALL_CURVE(428, 393, 436, 383),
                        new SMALL_CURVE(443, 389, 442, 399),
                        new MOVE(396, 422),
                        new SMALL_CURVE(389, 385, 414, 398),
                        new SMALL_CURVE(424, 391, 424, 422),
                        new MOVE(384, 357),
                        new SMALL_CURVE(378, 346, 387, 358),
                        new MOVE(459, 365),
                        new SMALL_CURVE(452, 351, 457, 366)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(428, 343, new Color(253, 218, 119, 255)),
                        new FILL_COLOR(392, 392, new Color(255, 255, 255, 255)),
                        new FILL_COLOR(411, 415, new Color(0, 0, 0, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(124, 424),
                        new CURVE(81, 363, 129, 221, 175, 223),
                        new CURVE(164, 208, 181, 197, 193, 208),
                        new CURVE(188, 204, 212, 189, 219, 223),
                        new CURVE(244, 215, 350, 320, 293, 426),
                        new CURVE(257, 451, 156, 473, 124, 423),
                        new MOVE(126, 277),
                        new CURVE(105, 270, 118, 227, 142, 246),
                        new MOVE(203, 328),
                        new CURVE(219, 343, 244, 345, 242, 307),
                        new MOVE(232, 391),
                        new CURVE(248, 417, 221, 427, 209, 427),
                        new MOVE(235, 420),
                        new CURVE(240, 421, 256, 430, 272, 404),
                        new MOVE(154, 449),
                        new CURVE(148, 457, 174, 476, 192, 454),
                        new MOVE(232, 451),
                        new CURVE(240, 476, 277, 458, 264, 443),
                        new MOVE(173, 264),
                        new CURVE(189, 259, 192, 287, 170, 285),
                        new CURVE(139, 275, 166, 259, 179, 264),
                        new MOVE(198, 271),
                        new LINE(221, 275),
                        new SMALL_CURVE(212, 287, 210, 276),
                        new MOVE(136, 263),
                        new LINE(152, 267),
                        new SMALL_CURVE(144, 277, 142, 266),
                        new MOVE(200, 251),
                        new CURVE(205, 249, 212, 243, 219, 254),
                        new MOVE(154, 259),
                        new LINE(144, 251),
                        new MOVE(441, 353),
                        new SMALL_CURVE(428, 360, 446, 374),
                        new MOVE(437, 359),
                        new CURVE(423, 343, 401, 369, 414, 372),
                        new SMALL_CURVE(422, 384, 440, 370)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(196, 346, new Color(253, 218, 119, 255)),
                        new FILL_COLOR(123, 252, new Color(253, 218, 119, 255)),
                        new FILL_COLOR(167, 457, new Color(250, 171, 118, 255)),
                        new FILL_COLOR(168, 276, new Color(250, 171, 118, 255)),
                        new FILL_COLOR(249, 455, new Color(250, 171, 118, 255)),
                        new FILL_COLOR(429, 366, new Color(250, 171, 118, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(46, 263),
                        new SMALL_CURVE(56, 257, 62, 238),
                        new SMALL_CURVE(69, 254, 85, 261),
                        new SMALL_CURVE(68, 259, 66, 280),
                        new SMALL_CURVE(62, 268, 48, 263),
                        new MOVE(119, 169),
                        new SMALL_CURVE(119, 183, 137, 189),
                        new SMALL_CURVE(122, 191, 120, 209),
                        new SMALL_CURVE(116, 191, 103, 190),
                        new SMALL_CURVE(116, 183, 118, 168),
                        new MOVE(294, 185),
                        new CURVE(264, 200, 312, 222, 309, 190),
                        new SMALL_CURVE(298, 177, 293, 186),
                        new MOVE(328, 279),
                        new SMALL_CURVE(332, 260, 348, 261),
                        new SMALL_CURVE(323, 254, 325, 241),
                        new SMALL_CURVE(321, 252, 307, 260),
                        new SMALL_CURVE(320, 262, 328, 279)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(322, 266, new Color(252, 226, 54, 255)),
                        new FILL_COLOR(297, 199, new Color(252, 226, 54, 255)),
                        new FILL_COLOR(116, 187, new Color(252, 226, 54, 255)),
                        new FILL_COLOR(63, 255, new Color(252, 226, 54, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }
    }

    public static class Frame14 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(84, 424),
                        new LINE(571, 421),
                        new MOVE(342, 423),
                        new CURVE(332, 405, 350, 330, 416, 322),
                        new CURVE(402, 305, 428, 291, 437, 314),
                        new CURVE(445, 290, 472, 299, 467, 323),
                        new CURVE(502, 328, 525, 363, 525, 422),
                        new MOVE(442, 422),
                        new CURVE(417, 413, 444, 382, 466, 407),
                        new MOVE(380, 423),
                        new CURVE(401, 410, 374, 384, 361, 403),
                        new MOVE(382, 401),
                        new SMALL_CURVE(378, 383, 392, 382),
                        new SMALL_CURVE(399, 391, 407, 383),
                        new SMALL_CURVE(416, 391, 419, 382),
                        new SMALL_CURVE(428, 393, 436, 383),
                        new SMALL_CURVE(443, 389, 442, 399),
                        new MOVE(396, 422),
                        new SMALL_CURVE(389, 385, 414, 398),
                        new SMALL_CURVE(424, 391, 424, 422),
                        new MOVE(384, 357),
                        new SMALL_CURVE(378, 346, 387, 358),
                        new MOVE(459, 365),
                        new SMALL_CURVE(452, 351, 457, 366)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(428, 343, new Color(253, 218, 119, 255)),
                        new FILL_COLOR(392, 392, new Color(255, 255, 255, 255)),
                        new FILL_COLOR(411, 415, new Color(0, 0, 0, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(132, 423),
                        new CURVE(98, 411, 66, 251, 186, 225),
                        new CURVE(175, 214, 189, 187, 204, 214),
                        new CURVE(205, 189, 230, 202, 225, 224),
                        new CURVE(255, 234, 272, 243, 277, 293),
                        new CURVE(301, 303, 347, 351, 300, 419),
                        new CURVE(280, 444, 195, 469, 132, 423),
                        new MOVE(173, 265),
                        new CURVE(191, 267, 188, 283, 170, 286),
                        new CURVE(135, 287, 159, 255, 176, 267),
                        new MOVE(199, 279),
                        new LINE(216, 281),
                        new SMALL_CURVE(209, 291, 207, 282),
                        new MOVE(202, 261),
                        new SMALL_CURVE(204, 243, 216, 263),
                        new MOVE(140, 261),
                        new LINE(150, 267),
                        new MOVE(132, 271),
                        new LINE(144, 276),
                        new SMALL_CURVE(138, 289, 138, 276),
                        new MOVE(122, 268),
                        new CURVE(112, 247, 132, 229, 150, 240),
                        new MOVE(205, 329),
                        new CURVE(231, 362, 253, 328, 241, 309),
                        new MOVE(234, 375),
                        new CURVE(249, 373, 270, 401, 237, 420),
                        new MOVE(254, 403),
                        new CURVE(260, 414, 275, 416, 286, 399),
                        new MOVE(158, 440),
                        new CURVE(155, 438, 136, 447, 160, 465),
                        new CURVE(195, 470, 197, 451, 188, 449),
                        new MOVE(228, 450),
                        new CURVE(224, 465, 276, 471, 267, 440),
                        new MOVE(440, 350),
                        new SMALL_CURVE(421, 351, 435, 372),
                        new MOVE(434, 353),
                        new CURVE(410, 330, 382, 370, 432, 368)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(220, 301, new Color(253, 218, 119, 255)),
                        new FILL_COLOR(174, 271, new Color(250, 171, 118, 255)),
                        new FILL_COLOR(134, 244, new Color(253, 218, 119, 255)),
                        new FILL_COLOR(165, 449, new Color(250, 171, 118, 255)),
                        new FILL_COLOR(252, 455, new Color(250, 171, 118, 255)),
                        new FILL_COLOR(414, 355, new Color(250, 171, 118, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(66, 291),
                        new SMALL_CURVE(64, 268, 88, 263),
                        new SMALL_CURVE(69, 251, 58, 229),
                        new SMALL_CURVE(56, 257, 37, 267),
                        new SMALL_CURVE(59, 268, 65, 295),
                        new MOVE(298, 170),
                        new SMALL_CURVE(296, 178, 320, 191),
                        new SMALL_CURVE(304, 197, 300, 214),
                        new SMALL_CURVE(296, 203, 276, 194),
                        new SMALL_CURVE(288, 188, 296, 168),
                        new MOVE(113, 188),
                        new CURVE(111, 205, 133, 199, 130, 186),
                        new SMALL_CURVE(116, 172, 114, 188),
                        new MOVE(332, 254),
                        new CURVE(324, 246, 307, 262, 325, 268),
                        new SMALL_CURVE(335, 267, 333, 256)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(324, 259, new Color(252, 226, 54, 255)),
                        new FILL_COLOR(299, 193, new Color(251, 225, 54, 255)),
                        new FILL_COLOR(122, 187, new Color(251, 225, 54, 255)),
                        new FILL_COLOR(62, 255, new Color(252, 226, 54, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }

    }

    public static class Frame15 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(84, 424),
                        new LINE(571, 421),
                        new MOVE(342, 423),
                        new CURVE(332, 405, 350, 330, 416, 322),
                        new CURVE(402, 305, 428, 291, 437, 314),
                        new CURVE(445, 290, 472, 299, 467, 323),
                        new CURVE(502, 328, 525, 363, 525, 422),
                        new MOVE(442, 422),
                        new CURVE(417, 413, 444, 382, 466, 407),
                        new MOVE(380, 423),
                        new CURVE(401, 410, 374, 384, 361, 403),
                        new MOVE(382, 401),
                        new SMALL_CURVE(378, 383, 392, 382),
                        new SMALL_CURVE(399, 391, 407, 383),
                        new SMALL_CURVE(416, 391, 419, 382),
                        new SMALL_CURVE(428, 393, 436, 383),
                        new SMALL_CURVE(443, 389, 442, 399),
                        new MOVE(396, 422),
                        new SMALL_CURVE(389, 385, 414, 398),
                        new SMALL_CURVE(424, 391, 424, 422),
                        new MOVE(384, 357),
                        new SMALL_CURVE(378, 346, 387, 358),
                        new MOVE(459, 365),
                        new SMALL_CURVE(452, 351, 457, 366)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(428, 343, new Color(253, 218, 119, 255)),
                        new FILL_COLOR(392, 392, new Color(255, 255, 255, 255)),
                        new FILL_COLOR(411, 415, new Color(0, 0, 0, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(123, 424),
                        new CURVE(73, 394, 109, 240, 176, 225),
                        new CURVE(164, 214, 178, 191, 198, 214),
                        new CURVE(195, 187, 227, 198, 220, 224),
                        new CURVE(308, 249, 327, 395, 277, 427),
                        new CURVE(241, 455, 145, 454, 116, 417),
                        new MOVE(125, 273),
                        new CURVE(105, 259, 137, 219, 148, 242),
                        new MOVE(159, 443),
                        new CURVE(145, 455, 180, 479, 195, 447),
                        new MOVE(232, 446),
                        new CURVE(223, 471, 279, 465, 266, 436),
                        new MOVE(216, 414),
                        new CURVE(235, 414, 257, 411, 252, 375),
                        new MOVE(248, 406),
                        new CURVE(255, 409, 266, 413, 279, 402),
                        new MOVE(162, 267),
                        new CURVE(144, 270, 154, 289, 186, 279),
                        new CURVE(190, 267, 176, 259, 160, 266),
                        new MOVE(133, 270),
                        new LINE(146, 272),
                        new SMALL_CURVE(139, 284, 140, 271),
                        new MOVE(199, 276),
                        new LINE(216, 279),
                        new SMALL_CURVE(205, 288, 209, 280),
                        new MOVE(204, 255),
                        new SMALL_CURVE(204, 245, 217, 257),
                        new MOVE(148, 265),
                        new LINE(140, 259),
                        new MOVE(202, 323),
                        new CURVE(208, 352, 250, 345, 242, 307),
                        new MOVE(429, 345),
                        new SMALL_CURVE(411, 346, 423, 367),
                        new MOVE(423, 349),
                        new CURVE(408, 322, 383, 367, 420, 362)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(182, 346, new Color(253, 218, 119, 255)),
                        new FILL_COLOR(172, 273, new Color(250, 171, 118, 255)),
                        new FILL_COLOR(132, 248, new Color(253, 218, 119, 255)),
                        new FILL_COLOR(176, 455, new Color(250, 171, 118, 255)),
                        new FILL_COLOR(252, 446, new Color(250, 171, 118, 255)),
                        new FILL_COLOR(411, 351, new Color(249, 170, 118, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(65, 286),
                        new SMALL_CURVE(64, 268, 83, 263),
                        new SMALL_CURVE(68, 255, 61, 235),
                        new SMALL_CURVE(56, 257, 42, 263),
                        new SMALL_CURVE(59, 268, 64, 287),
                        new MOVE(120, 168),
                        new SMALL_CURVE(117, 179, 140, 188),
                        new SMALL_CURVE(122, 191, 120, 210),
                        new SMALL_CURVE(116, 199, 100, 188),
                        new SMALL_CURVE(112, 188, 121, 166),
                        new MOVE(328, 280),
                        new SMALL_CURVE(328, 260, 345, 260),
                        new SMALL_CURVE(324, 252, 324, 235),
                        new SMALL_CURVE(319, 252, 309, 262),
                        new SMALL_CURVE(319, 263, 328, 280),
                        new MOVE(298, 187),
                        new CURVE(274, 189, 291, 218, 305, 200),
                        new SMALL_CURVE(306, 187, 297, 188)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(320, 259, new Color(252, 226, 54, 255)),
                        new FILL_COLOR(296, 195, new Color(252, 226, 54, 255)),
                        new FILL_COLOR(122, 187, new Color(252, 226, 54, 255)),
                        new FILL_COLOR(61, 259, new Color(252, 226, 54, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }
    }

    public static class Frame16 {
        public static ArrayList<BufferedImage> render() {
            ArrayList<BufferedImage> list = new ArrayList<>();
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(84, 424),
                        new LINE(571, 421),
                        new MOVE(342, 423),
                        new CURVE(332, 405, 350, 330, 416, 322),
                        new CURVE(402, 305, 428, 291, 437, 314),
                        new CURVE(445, 290, 472, 299, 467, 323),
                        new CURVE(502, 328, 525, 363, 525, 422),
                        new MOVE(442, 422),
                        new CURVE(417, 413, 444, 382, 466, 407),
                        new MOVE(380, 423),
                        new CURVE(401, 410, 374, 384, 361, 403),
                        new MOVE(382, 401),
                        new SMALL_CURVE(378, 383, 392, 382),
                        new SMALL_CURVE(399, 391, 407, 383),
                        new SMALL_CURVE(416, 391, 419, 382),
                        new SMALL_CURVE(428, 393, 436, 383),
                        new SMALL_CURVE(443, 389, 442, 399),
                        new MOVE(396, 422),
                        new SMALL_CURVE(389, 385, 414, 398),
                        new SMALL_CURVE(424, 391, 424, 422),
                        new MOVE(384, 357),
                        new SMALL_CURVE(378, 346, 387, 358),
                        new MOVE(459, 365),
                        new SMALL_CURVE(452, 351, 457, 366)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(428, 343, new Color(253, 218, 119, 255)),
                        new FILL_COLOR(392, 392, new Color(255, 255, 255, 255)),
                        new FILL_COLOR(411, 415, new Color(0, 0, 0, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(123, 424),
                        new MOVE(120, 268),
                        new CURVE(105, 259, 120, 228, 143, 241),
                        new MOVE(154, 443),
                        new CURVE(145, 455, 180, 479, 190, 449),
                        new MOVE(228, 446),
                        new CURVE(223, 471, 279, 465, 263, 434),
                        new MOVE(190, 423),
                        new CURVE(212, 427, 229, 416, 232, 399),
                        new MOVE(220, 420),
                        new CURVE(232, 431, 247, 423, 260, 410),
                        new MOVE(162, 267),
                        new CURVE(144, 270, 156, 284, 181, 279),
                        new CURVE(186, 265, 172, 260, 160, 266),
                        new MOVE(133, 267),
                        new LINE(147, 270),
                        new SMALL_CURVE(139, 284, 140, 268),
                        new MOVE(197, 271),
                        new LINE(216, 274),
                        new SMALL_CURVE(209, 286, 208, 275),
                        new MOVE(196, 252),
                        new SMALL_CURVE(193, 246, 212, 247),
                        new MOVE(151, 260),
                        new LINE(139, 253),
                        new MOVE(202, 323),
                        new CURVE(208, 352, 250, 345, 242, 307),
                        new MOVE(109, 424),
                        new CURVE(76, 383, 98, 357, 111, 299),
                        new CURVE(112, 286, 111, 251, 176, 218),
                        new CURVE(180, 195, 194, 194, 199, 211),
                        new CURVE(228, 183, 227, 220, 213, 223),
                        new CURVE(260, 236, 334, 291, 288, 407),
                        new CURVE(264, 458, 155, 457, 109, 423),
                        new MOVE(428, 360),
                        new CURVE(399, 344, 382, 370, 419, 376),
                        new SMALL_CURVE(439, 380, 428, 359)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(168, 314, new Color(253, 218, 119, 255)),
                        new FILL_COLOR(172, 272, new Color(250, 170, 118, 255)),
                        new FILL_COLOR(127, 245, new Color(248, 214, 116, 255)),
                        new FILL_COLOR(251, 445, new Color(250, 171, 118, 255)),
                        new FILL_COLOR(172, 455, new Color(247, 169, 116, 255)),
                        new FILL_COLOR(420, 368, new Color(250, 171, 118, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            {
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(120, 168),
                        new SMALL_CURVE(117, 179, 140, 188),
                        new SMALL_CURVE(122, 191, 120, 210),
                        new SMALL_CURVE(116, 199, 100, 188),
                        new SMALL_CURVE(112, 188, 121, 166),
                        new MOVE(328, 280),
                        new SMALL_CURVE(328, 260, 345, 260),
                        new SMALL_CURVE(324, 252, 324, 235),
                        new SMALL_CURVE(319, 252, 304, 260),
                        new SMALL_CURVE(319, 263, 328, 280),
                        new MOVE(298, 187),
                        new CURVE(274, 189, 291, 218, 305, 200),
                        new SMALL_CURVE(306, 187, 297, 188),
                        new MOVE(59, 264),
                        new CURVE(41, 260, 62, 237, 71, 256),
                        new SMALL_CURVE(72, 266, 59, 266)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(296, 195, new Color(252, 226, 54, 255)),
                        new FILL_COLOR(122, 187, new Color(252, 226, 54, 255)),
                        new FILL_COLOR(61, 259, new Color(252, 226, 54, 255)),
                        new FILL_COLOR(63, 255, new Color(252, 226, 54, 255)),
                        new FILL_COLOR(321, 259, new Color(252, 226, 54, 255)),
                        new FILL_COLOR(292, 196, new Color(252, 226, 54, 255))
                //
                );

                Painter painter = new Painter(600, 600, plan, fill_plan);
                list.add(painter.paint());
            }
            return list;
        }

    }

}

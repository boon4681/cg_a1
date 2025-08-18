import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.BiPredicate;
import java.awt.Graphics2D;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Assignment1_66050170_66050331 {
    public static void main(String[] args) {
        Window window = new Window("WHAT THE HEYYYY!!");
        window.setSize(600, 600 + 37);
        window.setVisible(true);
        window.setBackground(Color.BLACK);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);

        Frame1.setup(window);
        Frame2.setup(window);
        Frame3.setup(window);

        Ticker ticker = new Ticker(window);
        ticker.start();
        window.repaint();
    }

    public interface IObject {
        public boolean isVisible();

        public UUID getID();

        public Canvas getParent();

        public void render(Graphics2D g);

        public void update(double dt);

        public default void remove() {
            this.getParent().remove(this);
        }
    }

    public interface IOperation {

        double getStrokeWidth();

    }

    public static class Window extends JFrame implements Tickable {
        private ArrayList<Canvas> canvas_list = new ArrayList<>();
        private double t = 0;
        private double tt = 0;

        public Window(String name) {
            super(name);
        }

        public void add(Canvas canvas) {
            this.canvas_list.add(canvas);
            super.add(canvas);
        }

        public void remove(Canvas canvas) {
            this.canvas_list.remove(canvas);
            super.remove(canvas);
        }

        @Override
        public final void tick(double dt) {
            if (t == 0) {
                Frame3.list.forEach((e) -> {
                    e.setVisible(false);
                });
                Frame1.list.forEach((e) -> {
                    e.setVisible(true);
                });
            }
            if (t > 100) {
                Frame1.list.forEach((e) -> {
                    e.setVisible(false);
                });
                Frame2.list.forEach((e) -> {
                    e.setVisible(true);
                });
            }
            if (t > 200) {
                Frame2.list.forEach((e) -> {
                    e.setVisible(false);
                });
                Frame3.list.forEach((e) -> {
                    e.setVisible(true);
                });
            }
            t += dt;
            tt += dt;
            if (t > 300) {
                t = 0;
            }
            if (tt > 5000) {
                System.exit(0);
            }
            for (Canvas canvas : canvas_list) {
                canvas.tick(dt);
            }
        }
    }

    public interface Tickable {
        public void tick(double dt);
    }

    public static class Ticker implements Runnable {
        private Window window;
        public ArrayList<Tickable> tickables = new ArrayList<>();

        public Ticker(Window window) {
            this.window = window;
        }

        private Thread worldThread;
        private boolean loop = false;

        public void start() {
            this.loop = true;
            this.worldThread = new Thread(this);
            this.worldThread.start();
        }

        @Override
        public void run() {
            int FPS = 60;
            double nano = TimeUnit.SECONDS.toNanos(1);
            double dt = 0;
            long lastTime = System.nanoTime();
            long currentTime = System.nanoTime();
            try {
                while (loop) {
                    currentTime = System.nanoTime();
                    dt = ((currentTime - lastTime) / nano) * 1000;
                    for (Tickable tickable : tickables) {
                        tickable.tick(dt);
                    }
                    window.tick(dt);
                    lastTime = currentTime;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void stop() {
            this.loop = false;
        }
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

    public static class Canvas extends JPanel implements Tickable {
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
            double length = Math.hypot(x1 - x2, y1 - y2) + Math.hypot(x2 - x3, y2 - y3) + Math.hypot(x3 - x4, y3 - y4);
            int steps = Math.max(1, (int) Math.round(length));

            for (int i = 0; i <= steps; i++) {
                double t = (double) i / steps;
                double v = 1 - t;
                double xt = v * v * v * x1 + 3 * t * v * v * x2 + 3 * t * t * v * x3 + t * t * t * x4;
                double yt = v * v * v * y1 + 3 * t * v * v * y2 + 3 * t * t * v * y3 + t * t * t * y4;
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

    public static class Painter implements IObject {
        private double currentX = 0;
        private double currentY = 0;
        private double startX = 0;
        private double startY = 0;
        private double lastControlX = 0;
        private double lastControlY = 0;
        public boolean visible = true;

        private UUID uuid;

        private final List<IOperation> stroke_plans;
        private final List<FILL_COLOR> fill_plans;
        private final Canvas parent;

        public Painter(
                Canvas parent,
                List<IOperation> stroke_plan
        //
        ) {
            this(parent, stroke_plan, List.of());
        }

        public Painter(
                Canvas parent,
                List<IOperation> stroke_plans,
                List<FILL_COLOR> fill_plans
        //
        ) {
            this.stroke_plans = stroke_plans;
            this.parent = parent;
            this.fill_plans = fill_plans;
        }

        public BufferedImage run() {
            Canvas canvas = new Canvas(this.parent.window, null, this.parent.getWidth(), this.parent.getHeight());
            for (IOperation op : stroke_plans) {
                if (op instanceof COLOR) {
                    COLOR c = (COLOR) op;
                    canvas.setColor(c.color);
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
                    canvas.line(this.currentX, this.currentY, l.x1, l.y1, l.getStrokeWidth());
                    this.currentX = l.x1;
                    this.currentY = l.y1;
                }
                if (op instanceof CURVE) {
                    CURVE c = (CURVE) op;
                    canvas.bezier(
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
                    canvas.bezier(
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
                canvas.fill(op.x, op.y, op.color, op.tolerance, op.kernelSize);
            }
            return canvas.getImage();
        }

        @Override
        public boolean isVisible() {
            return this.visible;
        }

        @Override
        public UUID getID() {
            return this.uuid;
        }

        @Override
        public Canvas getParent() {
            return this.parent;
        }

        @Override
        public void render(Graphics2D g) {
            BufferedImage image = this.run();
            g.drawImage(image, null, 0, 0);
        }

        @Override
        public void update(double dt) {
            // empty no update
        }
    }

    public class Frame1 {
        public static ArrayList<Canvas> list = new ArrayList<>();

        public static void setup(Window window) {
            {
                Canvas canvas = new Canvas(window, "layer0", 600, 600);
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(121, 424),
                        new CURVE(88, 343, 126, 263, 136, 252),
                        new CURVE(155, 227, 158, 227, 178, 220),
                        new CURVE(169, 215, 172, 195, 195, 210),
                        new CURVE(181, 211, 212, 187, 219, 223),
                        new CURVE(264, 231, 342, 315, 296, 422),
                        new CURVE(264, 446, 180, 476, 121, 425),
                        new MOVE(124, 277),
                        new CURVE(111, 274, 112, 230, 143, 247),
                        new MOVE(164, 267),
                        new CURVE(160, 259, 195, 260, 180, 284),
                        new CURVE(163, 287, 143, 271, 164, 267),
                        new MOVE(205, 327),
                        new CURVE(212, 351, 251, 339, 245, 307),
                        new MOVE(201, 273),
                        new LINE(219, 276),
                        new CURVE(223, 283, 206, 287, 210, 276),
                        new MOVE(134, 264),
                        new LINE(151, 269),
                        new CURVE(154, 265, 144, 284, 141, 267),
                        new MOVE(202, 255),
                        new CURVE(200, 250, 212, 240, 218, 254),
                        new MOVE(208, 427),
                        new CURVE(227, 421, 241, 426, 235, 390),
                        new MOVE(234, 419),
                        new CURVE(241, 415, 255, 432, 274, 404),
                        new MOVE(155, 448),
                        new CURVE(147, 443, 156, 483, 192, 455),
                        new MOVE(231, 451),
                        new CURVE(228, 461, 272, 474, 264, 443),
                        new MOVE(341, 422),
                        new CURVE(340, 336, 394, 323, 418, 323),
                        new CURVE(404, 300, 428, 294, 439, 314),
                        new CURVE(438, 286, 482, 304, 466, 322),
                        new CURVE(488, 335, 532, 344, 524, 420),
                        new LINE(342, 421),
                        new MOVE(363, 403),
                        new CURVE(359, 386, 402, 395, 384, 423),
                        new MOVE(440, 423),
                        new CURVE(416, 411, 444, 381, 466, 407),
                        new MOVE(380, 356),
                        new SMALL_CURVE(375, 351, 389, 352),
                        new MOVE(454, 364),
                        new SMALL_CURVE(457, 355, 465, 364),
                        new MOVE(382, 398),
                        new CURVE(379, 399, 384, 376, 394, 383),
                        new CURVE(393, 389, 403, 388, 409, 383),
                        new CURVE(408, 388, 418, 387, 423, 383),
                        new CURVE(427, 387, 426, 385, 435, 385),
                        new SMALL_CURVE(440, 385, 443, 399),
                        new MOVE(396, 420),
                        new SMALL_CURVE(391, 405, 401, 397),
                        new SMALL_CURVE(406, 390, 423, 399),
                        new SMALL_CURVE(426, 408, 424, 423),
                        new MOVE(145, 255),
                        new LINE(152, 258),
                        new MOVE(443, 354),
                        new CURVE(427, 348, 440, 379, 448, 374),
                        new MOVE(442, 372),
                        new CURVE(399, 384, 406, 346, 438, 358));
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(268, 347, new Color(254, 219, 119, 255)),
                        new FILL_COLOR(123, 254, new Color(254, 219, 119, 255)),
                        new FILL_COLOR(170, 275, new Color(252, 172, 119, 255)),
                        new FILL_COLOR(252, 454, new Color(252, 172, 119, 255)),
                        new FILL_COLOR(167, 458, new Color(252, 172, 119, 255)),
                        new FILL_COLOR(421, 364, new Color(252, 172, 119, 255)),
                        new FILL_COLOR(402, 347, new Color(254, 219, 119, 255)),
                        new FILL_COLOR(213, 279, new Color(0, 0, 0, 255)),
                        new FILL_COLOR(144, 271, new Color(0, 0, 0, 255)),
                        new FILL_COLOR(428, 396, new Color(255, 255, 255, 255)),
                        new FILL_COLOR(407, 406, new Color(0, 0, 0, 255)));

                canvas.add(new Painter(canvas, plan, fill_plan));
                window.add(canvas);
                canvas.setVisible(false);
                list.add(canvas);
            }
            {
                Canvas canvas = new Canvas(window, "layer0", 600, 600);
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(89, 424),
                        new LINE(568, 422),
                        new MOVE(44, 263),
                        new SMALL_CURVE(53, 259, 62, 237),
                        new SMALL_CURVE(68, 251, 82, 259),
                        new SMALL_CURVE(66, 267, 63, 285),
                        new SMALL_CURVE(59, 267, 46, 265),
                        new MOVE(120, 168),
                        new SMALL_CURVE(114, 179, 100, 191),
                        new SMALL_CURVE(107, 192, 120, 210),
                        new SMALL_CURVE(117, 194, 139, 189),
                        new SMALL_CURVE(122, 181, 121, 167),
                        new MOVE(296, 183),
                        new CURVE(275, 180, 288, 211, 299, 204),
                        new SMALL_CURVE(315, 189, 296, 183),
                        new MOVE(308, 260),
                        new SMALL_CURVE(316, 252, 328, 242),
                        new SMALL_CURVE(328, 252, 349, 263),
                        new SMALL_CURVE(330, 263, 328, 281),
                        new SMALL_CURVE(321, 269, 308, 261));
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(65, 255, new Color(254, 219, 119, 255)),
                        new FILL_COLOR(328, 259, new Color(254, 219, 119, 255)),
                        new FILL_COLOR(294, 194, new Color(254, 219, 119, 255)),
                        new FILL_COLOR(112, 189, new Color(254, 219, 119, 255)));

                canvas.add(new Painter(canvas, plan, fill_plan));
                window.add(canvas);
                canvas.setVisible(false);
                list.add(canvas);
            }
        }
    }

    public class Frame2 {
        public static ArrayList<Canvas> list = new ArrayList<>();

        public static void setup(Window window) {
            {
                Canvas canvas = new Canvas(window, "layer0", 600, 600);
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(128, 423),
                        new CURVE(56, 299, 133, 237, 187, 223),
                        new CURVE(180, 217, 188, 191, 206, 212),
                        new CURVE(189, 207, 228, 186, 223, 224),
                        new CURVE(227, 225, 264, 227, 278, 292),
                        new CURVE(293, 304, 350, 341, 300, 423),
                        new CURVE(282, 435, 209, 476, 126, 423),
                        new MOVE(159, 442),
                        new CURVE(126, 448, 178, 487, 193, 450),
                        new MOVE(226, 448),
                        new CURVE(210, 459, 272, 476, 267, 443),
                        new MOVE(121, 266),
                        new CURVE(112, 241, 139, 233, 151, 241),
                        new MOVE(204, 329),
                        new CURVE(204, 348, 259, 348, 240, 310),
                        new MOVE(234, 380),
                        new CURVE(230, 358, 287, 403, 236, 420),
                        new MOVE(258, 407),
                        new CURVE(266, 409, 281, 415, 284, 399),
                        new MOVE(155, 279),
                        new CURVE(160, 261, 178, 263, 185, 275),
                        new CURVE(182, 278, 170, 299, 154, 278),
                        new MOVE(197, 279),
                        new LINE(212, 280),
                        new SMALL_CURVE(205, 293, 204, 282),
                        new MOVE(131, 271),
                        new LINE(144, 274),
                        new SMALL_CURVE(140, 279, 139, 274),
                        new MOVE(341, 423),
                        new CURVE(346, 328, 399, 320, 417, 324),
                        new CURVE(408, 325, 411, 279, 439, 315),
                        new CURVE(426, 292, 479, 295, 469, 323),
                        new CURVE(502, 341, 523, 343, 527, 423),
                        new LINE(342, 421),
                        new MOVE(363, 401),
                        new SMALL_CURVE(397, 383, 386, 423),
                        new MOVE(440, 423),
                        new SMALL_CURVE(416, 389, 463, 403),
                        new MOVE(382, 397),
                        new CURVE(384, 391, 384, 381, 396, 380),
                        new SMALL_CURVE(400, 389, 410, 383),
                        new SMALL_CURVE(415, 388, 424, 381),
                        new SMALL_CURVE(424, 394, 436, 384),
                        new SMALL_CURVE(440, 387, 443, 401),
                        new MOVE(399, 423),
                        new SMALL_CURVE(380, 387, 422, 396),
                        new SMALL_CURVE(425, 408, 422, 424),
                        new MOVE(384, 354),
                        new SMALL_CURVE(379, 347, 383, 358),
                        new MOVE(461, 366),
                        new SMALL_CURVE(456, 357, 463, 365),
                        new MOVE(204, 259),
                        new SMALL_CURVE(211, 251, 216, 265),
                        new MOVE(146, 265),
                        new LINE(141, 261),
                        new MOVE(432, 367),
                        new CURVE(383, 375, 412, 323, 436, 352),
                        new MOVE(441, 350),
                        new SMALL_CURVE(421, 354, 437, 371)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(478, 366, new Color(254, 219, 119, 255)),
                        new FILL_COLOR(416, 357, new Color(252, 172, 119, 255)),
                        new FILL_COLOR(420, 360, new Color(252, 172, 119, 255)),
                        new FILL_COLOR(430, 398, new Color(255, 255, 255, 255)),
                        new FILL_COLOR(404, 410, new Color(0, 0, 0, 255)),
                        new FILL_COLOR(165, 275, new Color(252, 172, 119, 255)),
                        new FILL_COLOR(279, 347, new Color(254, 219, 119, 255)),
                        new FILL_COLOR(129, 246, new Color(254, 219, 119, 255)),
                        new FILL_COLOR(260, 450, new Color(252, 172, 119, 255)),
                        new FILL_COLOR(175, 456, new Color(254, 219, 119, 255))
                //
                );

                canvas.add(new Painter(canvas, plan, fill_plan));
                window.add(canvas);
                canvas.setVisible(false);
                list.add(canvas);
            }
            {
                Canvas canvas = new Canvas(window, "layer1", 600, 600);
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(39, 264),
                        new SMALL_CURVE(55, 258, 62, 234),
                        new SMALL_CURVE(72, 252, 87, 260),
                        new SMALL_CURVE(68, 267, 66, 291),
                        new SMALL_CURVE(56, 267, 42, 265),
                        new MOVE(118, 183),
                        new SMALL_CURVE(132, 178, 128, 199),
                        new SMALL_CURVE(103, 200, 117, 185),
                        new MOVE(278, 195),
                        new SMALL_CURVE(287, 188, 294, 170),
                        new SMALL_CURVE(301, 183, 320, 193),
                        new SMALL_CURVE(307, 197, 300, 216),
                        new SMALL_CURVE(289, 198, 280, 195),
                        new MOVE(331, 257),
                        new SMALL_CURVE(314, 251, 325, 268),
                        new SMALL_CURVE(340, 271, 333, 258)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(120, 192, new Color(253, 227, 54, 255)),
                        new FILL_COLOR(300, 192, new Color(253, 227, 54, 255)),
                        new FILL_COLOR(329, 260, new Color(253, 227, 54, 255)),
                        new FILL_COLOR(60, 263, new Color(253, 227, 54, 255))
                //
                );

                canvas.add(new Painter(canvas, plan, fill_plan));
                window.add(canvas);
                canvas.setVisible(false);
                list.add(canvas);
            }
        }
    }

    public class Frame3 {
        public static ArrayList<Canvas> list = new ArrayList<>();

        public static void setup(Window window) {
            {
                Canvas c1 = new Canvas(window, "layer0", 600, 600);
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(265, 439),
                        new CURVE(350, 383, 288, 238, 218, 220),
                        new CURVE(233, 217, 203, 180, 200, 209),
                        new CURVE(165, 191, 175, 230, 180, 225),
                        new CURVE(108, 223, 84, 386, 112, 406),
                        new CURVE(155, 463, 234, 446, 266, 439),
                        new CURVE(272, 435, 269, 473, 234, 459),
                        new SMALL_CURVE(226, 454, 232, 444),
                        new MOVE(196, 449),
                        new CURVE(170, 479, 146, 447, 156, 440),
                        new MOVE(241, 304),
                        new CURVE(250, 346, 220, 343, 214, 339),
                        new CURVE(208, 338, 206, 333, 202, 324),
                        new MOVE(252, 379),
                        new CURVE(256, 373, 255, 424, 216, 415),
                        new MOVE(280, 399),
                        new CURVE(278, 406, 262, 413, 250, 407),
                        new MOVE(125, 268),
                        new CURVE(105, 267, 125, 221, 146, 243),
                        new MOVE(136, 191),
                        new CURVE(124, 199, 124, 188, 120, 209),
                        new CURVE(103, 201, 118, 203, 101, 188),
                        new CURVE(124, 175, 106, 181, 120, 165),
                        new CURVE(127, 183, 132, 181, 138, 193),
                        new MOVE(183, 263),
                        new CURVE(208, 297, 118, 283, 170, 263),
                        new SMALL_CURVE(176, 262, 186, 265),
                        new MOVE(210, 283),
                        new SMALL_CURVE(219, 274, 196, 277),
                        new MOVE(145, 275),
                        new CURVE(146, 271, 140, 269, 133, 269),
                        new MOVE(214, 253),
                        new SMALL_CURVE(203, 247, 200, 259),
                        new MOVE(146, 264),
                        new SMALL_CURVE(144, 263, 137, 259),
                        new MOVE(84, 261),
                        new SMALL_CURVE(69, 259, 62, 236),
                        new SMALL_CURVE(63, 260, 41, 259),
                        new SMALL_CURVE(58, 264, 64, 281),
                        new SMALL_CURVE(63, 263, 84, 262),
                        new MOVE(330, 277),
                        new SMALL_CURVE(327, 263, 348, 259),
                        new SMALL_CURVE(331, 254, 328, 238),
                        new SMALL_CURVE(322, 254, 305, 259),
                        new SMALL_CURVE(327, 271, 329, 281),
                        new MOVE(339, 421),
                        new SMALL_CURVE(339, 329, 417, 323),
                        new SMALL_CURVE(407, 300, 426, 303),
                        new SMALL_CURVE(432, 307, 438, 316),
                        new SMALL_CURVE(439, 291, 468, 307),
                        new SMALL_CURVE(470, 311, 466, 321),
                        new SMALL_CURVE(527, 337, 526, 423),
                        new LINE(342, 423),
                        new MOVE(382, 422),
                        new CURVE(398, 411, 380, 378, 360, 405),
                        new MOVE(439, 423),
                        new CURVE(420, 405, 456, 385, 465, 405),
                        new MOVE(442, 401),
                        new CURVE(443, 402, 435, 381, 434, 385),
                        new SMALL_CURVE(430, 394, 421, 386),
                        new SMALL_CURVE(416, 394, 409, 384),
                        new SMALL_CURVE(401, 392, 392, 383),
                        new SMALL_CURVE(383, 384, 382, 397),
                        new MOVE(433, 343),
                        new SMALL_CURVE(414, 346, 424, 369),
                        new MOVE(426, 349),
                        new CURVE(404, 324, 392, 371, 421, 361),
                        new MOVE(398, 424),
                        new CURVE(386, 386, 412, 395, 424, 399),
                        new SMALL_CURVE(430, 409, 423, 424),
                        new MOVE(454, 353),
                        new SMALL_CURVE(451, 348, 446, 349),
                        new MOVE(400, 341),
                        new SMALL_CURVE(389, 337, 385, 347)
                //
                );
                List<FILL_COLOR> fill_plan = List.of(
                        new FILL_COLOR(172, 331, new Color(248, 220, 133, 255)),
                        new FILL_COLOR(171, 271, new Color(240, 175, 127, 255)),
                        new FILL_COLOR(126, 250, new Color(243, 221, 144, 255)),
                        new FILL_COLOR(244, 451, new Color(230, 178, 134, 255)),
                        new FILL_COLOR(172, 451, new Color(222, 180, 140, 255)),
                        new FILL_COLOR(119, 190, new Color(243, 221, 144, 255)),
                        new FILL_COLOR(68, 258, new Color(239, 222, 153, 255)),
                        new FILL_COLOR(328, 255, new Color(243, 221, 144, 255)),
                        new FILL_COLOR(496, 397, new Color(243, 221, 144, 255)),
                        new FILL_COLOR(411, 350, new Color(230, 178, 134, 255)),
                        new FILL_COLOR(406, 409, new Color(0, 0, 0, 255))
                //
                );

                c1.add(new Painter(c1, plan, fill_plan));
                window.add(c1);
                c1.setVisible(false);
                list.add(c1);
            }
            {
                Canvas c2 = new Canvas(window, "layer0", 600, 600);
                List<IOperation> plan = List.of(
                        new COLOR(new Color(0, 0, 0)),
                        new MOVE(85, 422),
                        new LINE(564, 421));
                List<FILL_COLOR> fill_plan = List.of();

                c2.add(new Painter(c2, plan, fill_plan));
                window.add(c2);
                c2.setVisible(false);
                list.add(c2);
            }
        }
    }
}

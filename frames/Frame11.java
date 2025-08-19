package frames;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import engine.Painter;
import engine.operation.COLOR;
import engine.operation.CURVE;
import engine.operation.FILL_COLOR;
import engine.operation.LINE;
import engine.operation.MOVE;
import engine.operation.SMALL_CURVE;
import engine.operation.iterfaces.IOperation;

public class Frame11 {
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

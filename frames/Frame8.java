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

public class Frame8 {
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

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

public class Frame10 {
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

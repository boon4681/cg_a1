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

public class Frame2 {
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

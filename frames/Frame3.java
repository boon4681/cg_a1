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

public class Frame3 {
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

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

public class Frame14 {
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

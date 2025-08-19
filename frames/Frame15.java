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

public class Frame15 {
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

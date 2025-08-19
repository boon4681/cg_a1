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

public class Frame13 {
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

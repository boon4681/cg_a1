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

public class Frame16 {
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

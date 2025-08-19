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

public class Frame5 {
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
                    new MOVE(111, 499),
                    new CURVE(140, 463, 172, 460, 200, 459),
                    new CURVE(236, 444, 223, 419, 262, 406),
                    new CURVE(269, 387, 326, 405, 364, 422),
                    new CURVE(436, 430, 434, 387, 449, 384),
                    new CURVE(460, 368, 496, 365, 474, 451),
                    new MOVE(404, 423),
                    new CURVE(399, 418, 416, 445, 423, 429),
                    new SMALL_CURVE(420, 396, 460, 375),
                    new MOVE(481, 388),
                    new CURVE(447, 357, 497, 320, 533, 338),
                    new CURVE(569, 343, 566, 281, 600, 254),
                    new MOVE(444, 600),
                    new CURVE(502, 533, 530, 566, 600, 476),
                    new MOVE(261, 523),
                    new CURVE(328, 441, 356, 522, 399, 499),
                    new MOVE(295, 600),
                    new SMALL_CURVE(280, 584, 309, 549),
                    new MOVE(159, 600),
                    new CURVE(137, 548, 106, 534, 112, 499),
                    new CURVE(98, 479, 77, 421, 67, 418),
                    new CURVE(49, 383, 42, 371, 25, 357),
                    new SMALL_CURVE(11, 325, 0, 323),
                    new MOVE(104, 485),
                    new CURVE(142, 472, 146, 447, 176, 448),
                    new CURVE(248, 432, 224, 365, 344, 397),
                    new CURVE(403, 443, 375, 359, 429, 365),
                    new CURVE(428, 372, 443, 398, 470, 367),
                    new SMALL_CURVE(456, 367, 433, 369),
                    new CURVE(426, 372, 447, 330, 472, 333),
                    new CURVE(475, 352, 477, 347, 466, 367),
                    new MOVE(473, 335),
                    new SMALL_CURVE(456, 317, 444, 336),
                    new SMALL_CURVE(429, 315, 455, 311),
                    new SMALL_CURVE(438, 298, 451, 297),
                    new CURVE(452, 285, 424, 264, 410, 263),
                    new CURVE(393, 263, 378, 266, 360, 295),
                    new LINE(356, 292),
                    new CURVE(330, 305, 334, 357, 369, 369),
                    new SMALL_CURVE(360, 387, 339, 396),
                    new MOVE(408, 263),
                    new CURVE(400, 251, 414, 230, 423, 247),
                    new CURVE(420, 238, 438, 242, 436, 262),
                    new CURVE(447, 235, 444, 267, 460, 285),
                    new CURVE(480, 275, 463, 309, 472, 332),
                    new MOVE(69, 419),
                    new CURVE(92, 381, 140, 364, 188, 393),
                    new CURVE(207, 403, 239, 343, 273, 371),
                    new MOVE(267, 393),
                    new CURVE(255, 380, 276, 356, 296, 376),
                    new CURVE(329, 397, 327, 347, 346, 349),
                    new MOVE(313, 391),
                    new SMALL_CURVE(321, 368, 361, 366),
                    new MOVE(265, 367),
                    new CURVE(252, 310, 311, 322, 308, 330),
                    new CURVE(316, 331, 329, 325, 341, 331),
                    new MOVE(194, 394),
                    new CURVE(199, 373, 190, 360, 184, 350),
                    new CURVE(172, 339, 160, 324, 164, 299),
                    new CURVE(160, 255, 154, 235, 146, 201),
                    new SMALL_CURVE(180, 237, 219, 167),
                    new CURVE(215, 194, 254, 166, 229, 207),
                    new CURVE(231, 186, 287, 199, 244, 262),
                    new CURVE(259, 247, 326, 295, 317, 330),
                    new MOVE(106, 415),
                    new CURVE(136, 406, 135, 447, 174, 434),
                    new MOVE(162, 211),
                    new LINE(139, 151),
                    new SMALL_CURVE(105, 67, 139, 93),
                    new CURVE(123, 80, 138, 57, 153, 83),
                    new CURVE(140, 75, 161, 51, 169, 80),
                    new CURVE(164, 63, 181, 51, 190, 98),
                    new CURVE(200, 85, 210, 95, 192, 122),
                    new LINE(212, 185),
                    new MOVE(163, 210),
                    new SMALL_CURVE(135, 210, 153, 189),
                    new MOVE(206, 165),
                    new SMALL_CURVE(225, 160, 212, 183),
                    new MOVE(0, 550),
                    new CURVE(11, 576, 5, 591, 20, 600)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(533, 425, new Color(150, 132, 170, 255)),
                    new FILL_COLOR(207, 404, new Color(150, 132, 170, 255)),
                    new FILL_COLOR(311, 349, new Color(150, 132, 170, 255)),
                    new FILL_COLOR(284, 377, new Color(97, 74, 102, 255)),
                    new FILL_COLOR(337, 357, new Color(97, 74, 102, 255)),
                    // new FILL_COLOR(428, 377, new Color(97, 74, 102, 255)),
                    new FILL_COLOR(404, 394, new Color(113, 90, 116, 255)),
                    new FILL_COLOR(420, 426, new Color(97, 74, 102, 255)),
                    new FILL_COLOR(457, 353, new Color(160, 137, 158, 255)),
                    new FILL_COLOR(412, 328, new Color(190, 169, 185, 255)),
                    new FILL_COLOR(76, 486, new Color(89, 62, 84, 255)),
                    new FILL_COLOR(4, 592, new Color(150, 132, 170, 255)),
                    new FILL_COLOR(338, 377, new Color(145, 123, 147, 255)),
                    new FILL_COLOR(179, 147, new Color(189, 168, 184, 255)),
                    new FILL_COLOR(209, 240, new Color(137, 122, 159, 255)),
                    new FILL_COLOR(421, 257, new Color(167, 139, 167, 255)),
                    new FILL_COLOR(211, 169, new Color(110, 87, 116, 255)),
                    new FILL_COLOR(153, 200, new Color(110, 87, 116, 255))
            //
            );

            Painter painter = new Painter(600, 600, plan, fill_plan);
            list.add(painter.paint());
        }
        {
            List<IOperation> plan = List.of(
                    new COLOR(new Color(0, 0, 0)),
                    new MOVE(359, 298),
                    new CURVE(365, 266, 406, 291, 398, 323),
                    new SMALL_CURVE(388, 304, 357, 297),
                    new MOVE(144, 172),
                    new CURVE(132, 167, 113, 189, 115, 226),
                    new CURVE(113, 271, 180, 259, 165, 212),
                    new CURVE(152, 201, 168, 177, 146, 172),
                    new MOVE(600, 287),
                    new SMALL_CURVE(584, 287, 588, 295),
                    new CURVE(600, 397, 496, 333, 538, 285),
                    new CURVE(520, 263, 508, 194, 572, 163),
                    new SMALL_CURVE(581, 156, 600, 156),
                    new MOVE(549, 499),
                    new CURVE(527, 494, 514, 539, 526, 542),
                    new CURVE(524, 562, 546, 579, 571, 566),
                    new CURVE(600, 561, 582, 513, 564, 523),
                    new CURVE(566, 516, 563, 497, 548, 500),
                    new MOVE(194, 198),
                    new CURVE(170, 195, 188, 164, 199, 177),
                    new CURVE(210, 179, 206, 197, 192, 198),
                    new MOVE(230, 352),
                    new CURVE(218, 349, 218, 371, 224, 371),
                    new CURVE(244, 381, 251, 345, 230, 351),
                    new MOVE(260, 259),
                    new CURVE(248, 249, 229, 277, 243, 279),
                    new CURVE(251, 284, 270, 276, 260, 259),
                    new MOVE(506, 299),
                    new CURVE(501, 293, 489, 316, 504, 314),
                    new CURVE(525, 319, 512, 295, 507, 297),
                    new MOVE(48, 422),
                    new CURVE(63, 408, 73, 442, 59, 443),
                    new CURVE(44, 450, 28, 416, 53, 419),
                    new MOVE(225, 303),
                    new CURVE(220, 298, 227, 279, 242, 291),
                    new CURVE(244, 295, 242, 309, 225, 303),
                    new MOVE(0, 284),
                    new CURVE(11, 287, 16, 264, 0, 265),
                    new MOVE(187, 519),
                    new CURVE(198, 509, 201, 541, 185, 537),
                    new CURVE(181, 543, 173, 519, 187, 519),
                    new MOVE(211, 552),
                    new CURVE(172, 557, 210, 527, 216, 535),
                    new CURVE(231, 541, 221, 550, 206, 553)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(568, 231, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(382, 298, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(507, 307, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(565, 547, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(185, 527, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(212, 545, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(52, 434, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(3, 274, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(231, 363, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(227, 295, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(254, 268, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(128, 221, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(199, 186, new Color(220, 181, 178, 255))
            //
            );

            Painter painter = new Painter(600, 600, plan, fill_plan);
            list.add(painter.paint());
        }
        return list;
    }
}

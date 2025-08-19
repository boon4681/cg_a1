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

public class Frame7 {
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
                    new CURVE(236, 444, 223, 419, 260, 407),
                    new CURVE(272, 391, 326, 405, 364, 422),
                    new CURVE(436, 430, 425, 388, 432, 379),
                    new CURVE(438, 344, 476, 371, 468, 440),
                    new MOVE(404, 423),
                    new CURVE(399, 418, 416, 445, 423, 429),
                    new SMALL_CURVE(420, 396, 435, 377),
                    new MOVE(457, 378),
                    new CURVE(435, 314, 477, 298, 504, 305),
                    new CURVE(467, 189, 562, 184, 600, 198),
                    new MOVE(444, 600),
                    new CURVE(512, 539, 536, 542, 600, 447),
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
                    new CURVE(403, 443, 375, 359, 431, 368),
                    new SMALL_CURVE(424, 364, 436, 369),
                    new CURVE(426, 372, 447, 330, 453, 334),
                    new CURVE(449, 343, 452, 361, 456, 372),
                    new MOVE(453, 332),
                    new SMALL_CURVE(446, 333, 444, 336),
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
                    new CURVE(480, 275, 468, 295, 468, 311),
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
                    new CURVE(196, 374, 197, 368, 196, 344),
                    new CURVE(182, 332, 179, 310, 183, 294),
                    new CURVE(195, 258, 197, 239, 194, 195),
                    new SMALL_CURVE(228, 215, 280, 179),
                    new CURVE(287, 187, 303, 207, 268, 212),
                    new CURVE(280, 203, 344, 214, 274, 269),
                    new CURVE(289, 275, 333, 303, 328, 329),
                    new MOVE(106, 415),
                    new CURVE(136, 406, 135, 447, 174, 434),
                    new MOVE(209, 201),
                    new LINE(210, 140),
                    new SMALL_CURVE(196, 44, 220, 75),
                    new CURVE(213, 62, 233, 44, 240, 72),
                    new CURVE(234, 56, 254, 47, 258, 79),
                    new CURVE(249, 59, 276, 47, 266, 97),
                    new CURVE(281, 90, 298, 103, 263, 120),
                    new LINE(267, 188),
                    new MOVE(197, 195),
                    new SMALL_CURVE(185, 197, 210, 179),
                    new MOVE(267, 165),
                    new SMALL_CURVE(277, 167, 281, 179),
                    new MOVE(0, 550),
                    new CURVE(11, 576, 5, 591, 20, 600)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(207, 404, new Color(150, 132, 170, 255)),
                    new FILL_COLOR(432, 265, new Color(167, 139, 167, 255)),
                    new FILL_COLOR(84, 479, new Color(89, 62, 84, 255)),
                    new FILL_COLOR(301, 429, new Color(150, 132, 170, 255)),
                    new FILL_COLOR(412, 393, new Color(113, 90, 116, 255)),
                    new FILL_COLOR(384, 331, new Color(190, 169, 185, 255)),
                    new FILL_COLOR(232, 289, new Color(135, 123, 157, 255)),
                    new FILL_COLOR(227, 150, new Color(189, 167, 184, 255)),
                    new FILL_COLOR(204, 190, new Color(109, 89, 118, 255)),
                    new FILL_COLOR(268, 172, new Color(109, 89, 118, 255)),
                    new FILL_COLOR(304, 351, new Color(150, 132, 170, 255)),
                    new FILL_COLOR(415, 425, new Color(88, 67, 92, 255)),
                    new FILL_COLOR(447, 355, new Color(160, 137, 158, 255)),
                    new FILL_COLOR(338, 385, new Color(145, 123, 147, 255)),
                    new FILL_COLOR(284, 378, new Color(97, 74, 102, 255)),
                    new FILL_COLOR(6, 591, new Color(150, 132, 170, 255)),
                    new FILL_COLOR(341, 364, new Color(97, 74, 102, 255))
            //
            );

            Painter painter = new Painter(600, 600, plan, fill_plan);
            list.add(painter.paint());
        }
        {
            List<IOperation> plan = List.of(
                    new COLOR(new Color(0, 0, 0)),
                    new MOVE(353, 294),
                    new CURVE(344, 285, 340, 267, 352, 267),
                    new CURVE(327, 255, 333, 220, 356, 208),
                    new CURVE(351, 172, 434, 163, 414, 242),
                    new CURVE(423, 248, 433, 255, 419, 281),
                    new CURVE(406, 298, 432, 315, 410, 328),
                    new CURVE(396, 325, 373, 280, 354, 295),
                    new MOVE(432, 175),
                    new CURVE(425, 169, 406, 186, 427, 196),
                    new CURVE(446, 191, 436, 179, 432, 175),
                    new MOVE(600, 176),
                    new CURVE(560, 167, 596, 209, 559, 221),
                    new CURVE(494, 219, 527, 163, 524, 143),
                    new CURVE(499, 111, 515, 82, 542, 66),
                    new CURVE(559, 55, 585, 15, 600, 24),
                    new MOVE(503, 371),
                    new CURVE(525, 383, 551, 393, 550, 435),
                    new CURVE(526, 465, 487, 463, 494, 413),
                    new CURVE(461, 388, 490, 363, 505, 373),
                    new MOVE(203, 506),
                    new CURVE(191, 503, 183, 546, 223, 531),
                    new CURVE(259, 503, 225, 485, 200, 507),
                    new MOVE(43, 311),
                    new CURVE(62, 310, 56, 340, 37, 336),
                    new CURVE(7, 330, 21, 295, 48, 312),
                    new MOVE(0, 219),
                    new CURVE(29, 211, 23, 187, 0, 181),
                    new MOVE(133, 96),
                    new CURVE(121, 98, 117, 123, 133, 150),
                    new CURVE(120, 154, 126, 188, 167, 184),
                    new CURVE(176, 180, 204, 153, 173, 125),
                    new CURVE(163, 112, 160, 83, 134, 95),
                    new MOVE(208, 99),
                    new CURVE(173, 99, 177, 138, 205, 139),
                    new CURVE(216, 141, 237, 98, 204, 99),
                    new MOVE(280, 187),
                    new CURVE(250, 187, 257, 213, 282, 212),
                    new CURVE(292, 219, 294, 183, 277, 188),
                    new MOVE(243, 300),
                    new CURVE(237, 288, 255, 265, 274, 290),
                    new CURVE(281, 302, 252, 329, 243, 299),
                    new MOVE(243, 247),
                    new CURVE(228, 240, 239, 208, 264, 223),
                    new CURVE(267, 231, 271, 256, 244, 247),
                    new MOVE(210, 446),
                    new CURVE(224, 446, 229, 474, 212, 475),
                    new CURVE(177, 478, 194, 437, 210, 446)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(560, 102, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(397, 226, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(430, 186, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(515, 423, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(260, 293, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(10, 197, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(35, 320, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(169, 136, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(248, 230, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(280, 196, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(200, 115, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(211, 462, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(218, 515, new Color(220, 181, 178, 255))
            //
            );

            Painter painter = new Painter(600, 600, plan, fill_plan);
            list.add(painter.paint());
        }
        return list;
    }
}

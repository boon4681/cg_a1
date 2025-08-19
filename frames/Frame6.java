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

public class Frame6 {
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
                    new CURVE(436, 430, 425, 388, 440, 383),
                    new CURVE(441, 354, 484, 369, 468, 440),
                    new MOVE(404, 423),
                    new CURVE(399, 418, 416, 445, 423, 429),
                    new SMALL_CURVE(420, 396, 449, 370),
                    new MOVE(464, 369),
                    new CURVE(442, 323, 491, 318, 520, 316),
                    new CURVE(498, 196, 584, 223, 600, 215),
                    new MOVE(444, 600),
                    new CURVE(514, 544, 530, 554, 600, 467),
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
                    new SMALL_CURVE(464, 371, 436, 369),
                    new CURVE(426, 372, 447, 330, 469, 334),
                    new CURVE(449, 343, 467, 365, 460, 373),
                    new MOVE(470, 331),
                    new SMALL_CURVE(450, 319, 444, 336),
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
                    new CURVE(480, 275, 463, 309, 469, 332),
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
                    new CURVE(171, 257, 158, 234, 156, 204),
                    new SMALL_CURVE(220, 206, 229, 164),
                    new CURVE(227, 187, 276, 174, 229, 207),
                    new CURVE(247, 187, 304, 196, 244, 262),
                    new CURVE(259, 247, 326, 295, 317, 330),
                    new MOVE(106, 415),
                    new CURVE(136, 406, 135, 447, 174, 434),
                    new MOVE(170, 203),
                    new LINE(156, 136),
                    new SMALL_CURVE(124, 49, 156, 83),
                    new CURVE(148, 67, 164, 41, 173, 77),
                    new CURVE(171, 66, 183, 37, 191, 76),
                    new CURVE(186, 55, 206, 47, 207, 92),
                    new CURVE(211, 84, 243, 84, 208, 111),
                    new LINE(223, 182),
                    new MOVE(157, 206),
                    new SMALL_CURVE(150, 196, 166, 186),
                    new MOVE(221, 160),
                    new SMALL_CURVE(227, 154, 230, 173),
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
                    // new FILL_COLOR(457, 353, new Color(160, 137, 158, 255)),
                    new FILL_COLOR(412, 328, new Color(190, 169, 185, 255)),
                    new FILL_COLOR(4, 592, new Color(150, 132, 170, 255)),
                    new FILL_COLOR(338, 377, new Color(145, 123, 147, 255)),
                    new FILL_COLOR(179, 147, new Color(189, 168, 184, 255)),
                    new FILL_COLOR(209, 240, new Color(137, 122, 159, 255)),
                    new FILL_COLOR(187, 140, new Color(190, 169, 185, 255)),
                    new FILL_COLOR(224, 167, new Color(110, 88, 117, 255)),
                    new FILL_COLOR(163, 197, new Color(110, 88, 117, 255)),
                    new FILL_COLOR(82, 515, new Color(89, 62, 84, 255)),
                    new FILL_COLOR(414, 390, new Color(113, 90, 116, 255)),
                    new FILL_COLOR(416, 425, new Color(97, 74, 102, 255)),
                    new FILL_COLOR(432, 265, new Color(167, 139, 167, 255))
            //
            );

            Painter painter = new Painter(600, 600, plan, fill_plan);
            list.add(painter.paint());
        }
        {
            List<IOperation> plan = List.of(
                    new COLOR(new Color(0, 0, 0)),
                    new MOVE(352, 295),
                    new CURVE(353, 278, 346, 219, 390, 234),
                    new CURVE(411, 244, 400, 271, 414, 295),
                    new CURVE(414, 311, 416, 315, 396, 322),
                    new SMALL_CURVE(385, 303, 353, 296),
                    new MOVE(165, 189),
                    new CURVE(128, 192, 138, 150, 129, 135),
                    new CURVE(108, 111, 140, 90, 164, 114),
                    new CURVE(190, 146, 207, 167, 164, 191),
                    new MOVE(224, 145),
                    new CURVE(184, 163, 188, 95, 217, 109),
                    new CURVE(219, 103, 244, 129, 223, 145),
                    new MOVE(542, 247),
                    new CURVE(519, 244, 499, 179, 534, 167),
                    new CURVE(495, 155, 491, 91, 544, 90),
                    new CURVE(556, 71, 560, 43, 600, 49),
                    new MOVE(600, 196),
                    new CURVE(589, 204, 569, 192, 574, 207),
                    new CURVE(576, 231, 565, 251, 540, 246),
                    new MOVE(500, 506),
                    new CURVE(482, 489, 500, 434, 532, 438),
                    new CURVE(544, 445, 540, 469, 553, 495),
                    new CURVE(559, 526, 515, 525, 500, 507),
                    new MOVE(0, 267),
                    new CURVE(36, 277, 29, 221, 0, 237),
                    new MOVE(232, 316),
                    new CURVE(243, 291, 283, 315, 255, 345),
                    new CURVE(247, 355, 214, 333, 233, 315),
                    new MOVE(43, 357),
                    new CURVE(60, 351, 56, 385, 49, 379),
                    new CURVE(15, 389, 26, 339, 51, 361),
                    new MOVE(201, 481),
                    new CURVE(206, 478, 219, 503, 200, 503),
                    new CURVE(173, 504, 189, 472, 204, 483),
                    new MOVE(233, 529),
                    new CURVE(203, 526, 234, 488, 242, 509),
                    new CURVE(252, 514, 245, 529, 232, 529),
                    new MOVE(202, 555),
                    new CURVE(181, 559, 188, 591, 210, 577),
                    new CURVE(226, 568, 214, 542, 200, 555),
                    new MOVE(249, 259),
                    new CURVE(233, 247, 232, 275, 241, 277),
                    new CURVE(259, 283, 264, 263, 247, 259),
                    new MOVE(275, 224),
                    new CURVE(248, 216, 252, 242, 260, 240),
                    new CURVE(264, 246, 284, 243, 276, 226),
                    new MOVE(420, 215),
                    new CURVE(404, 211, 406, 231, 421, 233),
                    new CURVE(424, 236, 440, 215, 420, 215),
                    new MOVE(493, 249),
                    new CURVE(488, 247, 499, 231, 509, 239),
                    new CURVE(523, 243, 512, 268, 492, 247)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(531, 135, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(419, 223, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(505, 248, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(377, 267, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(512, 481, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(250, 324, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(240, 267, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(269, 234, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(160, 150, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(12, 249, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(38, 371, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(195, 491, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(240, 516, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(210, 562, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(223, 127, new Color(220, 181, 178, 255))
            //
            );

            Painter painter = new Painter(600, 600, plan, fill_plan);
            list.add(painter.paint());
        }
        return list;
    }

}

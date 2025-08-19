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

public class Frame4 {
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
                    new CURVE(436, 430, 434, 387, 456, 391),
                    new CURVE(466, 383, 496, 365, 474, 451),
                    new MOVE(404, 423),
                    new CURVE(399, 418, 416, 445, 430, 431),
                    new SMALL_CURVE(436, 406, 456, 392),
                    new MOVE(481, 388),
                    new CURVE(471, 375, 514, 324, 548, 361),
                    new CURVE(575, 354, 566, 281, 600, 284),
                    new MOVE(444, 600),
                    new CURVE(502, 533, 535, 599, 600, 488),
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
                    new CURVE(403, 443, 375, 359, 432, 368),
                    new CURVE(428, 372, 473, 410, 472, 366),
                    new SMALL_CURVE(458, 369, 433, 369),
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
                    new CURVE(178, 368, 148, 369, 141, 328),
                    new CURVE(130, 307, 120, 294, 100, 269),
                    new CURVE(111, 256, 154, 235, 146, 201),
                    new SMALL_CURVE(152, 195, 160, 211),
                    new CURVE(173, 209, 175, 204, 173, 230),
                    new CURVE(186, 197, 223, 219, 209, 277),
                    new CURVE(243, 247, 308, 298, 303, 325),
                    new MOVE(106, 415),
                    new CURVE(136, 406, 135, 447, 174, 434),
                    new MOVE(109, 260),
                    new LINE(41, 180),
                    new SMALL_CURVE(17, 144, 44, 161),
                    new CURVE(25, 139, 44, 128, 54, 144),
                    new CURVE(40, 127, 58, 121, 71, 139),
                    new CURVE(61, 115, 75, 113, 94, 145),
                    new CURVE(92, 133, 123, 127, 104, 167),
                    new LINE(146, 217),
                    new MOVE(102, 270),
                    new SMALL_CURVE(89, 263, 100, 250),
                    new MOVE(136, 203),
                    new SMALL_CURVE(138, 194, 150, 202),
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
                    new FILL_COLOR(452, 377, new Color(97, 74, 102, 255)),
                    new FILL_COLOR(404, 394, new Color(113, 90, 116, 255)),
                    new FILL_COLOR(420, 426, new Color(97, 74, 102, 255)),
                    new FILL_COLOR(457, 353, new Color(160, 137, 158, 255)),
                    new FILL_COLOR(412, 328, new Color(190, 169, 185, 255)),
                    new FILL_COLOR(76, 486, new Color(89, 62, 84, 255)),
                    new FILL_COLOR(4, 592, new Color(150, 132, 170, 255)),
                    new FILL_COLOR(458, 301, new Color(167, 139, 167, 255)),
                    new FILL_COLOR(338, 377, new Color(145, 123, 147, 255)),
                    new FILL_COLOR(111, 211, new Color(190, 169, 185, 255)),
                    new FILL_COLOR(102, 258, new Color(106, 83, 111, 255)),
                    new FILL_COLOR(140, 204, new Color(110, 86, 116, 255)),
                    new FILL_COLOR(208, 330, new Color(138, 122, 160, 255))
            //
            );

            Painter painter = new Painter(600, 600, plan, fill_plan);
            list.add(painter.paint());
        }
        {
            List<IOperation> plan = List.of(
                    new COLOR(new Color(0, 0, 0)),
                    new MOVE(190, 317),
                    new CURVE(126, 317, 135, 233, 161, 230),
                    new CURVE(178, 215, 196, 254, 204, 267),
                    new CURVE(211, 283, 228, 303, 188, 316),
                    new MOVE(220, 254),
                    new CURVE(182, 247, 204, 199, 224, 215),
                    new CURVE(236, 224, 239, 247, 220, 253),
                    new MOVE(600, 278),
                    new CURVE(579, 275, 576, 285, 590, 306),
                    new CURVE(592, 343, 564, 355, 546, 346),
                    new CURVE(502, 329, 512, 276, 533, 263),
                    new CURVE(505, 243, 545, 144, 600, 162),
                    new MOVE(504, 358),
                    new CURVE(490, 355, 497, 331, 514, 341),
                    new CURVE(527, 346, 510, 364, 505, 359),
                    new MOVE(515, 600),
                    new CURVE(516, 579, 559, 551, 571, 600),
                    new MOVE(232, 395),
                    new CURVE(220, 386, 248, 375, 252, 391),
                    new CURVE(255, 405, 232, 408, 231, 395),
                    new MOVE(0, 277),
                    new CURVE(12, 282, 13, 296, 0, 295),
                    new MOVE(40, 440),
                    new CURVE(57, 434, 32, 403, 31, 419),
                    new CURVE(17, 429, 31, 448, 43, 440),
                    new MOVE(265, 311),
                    new CURVE(244, 313, 253, 279, 269, 293),
                    new CURVE(272, 299, 272, 307, 265, 310),
                    new MOVE(181, 551),
                    new CURVE(196, 542, 205, 561, 191, 569),
                    new CURVE(180, 579, 164, 548, 186, 551),
                    new MOVE(225, 570),
                    new CURVE(221, 555, 194, 569, 208, 583),
                    new CURVE(220, 598, 235, 571, 225, 568)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(549, 282, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(508, 352, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(181, 267, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(220, 230, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(261, 299, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(239, 392, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(32, 430, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(188, 556, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(216, 575, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(543, 591, new Color(220, 181, 178, 255)),
                    new FILL_COLOR(2, 286, new Color(220, 181, 178, 255))
            //
            );
            Painter painter = new Painter(600, 600, plan, fill_plan);
            list.add(painter.paint());
        }
        return list;
    }
}

package frames;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import engine.Canvas;
import engine.Painter;
import engine.Window;
import engine.operation.COLOR;
import engine.operation.CURVE;
import engine.operation.FILL_COLOR;
import engine.operation.LINE;
import engine.operation.MOVE;
import engine.operation.SMALL_CURVE;
import engine.operation.iterfaces.IOperation;

public class Frame4 {
    public static ArrayList<Canvas> list = new ArrayList<>();

    public static void setup(Window window) {
        {
            Canvas c1 = new Canvas(window, "layer0", 600, 600);
            List<IOperation> plan = List.of(
                    new COLOR(new Color(0, 0, 0)),
                    new MOVE(112, 427),
                    new CURVE(78, 386, 96, 344, 113, 289),
                    new CURVE(134, 227, 157, 226, 177, 221),
                    new CURVE(172, 215, 193, 184, 202, 210),
                    new CURVE(206, 200, 241, 201, 212, 226),
                    new CURVE(248, 231, 345, 286, 284, 416),
                    new CURVE(264, 432, 207, 474, 109, 425),
                    new MOVE(120, 271),
                    new SMALL_CURVE(100, 235, 143, 240),
                    new MOVE(156, 445),
                    new CURVE(139, 448, 179, 483, 192, 448),
                    new MOVE(229, 447),
                    new CURVE(225, 462, 265, 471, 264, 431),
                    new MOVE(161, 263),
                    new CURVE(165, 263, 182, 266, 184, 270),
                    new CURVE(180, 285, 140, 277, 159, 264),
                    new MOVE(203, 326),
                    new CURVE(216, 350, 257, 339, 240, 303),
                    new MOVE(186, 417),
                    new CURVE(206, 423, 215, 434, 234, 399),
                    new MOVE(219, 421),
                    new CURVE(224, 420, 242, 438, 260, 408),
                    new MOVE(132, 263),
                    new LINE(149, 268),
                    new SMALL_CURVE(139, 278, 139, 267),
                    new MOVE(197, 271),
                    new LINE(215, 274),
                    new SMALL_CURVE(208, 285, 208, 273),
                    new MOVE(139, 254),
                    new LINE(148, 258),
                    new MOVE(197, 251),
                    new SMALL_CURVE(197, 243, 212, 248),
                    new MOVE(341, 420),
                    new CURVE(339, 352, 376, 327, 419, 322),
                    new CURVE(406, 322, 416, 277, 440, 315),
                    new CURVE(428, 302, 472, 286, 468, 323),
                    new CURVE(529, 351, 517, 387, 528, 422),
                    new LINE(341, 419),
                    new MOVE(382, 358),
                    new SMALL_CURVE(377, 349, 385, 355),
                    new MOVE(457, 366),
                    new SMALL_CURVE(455, 359, 460, 364),
                    new MOVE(365, 401),
                    new SMALL_CURVE(391, 384, 386, 421),
                    new MOVE(438, 422),
                    new SMALL_CURVE(413, 389, 464, 399),
                    new MOVE(381, 398),
                    new SMALL_CURVE(383, 387, 394, 383),
                    new SMALL_CURVE(395, 388, 409, 383),
                    new SMALL_CURVE(413, 389, 421, 383),
                    new SMALL_CURVE(426, 387, 436, 387),
                    new SMALL_CURVE(432, 387, 444, 399),
                    new MOVE(399, 371),
                    new SMALL_CURVE(409, 363, 404, 352),
                    new MOVE(436, 377),
                    new SMALL_CURVE(429, 369, 439, 360),
                    new MOVE(408, 360),
                    new SMALL_CURVE(419, 350, 436, 367),
                    new MOVE(403, 369),
                    new SMALL_CURVE(416, 379, 435, 373),
                    new MOVE(400, 422),
                    new SMALL_CURVE(391, 408, 401, 399),
                    new SMALL_CURVE(406, 391, 424, 398),
                    new SMALL_CURVE(425, 406, 424, 420)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(485, 355, new Color(254, 219, 119, 255)),
                    new FILL_COLOR(417, 365, new Color(252, 172, 119, 255)),
                    new FILL_COLOR(168, 272, new Color(252, 172, 119, 255)),
                    new FILL_COLOR(266, 350, new Color(254, 219, 119, 255)),
                    new FILL_COLOR(239, 451, new Color(252, 172, 119, 255)),
                    new FILL_COLOR(175, 455, new Color(252, 172, 119, 255)),
                    new FILL_COLOR(127, 247, new Color(252, 172, 119, 255)),
                    new FILL_COLOR(390, 395, new Color(253, 227, 54, 255)),
                    new FILL_COLOR(413, 407, new Color(0, 0, 0, 255))
            //
            );

            c1.add(new Painter(c1, plan, fill_plan));
            window.add(c1);
            c1.setVisible(false);
            list.add(c1);
        }
        {
            Canvas c2 = new Canvas(window, "layer0", 600, 600);
            List<IOperation> plan = List.of(
                    new COLOR(new Color(0, 0, 0)),
                    new MOVE(56, 259),
                    new SMALL_CURVE(68, 236, 69, 262),
                    new SMALL_CURVE(61, 267, 56, 258),
                    new MOVE(95, 188),
                    new SMALL_CURVE(104, 180, 115, 159),
                    new SMALL_CURVE(123, 179, 145, 188),
                    new SMALL_CURVE(127, 193, 120, 215),
                    new SMALL_CURVE(114, 197, 96, 189),
                    new MOVE(292, 191),
                    new SMALL_CURVE(294, 169, 306, 190),
                    new SMALL_CURVE(304, 204, 293, 194),
                    new MOVE(300, 259),
                    new SMALL_CURVE(313, 253, 322, 228),
                    new SMALL_CURVE(333, 247, 355, 261),
                    new SMALL_CURVE(340, 264, 324, 287),
                    new SMALL_CURVE(320, 271, 304, 261)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(331, 252, new Color(253, 227, 54, 255)),
                    new FILL_COLOR(299, 191, new Color(253, 227, 54, 255)),
                    new FILL_COLOR(108, 187, new Color(253, 227, 54, 255)),
                    new FILL_COLOR(64, 259, new Color(253, 227, 54, 255))
            //
            );

            c2.add(new Painter(c2, plan, fill_plan));
            window.add(c2);
            c2.setVisible(false);
            list.add(c2);
        }
    }
}

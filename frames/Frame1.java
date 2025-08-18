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

public class Frame1 {
    public static ArrayList<Canvas> list = new ArrayList<>();
    public static void setup(Window window) {
        {
            Canvas canvas = new Canvas(window, "layer0", 600, 600);
            List<IOperation> plan = List.of(
                    new COLOR(new Color(0, 0, 0)),
                    new MOVE(121, 424),
                    new CURVE(88, 343, 126, 263, 136, 252),
                    new CURVE(155, 227, 158, 227, 178, 220),
                    new CURVE(169, 215, 172, 195, 195, 210),
                    new CURVE(181, 211, 212, 187, 219, 223),
                    new CURVE(264, 231, 342, 315, 296, 422),
                    new CURVE(264, 446, 180, 476, 121, 425),
                    new MOVE(124, 277),
                    new CURVE(111, 274, 112, 230, 143, 247),
                    new MOVE(164, 267),
                    new CURVE(160, 259, 195, 260, 180, 284),
                    new CURVE(163, 287, 143, 271, 164, 267),
                    new MOVE(205, 327),
                    new CURVE(212, 351, 251, 339, 245, 307),
                    new MOVE(201, 273),
                    new LINE(219, 276),
                    new CURVE(223, 283, 206, 287, 210, 276),
                    new MOVE(134, 264),
                    new LINE(151, 269),
                    new CURVE(154, 265, 144, 284, 141, 267),
                    new MOVE(202, 255),
                    new CURVE(200, 250, 212, 240, 218, 254),
                    new MOVE(208, 427),
                    new CURVE(227, 421, 241, 426, 235, 390),
                    new MOVE(234, 419),
                    new CURVE(241, 415, 255, 432, 274, 404),
                    new MOVE(155, 448),
                    new CURVE(147, 443, 156, 483, 192, 455),
                    new MOVE(231, 451),
                    new CURVE(228, 461, 272, 474, 264, 443),
                    new MOVE(341, 422),
                    new CURVE(340, 336, 394, 323, 418, 323),
                    new CURVE(404, 300, 428, 294, 439, 314),
                    new CURVE(438, 286, 482, 304, 466, 322),
                    new CURVE(488, 335, 532, 344, 524, 420),
                    new LINE(342, 421),
                    new MOVE(363, 403),
                    new CURVE(359, 386, 402, 395, 384, 423),
                    new MOVE(440, 423),
                    new CURVE(416, 411, 444, 381, 466, 407),
                    new MOVE(380, 356),
                    new SMALL_CURVE(375, 351, 389, 352),
                    new MOVE(454, 364),
                    new SMALL_CURVE(457, 355, 465, 364),
                    new MOVE(382, 398),
                    new CURVE(379, 399, 384, 376, 394, 383),
                    new CURVE(393, 389, 403, 388, 409, 383),
                    new CURVE(408, 388, 418, 387, 423, 383),
                    new CURVE(427, 387, 426, 385, 435, 385),
                    new SMALL_CURVE(440, 385, 443, 399),
                    new MOVE(396, 420),
                    new SMALL_CURVE(391, 405, 401, 397),
                    new SMALL_CURVE(406, 390, 423, 399),
                    new SMALL_CURVE(426, 408, 424, 423),
                    new MOVE(145, 255),
                    new LINE(152, 258),
                    new MOVE(443, 354),
                    new CURVE(427, 348, 440, 379, 448, 374),
                    new MOVE(442, 372),
                    new CURVE(399, 384, 406, 346, 438, 358));
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(268, 347, new Color(254, 219, 119, 255)),
                    new FILL_COLOR(123, 254, new Color(254, 219, 119, 255)),
                    new FILL_COLOR(170, 275, new Color(252, 172, 119, 255)),
                    new FILL_COLOR(252, 454, new Color(252, 172, 119, 255)),
                    new FILL_COLOR(167, 458, new Color(252, 172, 119, 255)),
                    new FILL_COLOR(421, 364, new Color(252, 172, 119, 255)),
                    new FILL_COLOR(402, 347, new Color(254, 219, 119, 255)),
                    new FILL_COLOR(213, 279, new Color(0, 0, 0, 255)),
                    new FILL_COLOR(144, 271, new Color(0, 0, 0, 255)),
                    new FILL_COLOR(428, 396, new Color(255, 255, 255, 255)),
                    new FILL_COLOR(407, 406, new Color(0, 0, 0, 255)));

            canvas.add(new Painter(canvas, plan, fill_plan));
            window.add(canvas);
            canvas.setVisible(false);
            list.add(canvas);
        }
        {
            Canvas canvas = new Canvas(window, "layer0", 600, 600);
            List<IOperation> plan = List.of(
                    new COLOR(new Color(0, 0, 0)),
                    new MOVE(89, 424),
                    new LINE(568, 422),
                    new MOVE(44, 263),
                    new SMALL_CURVE(53, 259, 62, 237),
                    new SMALL_CURVE(68, 251, 82, 259),
                    new SMALL_CURVE(66, 267, 63, 285),
                    new SMALL_CURVE(59, 267, 46, 265),
                    new MOVE(120, 168),
                    new SMALL_CURVE(114, 179, 100, 191),
                    new SMALL_CURVE(107, 192, 120, 210),
                    new SMALL_CURVE(117, 194, 139, 189),
                    new SMALL_CURVE(122, 181, 121, 167),
                    new MOVE(296, 183),
                    new CURVE(275, 180, 288, 211, 299, 204),
                    new SMALL_CURVE(315, 189, 296, 183),
                    new MOVE(308, 260),
                    new SMALL_CURVE(316, 252, 328, 242),
                    new SMALL_CURVE(328, 252, 349, 263),
                    new SMALL_CURVE(330, 263, 328, 281),
                    new SMALL_CURVE(321, 269, 308, 261));
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(65, 255, new Color(254, 219, 119, 255)),
                    new FILL_COLOR(328, 259, new Color(254, 219, 119, 255)),
                    new FILL_COLOR(294, 194, new Color(254, 219, 119, 255)),
                    new FILL_COLOR(112, 189, new Color(254, 219, 119, 255)));

            canvas.add(new Painter(canvas, plan, fill_plan));
            window.add(canvas);
            canvas.setVisible(false);
            list.add(canvas);
        }
    }
}

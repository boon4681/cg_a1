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

public class Frame3 {
    public static ArrayList<Canvas> list = new ArrayList<>();

    public static void setup(Window window) {
        {
            Canvas c1 = new Canvas(window, "layer0", 600, 600);
            List<IOperation> plan = List.of(
                    new COLOR(new Color(0, 0, 0)),
                    new MOVE(265, 439),
                    new CURVE(350, 383, 288, 238, 218, 220),
                    new CURVE(233, 217, 203, 180, 200, 209),
                    new CURVE(165, 191, 175, 230, 180, 225),
                    new CURVE(108, 223, 84, 386, 112, 406),
                    new CURVE(155, 463, 234, 446, 266, 439),
                    new CURVE(272, 435, 269, 473, 234, 459),
                    new SMALL_CURVE(226, 454, 232, 444),
                    new MOVE(196, 449),
                    new CURVE(170, 479, 146, 447, 156, 440),
                    new MOVE(241, 304),
                    new CURVE(250, 346, 220, 343, 214, 339),
                    new CURVE(208, 338, 206, 333, 202, 324),
                    new MOVE(252, 379),
                    new CURVE(256, 373, 255, 424, 216, 415),
                    new MOVE(280, 399),
                    new CURVE(278, 406, 262, 413, 250, 407),
                    new MOVE(125, 268),
                    new CURVE(105, 267, 125, 221, 146, 243),
                    new MOVE(136, 191),
                    new CURVE(124, 199, 124, 188, 120, 209),
                    new CURVE(103, 201, 118, 203, 101, 188),
                    new CURVE(124, 175, 106, 181, 120, 165),
                    new CURVE(127, 183, 132, 181, 138, 193),
                    new MOVE(183, 263),
                    new CURVE(208, 297, 118, 283, 170, 263),
                    new SMALL_CURVE(176, 262, 186, 265),
                    new MOVE(210, 283),
                    new SMALL_CURVE(219, 274, 196, 277),
                    new MOVE(145, 275),
                    new CURVE(146, 271, 140, 269, 133, 269),
                    new MOVE(214, 253),
                    new SMALL_CURVE(203, 247, 200, 259),
                    new MOVE(146, 264),
                    new SMALL_CURVE(144, 263, 137, 259),
                    new MOVE(84, 261),
                    new SMALL_CURVE(69, 259, 62, 236),
                    new SMALL_CURVE(63, 260, 41, 259),
                    new SMALL_CURVE(58, 264, 64, 281),
                    new SMALL_CURVE(63, 263, 84, 262),
                    new MOVE(330, 277),
                    new SMALL_CURVE(327, 263, 348, 259),
                    new SMALL_CURVE(331, 254, 328, 238),
                    new SMALL_CURVE(322, 254, 305, 259),
                    new SMALL_CURVE(327, 271, 329, 281),
                    new MOVE(339, 421),
                    new SMALL_CURVE(339, 329, 417, 323),
                    new SMALL_CURVE(407, 300, 426, 303),
                    new SMALL_CURVE(432, 307, 438, 316),
                    new SMALL_CURVE(439, 291, 468, 307),
                    new SMALL_CURVE(470, 311, 466, 321),
                    new SMALL_CURVE(527, 337, 526, 423),
                    new LINE(342, 423),
                    new MOVE(382, 422),
                    new CURVE(398, 411, 380, 378, 360, 405),
                    new MOVE(439, 423),
                    new CURVE(420, 405, 456, 385, 465, 405),
                    new MOVE(442, 401),
                    new CURVE(443, 402, 435, 381, 434, 385),
                    new SMALL_CURVE(430, 394, 421, 386),
                    new SMALL_CURVE(416, 394, 409, 384),
                    new SMALL_CURVE(401, 392, 392, 383),
                    new SMALL_CURVE(383, 384, 382, 397),
                    new MOVE(433, 343),
                    new SMALL_CURVE(414, 346, 424, 369),
                    new MOVE(426, 349),
                    new CURVE(404, 324, 392, 371, 421, 361),
                    new MOVE(398, 424),
                    new CURVE(386, 386, 412, 395, 424, 399),
                    new SMALL_CURVE(430, 409, 423, 424),
                    new MOVE(454, 353),
                    new SMALL_CURVE(451, 348, 446, 349),
                    new MOVE(400, 341),
                    new SMALL_CURVE(389, 337, 385, 347)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(172, 331, new Color(248, 220, 133, 255)),
                    new FILL_COLOR(171, 271, new Color(240, 175, 127, 255)),
                    new FILL_COLOR(126, 250, new Color(243, 221, 144, 255)),
                    new FILL_COLOR(244, 451, new Color(230, 178, 134, 255)),
                    new FILL_COLOR(172, 451, new Color(222, 180, 140, 255)),
                    new FILL_COLOR(119, 190, new Color(243, 221, 144, 255)),
                    new FILL_COLOR(68, 258, new Color(239, 222, 153, 255)),
                    new FILL_COLOR(328, 255, new Color(243, 221, 144, 255)),
                    new FILL_COLOR(496, 397, new Color(243, 221, 144, 255)),
                    new FILL_COLOR(411, 350, new Color(230, 178, 134, 255)),
                    new FILL_COLOR(406, 409, new Color(0, 0, 0, 255))
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
                    new MOVE(85, 422),
                    new LINE(564, 421));
            List<FILL_COLOR> fill_plan = List.of();

            c2.add(new Painter(c2, plan, fill_plan));
            window.add(c2);
            c2.setVisible(false);
            list.add(c2);
        }
    }
}

package frames;

import java.awt.Color;
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

public class Frame2 {
    public static ArrayList<BufferedImage> render() {
        ArrayList<BufferedImage> list = new ArrayList<>();
        {
            List<IOperation> plan = List.of(
                    new COLOR(new Color(0, 0, 0)),
                    new MOVE(128, 423),
                    new CURVE(56, 299, 133, 237, 187, 223),
                    new CURVE(180, 217, 188, 191, 206, 212),
                    new CURVE(189, 207, 228, 186, 223, 224),
                    new CURVE(227, 225, 264, 227, 278, 292),
                    new CURVE(293, 304, 350, 341, 300, 423),
                    new CURVE(282, 435, 209, 476, 126, 423),
                    new MOVE(159, 442),
                    new CURVE(126, 448, 178, 487, 193, 450),
                    new MOVE(226, 448),
                    new CURVE(210, 459, 272, 476, 267, 443),
                    new MOVE(121, 266),
                    new CURVE(112, 241, 139, 233, 151, 241),
                    new MOVE(204, 329),
                    new CURVE(204, 348, 259, 348, 240, 310),
                    new MOVE(234, 380),
                    new CURVE(230, 358, 287, 403, 236, 420),
                    new MOVE(258, 407),
                    new CURVE(266, 409, 281, 415, 284, 399),
                    new MOVE(155, 279),
                    new CURVE(160, 261, 178, 263, 185, 275),
                    new CURVE(182, 278, 170, 299, 154, 278),
                    new MOVE(197, 279),
                    new LINE(212, 280),
                    new SMALL_CURVE(205, 293, 204, 282),
                    new MOVE(131, 271),
                    new LINE(144, 274),
                    new SMALL_CURVE(140, 279, 139, 274),
                    new MOVE(341, 423),
                    new CURVE(346, 328, 399, 320, 417, 324),
                    new CURVE(408, 325, 411, 279, 439, 315),
                    new CURVE(426, 292, 479, 295, 469, 323),
                    new CURVE(502, 341, 523, 343, 527, 423),
                    new LINE(342, 421),
                    new MOVE(363, 401),
                    new SMALL_CURVE(397, 383, 386, 423),
                    new MOVE(440, 423),
                    new SMALL_CURVE(416, 389, 463, 403),
                    new MOVE(382, 397),
                    new CURVE(384, 391, 384, 381, 396, 380),
                    new SMALL_CURVE(400, 389, 410, 383),
                    new SMALL_CURVE(415, 388, 424, 381),
                    new SMALL_CURVE(424, 394, 436, 384),
                    new SMALL_CURVE(440, 387, 443, 401),
                    new MOVE(399, 423),
                    new SMALL_CURVE(380, 387, 422, 396),
                    new SMALL_CURVE(425, 408, 422, 424),
                    new MOVE(384, 354),
                    new SMALL_CURVE(379, 347, 383, 358),
                    new MOVE(461, 366),
                    new SMALL_CURVE(456, 357, 463, 365),
                    new MOVE(204, 259),
                    new SMALL_CURVE(211, 251, 216, 265),
                    new MOVE(146, 265),
                    new LINE(141, 261),
                    new MOVE(432, 367),
                    new CURVE(383, 375, 412, 323, 436, 352),
                    new MOVE(441, 350),
                    new SMALL_CURVE(421, 354, 437, 371)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(478, 366, new Color(254, 219, 119, 255)),
                    new FILL_COLOR(416, 357, new Color(252, 172, 119, 255)),
                    new FILL_COLOR(420, 360, new Color(252, 172, 119, 255)),
                    new FILL_COLOR(430, 398, new Color(255, 255, 255, 255)),
                    new FILL_COLOR(404, 410, new Color(0, 0, 0, 255)),
                    new FILL_COLOR(165, 275, new Color(252, 172, 119, 255)),
                    new FILL_COLOR(279, 347, new Color(254, 219, 119, 255)),
                    new FILL_COLOR(129, 246, new Color(254, 219, 119, 255)),
                    new FILL_COLOR(260, 450, new Color(252, 172, 119, 255)),
                    new FILL_COLOR(175, 456, new Color(254, 219, 119, 255))
            //
            );

            Painter painter = new Painter(600, 600, plan, fill_plan);
            list.add(painter.paint());
        }
        {
            List<IOperation> plan = List.of(
                    new COLOR(new Color(0, 0, 0)),
                    new MOVE(39, 264),
                    new SMALL_CURVE(55, 258, 62, 234),
                    new SMALL_CURVE(72, 252, 87, 260),
                    new SMALL_CURVE(68, 267, 66, 291),
                    new SMALL_CURVE(56, 267, 42, 265),
                    new MOVE(118, 183),
                    new SMALL_CURVE(132, 178, 128, 199),
                    new SMALL_CURVE(103, 200, 117, 185),
                    new MOVE(278, 195),
                    new SMALL_CURVE(287, 188, 294, 170),
                    new SMALL_CURVE(301, 183, 320, 193),
                    new SMALL_CURVE(307, 197, 300, 216),
                    new SMALL_CURVE(289, 198, 280, 195),
                    new MOVE(331, 257),
                    new SMALL_CURVE(314, 251, 325, 268),
                    new SMALL_CURVE(340, 271, 333, 258)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(120, 192, new Color(253, 227, 54, 255)),
                    new FILL_COLOR(300, 192, new Color(253, 227, 54, 255)),
                    new FILL_COLOR(329, 260, new Color(253, 227, 54, 255)),
                    new FILL_COLOR(60, 263, new Color(253, 227, 54, 255))
            //
            );

            Painter painter = new Painter(600, 600, plan, fill_plan);
            list.add(painter.paint());
        }
        return list;
    }
}

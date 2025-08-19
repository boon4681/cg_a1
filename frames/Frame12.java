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

public class Frame12 {
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
                    new MOVE(454, 600),
                    new CURVE(432, 540, 411, 490, 353, 411),
                    new SMALL_CURVE(337, 398, 323, 390),
                    new CURVE(268, 391, 219, 375, 176, 376),
                    new CURVE(168, 375, 173, 351, 213, 360),
                    new CURVE(240, 363, 261, 344, 249, 323),
                    new CURVE(206, 279, 183, 259, 156, 229),
                    new SMALL_CURVE(132, 204, 161, 214),
                    new CURVE(184, 234, 194, 255, 230, 278),
                    new CURVE(239, 289, 248, 271, 225, 253),
                    new CURVE(188, 217, 176, 201, 165, 194),
                    new CURVE(157, 188, 168, 168, 209, 215),
                    new CURVE(237, 241, 282, 284, 241, 231),
                    new CURVE(196, 188, 185, 185, 201, 179),
                    new SMALL_CURVE(222, 189, 236, 203),
                    new CURVE(225, 184, 250, 192, 280, 213),
                    new CURVE(347, 266, 391, 335, 444, 392),
                    new CURVE(494, 455, 548, 494, 600, 542)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(378, 359, new Color(190, 169, 185, 255))
            //
            );

            Painter painter = new Painter(600, 600, plan, fill_plan);
            list.add(painter.paint());
        }
        {
            List<IOperation> plan = List.of(
                    new COLOR(new Color(0, 0, 0)),
                    new MOVE(249, 217),
                    new LINE(280, 246),
                    new CURVE(286, 245, 272, 226, 252, 219),
                    new MOVE(232, 359),
                    new CURVE(260, 363, 270, 349, 250, 327),
                    new SMALL_CURVE(261, 343, 232, 357),
                    new MOVE(454, 600),
                    new CURVE(432, 538, 410, 487, 361, 425),
                    new CURVE(427, 491, 452, 523, 504, 600)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(427, 500, new Color(212, 196, 211, 255)),
                    new FILL_COLOR(251, 352, new Color(212, 196, 211, 255)),
                    new FILL_COLOR(269, 233, new Color(212, 196, 211, 255))
            //
            );

            Painter painter = new Painter(600, 600, plan, fill_plan);
            list.add(painter.paint());
        }
        return list;
    }
}

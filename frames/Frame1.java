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

public class Frame1 {
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
                    new MOVE(182, 0),
                    new SMALL_CURVE(179, 13, 193, 19),
                    new SMALL_CURVE(197, 109, 266, 95),
                    new SMALL_CURVE(359, 139, 378, 39),
                    new SMALL_CURVE(401, 21, 396, 0)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(332, 77, new Color(217, 186, 179, 255))
            //
            );

            Painter painter = new Painter(600, 600, plan, fill_plan);
            list.add(painter.paint());
        }
        {
            List<IOperation> plan = List.of(
                    new COLOR(new Color(0, 0, 0)),
                    new MOVE(316, 0),
                    new SMALL_CURVE(312, 9, 334, 15),
                    new CURVE(330, 45, 311, 25, 298, 41),
                    new SMALL_CURVE(269, 32, 269, 25),
                    new SMALL_CURVE(267, 19, 268, 0),
                    new MOVE(281, 0),
                    new CURVE(268, 10, 302, 37, 303, 0)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(309, 19, new Color(157, 133, 168, 255))
            //
            );
            Painter painter = new Painter(600, 600, plan, fill_plan);
            list.add(painter.paint());
        }
        {
            List<IOperation> plan = List.of(
                    new COLOR(new Color(0, 0, 0)),
                    new MOVE(220, 23),
                    new LINE(245, 55),
                    new LINE(244, 15),
                    new CURVE(256, 54, 316, 64, 336, 35),
                    new CURVE(350, 38, 360, 17, 343, 15),
                    new SMALL_CURVE(345, 7, 340, 0),
                    new MOVE(328, 0),
                    new CURVE(332, 3, 337, 11, 327, 31),
                    new CURVE(314, 27, 300, 27, 298, 42),
                    new CURVE(266, 32, 256, 13, 249, 0),
                    new MOVE(234, 0),
                    new LINE(235, 30),
                    new LINE(222, 24)
            //
            );
            List<FILL_COLOR> fill_plan = List.of(
                    new FILL_COLOR(336, 27, new Color(117, 85, 107, 255))
            //
            );
            Painter painter = new Painter(600, 600, plan, fill_plan);
            list.add(painter.paint());
        }
        return list;
    }
}

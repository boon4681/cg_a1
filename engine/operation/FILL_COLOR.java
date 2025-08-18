package engine.operation;

import java.awt.Color;

public class FILL_COLOR {
    public final double x;
    public final double y;
    public final Color color;
    public final int tolerance;
    public final int kernelSize;

    public FILL_COLOR(
            double x,
            double y,
            Color color) {
        this(x, y, color, 250, 2);
    }

    public FILL_COLOR(
            double x,
            double y,
            Color color,
            int tolerance,
            int kernelSize
    //
    ) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.tolerance = tolerance;
        this.kernelSize = kernelSize;
    }

}

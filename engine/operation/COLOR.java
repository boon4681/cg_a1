package engine.operation;

import java.awt.Color;

import engine.operation.iterfaces.IOperation;

public class COLOR implements IOperation {
    public final double strokeWidth = 4;
    public final Color color;

    public COLOR(Color color) {
        this.color = color;
    }

    @Override
    public double getStrokeWidth() {
        return strokeWidth;
    }
}

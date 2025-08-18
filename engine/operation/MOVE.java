package engine.operation;

import engine.operation.iterfaces.IOperation;

public class MOVE implements IOperation {
    public final double strokeWidth = 4;
    public final double x1;
    public final double y1;

    public MOVE(double x1, double y1) {
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public double getStrokeWidth() {
        return strokeWidth;
    }
}
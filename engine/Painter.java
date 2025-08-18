package engine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.UUID;

import engine.operation.COLOR;
import engine.operation.CURVE;
import engine.operation.FILL_COLOR;
import engine.operation.LINE;
import engine.operation.MOVE;
import engine.operation.SMALL_CURVE;
import engine.operation.iterfaces.IOperation;
import engine.objects.IObject;

public class Painter implements IObject {
    private double currentX = 0;
    private double currentY = 0;
    private double startX = 0;
    private double startY = 0;
    private double lastControlX = 0;
    private double lastControlY = 0;
    public boolean visible = true;

    private UUID uuid;

    private final List<IOperation> stroke_plans;
    private final List<FILL_COLOR> fill_plans;
    private final Canvas parent;

    public Painter(
            Canvas parent,
            List<IOperation> stroke_plan
    //
    ) {
        this(parent, stroke_plan, List.of());
    }

    public Painter(
            Canvas parent,
            List<IOperation> stroke_plans,
            List<FILL_COLOR> fill_plans
    //
    ) {
        this.stroke_plans = stroke_plans;
        this.parent = parent;
        this.fill_plans = fill_plans;
    }

    public BufferedImage run() {
        Canvas canvas = new Canvas(this.parent.window, null, this.parent.getWidth(), this.parent.getHeight());
        for (IOperation op : stroke_plans) {
            if (op instanceof COLOR) {
                COLOR c = (COLOR) op;
                canvas.setColor(c.color);
            }
            if (op instanceof MOVE) {
                MOVE m = (MOVE) op;
                this.currentX = m.x1;
                this.currentY = m.y1;
                this.startX = this.currentX;
                this.startY = this.currentY;
            }
            if (op instanceof LINE) {
                LINE l = (LINE) op;
                canvas.line(this.currentX, this.currentY, l.x1, l.y1, l.getStrokeWidth());
                this.currentX = l.x1;
                this.currentY = l.y1;
            }
            if (op instanceof CURVE) {
                CURVE c = (CURVE) op;
                canvas.bezier(
                        this.currentX,
                        this.currentY,
                        c.x1,
                        c.y1,
                        c.x2,
                        c.y2,
                        c.x3,
                        c.y3,
                        c.getStrokeWidth()
                // this message is here to f*ck with vscode java fomatter
                );
                this.lastControlX = c.x2;
                this.lastControlY = c.y2;
                this.currentX = c.x3;
                this.currentY = c.y3;
            }
            if (op instanceof SMALL_CURVE) {
                SMALL_CURVE sc = (SMALL_CURVE) op;
                canvas.bezier(
                        this.currentX,
                        this.currentY,
                        this.currentX,
                        this.currentY,
                        sc.x1,
                        sc.y1,
                        sc.x2,
                        sc.y2,
                        sc.getStrokeWidth()
                // this message is here to f*ck with vscode java fomatter
                );
                this.lastControlX = sc.x1;
                this.lastControlY = sc.y1;
                this.currentX = sc.x2;
                this.currentY = sc.y2;
            }
        }
        for (FILL_COLOR op : this.fill_plans) {
            canvas.fill(op.x, op.y, op.color, op.tolerance, op.kernelSize);
        }
        return canvas.getImage();
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }

    @Override
    public UUID getID() {
        return this.uuid;
    }

    @Override
    public Canvas getParent() {
        return this.parent;
    }

    @Override
    public void render(Graphics2D g) {
        BufferedImage image = this.run();
        g.drawImage(image, null, 0, 0);
    }

    @Override
    public void update(double dt) {
        // empty no update
    }
}

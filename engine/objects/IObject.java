package engine.objects;

import java.awt.Graphics2D;
import java.util.UUID;

import engine.Canvas;

public interface IObject {
    public boolean isVisible();

    public UUID getID();

    public Canvas getParent();

    public void render(Graphics2D g);

    public void update(double dt);

    public default void remove() {
        this.getParent().remove(this);
    }
}

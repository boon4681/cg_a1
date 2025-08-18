package engine.objects;

import java.awt.Graphics2D;
import java.util.UUID;


public interface IObject {
    public boolean isVisible();

    public UUID getID();

    public void render(Graphics2D g);

    public void update(double dt);
}

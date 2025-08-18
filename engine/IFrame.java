package engine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class IFrame {
    private final BufferedImage image;
    private final long duration; // in milliseconds

    public IFrame(BufferedImage image, long duration) {
        this.image = image;
        this.duration = duration;
    }

    public IFrame(ArrayList<BufferedImage> list, long duration) {
        BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        for (BufferedImage buffer : list) {
            g2d.drawImage(buffer, 0, 0, 600, 600, null);
        }
        this.image = image;
        this.duration = duration;
    }

    public BufferedImage getImage() {
        return image;
    }

    public long getDuration() {
        return duration;
    }
}
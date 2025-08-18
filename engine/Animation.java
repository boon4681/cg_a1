package engine;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Animation {
    private final List<IFrame> frames;
    private int currentFrameIndex;
    private long timeSinceLastFrame;
    private boolean isLooping;

    public Animation(boolean isLooping) {
        this.frames = new ArrayList<>();
        this.isLooping = isLooping;
        this.currentFrameIndex = 0;
        this.timeSinceLastFrame = 0;
    }

    public void addFrame(BufferedImage image, long duration) {
        frames.add(new IFrame(image, duration));
    }

    public void addFrame(ArrayList<BufferedImage> image, long duration) {
        frames.add(new IFrame(image, duration));
    }

    public void update(long deltaTime) {
        if (frames.isEmpty()) {
            return;
        }

        timeSinceLastFrame += deltaTime;
        long currentFrameDuration = frames.get(currentFrameIndex).getDuration();
        if (timeSinceLastFrame >= currentFrameDuration) {
            timeSinceLastFrame -= currentFrameDuration;
            currentFrameIndex++;

            if (currentFrameIndex >= frames.size()) {
                if (isLooping) {
                    currentFrameIndex = 0;
                } else {
                    currentFrameIndex = frames.size() - 1;
                }
            }
        }
    }

    public BufferedImage getCurrentImage() {
        if (frames.isEmpty()) {
            return null;
        }
        return frames.get(currentFrameIndex).getImage();
    }

    public void reset() {
        this.currentFrameIndex = 0;
        this.timeSinceLastFrame = 0;
    }
}
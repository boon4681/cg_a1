package engine.tick;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import engine.Animation;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Ticker extends Canvas implements Runnable {

    private final Animation animation;
    private Thread animationThread;
    private volatile boolean running = false;

    private static final int TARGET_FPS = 60;
    private static final long OPTIMAL_TIME = 1000 / TARGET_FPS;

    public Ticker(Animation animation) {
        this.animation = animation;
        setSize(new Dimension(600, 600));
    }

    @Override
    public void addNotify() {
        super.addNotify();
        start();
    }

    @Override
    public void removeNotify() {
        stop();
        super.removeNotify();
    }

    private void start() {
        if (running)
            return;
        running = true;
        animationThread = new Thread(this);
        animationThread.start();
    }

    private void stop() {
        if (!running)
            return;
        running = false;
        try {
            animationThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastUpdateTime = System.currentTimeMillis();

        while (running) {
            long now = System.currentTimeMillis();
            long deltaTime = now - lastUpdateTime;
            lastUpdateTime = now;

            animation.update(deltaTime);
            render();

            long loopTime = System.currentTimeMillis() - lastUpdateTime;
            if (loopTime < OPTIMAL_TIME) {
                try {
                    Thread.sleep(OPTIMAL_TIME - loopTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());

        BufferedImage currentFrame = animation.getCurrentImage();
        if (currentFrame != null) {
            g.drawImage(currentFrame, 0, 0, 600, 600, null);
        }

        g.dispose();
        bs.show();
    }
}
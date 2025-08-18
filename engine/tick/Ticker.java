package engine.tick;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import engine.Window;

public class Ticker implements Runnable {
    private Window window;
    public ArrayList<Tickable> tickables = new ArrayList<>();

    public Ticker(Window window) {
        this.window = window;
    }

    private Thread worldThread;
    private boolean loop = false;

    public void start() {
        this.loop = true;
        this.worldThread = new Thread(this);
        this.worldThread.start();
    }

    @Override
    public void run() {
        int FPS = 60;
        double nano = TimeUnit.SECONDS.toNanos(1);
        double dt = 0;
        long lastTime = System.nanoTime();
        long currentTime = System.nanoTime();
        try {
            while (loop) {
                currentTime = System.nanoTime();
                dt = ((currentTime - lastTime) / nano) * 1000;
                for (Tickable tickable : tickables) {
                    tickable.tick(dt);
                }
                window.tick(dt);
                lastTime = currentTime;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        this.loop = false;
    }
}

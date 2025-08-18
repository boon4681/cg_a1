package engine;

import java.util.ArrayList;

import javax.swing.JFrame;

import engine.tick.Tickable;
import frames.Frame1;
import frames.Frame2;
import frames.Frame3;
import frames.Frame4;

public class Window extends JFrame implements Tickable {
    private ArrayList<Canvas> canvas_list = new ArrayList<>();
    private double t = 0;
    private double tt = 0;

    public Window(String name) {
        super(name);
    }

    public void add(Canvas canvas) {
        this.canvas_list.add(canvas);
        super.add(canvas);
    }

    public void remove(Canvas canvas) {
        this.canvas_list.remove(canvas);
        super.remove(canvas);
    }

    @Override
    public final void tick(double dt) {
        if (t == 0) {
            Frame4.list.forEach((e) -> {
                e.setVisible(false);
            });
            Frame1.list.forEach((e) -> {
                e.setVisible(true);
            });
        } else if (t > 100 && t <= 200) {
            Frame1.list.forEach((e) -> {
                e.setVisible(false);
            });
            Frame2.list.forEach((e) -> {
                e.setVisible(true);
            });
        } else if (t > 200 && t <= 300) {
            Frame2.list.forEach((e) -> {
                e.setVisible(false);
            });
            Frame3.list.forEach((e) -> {
                e.setVisible(true);
            });
        } else if (t > 300 && t <= 400) {
            Frame3.list.forEach((e) -> {
                e.setVisible(false);
            });
            Frame4.list.forEach((e) -> {
                e.setVisible(true);
            });
        }
        t += dt;
        tt += dt;
        if (t > 500) {
            t = 0;
        }
        if (tt > 5000) {
            System.exit(0);
        }
        for (Canvas canvas : canvas_list) {
            canvas.tick(dt);
        }
    }
}

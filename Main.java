import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import engine.Animation;
import engine.IFrame;
import engine.tick.Ticker;
import frames.Frame1;
import frames.Frame2;
import frames.Frame3;
import frames.Frame4;

public class Main {

    public static void main(String[] args) {
        Frame frame = new Frame("WHAT THE HEYYYY!!");
        frame.setSize(600, 600);
        Animation animtion = new Animation(true);

        animtion.addFrame(Frame1.render(), 200);
        animtion.addFrame(Frame2.render(), 200);
        animtion.addFrame(Frame3.render(), 200);
        animtion.addFrame(Frame4.render(), 200);
        Ticker animationCanvas = new Ticker(animtion);

        frame.add(animationCanvas);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

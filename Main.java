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
import frames.Frame10;
import frames.Frame11;
import frames.Frame12;
import frames.Frame13;
import frames.Frame14;
import frames.Frame15;
import frames.Frame16;
import frames.Frame2;
import frames.Frame3;
import frames.Frame4;
import frames.Frame5;
import frames.Frame6;
import frames.Frame7;
import frames.Frame8;
import frames.Frame9;

public class Main {

    public static void main(String[] args) {
        Frame frame = new Frame("WHAT THE HEYYYY!!");
        frame.setSize(600, 600 + 37);
        Animation animtion = new Animation(true);

        animtion.addFrame(Frame1.render(), 200);
        animtion.addFrame(Frame2.render(), 100);
        animtion.addFrame(Frame3.render(), 100);
        animtion.addFrame(Frame4.render(), 200);
        animtion.addFrame(Frame5.render(), 200);
        animtion.addFrame(Frame6.render(), 200);
        animtion.addFrame(Frame7.render(), 100);
        animtion.addFrame(Frame8.render(), 100);
        animtion.addFrame(Frame9.render(), 100);
        animtion.addFrame(Frame10.render(), 200);
        animtion.addFrame(Frame11.render(), 200);
        animtion.addFrame(Frame12.render(), 200);

        animtion.addFrame(Frame13.render(), 100);
        animtion.addFrame(Frame14.render(), 100);
        animtion.addFrame(Frame15.render(), 100);
        animtion.addFrame(Frame16.render(), 100);
        animtion.addFrame(Frame13.render(), 100);
        animtion.addFrame(Frame14.render(), 100);
        animtion.addFrame(Frame15.render(), 100);
        animtion.addFrame(Frame16.render(), 100);
        animtion.addFrame(Frame13.render(), 100);
        animtion.addFrame(Frame14.render(), 100);
        animtion.addFrame(Frame15.render(), 100);
        animtion.addFrame(Frame16.render(), 100);
        animtion.addFrame(Frame13.render(), 100);
        animtion.addFrame(Frame14.render(), 100);
        animtion.addFrame(Frame15.render(), 100);
        animtion.addFrame(Frame16.render(), 100);

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

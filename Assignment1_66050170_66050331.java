import javax.swing.JFrame;

import engine.Window;
import engine.tick.Ticker;
import frames.Frame1;
import frames.Frame2;
import frames.Frame3;
import engine.Canvas;
import engine.Painter;
import engine.Window;
import engine.operation.COLOR;
import engine.operation.CURVE;
import engine.operation.FILL_COLOR;
import engine.operation.LINE;
import engine.operation.MOVE;
import engine.operation.SMALL_CURVE;
import engine.operation.iterfaces.IOperation;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import engine.Canvas;
import engine.Painter;
import engine.Window;
import engine.operation.COLOR;
import engine.operation.CURVE;
import engine.operation.FILL_COLOR;
import engine.operation.LINE;
import engine.operation.MOVE;
import engine.operation.SMALL_CURVE;
import engine.operation.iterfaces.IOperation;

public class Assignment1_66050170_66050331 {
    public static void main(String[] args) {
        Window window = new Window("WHAT THE HEYYYY!!");
        window.setSize(600, 600 + 37);
        window.setVisible(true);
        window.setBackground(Color.BLACK);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);

        Frame1.setup(window);
        Frame2.setup(window);
        Frame3.setup(window);

        Ticker ticker = new Ticker(window);
        ticker.start();
        window.repaint();
    }
}

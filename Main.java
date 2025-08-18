import java.awt.Color;
import java.rmi.server.Operation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import engine.Canvas;
import engine.Painter;
import engine.Window;
import engine.operation.*;
import engine.operation.iterfaces.IOperation;
import engine.tick.Ticker;
import frames.Frame1;
import frames.Frame2;
import frames.Frame3;

class Main {
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
package app.moneytracker;

import app.moneytracker.view.MainFrame;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setTitle("Money Tracker");
        mainFrame.setPreferredSize(new Dimension(400, 500));
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}

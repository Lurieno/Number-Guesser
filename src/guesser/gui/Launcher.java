package guesser.gui;

import guesser.gui.utils.*;

import javax.swing.SwingUtilities;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Frontend frame = new Frontend();
            }
        });
    }
}
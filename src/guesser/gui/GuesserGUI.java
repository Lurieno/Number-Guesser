package guesser.gui;

import javax.swing.SwingUtilities;

public class GuesserGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrameWrapper frame = new JFrameWrapper();
            }
        });
    }
}
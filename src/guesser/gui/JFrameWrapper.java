package guesser.gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
// TODO:
/* consider using GraphicsConfiguration?
 * add interface to enter min/max number
 * add field for user guess
 * add button "play" that executes all the stuff
 */
public class JFrameWrapper {
    private JFrame frame;

    public JFrameWrapper() {
        initialise();
    }
    
    private void initialise() {
        frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 2));  // Creates a grid with x columns and 2 rows
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
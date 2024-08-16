package guesser.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

// TODO:
/* consider using GraphicsConfiguration? This will extend support for different monitor sizes
 */
public class GUI {
    private JFrame frame;

    public GUI() {
        initialise();
    }
    
    private void initialise() {
        // Initialise the frame that will contain everything
        frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Borderlayout consists of 5 regions: north, east, south, west, and center
        frame.setLayout(new BorderLayout(10, 5));
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        // TODO: add instructions
        // Create a panel in the frame's north section. This will contain instructions
        JPanel top_panel = new JPanel();
        JLabel instruction = new JLabel("<html>Try to guess the number the computer chose!<br/>Choose the range with " +
                                        " the MIN and MAX fields.</html>");
        top_panel.add(instruction);
        frame.add(top_panel, BorderLayout.NORTH);

        // Create a panel in the frame's center section. It will contain the fields for entering data
        JPanel main_panel = new JPanel(new GridLayout(3, 1));
        frame.add(main_panel, BorderLayout.CENTER);

        // TODO: need to figure out a way to make sure f_min > f_max and that f_guess is between those
        // Fields for the user to enter data in
        JFormattedTextField f_min = createTextField("####");
        JFormattedTextField f_max = createTextField("####");
        JFormattedTextField f_guess = createTextField("####");

        // Labels to describe the fields
        JLabel l_min = new JLabel("MIN");
        JLabel l_max = new JLabel("MAX");
        JLabel l_guess = new JLabel("Your Guess");

        // Create a panel within main_panel to contain each of MIN, MAX, and User Guess
        JPanel p_min = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p_min.add(l_min);
        p_min.add(f_min);
        main_panel.add(p_min);

        JPanel p_max = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p_max.add(l_max);
        p_max.add(f_max);
        main_panel.add(p_max);

        JPanel p_guess = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p_guess.add(l_guess);
        p_guess.add(f_guess);
        main_panel.add(p_guess);

        // Create a panel in the frame's south section. It will contain the "play" button
        JPanel south_panel = new JPanel();
        JButton play = new JButton("Play");
        south_panel.add(play);
        frame.add(south_panel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    /* Available symbols for formatting:
     * # - any number
     * U - any character, everything is mapped to uppercase
     * L - any character, everything is mapped to lowercase
     * A - any character or number
     * ? - any character
     * * - anything
     * H - any hex character (0-9, a-f, A-F) 
     */
    // Creates a text field that only accepts the specified characters
    private JFormattedTextField createTextField(String format) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(format);
        } catch (java.text.ParseException e) {
            System.err.println("formatter is bad: " + e.getMessage());
            System.exit(-1);
        }

        JFormattedTextField field = new JFormattedTextField(formatter);
        field.setColumns(format.length());
        return field;
    }
}
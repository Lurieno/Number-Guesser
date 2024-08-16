package guesser.gui.utils;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;

import java.text.NumberFormat;
import java.text.ParseException;

// TODO:
/* consider using GraphicsConfiguration? This will extend support for different monitor sizes
 */
public class Frontend {
    private JFrame frame;
    private Backend backend;

    public Frontend() {
        backend = new Backend();
        initialise();
    }
    
    // Initialse the GUI
    private void initialise() {
        // Initialise the frame that will contain everything
        frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Borderlayout consists of 5 regions: north, east, south, west, and center
        frame.setLayout(new BorderLayout(10, 5));
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        // Create a panel in the frame's north section. It contains game instructions
        JPanel top_panel = new JPanel();
        JLabel instruction = new JLabel("<html>Try to guess the number the computer chose!<br/>Choose the range with " +
                                        " the MIN and MAX fields.</html>");
        top_panel.add(instruction);
        frame.add(top_panel, BorderLayout.NORTH);

        // Create a panel in the frame's center section. It contains the fields for entering data
        JPanel main_panel = new JPanel(new GridLayout(3, 1));
        frame.add(main_panel, BorderLayout.CENTER);

        // Fields for the user to enter data in
        JFormattedTextField field_min = createTextField();
        JFormattedTextField field_max = createTextField();
        JFormattedTextField field_guess = createTextField();

        // Labels to describe the fields
        JLabel label_min = new JLabel("MIN");
        JLabel label_max = new JLabel("MAX");
        JLabel label_guess = new JLabel("Your Guess");

        // Create a panel within main_panel to contain each of MIN, MAX, and User Guess
        JPanel panel_min = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_min.add(label_min);
        panel_min.add(field_min);
        main_panel.add(panel_min);

        JPanel panel_max = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_max.add(label_max);
        panel_max.add(field_max);
        main_panel.add(panel_max);

        JPanel panel_guess = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_guess.add(label_guess);
        panel_guess.add(field_guess);
        main_panel.add(panel_guess);

        // Create a panel in the frame's south section. It will contain the "play" button
        JPanel south_panel = new JPanel();
        JButton play_button = new JButton("Play");
        south_panel.add(play_button);
        frame.add(south_panel, BorderLayout.SOUTH);

        frame.setVisible(true);

        // The actionlistener makes the game run once when the "play" button is clicked,
        // using the paramters input into the fields
        play_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Play")) {
                    int min = Integer.parseInt(field_min.getText());
                    int max = Integer.parseInt(field_max.getText());
                    int guess = Integer.parseInt(field_guess.getText());

                    try {
                        backend.run(min, max, guess);
                    } catch (ArithmeticException ex) {
                        System.out.println(ex.getMessage());
                    }

                }
            }
        });
    }

    // Creates a text field that only accepts numbers
    private JFormattedTextField createTextField() {
        NumberFormatter formatter = new NumberFormatter(NumberFormat.getInstance()) {
            @Override
            // This lets you empty the text field. According to NumberFormatter, "" is not a number
            public Object stringToValue(String text) throws ParseException {
                if (text == null || text.isEmpty()) {
                    return null; // Return null when the text field is empty
                }
                return super.stringToValue(text);
            }
        };

        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);

        formatter.setCommitsOnValidEdit(true);

        JFormattedTextField field = new JFormattedTextField(formatter);
        field.setColumns(4);

        return field;
    }
}
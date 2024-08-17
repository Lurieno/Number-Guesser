package guesser;

import guesser.utils.*;
import javax.swing.SwingUtilities;

/* Launcher attempts to start a connection as a client
 * If none is found, launcher starts its own server
 * Server runs the actual game
 * As a client your only job is to send the data input into the window to the server
 * (Also display the results the server sends back)
 */
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
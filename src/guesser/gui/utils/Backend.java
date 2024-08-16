package guesser.gui.utils;

import java.util.Random;

public class Backend {
    private Random rand;

    public Backend() {
        rand = new Random();
    }

    // TODO: make your own exception type
    public void run(int min, int max, int guess) throws ArithmeticException {
        if (max < min) {
            throw new ArithmeticException("MAX cannot be less than MIN");
        } else if (min > max) {
            throw new ArithmeticException("MIN cannot be larger than MAX");
        } else if (guess < min || guess > max) {
            throw new ArithmeticException("Guess out of bounds");
        }
        
        int com_guess = rand.nextInt(max-min+1) + min;

        if (com_guess == guess) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect. The number is " + com_guess);
        }
    }
}
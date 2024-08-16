import java.util.Scanner;
import java.util.Random;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader; 

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Guesser {
    public static final Scanner sc = new Scanner(System.in);
    public static final int max = 10;
    public static void main(String[] args) {
        Boolean quit = false;
        String statfile = "target/stat.csv";
        
        try {
            // Results will be written to this file. Avoid opening and closing every time
            FileWriter fw = new FileWriter(statfile, true);
            
            // Game loop
            while (true) {
                Random rand = new Random();
                int com_guess = rand.nextInt(max+1);
                int usr_guess = -1; 
                String winner = "";
    
                System.out.println("Guess a number between 0.." + max);
    
                // Get input and check validity
                while (true) {
                    String input = sc.nextLine();
    
                    if (input.equals("QUIT")) {
                        quit = true;
                        break;
                    }
    
                    // Attempt to convert input to an integer
                    try {
                        usr_guess = Integer.parseInt(input);
                        if (usr_guess > max || usr_guess < 0) {
                            System.out.println("Input out of bounds, try again");
                            continue;
                        }

                        break;

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, try again");
                    }
                }
    
                // TODO: could probs do this better
                if (quit) {
                    break;
                }
    
                if (com_guess == usr_guess) {
                    System.out.println("Correct!");
                    winner = "USER\t";
                } else {
                    System.out.println("Incorrect. The number is " + com_guess);
                    winner = "COMPUTER";
                }
    
                // Write results to file
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String time = LocalDateTime.now().format(formatter);

                fw.write(time + "\t\t" + winner + "\t" + com_guess + "\n");
            }

            fw.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

        // Print results file
        try {
            FileReader fr = new FileReader(statfile);
            BufferedReader br = new BufferedReader(fr);
            
            if (br.ready()) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line); 
                }
            }
            
            br.close();
            fr.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
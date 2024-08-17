package guesser.utils.multiplayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    
    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            System.out.println("Connected to server " + ip + " on port " + port);
            
            // TODO: switch to bufferedwriter? printwriter swallows exceptions
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String sendMessage(String msg) {
        out.println(msg);
        try {
            String resp = in.readLine();
            return resp;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);
        Scanner sc = new Scanner(System.in);

        String inputLine = "";
        while (true) {
            inputLine = sc.nextLine();

            if (inputLine.equals("Q")) {
                break;
            }

            String response = client.sendMessage(inputLine);
            System.out.println(response);

            if (inputLine.equals(".")) {
                break;
            }
        }    
        
        client.stop();
    }
}
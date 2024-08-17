package guesser.utils.multiplayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server listening on port " + port);

            clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (".".equals(inputLine)) {
                    out.println("good bye");
                    break;
                }
                out.println(inputLine);
                System.out.println(inputLine);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Connection closed");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start(6666);
    }
}
package test;

import guesser.utils.multiplayer.*;

public class ServerTest {
    public static void main(String[] args) {
        Server s = new Server();
        s.start(6666);

    }
}
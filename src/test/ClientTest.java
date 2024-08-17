package test;

import guesser.utils.multiplayer.*;

public class ClientTest {
    private void assertEquals(String a, String b) throws Exception {
        if (!a.equals(b)) {
            throw new Exception("Strings " + a + " and " + b + " are not equal");
        }
    }
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws Exception {
        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("hello server");
        // client.stop();
        assertEquals("hello client", response);
    }

    public static void main(String[] args) {
        // Server s = new Server();
        // s.start(6666);
        ClientTest t = new ClientTest();
        try {
            t.givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // s.stop();
    }
}
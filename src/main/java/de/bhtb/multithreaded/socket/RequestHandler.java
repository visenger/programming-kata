package de.bhtb.multithreaded.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by visenger on 13/12/16.
 */
public class RequestHandler implements Runnable {
    private final Socket client;
    private ServerSocket serverSocket = null;

    public RequestHandler(Socket s) {
        this.client = s;
    }

    @Override
    public void run() {


        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));) {

            System.out.println("Thread started: " + Thread.currentThread().getName());
            String userInput;

            while ((userInput = in.readLine()) != null) {
                System.out.println("received message from:  " + Thread.currentThread().getName() + " - " + userInput);
                userInput = userInput.toUpperCase();
                writer.write("you entered: " + userInput);
                writer.newLine();
                writer.flush();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

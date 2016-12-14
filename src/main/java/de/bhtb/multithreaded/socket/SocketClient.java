package de.bhtb.multithreaded.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by visenger on 12/12/16.
 */
public class SocketClient {
    //args: 127.0.0.1 8005
    public static void main(String... args) {
        if (args.length != 2) {
            System.err.println("Usage: java SocketClient <host> <port>");
            System.exit(1);
        }

        List<String> inputArgs = Arrays.asList(args);
        String host = inputArgs.get(0);
        int port = Integer.parseInt(inputArgs.get(1));

        try (Socket socket = new Socket(host, port)) {

            PrintWriter out
                    = new PrintWriter(socket.getOutputStream(), true); //write to server
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(socket.getInputStream())); //read from server
            BufferedReader stdInput
                    = new BufferedReader(new InputStreamReader(System.in)); //input from the client cli

            String userInput;

            while ((userInput = stdInput.readLine()) != null) {
                out.println(userInput); // send our message to server (e.g. updated view)
                System.out.println("echo: " + in.readLine()); // client waits until the server echoes the information back to the client
            }

        } catch (UnknownHostException e) {
            System.err.println("Host is unknown" + host);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("I/O connection to host can not be established" + host);
            System.exit(1);
        }


    }

}
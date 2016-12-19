package de.bhtb.multithreaded.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by visenger on 12/12/16.
 * <p>
 * basic workflow:
 * while (true) {
 * accept a connection;
 * create a thread to deal with the client;
 * }
 */
public class SocketServer {
    public static void main(String... args) {
        System.out.println("Starting server....");

        if (args.length != 1) {
            System.err.println("usage: java SocketServer <port>");
            System.exit(1);
        }

        String arg = Arrays.asList(args).get(0);
        int port = Integer.parseInt(arg);

        ExecutorService executor = null;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            executor = Executors.newFixedThreadPool(4);
            System.out.println("waiting for clients... ");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                RequestHandler worker = new RequestHandler(clientSocket);
                executor.execute(worker);
            }

        } catch (IOException e) {

            String className = e.getClass().getName();
            String exceptionMessage = e.getMessage();
            String str = e.toString();

            String info = String
                    .format(" Class name: %s, the message: %s, exception sring: %s",
                            className,
                            exceptionMessage,
                            str);
            System.out.println(info);

            e.printStackTrace();

        } finally {
            if (executor != null) executor.shutdown();
        }
    }

}

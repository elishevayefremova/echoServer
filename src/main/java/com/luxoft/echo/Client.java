package com.luxoft.echo;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        try (
                Socket socket = new Socket("localhost", 3000);
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter bufferedWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        ) {
            while (true) {
                System.out.println("Say smth:");
                // read line from console
                String line = consoleReader.readLine();
                // send line to server
                bufferedWriter.write(line);
                bufferedWriter.println();
                // receive echo and print
                String serverResponse = bufferedReader.readLine();
                System.out.println(serverResponse);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

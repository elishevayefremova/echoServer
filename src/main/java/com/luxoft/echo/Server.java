package com.luxoft.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        try (
                Socket clientSocket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);
        ) {
            while (true) {
                // read line from client
                String line = reader.readLine();
                // send echo to client
                writer.write("echo: " + line);
                writer.println();
            }
        }
    }
}

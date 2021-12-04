package com.luxoft.echo;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

public class Client {

    public static void main(String[] args) throws IOException {
        try(
                Socket socket = new Socket("localhost", 3000);
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        ) {


            while (true){
                System.out.println("Say smth:");

                String line = consoleReader.readLine();

                out.write(line);
                out.println();

                String serverResponse = in.readLine();
                System.out.println(serverResponse);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

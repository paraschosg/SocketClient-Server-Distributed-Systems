package org.example.socketclientserver.client;

import org.example.socketclientserver.model.Album;
import org.example.socketclientserver.model.Song;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class TestClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            // Δημιουργία Album
            Album album = new Album("Test Album", "A sample album", "Rock", 2023,
                    Arrays.asList(new Song("Song1", "Artist1", 180)));

            // Στέλνουμε την εντολή ADD
            out.writeObject("ADD");
            out.writeObject(album);
            System.out.println("Server response: " + in.readObject());

            // Στέλνουμε την εντολή GET
            out.writeObject("GET");
            System.out.println("Albums: " + in.readObject());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

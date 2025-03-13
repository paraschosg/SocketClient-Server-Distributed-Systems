package org.example.socketclientserver.server;

import org.example.socketclientserver.model.Album;
import org.example.socketclientserver.model.Song;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MusicLibraryServer {
    private static final int PORT = 12345;
    private List<Album> albums;

    public MusicLibraryServer() {
        albums = new ArrayList<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                     ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

                    String command = (String) in.readObject();
                    if ("ADD".equals(command)) {
                        Album album = (Album) in.readObject();
                        albums.add(album);
                        out.writeObject("Album added successfully");
                    } else if ("GET".equals(command)) {
                        out.writeObject(albums);
                    } else if ("DELETE".equals(command)) {
                        String title = (String) in.readObject();
                        albums.removeIf(album -> album.getTitle().equals(title));
                        out.writeObject("Album deleted successfully");
                    } else {
                        out.writeObject("Unknown command");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MusicLibraryServer().start();
    }
}

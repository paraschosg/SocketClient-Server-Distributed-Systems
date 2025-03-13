package org.example.socketclientserver.model;

import java.io.Serializable;
import java.util.List;

public class Album implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String description;
    private String genre;
    private int year;
    private List<Song> songs;

    public Album(String title, String description, String genre, int year, List<Song> songs){
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.year = year;
        this.songs = songs;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString(){
        return "Album: " + title + ", " + description + ", " + genre + ", " + year + ", " + songs;
    }
}

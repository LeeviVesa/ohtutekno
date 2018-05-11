package com.ohjelmisto.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String songName;
    private String artistName;
    private String date;
    private String path;

    public Music() {
    }

    public Music(String songName, String artistName, String date, String path) {
        this.songName = songName;
        this.artistName = artistName;
        this.date = date;
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Music [Path=" + path + "songName=" + songName + ", artistName=" + artistName + ", date=" + date + "]";
    }


}

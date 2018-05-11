package com.ohjelmisto.domain;

public class AddMusicForm {

    private String songName = "";

    private String artistName = "";

    private String date = "";

    private String path = "";

    public String getsongName() {
        return songName;
    }

    public void setsongName(String username) {
        this.songName = username;
    }

    public String getartistName() {
        return artistName;
    }

    public void setartistName(String password) {
        this.artistName = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getpath() {
        return path;
    }

    public void setpath(String role) {
        this.path = role;
    }


}

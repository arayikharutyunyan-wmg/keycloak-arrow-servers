package com.demo.users.model;

public class User {

  private String id;
  private String name;
  private String playlistId;
  private Playlist playlist;

  public User() {

  }

  public User(String id, String name, String playlistId) {
    this.id = id;
    this.name = name;
    this.playlistId = playlistId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPlaylistId() {
    return playlistId;
  }

  public void setPlaylistId(String playlistId) {
    this.playlistId = playlistId;
  }

  public Playlist getPlaylist() {
    return playlist;
  }

  public void setPlaylist(Playlist playlist) {
    this.playlist = playlist;
  }

}
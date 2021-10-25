package com.demo.users.controller;

import com.demo.users.client.PlaylistProxy;
import com.demo.users.model.Playlist;
import com.demo.users.model.User;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final PlaylistProxy playlistProxy;

  public UserController(PlaylistProxy playlistProxy) {
    this.playlistProxy = playlistProxy;
  }

  private final List<User> users = Stream.of(
          new User("1", "user1", "1"),
          new User("2", "user2", "1"),
          new User("3", "user3", "2")
      )
      .collect(Collectors.toList());

  @GetMapping
  public List<User> getAll() {
    System.out.println(users);
    return users;
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getDetails(@PathVariable String id) {
    final Optional<User> product$ = users.stream().filter(p -> id.equals(p.getId())).findFirst();
    if (product$.isPresent()) {
      User user = product$.get();
      final Playlist playlist = playlistProxy.getDetails(user.getPlaylistId());
      user.setPlaylist(playlist);
      return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}

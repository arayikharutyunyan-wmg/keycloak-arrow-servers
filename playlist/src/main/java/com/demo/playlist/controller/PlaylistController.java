package com.demo.playlist.controller;

import com.demo.playlist.model.Playlist;
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
@RequestMapping("/playlist")
public class PlaylistController {

  private final List<Playlist> playlistList = Stream.of(
          new Playlist("1", "playlist1"),
          new Playlist("2", "playlist2")
      )
      .collect(Collectors.toList());

  @GetMapping(value = "/{id}")
  public ResponseEntity<Playlist> getDetails(@PathVariable("id") String id) {
    Optional<Playlist> provider$ = playlistList.stream().filter(p -> id.equals(p.getId()))
        .findFirst();
    return provider$.map(playlist -> new ResponseEntity<>(playlist, HttpStatus.ACCEPTED))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

}
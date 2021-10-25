package com.demo.users.client;

import com.demo.users.config.ClientConfiguration;
import com.demo.users.model.Playlist;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "playlist-service", url = "${microservice.playlist.url}", configuration = {
    ClientConfiguration.class}
)
public interface PlaylistProxy {

  @GetMapping(value = "/playlist/{id}")
  Playlist getDetails(@PathVariable("id") String id);
}
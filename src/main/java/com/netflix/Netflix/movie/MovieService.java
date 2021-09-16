package com.netflix.Netflix.movie;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MovieDb", url = "${serviceURL}")
public interface MovieService {

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> findById(@PathVariable Integer id, @RequestParam("api_key") String apiKey);

    @GetMapping(value = "discover/movie?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US&sort_by=popularity.{sort}&include_adult=false&include_video={include_vid}&page={page}&with_watch_monetization_types=flatrate")
    ResponseEntity<String> dicovery(
            @PathVariable("sort") String sort,
            @PathVariable("include_vid") String include_vid,
            @PathVariable("page") Integer page);


    @GetMapping(value = "genre/movie/list?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US")
    ResponseEntity<String> genre();
}


//api.themoviedb.org/3/genre/movie/list?api_key=97d7b8e2bab65af96c47f53519958733&language=en-US

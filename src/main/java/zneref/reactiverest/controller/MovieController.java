package zneref.reactiverest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import zneref.reactiverest.repository.MovieRepository;
import zneref.reactiverest.model.Movie;
import zneref.reactiverest.service.MovieService;


@RestController
@RequestMapping("/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;

    @GetMapping("/first")
    public Mono<Movie> searchFirst(@RequestParam("q") final String searchCriteria) {
        return service.getFirstTitleLike(searchCriteria);
    }

    @GetMapping("/all")
    public Flux<Movie> searchAll(@RequestParam("q") final String searchCriteria) {
        return service.getTitleLike(searchCriteria);
    }

    @GetMapping
    public Flux<Movie> getMovies() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Movie>> getMovie(@PathVariable(value = "id") String movieId) {
        return service.getById(movieId)
                .map(movie -> ResponseEntity.ok(movie))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}

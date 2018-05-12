package zneref.reactiverest.controller;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import zneref.reactiverest.model.Movie;
import zneref.reactiverest.service.MovieService;

@Component
@RequiredArgsConstructor
public class MovieHandler {

    final MovieService movieService;

    public Mono<ServerResponse> searchFirst(final ServerRequest request) {

        val searchCriteria = request.queryParam("q").orElse("");
        val body = movieService.getFirstTitleLike(searchCriteria);

        return ServerResponse.ok().body(body, Movie.class);
    }

    public Mono<ServerResponse> searchAll(final ServerRequest request) {

        val searchCriteria = request.queryParam("q").orElse("");
        val body = movieService.getTitleLike(searchCriteria);

        return ServerResponse.ok().body(body, Movie.class);
    }

    public Mono<ServerResponse> getMovie(final ServerRequest request) {

        val id = request.pathVariable("id");
        val body = movieService.getById(id);

        return ServerResponse.ok().body(body, Movie.class);
    }

    public Mono<ServerResponse> getMovies(final ServerRequest request) {
        return ServerResponse.ok().body(movieService.getAll(), Movie.class);
    }
}

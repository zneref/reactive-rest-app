package zneref.reactiverest.controller;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import zneref.reactiverest.model.Movie;
import zneref.reactiverest.repository.MovieRepository;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class MovieControllerTestSuite {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    MovieRepository movieRepository;

    @Test
    public void testGetAllMovies() {
        webTestClient.get().uri("/v1/movies")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBodyList(Movie.class);
    }

/*    @Test
    public void testAddMovie() {
        //Given
        Movie movie = new Movie("1", "movie title", "available");

        //When, Then
        webTestClient.post().uri("/v1/library/movies")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(movie), Movie.class)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody()
                .jsonPath("$.id").isNotEmpty()
                .jsonPath("$.title").isEqualTo("movie title");
    }

    @Test
    public void testGetMovie() {
        Movie movie = movieRepository.save(new Movie("movie title", "available")).block();

        webTestClient.get()
                .uri("/v1/library/movies/{id}", Collections.singletonMap("id", movie.getId()))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(response ->
                        Assertions.assertThat(response.getResponseBody()).isNotNull());
    }

    @Test
    public void testUpdateMovie() {
        Movie movie = movieRepository.save(new Movie("movie title", "available")).block();

        Movie newMovie = new Movie("movie title", "rented");

        webTestClient.put()
                .uri("/v1/library/movies/{id}", Collections.singletonMap("id", movie.getId()))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(newMovie), Movie.class)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody()
                .jsonPath("$.status").isEqualTo("rented");
    }

    @Test
    public void testDeleteMovie() {
        Movie movie = movieRepository.save(new Movie("To be deleted", "ok")).block();

        webTestClient.delete()
                .uri("/v1/library/movies/{id}", Collections.singletonMap("id", movie.getId()))
                .exchange()
                .expectStatus().isOk();
    }*/
}
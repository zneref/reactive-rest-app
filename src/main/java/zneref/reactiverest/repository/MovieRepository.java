package zneref.reactiverest.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import zneref.reactiverest.model.Movie;

@Repository
public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
    Flux<Movie> findAllByTitleContainingIgnoreCase(final String title);

    Mono<Movie> findFirstByTitleContainingIgnoreCase(final String title);

}

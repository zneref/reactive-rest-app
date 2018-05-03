package zneref.reactiverest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import zneref.reactiverest.model.Movie;
import zneref.reactiverest.repository.MovieRepository;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository repository;

    public Flux<Movie> getAll() {
        return repository.findAll();
    }

    public Flux<Movie> getTitleLike(final String searchCriteria) {
        return repository.findAllByTitleContainingIgnoreCase(searchCriteria);
    }

    public Mono<Movie> getFirstTitleLike(final String searchCriteria) {
        return repository.findFirstByTitleContainingIgnoreCase(searchCriteria);
    }

    public Mono<Movie> getById(final String id) {
        return repository.findById(id);
    }
}

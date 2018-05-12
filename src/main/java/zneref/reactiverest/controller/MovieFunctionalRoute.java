package zneref.reactiverest.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class MovieFunctionalRoute {

    @Bean
    RouterFunction<ServerResponse> movieRouterFunction(final MovieHandler handler) {

        return route(GET("/v2/movies/first"), handler::searchFirst)
                .andRoute(GET("/v2/movies/all"), handler::searchAll)
                .andRoute(GET("/v2/movies/{id}"), handler::getMovie)
                .andRoute(GET("/v2/movies/**"), handler::getMovies)
                ;
    }
}

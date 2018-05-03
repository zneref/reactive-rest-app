package zneref.reactiverest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MovieInfo {
    @NotNull
    private List<String> directors;
    @NotNull
    private String release_date;
    @NotNull
    private double rating;
    @NotNull
    private List<String> genres;
    @NotNull
    private String image_url;
    @NotNull
    private String plot;
    @NotNull
    private int rank;
    @NotNull
    private long running_time_secs;
    @NotNull
    private List<String> actors;
}

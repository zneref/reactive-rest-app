package zneref.reactiverest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document(collection = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Movie {
    @Id
    private String id;
    @NotBlank
    private String title;
    @NotNull
    private MovieInfo info;
}

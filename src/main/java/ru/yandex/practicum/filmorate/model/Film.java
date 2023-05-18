package ru.yandex.practicum.filmorate.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import ru.yandex.practicum.filmorate.annotations.CorrectReleaseDay;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Film {

    @PositiveOrZero
    private Long id;

    @NotBlank
    private String name;

    @Length(max = 200)
    private String description;

    @CorrectReleaseDay(message = "1895-12-28")
    private LocalDate releaseDate;

    @Positive
    private int duration;

    private MpaRating mpa;

    private List<Long> likes = new ArrayList<>();

    private List<Genre> genres;


}

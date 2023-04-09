package ru.yandex.practicum.filmorate.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.Duration;
import java.time.LocalDate;

import org.hibernate.validator.constraints.time.DurationMin;
import ru.yandex.practicum.filmorate.annotations.CorrectReleaseDay;

@Data
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Film {
    @PositiveOrZero(message = "id can not be negative")
    private int id;

    @NotBlank(message = "name must not be empty")
    private String name;

    @Length(min = 1, max = 200, message = "description length must be between 1 and 200")
    private String description;

    @PastOrPresent
    private LocalDate releaseDate;

    @DurationMin(message = "duration can not be negative")
    private Duration duration;
}
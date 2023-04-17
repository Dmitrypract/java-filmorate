package ru.yandex.practicum.filmorate.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

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

    @PositiveOrZero
    private Integer duration;
}
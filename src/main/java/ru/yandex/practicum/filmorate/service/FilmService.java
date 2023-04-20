package ru.yandex.practicum.filmorate.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.storage.FilmStorage;
import ru.yandex.practicum.filmorate.storage.UserStorage;
import ru.yandex.practicum.filmorate.storage.FilmStorage;
import ru.yandex.practicum.filmorate.storage.UserStorage;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmService  {
    private final FilmStorage filmStorage;
    private final UserStorage userStorage;

    public Film getFilmById(long id) {
        return filmStorage.getFilmById(id);
    }

    public void addLike(long id, long userId) {
        filmStorage.getFilmById(id).addLike(userStorage.getUserById(userId).getId());
    }

    public void unlike(long id, long userId) {
        filmStorage.getFilmById(id).deleteLike(userStorage.getUserById(userId).getId());
    }

    public Collection<Film> getMostPopularFilms(long count) {
        return filmStorage
                .getFilms()
                .stream()
                .sorted(Comparator.comparingLong(f -> f.getLikes().size()))
                .limit(count)
                .collect(Collectors.toSet());
    }


    public Collection<Film> getFilms() {
        return filmStorage.getFilms();
    }


    public Film updateFilm(Film film) {
        return filmStorage.updateFilm(film);
    }


    public Film createFilm(Film film) {
        return filmStorage.createFilm(film);
    }
}
package ru.yandex.practicum.filmorate.model;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

import lombok.*;
import ru.yandex.practicum.filmorate.annotations.CorrectLogin;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class User {
    @PositiveOrZero
    private long id;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String login;
    private String name;
    @PastOrPresent
    private LocalDate birthday;
    private Set<Long> friendsId = new HashSet<>();

    public User(long id, String email, String login, String name, LocalDate birthday) {
        this.id = id;
        this.email = email;
        this.login = login;
        this.name = name;
        this.birthday = birthday;
    }


    public void addFriend(long id) {
        if (friendsId == null) {
            friendsId = new HashSet<>();
        }
        friendsId.add(id);
    }



    public void unfriend(long id) {
        friendsId.remove(id);
    }
}
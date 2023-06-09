package ru.yandex.practicum.filmorate.storage;

import ru.yandex.practicum.filmorate.model.User;

import java.util.Collection;

public interface UserStorage {
    User createUser(User user);

    User updateUser(User user);

    Collection<User> getUsers();

    User getUserById(long id);

    Collection<User> getUsersByIds(Collection<Long> ids);
}
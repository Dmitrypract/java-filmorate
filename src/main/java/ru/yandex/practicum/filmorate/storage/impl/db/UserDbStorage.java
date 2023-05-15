package ru.yandex.practicum.filmorate.storage.impl.db;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.filmorate.dao.UserDao;
import ru.yandex.practicum.filmorate.exception.UserNotFoundException;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.storage.UserStorage;

import java.util.Collection;
import java.util.Set;

@Slf4j
@Repository
@Primary
@RequiredArgsConstructor
public class UserDbStorage implements UserStorage {

    private final UserDao userDao;

    @Override
    public User createUser(User user) {
        User newUser = userDao.createUser(user);
        log.info("Создан пользователь: " + newUser);
        return user;
    }

    @Override
    public User updateUser(User user) {
        if (!isExist(user.getId())) {
            log.error("Ошибка, пользователь не существует: " + user);
            throw new UserNotFoundException();
        }
        userDao.updateUser(user);
        log.info("Обновлен пользователь: " + user);
        return user;
    }

    @Override
    public Collection<User> getUsers() {
        Collection<User> users = userDao.getUsers();
        log.info("Получены пользователи: " + users);
        return users;
    }

    @Override
    public Collection<User> getUsersByIds(Collection<Long> ids) {
        Collection<User> users = userDao.getUsersByIds((Set<Long>) ids);
        log.info("Получены пользователи: " + users);
        return users;
    }

    @Override
    public User getUserById(long userId) {
        User user = userDao.getUserById(userId).orElseThrow(UserNotFoundException::new);
        log.info("Получен пользователь: " + user);
        return user;
    }

    private boolean isExist(long userId) {
        return userDao.getUserById(userId).isPresent();
    }
}
package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.AbstractNamedEntity;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class UsersUtil {

    public static final List<User> users = Arrays.asList(
            new User(null, "Вася", "vasya@mail.ru", "vasay123", Role.USER, Role.ADMIN),
            new User(null, "Петя", "petya@mail.ru", "petya321", Role.USER),
            new User(null, "Маша", "mary@mail.ru", "mrsmary", Role.USER),
            new User(null, "Вася", "mrvasyan@mail.ru", "vasaynQWERTY", Role.USER)
    );

    public static List<User> getSorteredUsers(List<User> users) {
        return users.stream().sorted(Comparator.comparing(AbstractNamedEntity::getName)).collect(Collectors.toList());
    }

    public static Role[] roleToString(Set<Role> roles) {
        return roles.toArray(new Role[0]);
    }
}


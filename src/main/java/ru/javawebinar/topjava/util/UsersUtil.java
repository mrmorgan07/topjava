package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.AbstractNamedEntity;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UsersUtil {

    public static final List<User> users = Arrays.asList(
            new User(1,"Вася", "vasya@mail.ru","vasay123", Role.USER),
            new User(2,"Петя", "petya@mail.ru","petya321", Role.USER),
            new User(3,"Маша", "mary@mail.ru","mrsmary", Role.USER),
            new User(4,"Вася", "mrvasyan@mail.ru","vasaynQWERTY", Role.USER)
    );

    public static List<User> getSorteredUsers(Collection<User> users){
        return users.stream().sorted(Comparator.comparing(AbstractNamedEntity::getName)).collect(Collectors.toList());
    }
}


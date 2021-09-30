package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;


public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );

        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        mealsTo.forEach(System.out::println);

//        System.out.println(filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
    }

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with excess. Implement by cycles

        List<UserMealWithExcess> result = new ArrayList<>();
        Map<LocalDate, Integer> sumCaloriesMap = new HashMap<>();

        // в sumCaloriesMap пишу сумму калорий по каждому дню,
        // чтобы при добавлении записи сразу проставлять excess флаг
        meals.forEach(item -> {
            if (item.getDateTime().toLocalTime().compareTo(startTime) >= 0
                    && item.getDateTime().toLocalTime().compareTo(endTime) <= 0) {
                if (sumCaloriesMap.containsKey(item.getDateTime().toLocalDate())) {
                    sumCaloriesMap.put(item.getDateTime().toLocalDate(), sumCaloriesMap.get(item.getDateTime().toLocalDate()) + item.getCalories());
                } else {
                    sumCaloriesMap.put(item.getDateTime().toLocalDate(), item.getCalories());
                }
            }
        });

        // основной цикл для получения фильтрованного списка
        meals.forEach(item -> {
            if (item.getCalories() > caloriesPerDay) {

                //добавляем сразу запись, где идет избыток дневных калорий
                result.add(new UserMealWithExcess(LocalDateTime.of(item.getDateTime().toLocalDate(),item.getDateTime().toLocalTime()),
                        item.getDescription(),
                        item.getCalories(),
                        true));
            } else {

                //фильтруем записи по временному промежутку
                if (item.getDateTime().toLocalTime().compareTo(startTime) >= 0
                        && item.getDateTime().toLocalTime().compareTo(endTime) <= 0) {

                    // проверяем суммарное за день потребление калорий
                    if (sumCaloriesMap.get(item.getDateTime().toLocalDate()) > caloriesPerDay) {
                        result.add(new UserMealWithExcess(LocalDateTime.of(item.getDateTime().toLocalDate(),item.getDateTime().toLocalTime()),
                                item.getDescription(),
                                item.getCalories(),
                                true));
                    } else {
                        result.add(new UserMealWithExcess(LocalDateTime.of(item.getDateTime().toLocalDate(),item.getDateTime().toLocalTime()),
                                item.getDescription(),
                                item.getCalories(),
                                false));
                    }
                }
            }
        }); 
        return result;
    }

    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO Implement by streams
        return null;
    }
}

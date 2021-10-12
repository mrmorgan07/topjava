package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private static List<Meal> meals;

    @Override
    public void init() {
        meals = MealsUtil.initData();
        log.debug("Load meal data");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MealTo> mealsTo = MealsUtil.filteredByStreams(meals, LocalTime.of(0, 0), LocalTime.of(LocalTime.MAX.getHour(), LocalTime.MAX.getMinute(), LocalTime.MAX.getSecond()), MealsUtil.caloriesPerDay);
        request.setAttribute("mealsToList", mealsTo);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("meals.jsp");
        requestDispatcher.forward(request, response);
        log.debug("redirect to meals");
    }
}
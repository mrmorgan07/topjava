package ru.javawebinar.topjava.util;

import org.junit.rules.Stopwatch;
import org.junit.runner.Description;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestWatch extends Stopwatch {
    private static Logger logger;
    public static final Map<String, String> timeMap = new HashMap<>();

    public TestWatch(Logger logger) {
        super();
        TestWatch.logger = logger;
    }

    @Override
    protected void finished(long nanos, Description description) {
        logInfo(description, nanos);
        saveTimeResult(description, nanos);
    }

    private static void logInfo(Description description, long nanos) {
        logger.info(String.format("Test %s spent %d microseconds",
                description.getMethodName(), TimeUnit.NANOSECONDS.toMillis(nanos)));
    }

    public static void saveTimeResult(Description description, long nanos) {
        timeMap.put(description.getMethodName(),
                String.valueOf(TimeUnit.NANOSECONDS.toMillis(nanos)));
    }
}

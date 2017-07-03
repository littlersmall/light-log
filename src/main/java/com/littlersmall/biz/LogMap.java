package com.littlersmall.biz;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by littlersmall on 2017/6/27.
 */
public class LogMap {
    private static Map<Class<?>, Logger> loggerMap = new HashMap<>();

    public static Logger getLogger(Class<?> clazz) {
        Logger logger = loggerMap.get(clazz);

        if (logger == null) {
            synchronized (LogMap.class) {
                if (!loggerMap.containsKey(clazz)) {
                    logger = LoggerFactory.getLogger(clazz);
                    loggerMap.put(clazz, logger);
                }
            }
        }

        return logger;
    }
}

package com.example.demo.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
    public static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void error(String message, Throwable t) {
        logger.error(message, t);
    }
}

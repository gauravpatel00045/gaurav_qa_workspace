package com.bankingexample.utilities;

import org.apache.log4j.Logger;

/**
 * Custom logger which use to access project level.
 */
public class CustomLogger {

    private static Logger logger;

    public static Logger getInstance() {
        if (logger == null) {
            logger = Logger.getLogger("banking_example");
        }
        return logger;
    }
}

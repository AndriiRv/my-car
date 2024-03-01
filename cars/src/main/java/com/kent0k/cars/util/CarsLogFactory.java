package com.kent0k.cars.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarsLogFactory {

    private CarsLogFactory() {
    }

    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}

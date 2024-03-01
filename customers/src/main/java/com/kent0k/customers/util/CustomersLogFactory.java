package com.kent0k.customers.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomersLogFactory {

    private CustomersLogFactory() {
    }

    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}

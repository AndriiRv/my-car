package com.kent0k.servicepartners.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServicePartnersLogFactory {

    private ServicePartnersLogFactory() {
    }

    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}

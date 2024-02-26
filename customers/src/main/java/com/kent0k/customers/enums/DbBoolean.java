package com.kent0k.customers.enums;

/**
 * Custom java-enum type for properly mapping boolean values with Oracle database.
 */
public enum DbBoolean {

    Y, N;

    public boolean isTrue() {
        return this == DbBoolean.Y;
    }
}

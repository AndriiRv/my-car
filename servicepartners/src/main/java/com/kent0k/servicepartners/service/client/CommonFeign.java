package com.kent0k.servicepartners.service.client;

import java.util.function.Supplier;

public interface CommonFeign<T, E extends RuntimeException> {

    default void isResourceAccessible(Supplier<T> responseEntitySupplier,
                                      Supplier<E> exceptionSupplier) {
        try {
            responseEntitySupplier.get();
        } catch (Exception e) {
            throw exceptionSupplier.get();
        }
    }
}

package com.kent0k.servicepartners.repository;

import com.kent0k.servicepartners.entity.BaseEntity;

/**
 * General repository which has common behavior for 'ServicePartners' repositories.
 *
 * @param <T> genetic should be extended by {@link BaseEntity}.
 */
public interface CommonRepository<T extends BaseEntity> {

    T findFirstByOrderByIdDesc();

    /**
     * Perform query against database to find first object which ordered by ID column as DESC and fetch ID value from it.
     * If object is non-null then return id of object. Otherwise, return zero.
     *
     * @return last id int value.
     */
    default int getLastIdValue() {
        T lastServicePartnerObj = findFirstByOrderByIdDesc();
        return lastServicePartnerObj != null ? lastServicePartnerObj.getId() : 0;
    }

    /**
     * Get last id value from table (collection), increment it by one and return this new built value.
     *
     * @return last id int value plus one.
     */
    default int incrementAndGet() {
        return getLastIdValue() + 1;
    }
}

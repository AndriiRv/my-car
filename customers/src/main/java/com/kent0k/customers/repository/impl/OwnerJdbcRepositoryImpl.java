package com.kent0k.customers.repository.impl;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class OwnerJdbcRepositoryImpl {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Update notification 'is_sent' column value to 'Y' related to only active owners with 'created_at_utc' older than 1 year.
     *
     * @return boolean
     */
    @Transactional
    public boolean updateNotificationIsSentStatus() {
        String sql = """
                DECLARE
                    ownerAccountCreatedAtLeastOneYearAgo date := SYSDATE - NUMTOYMINTERVAL(1, 'year');
                    type ownerNotificationIdArray IS VARRAY(100) OF INTEGER;
                    ownerNotificationIds                 ownerNotificationIdArray;
                BEGIN
                    SELECT OWNER_NOTIFICATIONS.ID BULK COLLECT INTO ownerNotificationIds
                    FROM OWNER
                             INNER JOIN OWNER_CREDENTIALS ON OWNER.ID = OWNER_CREDENTIALS.ID
                             INNER JOIN OWNER_NOTIFICATIONS ON OWNER_NOTIFICATIONS.OWNER_ID = OWNER.ID
                    WHERE OWNER_CREDENTIALS.IS_ACTIVE = 'Y'
                      AND OWNER.CREATED_AT_UTC < ownerAccountCreatedAtLeastOneYearAgo
                      AND OWNER_NOTIFICATIONS.IS_SENT = 'N';
                
                    IF (ownerNotificationIds.COUNT = 0) THEN
                        RAISE_APPLICATION_ERROR(-20000, 'Invalid: None notifications found');
                    END IF;
                
                    BEGIN
                        FOR i IN 1..ownerNotificationIds.COUNT
                            LOOP
                                UPDATE OWNER_NOTIFICATIONS SET IS_SENT = 'Y' WHERE ID = ownerNotificationIds(i);
                            END LOOP;
                    END;
                END;
                """;

        return jdbcTemplate.update(sql) > 0;
    }
}

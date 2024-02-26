CREATE TABLE owner
(
    id             NUMBER GENERATED AS IDENTITY NOT NULL PRIMARY KEY,
    firstname      VARCHAR(20)                  NOT NULL,
    lastname       VARCHAR(20)                  NOT NULL,
    birthdate      DATE                         NOT NULL,
    email          VARCHAR(50)                  NOT NULL UNIQUE,
    phone_number   VARCHAR(20)                  NOT NULL UNIQUE,
    created_at_utc TIMESTAMP                    NOT NULL,
    created_by_id  VARCHAR(20)                  NOT NULL,
    updated_at_utc TIMESTAMP                    NULL,
    updated_by_id  VARCHAR(20)                  NULL
);

CREATE TABLE owner_credentials
(
    id             integer     NOT NULL PRIMARY KEY,
    username       VARCHAR(20) NOT NULL,
    password       VARCHAR(50) NOT NULL,
    is_active      VARCHAR(1)  NOT NULL CHECK (is_active IN ('Y', 'N')),
    created_at_utc TIMESTAMP   NOT NULL,
    created_by_id  VARCHAR(20) NOT NULL,
    updated_at_utc TIMESTAMP   NULL,
    updated_by_id  VARCHAR(20) NULL,
    FOREIGN KEY (id) REFERENCES owner (id) ON DELETE CASCADE
);

CREATE TABLE owner_notifications
(
    id                       NUMBER GENERATED AS IDENTITY NOT NULL PRIMARY KEY,
    owner_id                 INTEGER                      NOT NULL,
    owners_notification_mode VARCHAR(20)                  NOT NULL CHECK (owners_notification_mode IN ('EMAIL', 'SMS', 'TELEGRAM')),
    message                  VARCHAR(100)                 NOT NULL,
    is_sent                  VARCHAR(1)                   NOT NULL CHECK (is_sent IN ('Y', 'N')),
    created_at_utc           TIMESTAMP                    NOT NULL,
    created_by_id            VARCHAR(20)                  NOT NULL,
    updated_at_utc           TIMESTAMP                    NULL,
    updated_by_id            VARCHAR(20)                  NULL,
    FOREIGN KEY (owner_id) REFERENCES owner (id) ON DELETE CASCADE
);

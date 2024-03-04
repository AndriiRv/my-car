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

COMMENT ON COLUMN owner.firstname IS 'Owners identifier as integer value';
COMMENT ON COLUMN owner.firstname IS 'Owners firstname';
COMMENT ON COLUMN owner.lastname IS 'Owners lastname';
COMMENT ON COLUMN owner.birthdate IS 'Owners birth date';
COMMENT ON COLUMN owner.email IS 'Owners email. Should be unique across table';
COMMENT ON COLUMN owner.phone_number IS 'Owners phone number. Should be unique across table';

CREATE TABLE owner_credentials
(
    id             integer     NOT NULL PRIMARY KEY,
    username       VARCHAR(20) NOT NULL UNIQUE,
    password       VARCHAR(50) NOT NULL,
    is_active      VARCHAR(1)  NOT NULL CHECK (is_active IN ('Y', 'N')),
    created_at_utc TIMESTAMP   NOT NULL,
    created_by_id  VARCHAR(20) NOT NULL,
    updated_at_utc TIMESTAMP   NULL,
    updated_by_id  VARCHAR(20) NULL,
    FOREIGN KEY (id) REFERENCES owner (id) ON DELETE CASCADE
);

COMMENT ON COLUMN owner_credentials.id IS 'Owner credentials identifier as integer value. Should be as ONE-TO-ONE related to owner table by owner.id column';
COMMENT ON COLUMN owner_credentials.username IS 'Owners username. Should be encrypted';
COMMENT ON COLUMN owner_credentials.password IS 'Owners password. Should be encrypted';
COMMENT ON COLUMN owner_credentials.is_active IS 'Owners account status';

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

COMMENT ON COLUMN owner_notifications.id IS 'Owner notifications identifier as integer value';
COMMENT ON COLUMN owner_notifications.owner_id IS 'Owners id. Should be as MANY-TO-ONE related to owner table by owner.id column';
COMMENT ON COLUMN owner_notifications.owners_notification_mode IS 'Owners notification mode. Different types of notify the customers/owners';
COMMENT ON COLUMN owner_notifications.message IS 'Owners notification message';
COMMENT ON COLUMN owner_notifications.is_sent IS 'Owners notification is sent status';

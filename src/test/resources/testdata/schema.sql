CREATE TABLE IF NOT EXISTS `PERSONA`
(
    `id`    varchar(100)    PRIMARY KEY,
    `name`  varchar(100)    NOT NULL,
    `age`   int             NOT NULL,
    `alive` boolean         NOT NULL
);
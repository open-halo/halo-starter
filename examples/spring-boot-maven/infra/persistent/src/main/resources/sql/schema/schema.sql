CREATE TABLE IF NOT EXISTS users (
    `id`    BIGINT,
    `age`   BIGINT,
    `name`  VARCHAR(64) NOT NULL,
    `email` VARCHAR(64) NOT NULL,
    PRIMARY KEY(`id`),
    UNIQUE  KEY `uk_email`(`email`),
    INDEX `idx_name`(`name`)
);
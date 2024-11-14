

CREATE TABLE IF NOT EXISTS `author` (
    `id`     BIGINT,
    `gender` VARCHAR(1),
    `name`   VARCHAR(64) NOT NULL,
    `email`  VARCHAR(64) NOT NULL,
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY(`id`),
    CONSTRAINT `ck_gender` CHECK  `gender` IN ('M', 'F');
    UNIQUE KEY `uk_email`(`email`),
    INDEX `idx_name`(`name`)
);


CREATE table `book` (
    `id`        BIGINT NOT NULL,
    `name`      VARCHAR(50) NOT NULL,
    `edition`   INT NOT NULL,
    `price`     DECIMAL(10, 2) NOT NULL,
    `author_id` BIGINT NOT NULL,
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY(`id`),
    UNIQUE KEY `uk_name_edition`(`name`, `edition`)
);


CREATE TABLE `store` (
    `id`      BIGINT NOT NULL,
    `name`    VARCHAR(50) NOT NULL,
    `website` VARCHAR(100) NOT NULL DEFAULT '',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY(`id`),
    UNIQUE KEY `uk_name`(`name`),
    UNIQUE KEY `uk_website`(`website`)
);

CREATE TABLE IF NOT EXISTS `book_store_link` (
    `id`        BIGINT NOT NULL,
    `book_id`   BIGINT NOT NULL,
    `store_id`  BIGINT NOT NULL,
    `count`     INT NOT NULL DEFAULT 0,

    PRIMARY KEY(`id`),
    UNIQUE KEY `uk_book_id_store_id`(`book_id`, `store_id`),
    UNIQUE KEY `uk_store_id_book_id`(`store_id`, `book_id`),ßßßß
    INDEX `idx_count`(`count`)
);
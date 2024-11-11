
CREATE TABLE IF NOT EXISTS `author` (
    `id`     BIGINT,
    `gender` VARCHAR(8),
    `name`   VARCHAR(64) NOT NULL,
    `email`  VARCHAR(64) NOT NULL,
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(`id`)
);

CREATE INDEX IF NOT EXISTS
    `idx_name` ON `author` (`name`);
ALTER TABLE `author` ADD CONSTRAINT
    `uk_email`  UNIQUE (`email`);
ALTER TABLE `author` ADD CONSTRAINT
    `ck_gender` CHECK  `gender` IN ('MALE', 'FEMALE');


CREATE table `book` (
    `id`        BIGINT NOT NULL,
    `name`      VARCHAR(50) NOT NULL,
    `edition`   INT NOT NULL,
    `price`     DECIMAL(10, 2) NOT NULL,
    `author_id` BIGINT NOT NULL,
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(`id`)
);

ALTER TABLE `book`
    ADD CONSTRAINT `uk_name_edition`
    UNIQUE(name, edition);


CREATE TABLE `store` (
    `id`      BIGINT NOT NULL,
    `name`    VARCHAR(50) NOT NULL,
    `website` VARCHAR(100) NOT NULL DEFAULT '',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(`id`)
);

ALTER TABLE `store`
    ADD CONSTRAINT `uk_name`
    UNIQUE(`name`);

ALTER TABLE `store`
    ADD CONSTRAINT `uk_website`
    UNIQUE(`website`);

CREATE TABLE IF NOT EXISTS `book_store_link` (
    `id`        BIGINT NOT NULL,
    `book_id`   BIGINT NOT NULL,
    `store_id`  BIGINT NOT NULL,
    `remain_count`     INT NOT NULL DEFAULT 0,
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(`id`)
);

ALTER TABLE `book_store_link`
    ADD CONSTRAINT `uk_book_id_store_id`
        UNIQUE KEY(book_id, store_id);
ALTER TABLE `book_store_link`
    ADD CONSTRAINT `uk_store_id_book_id`
        UNIQUE KEY(store_id, book_id);
CREATE INDEX IF NOT EXISTS
    `idx_remain_count` ON `book_store_link` (`remain_count`);
CREATE TABLE IF NOT EXISTS `users` (
    `id`    BIGINT,
    `age`   BIGINT,
    `name`  VARCHAR(64) NOT NULL,
    `email` VARCHAR(64) NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE UNIQUE INDEX IF NOT EXISTS `uk_email` ON `users` (`email`);
CREATE INDEX        IF NOT EXISTS `idx_name` ON `users` (`name`);
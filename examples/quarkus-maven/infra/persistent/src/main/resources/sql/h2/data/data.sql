INSERT INTO `author` (id, gender, name, email) VALUES (101, 'MALE', 'Joshua Bloch ', 'joshua.bloch@example.com');
INSERT INTO `author` (id, gender, name, email) VALUES (102, 'MALE', 'Scott Meyers ', 'scott.meyers@example.com');

INSERT INTO `book`(`id`, `name`, `edition`, `price`, `author_id`) VALUES (201, 'Effective Java', 3, 1);
INSERT INTO `book`(`id`, `name`, `edition`, `price`, `author_id`) VALUES (202, 'Effective C++',  3, 2);

INSERT INTO `store`(`id`, `name`, `website`) VALUES (301, 'Small Tree House', 'tree.example.com');
INSERT INTO `store`(`id`, `name`, `website`) VALUES (302, 'Big World', 'big.world.com');

INSERT INTO `book_store_link`(`id`, `book_id`, `store_id`, `price`, `remain_count`) VALUES (1, 201, 301, 50.6, 10);
INSERT INTO `book_store_link`(`id`, `book_id`, `store_id`, `price`, `remain_count`) VALUES (2, 202, 301, 50.6, 20);
INSERT INTO `book_store_link`(`id`, `book_id`, `store_id`, `price`, `remain_count`) VALUES (3, 201, 302, 40.9, 30);
INSERT INTO `book_store_link`(`id`, `book_id`, `store_id`, `price`, `remain_count`) VALUES (4, 202, 302, 40.9 40);
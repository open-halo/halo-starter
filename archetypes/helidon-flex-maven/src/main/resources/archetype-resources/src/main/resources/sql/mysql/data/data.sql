INSERT INTO `author` (id, gender, name, email) VALUES (101, 'F', 'Joshua Bloch ', 'joshua.bloch@example.com');
INSERT INTO `author` (id, gender, name, email) VALUES (102, 'F', 'Scott Meyers ', 'scott.meyers@example.com');

INSERT INTO `book`(`id`, `name`, `edition`, `price`, `author_id`) VALUES (201, 'Effective Java', 3, 50.6, 1);
INSERT INTO `book`(`id`, `name`, `edition`, `price`, `author_id`) VALUES (202, 'Effective C++',  3, 40.9, 2);

INSERT INTO `store`(`id`, `name`, `website`) VALUES (301, 'Small Tree House', 'tree.example.com');
INSERT INTO `store`(`id`, `name`, `website`) VALUES (302, 'Big World', 'big.world.com');

INSERT INTO `book_store_link`(`id`, `book_id`, `store_id`, `remain_count`) VALUES (1, 201, 301, 10);
INSERT INTO `book_store_link`(`id`, `book_id`, `store_id`, `remain_count`) VALUES (2, 202, 301, 20);
INSERT INTO `book_store_link`(`id`, `book_id`, `store_id`, `remain_count`) VALUES (3, 201, 302, 30);
INSERT INTO `book_store_link`(`id`, `book_id`, `store_id`, `remain_count`) VALUES (4, 202, 302, 40);
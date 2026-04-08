CREATE TABLE tb_user (
    id BINARY(16) PRIMARY KEY NOT NULL,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);
INSERT INTO tb_user (id, username, email) VALUES (UNHEX(REPLACE(UUID(),'-','')), 'user1', 'user1@example.com');
INSERT INTO tb_user (id, username, email) VALUES (UNHEX(REPLACE(UUID(),'-','')), 'user2', 'user2@example.com');
INSERT INTO tb_user (id, username, email) VALUES (UNHEX(REPLACE(UUID(),'-','')), 'user3', 'user3@example.com');
INSERT INTO tb_user (id, username, email) VALUES (UNHEX(REPLACE(UUID(),'-','')), 'user4', 'user4@example.com');
INSERT INTO tb_user (id, username, email) VALUES (UNHEX(REPLACE(UUID(),'-','')), 'user5', 'user5@example.com');
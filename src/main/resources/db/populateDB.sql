DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

insert into meals (user_id, description, calories) VALUES (100000,'завтрак', 1000);
insert into meals (user_id, description, calories) VALUES (100001,'завтрак', 1200);
insert into meals (user_id, description, calories) VALUES (100000,'Обед', 1200);
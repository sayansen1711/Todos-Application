create schema if not exists todosDB;
use todosDB;
desc todo;
select * from todo;

CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL DEFAULT 'ROLE_USER'
);

select * from users;
select * from todo where username='Rakesh Sen';
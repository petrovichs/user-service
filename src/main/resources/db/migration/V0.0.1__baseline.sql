create table if not exists users
(
    id         serial primary key,
    username   varchar(256) not null,
    first_name varchar(256),
    last_name  varchar(256),
    email      varchar(256),
    phone      varchar(2048)
);

create table if not exists users
(
    uuid       uuid primary key,
    id         bigint,
    username   varchar(256) not null,
    first_name varchar(256),
    last_name  varchar(256),
    email      varchar(256),
    phone      varchar(2048)
);

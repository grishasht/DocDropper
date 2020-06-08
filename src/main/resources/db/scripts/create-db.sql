CREATE TABLE users
(
    id       serial primary key,
    guid     uuid        not null unique,
    name     varchar(20) not null,
    surname  varchar(20),
    login    varchar(20) not null unique,
    password text        not null,
    email    varchar(40) not null
);

CREATE TABLE similarities
(
    id            serial primary key,
    id_first_doc  integer,
    id_second_doc integer
);

CREATE TABLE documents
(
    id                 serial primary key,
    guid               uuid        not null unique,
    name               varchar(40) not null,
    size               int8        not null,
    format             varchar(10),
    date_uploaded      timestamp   not null,
    date_last_modified timestamp   not null,
    guid_user          uuid references users (guid)
);

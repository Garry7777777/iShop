-- liquibase formatted sql


-- changeset garry:2
create table category
(
    id   BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(255)
);



-- liquibase formatted sql


-- changeset garry:1
create table product
(
    id                BIGSERIAL NOT NULL PRIMARY KEY,
    description       VARCHAR(255),
    creation_date     TIMESTAMP NOT NULL,
    modification_date TIMESTAMP NOT NULL,
    name              VARCHAR(255)
);



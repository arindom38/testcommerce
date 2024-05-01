CREATE TABLE IF NOT EXISTS customer
(
    id                      bigserial not null primary key,
    name                    varchar(80) not null,
    email                   varchar(80) not null,
    phone                   varchar(20) not null,
    address                 varchar(100),
    created_at             timestamp,
    modified_at             timestamp
);
CREATE TABLE IF NOT EXISTS item
(
    id          bigserial      not null primary key,
    name        varchar(80)    not null,
    description varchar(100),
    price       numeric(12, 2) not null,
    created_at  timestamp,
    modified_at timestamp
);
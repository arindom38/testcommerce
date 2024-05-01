CREATE TABLE IF NOT EXISTS sale
(
    id          bigserial   not null primary key,
    item_id     bigint      not null,
    sale_date   date   not null,
    amount      integer not null,
    created_at  timestamp,
    modified_at timestamp
);

create index if not exists index_item_id
    on sale (item_id);
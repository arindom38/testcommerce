CREATE TABLE IF NOT EXISTS customer_wishlist
(
    id          bigserial not null primary key,
    customer_id bigint    not null,
    item_id     bigint    not null,
    is_removed  boolean   not null,
    created_at  timestamp,
    modified_at timestamp,
    unique (customer_id, item_id)
);
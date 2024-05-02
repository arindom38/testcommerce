Delete
from customer;
insert into customer (id, name, email, phone, address, created_at, modified_at)
values (1, 'user A', 'usera@example.com', '0123456789', 'abcd', current_date, current_date);

insert into customer (id, name, email, phone, address, created_at, modified_at)
values (2, 'user B', 'userb@example.com', '0123446789', 'abcdf', current_date, current_date);

insert into customer (id, name, email, phone, address, created_at, modified_at)
values (3, 'user C', 'userc@example.com', '012343456789', 'abcdgh', current_date, current_date);

Delete
from customer_wishlist;
insert into customer_wishlist (customer_id, item_id, is_removed, created_at, modified_at)
values (1, 1, false, current_date, current_date);

insert into customer_wishlist (customer_id, item_id, is_removed, created_at, modified_at)
values (1, 2, false, current_date, current_date);

insert into customer_wishlist (customer_id, item_id, is_removed, created_at, modified_at)
values (1, 3, true, current_date, current_date);

insert into customer_wishlist (customer_id, item_id, is_removed, created_at, modified_at)
values (2, 3, false, current_date, current_date);

insert into customer_wishlist (customer_id, item_id, is_removed, created_at, modified_at)
values (2, 4, false, current_date, current_date);

Delete
from item;
insert into item (id, name, description, price, created_at, modified_at)
values (1, 'product A', 'product A', 100, current_date, current_date);

insert into item (id, name, description, price, created_at, modified_at)
values (2, 'product B', 'product B', 200, current_date, current_date);

insert into item (id, name, description, price, created_at, modified_at)
values (3, 'product C', 'product C', 300, current_date, current_date);

insert into item (id, name, description, price, created_at, modified_at)
values (4, 'product D', 'product D', 400, current_date, current_date);

insert into item (id, name, description, price, created_at, modified_at)
values (5, 'product E', 'product E', 500, current_date, current_date);

Delete
from sale;
insert into sale (item_id, sale_date, amount, created_at, modified_at)
values (1, '2024-04-01', 100, current_date, current_date);

insert into sale (item_id, sale_date, amount, created_at, modified_at)
values (1, '2024-04-01', 200, current_date, current_date);

insert into sale (item_id, sale_date, amount, created_at, modified_at)
values (2, '2024-04-02', 100, current_date, current_date);

insert into sale (item_id, sale_date, amount, created_at, modified_at)
values (3, '2024-04-02', 150, current_date, current_date);

insert into sale (item_id, sale_date, amount, created_at, modified_at)
values (4, '2024-04-02', 200, current_date, current_date);


insert into sale (item_id, sale_date, amount, created_at, modified_at)
values (1, '2024-04-03', 10, current_date, current_date);

insert into sale (item_id, sale_date, amount, created_at, modified_at)
values (3, '2024-04-03', 50, current_date, current_date);


insert into sale (item_id, sale_date, amount, created_at, modified_at)
values (4, '2024-04-05', 150, current_date, current_date);


insert into sale (item_id, sale_date, amount, created_at, modified_at)
values (4, '2024-04-05', 30, current_date, current_date);
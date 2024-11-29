-- Добавление пользователей
INSERT INTO shop_user (name, email) VALUES ('user 1', 'user1@mail.com');
INSERT INTO shop_user (name, email) VALUES ('user 2', 'user2@mail.com');

-- Добавление заказов для пользователей
INSERT INTO shop_order (user_id, status) VALUES (1, 'COMPLETED');
INSERT INTO shop_order (user_id, status) VALUES (1, 'PENDING');
INSERT INTO shop_order (user_id, status) VALUES (2, 'PENDING');


-- Добавление элементов в заказы
INSERT INTO order_item (order_id, product_name, price) VALUES (1, 'Laptop', 500.00);
INSERT INTO order_item (order_id, product_name, price) VALUES (1, 'Smartphone', 150.00);
INSERT INTO order_item (order_id, product_name, price) VALUES (2, 'Smartphone', 150.00);
INSERT INTO order_item (order_id, product_name, price) VALUES (3, 'Tablet', 300.00);

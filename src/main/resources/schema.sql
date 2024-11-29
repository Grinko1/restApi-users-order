CREATE TABLE IF NOT EXISTS shop_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE
);

CREATE TABLE IF NOT EXISTS shop_order (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
--    total_amount DOUBLE,
    status VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES shop_user(id)
);

CREATE TABLE IF NOT EXISTS order_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT,
    product_name VARCHAR(255),
    price DOUBLE,
    FOREIGN KEY (order_id) REFERENCES shop_order(id)
);

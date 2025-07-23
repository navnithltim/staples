CREATE TABLE IF NOT EXISTS orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id VARCHAR(255),
    product VARCHAR(255),
    quantity INT,
    status VARCHAR(50)
);



CREATE TABLE orders (
	id SERIAL PRIMARY KEY,
	order_id VARCHAR(255),
	product VARCHAR(100),
	quantity INTEGER,
	status VARCHAR(50)
);
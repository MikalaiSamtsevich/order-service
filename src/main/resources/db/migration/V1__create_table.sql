CREATE TABLE orders
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    customer_id  BIGINT,
    order_date   TIMESTAMP with time zone,
    total_amount DECIMAL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);
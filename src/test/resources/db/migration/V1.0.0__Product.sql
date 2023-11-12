CREATE TABLE IF NOT EXISTS product
(
    id SERIAL PRIMARY KEY,
    create_stamp timestamp(6),
    description character varying(255),
    gross_price numeric(38,2),
    product_name character varying(255),
    net_price numeric(38,2),
    supplier_id integer
);
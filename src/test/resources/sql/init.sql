create schema product;
CREATE TABLE IF NOT EXISTS product.product
(
    id SERIAL PRIMARY KEY,
    create_stamp timestamp(6),
    description character varying(255) COLLATE pg_catalog."default",
    gross_price numeric(38,2),
    name varchar COLLATE pg_catalog."default",
    net_price numeric(38,2),
    supplier_id integer
    );
INSERT INTO product.product(description, gross_price, name, net_price, supplier_id)
VALUES
    ('Organic Quinoa Salad with Lemon Vinaigrette', 12.99, 'Quinoa Salad', 10.99, 1),
    ('Artisanal Truffle Infused Olive Oil', 24.99, 'Truffle Olive Oil', 19.99, 2),
    ('Homestyle Tomato Basil Pasta Sauce', 8.99, 'Tomato Basil Sauce', 6.99, 1),
    ('Premium Aged Balsamic Vinegar of Modena', 18.99, 'Aged Balsamic Vinegar', 15.99, 3),
    ('Handcrafted Dark Chocolate Sea Salt Caramels', 14.99, 'Chocolate Caramels', 11.99, 2),
    ('Organic Matcha Green Tea Powder', 29.99, 'Matcha Tea', 24.99, 1),
    ('Gourmet Wild-caught Alaskan Salmon Fillets', 39.99, 'Alaskan Salmon', 34.99, 3),
    ('Mediterranean Herb Infused Sea Salt', 9.99, 'Herb Sea Salt', 7.99, 2),
    ('Freshly Roasted Ethiopian Yirgacheffe Coffee Beans', 16.99, 'Yirgacheffe Coffee', 13.99, 1),
    ('Hand-picked Italian San Marzano Tomato Cans', 5.99, 'San Marzano Tomatoes', 4.99, 3),
    ('Spicy Chicken Wings Bucket', 18.99, 'Chicken Wings Bucket', 15.99, 3)
;
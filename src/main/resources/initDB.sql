DROP TABLE review;
DROP TABLE loves;
DROP TABLE order_detail;
DROP TABLE orders;
DROP TABLE category_product;
DROP TABLE order_state;
DROP TABLE product_lng;
DROP TABLE item;
DROP TABLE product;
DROP TABLE brand;
DROP TABLE category;
DROP TABLE currency;
DROP TABLE users;
DROP TABLE locale;
DROP TABLE role;

CREATE TABLE role(
role_id NUMERIC NOT NULL,
role_name VARCHAR2(255) NOT NULL,
CONSTRAINT pk_role PRIMARY KEY(role_id)
);

CREATE TABLE locale(
locale_id NUMERIC NOT NULL,
name VARCHAR2(15) NOT NULL,
CONSTRAINT pk_locale PRIMARY KEY(locale_id)
);

CREATE TABLE currency(
currency_id NUMERIC NOT NULL,
name VARCHAR2(31) NOT NULL,
description VARCHAR2(255),
CONSTRAINT pk_currency PRIMARY KEY(currency_id)
);

CREATE TABLE category(
category_id NUMERIC NOT NULL,
name VARCHAR2(255) NOT NULL,
description VARCHAR2(255),
CONSTRAINT pk_category PRIMARY KEY(category_id)
);

CREATE TABLE brand(
brand_id NUMERIC NOT NULL,
name VARCHAR2(255) NOT NULL,
description VARCHAR2(1023),
CONSTRAINT pk_brand PRIMARY KEY(brand_id)
);

CREATE TABLE users(
user_id NUMERIC NOT NULL,
name VARCHAR2(255) NOT NULL,
email VARCHAR2(255) NOT NULL UNIQUE,
password VARCHAR2(255) NOT NULL,
role_id NUMERIC NOT NULL,
address VARCHAR2(255),
phone VARCHAR2(31),
birthday DATE,
CONSTRAINT pk_user PRIMARY KEY(user_id),
CONSTRAINT fk_user_role FOREIGN KEY(role_id) REFERENCES role(role_id)
);

CREATE TABLE product(
product_id NUMERIC NOT NULL,
brand_id NUMERIC,
image_source VARCHAR2(255),
CONSTRAINT pk_product PRIMARY KEY(product_id),
CONSTRAINT fk_prod_brand FOREIGN KEY(brand_id) REFERENCES brand(brand_id)
);

CREATE TABLE item(
item_id NUMERIC NOT NULL,
product_id NUMERIC NOT NULL,
price NUMBER(10,2) NOT NULL,
item_type VARCHAR2(255),
item_size VARCHAR2(255),
currency_id NUMERIC NOT NULL,
quantity NUMERIC NOT NULL,
quant_ordered NUMERIC NOT NULL,
image_source VARCHAR2(255),
discount NUMBER(5,2),
available NUMERIC,
CONSTRAINT pk_item PRIMARY KEY(item_id),
CONSTRAINT fk_item_prod FOREIGN KEY(product_id) REFERENCES product(product_id),
CONSTRAINT fk_item_curr FOREIGN KEY(currency_id) REFERENCES currency(currency_id)
);

CREATE TABLE product_lng(
product_id NUMERIC NOT NULL,
locale_id NUMERIC NOT NULL,
name VARCHAR2(255) NOT NULL,
description VARCHAR2(1023),
CONSTRAINT pk_productlng PRIMARY KEY(product_id, locale_id),
CONSTRAINT fk_prodlng_prod FOREIGN KEY(product_id) REFERENCES product(product_id),
CONSTRAINT fk_prod_locale FOREIGN KEY(locale_id) REFERENCES locale(locale_id)
);

CREATE TABLE order_state(
order_state_id NUMERIC NOT NULL,
name VARCHAR2(255),
CONSTRAINT pk_orderst PRIMARY KEY(order_state_id)
);

CREATE TABLE orders(
order_id NUMERIC NOT NULL,
user_id NUMERIC NOT NULL,
order_date DATE NOT NULL,
total_price NUMBER(5,2) NOT NULL,
delivery_date DATE,
delivery_info VARCHAR2(255),
order_state_id NUMERIC NOT NULL,
CONSTRAINT pk_orders PRIMARY KEY(order_id),
CONSTRAINT fk_orders_user FOREIGN KEY(user_id) REFERENCES users(user_id),
CONSTRAINT fk_ordersdet_orderst FOREIGN KEY(order_state_id) REFERENCES order_state(order_state_id)
);

CREATE TABLE order_detail(
order_id NUMERIC NOT NULL,
item_id NUMERIC NOT NULL,
quantity NUMERIC,
price NUMBER(5,2) NOT NULL,
discount NUMBER(5,2),
CONSTRAINT pk_ordersdet PRIMARY KEY(order_id, item_id),
CONSTRAINT fk_ordersdet_order FOREIGN KEY(order_id) REFERENCES orders(order_id),
CONSTRAINT fk_ordersdet_item FOREIGN KEY(item_id) REFERENCES item(item_id)
);

CREATE TABLE category_product(
product_id NUMERIC,
category_id NUMERIC,
CONSTRAINT pk_cp PRIMARY KEY(product_id, category_id),
CONSTRAINT fk_pc_product FOREIGN KEY(product_id) REFERENCES product(product_id),
CONSTRAINT fk_pc_categ FOREIGN KEY(category_id) REFERENCES category(category_id)
);

CREATE TABLE loves(
user_id NUMERIC NOT NULL,
product_id NUMERIC NOT NULL,
CONSTRAINT pk_loves PRIMARY KEY(user_id, product_id),
CONSTRAINT fk_loves_user FOREIGN KEY(user_id) REFERENCES users(user_id),
CONSTRAINT fk_loves_product FOREIGN KEY(product_id) REFERENCES product(product_id)
);

CREATE TABLE review(
review_id NUMERIC NOT NULL,
product_id NUMERIC NOT NULL,
user_id NUMERIC NOT NULL,
review_date DATE,
rating NUMERIC,
review_text VARCHAR2(1023),
CONSTRAINT pk_rev PRIMARY KEY(review_id),
CONSTRAINT fk_rev_user FOREIGN KEY(user_id) REFERENCES users(user_id),
CONSTRAINT fk_rev_product FOREIGN KEY(product_id) REFERENCES product(product_id)
);
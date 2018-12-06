DROP TABLE comments;
DROP TABLE viewed_product;
DROP TABLE cart_detail;
DROP TABLE cart;
DROP TABLE order_detail;
DROP TABLE orders;
DROP TABLE order_state;
DROP TABLE product_lng;
DROP TABLE product;
DROP TABLE product_group;
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

CREATE TABLE product_group(
group_id NUMERIC NOT NULL,
category_id NUMERIC NOT NULL,
brand_id NUMERIC,
image_source VARCHAR2(255),
CONSTRAINT pk_group PRIMARY KEY(group_id),
CONSTRAINT fk_prod_categ FOREIGN KEY(category_id) REFERENCES category(category_id),
CONSTRAINT fk_prod_brand FOREIGN KEY(brand_id) REFERENCES brand(brand_id)
);

CREATE TABLE product(
product_id NUMERIC NOT NULL,
group_id NUMERIC NOT NULL,
price NUMBER(10,2) NOT NULL,
currency_id NUMERIC NOT NULL,
quantity NUMERIC NOT NULL,
quant_ordered NUMERIC NOT NULL,
image_source VARCHAR2(255),
discount NUMBER(5,2),
CONSTRAINT pk_product PRIMARY KEY(product_id),
CONSTRAINT fk_prod_group FOREIGN KEY(group_id) REFERENCES product_group(group_id),
CONSTRAINT fk_prod_curr FOREIGN KEY(currency_id) REFERENCES currency(currency_id)
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
CONSTRAINT pk_orders PRIMARY KEY(order_id),
CONSTRAINT fk_orders_user FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE order_detail(
order_id NUMERIC NOT NULL,
product_id NUMERIC NOT NULL,
quantity NUMERIC,
price NUMBER(5,2) NOT NULL,
order_state_id NUMERIC NOT NULL,
discount NUMBER(5,2),
CONSTRAINT pk_ordersdet PRIMARY KEY(order_id, product_id),
CONSTRAINT fk_ordersdet_order FOREIGN KEY(order_id) REFERENCES orders(order_id),
CONSTRAINT fk_ordersdet_product FOREIGN KEY(product_id) REFERENCES product(product_id),
CONSTRAINT fk_ordersdet_orderst FOREIGN KEY(order_state_id) REFERENCES order_state(order_state_id)
);

CREATE TABLE cart(
cart_id NUMERIC NOT NULL,
user_id NUMERIC,
session_id NUMERIC,
total_price NUMBER(5,2) NOT NULL,
CONSTRAINT pk_cart PRIMARY KEY(cart_id),
CONSTRAINT fk_cart_user FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE cart_detail(
cart_id NUMERIC NOT NULL,
product_id NUMERIC NOT NULL,
quantity NUMERIC NOT NULL,
price NUMBER(5,2) NOT NULL,
discount NUMBER(5,2),
saved_later NUMERIC,
CONSTRAINT pk_cartdet PRIMARY KEY(cart_id, product_id),
CONSTRAINT fk_cartdet_cart FOREIGN KEY(cart_id) REFERENCES cart(cart_id),
CONSTRAINT fk_cartdet_product FOREIGN KEY(product_id) REFERENCES product(product_id)
);

CREATE TABLE viewed_product(
user_id NUMERIC NOT NULL,
product_id NUMERIC NOT NULL,
active_date DATE,
CONSTRAINT pk_vp PRIMARY KEY(user_id, product_id),
CONSTRAINT fk_vp_user FOREIGN KEY(user_id) REFERENCES users(user_id),
CONSTRAINT fk_vp_product FOREIGN KEY(product_id) REFERENCES product(product_id)
);

CREATE TABLE comments(
comment_id NUMERIC NOT NULL,
product_id NUMERIC NOT NULL,
user_id NUMERIC NOT NULL,
comment_date DATE,
CONSTRAINT pk_com PRIMARY KEY(comment_id),
CONSTRAINT fk_com_user FOREIGN KEY(user_id) REFERENCES users(user_id),
CONSTRAINT fk_com_product FOREIGN KEY(product_id) REFERENCES product(product_id)
);
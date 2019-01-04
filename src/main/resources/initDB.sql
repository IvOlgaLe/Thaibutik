CREATE TABLE role (
  id   NUMERIC GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1) NOT NULL,
  name VARCHAR2(255)                                                      NOT NULL,
  CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE currency (
  id          NUMERIC GENERATED ALWAYS AS IDENTITY (START WITH 11 INCREMENT BY 1)   NOT NULL,
  name        VARCHAR2(31)                                                          NOT NULL,
  description VARCHAR2(255),
  CONSTRAINT pk_currency PRIMARY KEY (id)
);

CREATE TABLE category (
  id          NUMERIC GENERATED ALWAYS AS IDENTITY (START WITH 101 INCREMENT BY 1)     NOT NULL,
  name        VARCHAR2(255)                                                            NOT NULL,
  description VARCHAR2(255),
  CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE groups (
  id          NUMERIC GENERATED ALWAYS AS IDENTITY (START WITH 51 INCREMENT BY 1)     NOT NULL,
  name        VARCHAR2(255)                                                           NOT NULL,
  description VARCHAR2(255),
  CONSTRAINT pk_group PRIMARY KEY (id)
);

CREATE TABLE group_category (
  group_id    NUMERIC NOT NULL,
  category_id NUMERIC NOT NULL,
  CONSTRAINT pk_gc PRIMARY KEY (group_id, category_id),
  CONSTRAINT fk_gc_group FOREIGN KEY (group_id) REFERENCES groups (id),
  CONSTRAINT fk_gc_category FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE brand (
  id          NUMERIC GENERATED ALWAYS AS IDENTITY (START WITH 201 INCREMENT BY 1)   NOT NULL,
  name        VARCHAR2(255)                                                          NOT NULL,
  description VARCHAR2(1023),
  CONSTRAINT pk_brand PRIMARY KEY (id)
);

CREATE TABLE users (
  id       NUMERIC GENERATED ALWAYS AS IDENTITY (START WITH 1001 INCREMENT BY 1)   NOT NULL,
  name     VARCHAR2(255)                                                           NOT NULL,
  email    VARCHAR2(255)                                                           NOT NULL UNIQUE,
  password VARCHAR2(255)                                                           NOT NULL,
  role_id  NUMERIC                                                                 NOT NULL,
  address  VARCHAR2(255),
  phone    VARCHAR2(31),
  birthday DATE,
  CONSTRAINT pk_user PRIMARY KEY (id),
  CONSTRAINT fk_user_role FOREIGN KEY (role_id) REFERENCES role (id)
);

CREATE TABLE product (
  id           NUMERIC GENERATED ALWAYS AS IDENTITY (START WITH 100001 INCREMENT BY 1)    NOT NULL,
  name         VARCHAR2(255)                                                              NOT NULL,
  brand_id     NUMERIC,
  image_source VARCHAR2(255),
  description  VARCHAR2(1023),
  CONSTRAINT pk_product PRIMARY KEY (id),
  CONSTRAINT fk_prod_brand FOREIGN KEY (brand_id) REFERENCES brand (id)
);

CREATE TABLE item (
  id            NUMERIC GENERATED ALWAYS AS IDENTITY (START WITH 1000001 INCREMENT BY 1)     NOT NULL,
  product_id    NUMERIC                                                                      NOT NULL,
  price         NUMBER(10, 2)                                                                NOT NULL,
  item_type     VARCHAR2(255),
  item_size     VARCHAR2(255),
  currency_id   NUMERIC                                                                      NOT NULL,
  quantity      NUMERIC                                                                      NOT NULL,
  quant_ordered NUMERIC                                                                      NOT NULL,
  image_source  VARCHAR2(255),
  discount      NUMBER(5, 2),
  available     NUMERIC,
  CONSTRAINT pk_item PRIMARY KEY (id),
  CONSTRAINT fk_item_prod FOREIGN KEY (product_id) REFERENCES product (id),
  CONSTRAINT fk_item_curr FOREIGN KEY (currency_id) REFERENCES currency (id)
);

CREATE TABLE order_state (
  id   NUMERIC GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1) NOT NULL,
  name VARCHAR2(255),
  CONSTRAINT pk_orderst PRIMARY KEY (id)
);

CREATE TABLE orders (
  id               NUMERIC GENERATED ALWAYS AS IDENTITY (START WITH 10001 INCREMENT BY 1) NOT NULL,
  user_id          NUMERIC                                                                NOT NULL,
  order_date       DATE                                                                   NOT NULL,
  total_price      NUMBER(10, 2)                                                          NOT NULL,
  total_quantity   NUMERIC                                                                NOT NULL,
  currency_id      NUMERIC                                                                NOT NULL,
  delivery_date    DATE,
  delivery_address VARCHAR2(255),
  delivery_info    VARCHAR2(255),
  order_state_id   NUMERIC                                                                NOT NULL,
  CONSTRAINT pk_orders PRIMARY KEY (id),
  CONSTRAINT fk_orders_user FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT fk_orders_curr FOREIGN KEY (currency_id) REFERENCES currency (id),
  CONSTRAINT fk_ordersdet_orderst FOREIGN KEY (order_state_id) REFERENCES order_state (id)
);

CREATE TABLE order_detail (
  order_id    NUMERIC       NOT NULL,
  item_id     NUMERIC       NOT NULL,
  quantity    NUMERIC       NOT NULL,
  price       NUMBER(10, 2) NOT NULL,
  currency_id NUMERIC       NOT NULL,
  CONSTRAINT pk_ordersdet PRIMARY KEY (order_id, item_id),
  CONSTRAINT fk_ordersdet_order FOREIGN KEY (order_id) REFERENCES orders (id),
  CONSTRAINT fk_ordersdet_item FOREIGN KEY (item_id) REFERENCES item (id),
  CONSTRAINT fk_ordersdet_curr FOREIGN KEY (currency_id) REFERENCES currency (id)
);

CREATE TABLE cart (
  id             NUMERIC GENERATED ALWAYS AS IDENTITY (START WITH 10001 INCREMENT BY 1)    NOT NULL,
  user_id        NUMERIC,
  total_price    NUMBER(10, 2)                                                             NOT NULL,
  total_quantity NUMERIC                                                                   NOT NULL,
  currency_id    NUMERIC                                                                   NOT NULL,
  cart_date      DATE                                                                      NOT NULL,
  CONSTRAINT pk_cart PRIMARY KEY (id),
  CONSTRAINT fk_cart_curr FOREIGN KEY (currency_id) REFERENCES currency (id)
);

CREATE TABLE cart_detail (
  cart_id  NUMERIC NOT NULL,
  item_id  NUMERIC NOT NULL,
  quantity NUMERIC NOT NULL,
  CONSTRAINT pk_cartdet PRIMARY KEY (cart_id, item_id),
  CONSTRAINT fk_cartdet_cart FOREIGN KEY (cart_id) REFERENCES cart (id),
  CONSTRAINT fk_cartdet_item FOREIGN KEY (item_id) REFERENCES item (id)
);

CREATE TABLE category_product (
  product_id  NUMERIC,
  category_id NUMERIC,
  CONSTRAINT pk_cp PRIMARY KEY (product_id, category_id),
  CONSTRAINT fk_pc_product FOREIGN KEY (product_id) REFERENCES product (id),
  CONSTRAINT fk_pc_categ FOREIGN KEY (category_id) REFERENCES category (id)
);

/*--------CONSTANTS-------*/
INSERT INTO role (name)
VALUES ('ROLE_ADMIN');
INSERT INTO role (name)
VALUES ('ROLE_MODERATOR');
INSERT INTO role (name)
VALUES ('ROLE_USER');

INSERT INTO order_state (name)
VALUES ('PROCESSING');
INSERT INTO order_state (name)
VALUES ('DELIVERED');
INSERT INTO order_state (name)
VALUES ('CANCELLED');

INSERT INTO category (name, description)
VALUES ('Bestseller', 'Bestseller');

INSERT INTO brand (name, description)
VALUES ('NO_BRAND', 'NO_BRAND');

COMMIT;
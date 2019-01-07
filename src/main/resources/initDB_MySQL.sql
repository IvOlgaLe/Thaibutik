CREATE TABLE role (
  id   INT AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  CONSTRAINT pk_role PRIMARY KEY (id)
);
ALTER TABLE role AUTO_INCREMENT=1;

CREATE TABLE currency (
  id          INT AUTO_INCREMENT,
  name        VARCHAR(31)   NOT NULL,
  description VARCHAR(255),
  CONSTRAINT pk_currency PRIMARY KEY (id)
);
ALTER TABLE currency AUTO_INCREMENT=11;

CREATE TABLE category (
  id          INT AUTO_INCREMENT,
  name        VARCHAR(255)                                                            NOT NULL,
  description VARCHAR(255),
  CONSTRAINT pk_category PRIMARY KEY (id)
);
ALTER TABLE category AUTO_INCREMENT=101;

CREATE TABLE groups (
  id          INT AUTO_INCREMENT,
  name        VARCHAR(255)                                                           NOT NULL,
  description VARCHAR(255),
  CONSTRAINT pk_group PRIMARY KEY (id)
);
ALTER TABLE groups AUTO_INCREMENT=51;

CREATE TABLE group_category (
  group_id    INT NOT NULL,
  category_id INT NOT NULL,
  CONSTRAINT pk_gc PRIMARY KEY (group_id, category_id),
  CONSTRAINT fk_gc_group FOREIGN KEY (group_id) REFERENCES groups (id),
  CONSTRAINT fk_gc_category FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE brand (
  id          INT AUTO_INCREMENT,
  name        VARCHAR(255)                                                          NOT NULL,
  description VARCHAR(1023),
  CONSTRAINT pk_brand PRIMARY KEY (id)
);
ALTER TABLE brand AUTO_INCREMENT=201;

CREATE TABLE users (
  id       INT AUTO_INCREMENT,
  name     VARCHAR(255)                                                           NOT NULL,
  email    VARCHAR(255)                                                           NOT NULL UNIQUE,
  password VARCHAR(255)                                                           NOT NULL,
  role_id  INT                                                                 NOT NULL,
  address  VARCHAR(255),
  phone    VARCHAR(31),
  birthday DATE,
  CONSTRAINT pk_user PRIMARY KEY (id),
  CONSTRAINT fk_user_role FOREIGN KEY (role_id) REFERENCES role (id)
);
ALTER TABLE users AUTO_INCREMENT=1001;

CREATE TABLE product (
  id           INT AUTO_INCREMENT,
  name         VARCHAR(255)                                                              NOT NULL,
  brand_id     INT,
  image_source VARCHAR(255),
  description  VARCHAR(1023),
  CONSTRAINT pk_product PRIMARY KEY (id),
  CONSTRAINT fk_prod_brand FOREIGN KEY (brand_id) REFERENCES brand (id)
);
ALTER TABLE product AUTO_INCREMENT=100001;

CREATE TABLE item (
  id            INT AUTO_INCREMENT,
  product_id    INT                                                                      NOT NULL,
  price         decimal(10, 2)                                                                NOT NULL,
  item_type     VARCHAR(255),
  item_size     VARCHAR(255),
  currency_id   INT                                                                      NOT NULL,
  quantity      INT                                                                      NOT NULL,
  quant_ordered INT                                                                      NOT NULL,
  image_source  VARCHAR(255),
  discount      decimal(5, 2),
  available     INT,
  CONSTRAINT pk_item PRIMARY KEY (id),
  CONSTRAINT fk_item_prod FOREIGN KEY (product_id) REFERENCES product (id),
  CONSTRAINT fk_item_curr FOREIGN KEY (currency_id) REFERENCES currency (id)
);
ALTER TABLE item AUTO_INCREMENT=1000001;

CREATE TABLE order_state (
  id   INT AUTO_INCREMENT,
  name VARCHAR(255),
  CONSTRAINT pk_orderst PRIMARY KEY (id)
);
ALTER TABLE order_state AUTO_INCREMENT=1;

CREATE TABLE orders (
  id               INT AUTO_INCREMENT,
  user_id          INT                                                                NOT NULL,
  order_date       DATE                                                                   NOT NULL,
  total_price      decimal(10, 2)                                                          NOT NULL,
  total_quantity   INT                                                                NOT NULL,
  currency_id      INT                                                                NOT NULL,
  delivery_date    DATE,
  delivery_address VARCHAR(255),
  delivery_info    VARCHAR(255),
  order_state_id   INT                                                                NOT NULL,
  CONSTRAINT pk_orders PRIMARY KEY (id),
  CONSTRAINT fk_orders_user FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT fk_orders_curr FOREIGN KEY (currency_id) REFERENCES currency (id),
  CONSTRAINT fk_ordersdet_orderst FOREIGN KEY (order_state_id) REFERENCES order_state (id)
);
ALTER TABLE orders AUTO_INCREMENT=10001;

CREATE TABLE order_detail (
  order_id    INT       NOT NULL,
  item_id     INT       NOT NULL,
  quantity    INT       NOT NULL,
  price       decimal(10, 2) NOT NULL,
  currency_id INT       NOT NULL,
  CONSTRAINT pk_ordersdet PRIMARY KEY (order_id, item_id),
  CONSTRAINT fk_ordersdet_order FOREIGN KEY (order_id) REFERENCES orders (id),
  CONSTRAINT fk_ordersdet_item FOREIGN KEY (item_id) REFERENCES item (id),
  CONSTRAINT fk_ordersdet_curr FOREIGN KEY (currency_id) REFERENCES currency (id)
);

CREATE TABLE cart (
  id             INT AUTO_INCREMENT,
  user_id        INT,
  total_price    decimal(10, 2)                                                             NOT NULL,
  total_quantity INT                                                                   NOT NULL,
  currency_id    INT                                                                   NOT NULL,
  cart_date      DATE                                                                      NOT NULL,
  CONSTRAINT pk_cart PRIMARY KEY (id),
  CONSTRAINT fk_cart_curr FOREIGN KEY (currency_id) REFERENCES currency (id)
);
ALTER TABLE cart AUTO_INCREMENT=10001;

CREATE TABLE cart_detail (
  cart_id  INT NOT NULL,
  item_id  INT NOT NULL,
  quantity INT NOT NULL,
  CONSTRAINT pk_cartdet PRIMARY KEY (cart_id, item_id),
  CONSTRAINT fk_cartdet_cart FOREIGN KEY (cart_id) REFERENCES cart (id),
  CONSTRAINT fk_cartdet_item FOREIGN KEY (item_id) REFERENCES item (id)
);

CREATE TABLE category_product (
  product_id  INT,
  category_id INT,
  CONSTRAINT pk_cp PRIMARY KEY (product_id, category_id),
  CONSTRAINT fk_pc_product FOREIGN KEY (product_id) REFERENCES product (id),
  CONSTRAINT fk_pc_categ FOREIGN KEY (category_id) REFERENCES category (id)
);

/*--------CONSTANTS-------*/
INSERT INTO currency(name, description)
VALUES ('USD', 'USD');
INSERT INTO currency(name, description)
VALUES ('RUB', 'RUB');

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
VALUES ('Bestsellers', 'Bestsellers');

INSERT INTO brand (name, description)
VALUES ('No Brand', 'No Brand');

COMMIT;
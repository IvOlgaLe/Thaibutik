INSERT INTO role(role_name) VALUES('ROLE_ADMIN');
INSERT INTO role(role_name) VALUES('ROLE_MODERATOR');
INSERT INTO role(role_name) VALUES('ROLE_USER');

INSERT INTO users(name, email, password, role_id, address, phone, birthday) VALUES('Cristina White', 'cristina@gmail.com', '111', 1, NULL, NULL, NULL);
INSERT INTO users(name, email, password, role_id, address, phone, birthday) VALUES('Stuart Little', 'stuart@gmail.com', '222', 2, NULL, NULL, NULL);
INSERT INTO users(name, email, password, role_id, address, phone, birthday) VALUES('Ben Black', 'ben@gmail.com', '333', 3, NULL, NULL, NULL);
INSERT INTO users(name, email, password, role_id, address, phone, birthday) VALUES('Emily Orange', 'emily@gmail.com', '444', 3, '145 Ocean St., Brooklyn, NY, 11256', '277-159-2565', to_date('5-Mar-95', 'DD-MON-RR'));

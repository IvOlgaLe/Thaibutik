INSERT INTO role VALUES(1, ROLE_ADMIN);
INSERT INTO role VALUES(2, ROLE_MODERATOR);
INSERT INTO role VALUES(3, ROLE_USER);

INSERT INTO users VALUES(101, 'Cristina White', 'cristina@gmail.com', '111', 1, NULL, NULL, NULL);
INSERT INTO users VALUES(102, 'Stuart Little', 'stuart@gmail.com', '222', 2, NULL, NULL, NULL);
INSERT INTO users VALUES(103, 'Ben Black', 'ben@gmail.com', '333', 3, NULL, NULL, NULL);
INSERT INTO users VALUES(104, 'Emily Orange', 'emily@gmail.com', '444', 3, '145 Ocean St., Brooklyn, NY, 11256', '277-159-2565', to_date('5-Mar-95', 'DD-MON-RR'));
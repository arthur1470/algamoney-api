create table category (
	id SERIAL primary key,
	name varchar(30) not null
);

INSERT INTO category (name) values ('Leisure');
INSERT INTO category (name) values ('Food');
INSERT INTO category (name) values ('Supermarket');
INSERT INTO category (name) values ('Drugstore');
INSERT INTO category (name) values ('Others');
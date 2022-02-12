create table person (
	id SERIAL,
	name varchar(70) not null,
	is_active boolean not null,
	street varchar(50) not null,
	number integer not null,
	complement varchar(50),
	district varchar(50) not null,
	zip_code varchar(50) not null,
	city varchar(50) not null,
	state varchar(50) not null
);
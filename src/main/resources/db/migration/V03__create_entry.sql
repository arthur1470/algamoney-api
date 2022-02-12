create table entry (
	id SERIAL,
	description varchar(50) not null,
	expiration_date timestamp not null,
	payment_day timestamp not null,
	value decimal not null,
	observation_note varchar(300),
	person_id bigint not null,
	category_id bigint not null,
	entry_type varchar(50) not null
);
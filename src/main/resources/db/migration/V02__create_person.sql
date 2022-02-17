create table person (
	id SERIAL primary key,
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

INSERT INTO person (name, street, number, complement, district, zip_code, city, state, is_active) values ('João Silva', 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO person (name, street, number, complement, district, zip_code, city, state, is_active) values ('Maria Rita', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-12', 'Ribeirão Preto', 'SP', true);
INSERT INTO person (name, street, number, complement, district, zip_code, city, state, is_active) values ('Pedro Santos', 'Rua da Bateria', '23', null, 'Morumbi', '54.212-12', 'Goiânia', 'GO', true);
INSERT INTO person (name, street, number, complement, district, zip_code, city, state, is_active) values ('Ricardo Pereira', 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-12', 'Salvador', 'BA', true);
INSERT INTO person (name, street, number, complement, district, zip_code, city, state, is_active) values ('Josué Mariano', 'Av Rio Branco', '321', null, 'Jardins', '56.400-12', 'Natal', 'RN', true);
INSERT INTO person (name, street, number, complement, district, zip_code, city, state, is_active) values ('Pedro Barbosa', 'Av Brasil', '100', null, 'Tubalina', '77.400-12', 'Porto Alegre', 'RS', true);
INSERT INTO person (name, street, number, complement, district, zip_code, city, state, is_active) values ('Henrique Medeiros', 'Rua do Sapo', '1120', 'Apto 201', 'Centro', '12.400-12', 'Rio de Janeiro', 'RJ', true);
INSERT INTO person (name, street, number, complement, district, zip_code, city, state, is_active) values ('Carlos Santana', 'Rua da Manga', '433', null, 'Centro', '31.400-12', 'Belo Horizonte', 'MG', true);
INSERT INTO person (name, street, number, complement, district, zip_code, city, state, is_active) values ('Leonardo Oliveira', 'Rua do Músico', '566', null, 'Segismundo Pereira', '38.400-00', 'Uberlândia', 'MG', true);
INSERT INTO person (name, street, number, complement, district, zip_code, city, state, is_active) values ('Isabela Martins', 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-12', 'Manaus', 'AM', true);
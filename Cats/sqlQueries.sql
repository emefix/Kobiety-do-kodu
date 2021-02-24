CREATE DATABASE catsapp;

CREATE TABLE cats (
	id					INT			PRIMARY KEY		AUTO_INCREMENT,
    name 				VARCHAR(255),
    date_of_birth		DATE,
    weight				FLOAT,
    name_of_catKeeper	VARCHAR(255)
);

SELECT * FROM catsapp.cats;

INSERT INTO catsapp.cats (name, date_of_birth, weight, name_of_catKeeper) 
VALUES ('Bob', '2021-01-02', 2.7, 'Liza');

DELETE FROM catsapp.cats WHERE id = 13;

SELECT * FROM catsapp.cats WHERE id = 1;

SELECT * FROM catsapp.cats WHERE name_of_catKeeper LIKE 'Amelka';
SELECT * FROM catsapp.cats WHERE name_of_catKeeper LIKE 'Mati';
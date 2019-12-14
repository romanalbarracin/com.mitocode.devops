CREATE DATABASE IF NOT EXISTS devopsbd CHARACTER SET latin1 COLLATE latin1_swedish_ci;

USE devopsbd;

SET foreign_key_checks = 0;

DROP TABLE IF EXISTS personas;

SET foreign_key_checks = 1;

CREATE TABLE personas(
	id INT(5) NOT NULL AUTO_INCREMENT,
	documento VARCHAR(20) NULL,
	nombres VARCHAR(50) NULL,
	apellidos VARCHAR(50) NULL,
	sexo CHAR(1) NULL,
	email VARCHAR(50) NULL,
	direccion VARCHAR(50) NULL,
	telefono VARCHAR(20) NULL,
	PRIMARY KEY (`ID`)
) ENGINE=INNODB;
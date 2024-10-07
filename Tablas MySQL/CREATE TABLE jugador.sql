use sgtb;

CREATE TABLE `sgtb`.`jugador` (
  `jugadorID` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  `email` VARCHAR(45) NULL,
  `puntaje` INT NULL,
  PRIMARY KEY (`jugadorID`));

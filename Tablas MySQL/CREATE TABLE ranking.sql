use sgtb;

CREATE TABLE `sgtb`.`ranking` (
  `rankingID` INT NOT NULL AUTO_INCREMENT,
  `jugador` INT NOT NULL,
  `puntos` INT NOT NULL,
  PRIMARY KEY (`rankingID`),
  INDEX `jugador_idx` (`jugador` ASC) VISIBLE,
  CONSTRAINT `jugador`
    FOREIGN KEY (`jugador`)
    REFERENCES `sgtb`.`jugador` (`jugadorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
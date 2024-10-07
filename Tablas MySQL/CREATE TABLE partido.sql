use sgtb;

CREATE TABLE `sgtb`.`partido` (
  `partidoID` INT NOT NULL AUTO_INCREMENT,
  `jugador1` INT NOT NULL,
  `jugador2` INT NOT NULL,
  `fecha` DATETIME NOT NULL,
  `resultado` VARCHAR(45) NOT NULL,
  `administrador` INT NOT NULL,
  `torneo` INT NOT NULL, 
  PRIMARY KEY (`partidoID`),
  INDEX `jugador1_idx` (`jugador1` ASC) VISIBLE,
  INDEX `jugador2_idx` (`jugador2` ASC) VISIBLE,
  INDEX `administrador_idx` (`administrador` ASC) VISIBLE,
  INDEX `torneo_idx` (`torneo` ASC) VISIBLE,
  CONSTRAINT `jugador1`
    FOREIGN KEY (`jugador1`)
    REFERENCES `sgtb`.`jugador` (`jugadorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `jugador2`
    FOREIGN KEY (`jugador2`)
    REFERENCES `sgtb`.`jugador` (`jugadorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `administrador`
  FOREIGN KEY (`administrador`)
  REFERENCES `sgtb`.`administrador` (`administradorID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
CONSTRAINT `torneo`
  FOREIGN KEY (`torneo`)
  REFERENCES `sgtb`.`torneo` (`torneoID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION)

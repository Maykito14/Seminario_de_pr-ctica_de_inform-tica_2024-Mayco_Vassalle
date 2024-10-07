use sgtb;

CREATE TABLE `sgtb`.`torneo` (
  `torneoID` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `estado` TINYINT NOT NULL,
  PRIMARY KEY (`torneoID`));
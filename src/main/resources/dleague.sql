-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dleague
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dleague` ;

-- -----------------------------------------------------
-- Schema dleague
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dleague` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema sakila
-- -----------------------------------------------------
USE `dleague` ;

-- -----------------------------------------------------
-- Table `dleague`.`Paises`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dleague`.`Paises` ;

CREATE TABLE IF NOT EXISTS `dleague`.`Paises` (
  `nombrePais` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`nombrePais`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dleague`.`Atletas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dleague`.`Atletas` ;

CREATE TABLE IF NOT EXISTS `dleague`.`Atletas` (
  `idAtleta` BIGINT NULL,
  `nombre` VARCHAR(75) NULL,
  `nombrePais` VARCHAR(75) NOT NULL,
  `sexo` ENUM('HOMBRE','MUJER') NULL,
  `raza` ENUM('CAUCASICA','NEGRA','ASIATICA','LATINA') NULL,
  PRIMARY KEY (`idAtleta`, `nombrePais`),
  CONSTRAINT `fk_Atletas_Paises1`
    FOREIGN KEY (`nombrePais`)
    REFERENCES `dleague`.`Paises` (`nombrePais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Atletas_Paises1_idx` ON `dleague`.`Atletas` (`nombrePais` ASC);


-- -----------------------------------------------------
-- Table `dleague`.`Pruebas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dleague`.`Pruebas` ;

CREATE TABLE IF NOT EXISTS `dleague`.`Pruebas` (
  `idPrueba` INT NULL,
  `nombrePrueba` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPrueba`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dleague`.`Ciudades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dleague`.`Ciudades` ;

CREATE TABLE IF NOT EXISTS `dleague`.`Ciudades` (
  `idCiudad` INT NOT NULL,
  `nombreCiudad` VARCHAR(45) NULL,
  `nombrePais` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`idCiudad`, `nombrePais`),
  CONSTRAINT `fk_Ciudades_Paises1`
    FOREIGN KEY (`nombrePais`)
    REFERENCES `dleague`.`Paises` (`nombrePais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Ciudades_Paises1_idx` ON `dleague`.`Ciudades` (`nombrePais` ASC);


-- -----------------------------------------------------
-- Table `dleague`.`Estadios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dleague`.`Estadios` ;

CREATE TABLE IF NOT EXISTS `dleague`.`Estadios` (
  `idEstadio` INT NOT NULL,
  `nombreEstadio` VARCHAR(75) NOT NULL,
  `aforo` DECIMAL(6,0) NOT NULL,
  `idCiudad` INT NOT NULL,
  PRIMARY KEY (`idEstadio`, `idCiudad`),
  CONSTRAINT `fk_Estadios_Ciudades1`
    FOREIGN KEY (`idCiudad`)
    REFERENCES `dleague`.`Ciudades` (`idCiudad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Estadios_Ciudades1_idx` ON `dleague`.`Estadios` (`idCiudad` ASC);


-- -----------------------------------------------------
-- Table `dleague`.`Ediciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dleague`.`Ediciones` ;

CREATE TABLE IF NOT EXISTS `dleague`.`Ediciones` (
  `anyo` DECIMAL(4,0) NULL,
  `categoria` ENUM('MASCULINA', 'FEMENINA') NULL,
  `edicion` INT NULL,
  PRIMARY KEY (`anyo`, `categoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dleague`.`Pruebas_Incluidas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dleague`.`Pruebas_Incluidas` ;

CREATE TABLE IF NOT EXISTS `dleague`.`Pruebas_Incluidas` (
  `anyo` DECIMAL(4,0) NULL,
  `categoria` ENUM('MASCULINA', 'FEMENINA') NULL,
  `idPrueba` INT NULL,
  `orden` INT NULL,
  PRIMARY KEY (`anyo`, `categoria`, `idPrueba`, `orden`),
  CONSTRAINT `fk_PruebasIncluidas_Ediciones1`
    FOREIGN KEY (`anyo` , `categoria`)
    REFERENCES `dleague`.`Ediciones` (`anyo` , `categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PruebasIncluidas_Pruebas1`
    FOREIGN KEY (`idPrueba`)
    REFERENCES `dleague`.`Pruebas` (`idPrueba`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_PruebasIncluidas_Pruebas1_idx` ON `dleague`.`Pruebas_Incluidas` (`idPrueba` ASC);


-- -----------------------------------------------------
-- Table `dleague`.`Atletas_Participantes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dleague`.`Atletas_Participantes` ;

CREATE TABLE IF NOT EXISTS `dleague`.`Atletas_Participantes` (
  `anyo` DECIMAL(4,0) NOT NULL,
  `categoria` ENUM('MASCULINA', 'FEMENINA') NOT NULL,
  `idPrueba` INT NOT NULL,
  `idAtleta` BIGINT NOT NULL,
  `dorsal` INT(11) NOT NULL,
  `posicion` INT NULL,
  `puntos` INT NULL,
  PRIMARY KEY (`anyo`, `categoria`, `idPrueba`, `idAtleta`),
  CONSTRAINT `fk_Atletas_Participantes_PruebasIncluidas1`
    FOREIGN KEY (`anyo` , `categoria` , `idPrueba`)
    REFERENCES `dleague`.`Pruebas_Incluidas` (`anyo` , `categoria` , `idPrueba`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Atletas_Participantes_Atletas1`
    FOREIGN KEY (`idAtleta`)
    REFERENCES `dleague`.`Atletas` (`idAtleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Atletas_Participantes_Atletas1_idx` ON `dleague`.`Atletas_Participantes` (`idAtleta` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

DROP DATABASE dap;
CREATE DATABASE dap;
USE dap;
CREATE TABLE IF NOT EXISTS usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(60) NOT NULL,
  password VARCHAR(25)NOT NULL,
  PRIMARY KEY (id_usuario) )
ENGINE = InnoDB CHARACTER SET = latin1;
-- -----------------------------------------------------
-- Table `educativo`.`habitacion`
-- ---------------------------------------------usuario--------
CREATE TABLE habitacion
 (
  id_habitacion VARCHAR(15),
  id_tipoHabitacion VARCHAR(45),
  id_tipocama VARCHAR(45),
  precio VARCHAR(20),
  estatus_habitacion VARCHAR(1),
  PRIMARY KEY (id_habitacion)
) ENGINE = InnoDB DEFAULT CHARSET=latin1;
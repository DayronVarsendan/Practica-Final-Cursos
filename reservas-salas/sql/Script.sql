-- MySQL Script generated by MySQL Workbench
-- Thu Jun 26 14:43:03 2025
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema reservas_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema reservas_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `reservas_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `reservas_db` ;

-- -----------------------------------------------------
-- Table `reservas_db`.`empleados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reservas_db`.`empleados` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `departamento` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `reservas_db`.`salas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reservas_db`.`salas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `capacidad` INT NOT NULL,
  `recursos` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `reservas_db`.`reservas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reservas_db`.`reservas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `empleado_id` INT NULL DEFAULT NULL,
  `sala_id` INT NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  `hora_inicio` TIME NULL DEFAULT NULL,
  `hora_fin` TIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `empleado_id` (`empleado_id` ASC) VISIBLE,
  INDEX `sala_id` (`sala_id` ASC) VISIBLE,
  CONSTRAINT `reservas_ibfk_1`
    FOREIGN KEY (`empleado_id`)
    REFERENCES `reservas_db`.`empleados` (`id`),
  CONSTRAINT `reservas_ibfk_2`
    FOREIGN KEY (`sala_id`)
    REFERENCES `reservas_db`.`salas` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- Datos de prueba para salas

INSERT INTO salas (nombre, capacidad, recursos) VALUES
('Sala A', 10, 'Proyector, Pizarra'),
('Sala B', 20, 'Micrófono, Pizarra'),
('Sala C', 5, 'Proyector'),
('Sala D', 8, 'Pizarra'),
('Sala E', 12, 'Proyector, Televisión, Micrófono');

-- Datos de prueba para empleados

INSERT INTO empleados (nombre, email, departamento) VALUES
('Ana López', 'ana.lopez@empresa.com', 'Recursos Humanos'),
('Carlos Pérez', 'carlos.perez@empresa.com', 'IT'),
('Marta García', 'marta.garcia@empresa.com', 'Marketing'),
('Javier Ruiz', 'javier.ruiz@empresa.com', 'Ventas'),
('Lucía Fernández', 'lucia.fernandez@empresa.com', 'Finanzas');


-- Datos de prueba para reservas

INSERT INTO reservas (empleado_id, sala_id, fecha, hora_inicio, hora_fin) VALUES
(1, 1, '2025-06-27', '09:00:00', '10:00:00'),
(2, 2, '2025-06-27', '11:00:00', '12:30:00'),
(3, 1, '2025-06-28', '15:00:00', '16:00:00'),
(1, 2, '2025-06-28', '09:30:00', '10:30:00'),
(2, 1, '2025-06-29', '13:00:00', '14:00:00');


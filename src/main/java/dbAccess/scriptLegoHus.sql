-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema legohus
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `legohus` ;

-- -----------------------------------------------------
-- Schema legohus
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `legohus` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema legohus
-- -----------------------------------------------------

USE `legohus` ;

-- -----------------------------------------------------
-- Table `legohus`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `legohus`.`users` ;

CREATE TABLE IF NOT EXISTS `legohus`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `legohus`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `legohus`.`orders` ;

CREATE TABLE IF NOT EXISTS `legohus`.`orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `height` INT NOT NULL,
  `length` INT NOT NULL,
  `width` INT NOT NULL,
  `sent` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`order_id`),
  INDEX `id_idx` (`user_id` ASC),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `legohus`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


START TRANSACTION;

INSERT INTO `legohus`.`users` (`id`, `email`, `password`, `role`) VALUES (1, 'mette', 'mette', 'customer');
INSERT INTO `legohus`.`users` (`id`, `email`, `password`, `role`) VALUES (2, 'admin', 'admin', 'employee');

COMMIT;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fruit_punk
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fruit_punk
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fruit_punk` ;
USE `fruit_punk` ;

-- -----------------------------------------------------
-- Table `fruit_punk`.`Addresses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fruit_punk`.`Addresses` (
  `id_Address` INT NOT NULL,
  `street` VARCHAR(255) NULL,
  `number` VARCHAR(45) NULL,
  `post_code` VARCHAR(45) NOT NULL,
  `county` VARCHAR(45) NULL,
  `province` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `geolocation` GEOMETRYCOLLECTION NULL,
  PRIMARY KEY (`id_Address`));


-- -----------------------------------------------------
-- Table `fruit_punk`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fruit_punk`.`Users` (
  `id_User` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(20) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `last_name1` VARCHAR(100) NULL,
  `last_name2` VARCHAR(100) NULL,
  `date_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_Address` INT NOT NULL,
  PRIMARY KEY (`id_User`),
  INDEX `fk_Usuario_Direccion_idx` (`id_Address` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Direccion`
    FOREIGN KEY (`id_Address`)
    REFERENCES `fruit_punk`.`Addresses` (`id_Address`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `fruit_punk`.`Stores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fruit_punk`.`Stores` (
  `id_Store` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `last_name1` VARCHAR(100) NULL,
  `last_name2` VARCHAR(100) NULL,
  `date_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_Address` INT NOT NULL,
  PRIMARY KEY (`id_Store`),
  INDEX `fk_Usuario_Direccion_idx` (`id_Address` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Direccion0`
    FOREIGN KEY (`id_Address`)
    REFERENCES `fruit_punk`.`Addresses` (`id_Address`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `fruit_punk`.`Image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fruit_punk`.`Image` (
  `id_Image` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `image` LONGBLOB NOT NULL,
  PRIMARY KEY (`id_Image`));


-- -----------------------------------------------------
-- Table `fruit_punk`.`Products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fruit_punk`.`Products` (
  `id_Product` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `type` ENUM('Fruit', 'Vegetable', 'Bread', 'Dairy', 'Meat', 'Other') NOT NULL DEFAULT 'Fruit',
  `price` DOUBLE NOT NULL DEFAULT 0.00,
  `weight` FLOAT NOT NULL DEFAULT 0.00,
  `date_delivered` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_expired` TIMESTAMP NULL,
  `discount` TINYINT(1) NULL DEFAULT 0,
  `quantity` FLOAT NOT NULL DEFAULT 0,
  `date_purchased` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_sold` TIMESTAMP NULL,
  `id_Store` INT NOT NULL,
  PRIMARY KEY (`id_Product`),
  INDEX `fk_Products_Stores1_idx` (`id_Store` ASC) VISIBLE,
  CONSTRAINT `fk_Products_Stores1`
    FOREIGN KEY (`id_Store`)
    REFERENCES `fruit_punk`.`Stores` (`id_Store`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `fruit_punk`.`Promotions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fruit_punk`.`Promotions` (
  `id_Promotion` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `type` ENUM('Percentage', 'Per Unit') NULL DEFAULT 'Percentage',
  `value` DOUBLE NOT NULL DEFAULT 0.00,
  `promo_active` TINYINT(1) NOT NULL DEFAULT 0,
  `date_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_applied` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `date_expired` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `id_Store` INT NOT NULL,
  PRIMARY KEY (`id_Promotion`),
  INDEX `fk_Promotions_Stores1_idx` (`id_Store` ASC) VISIBLE,
  CONSTRAINT `fk_Promotions_Stores1`
    FOREIGN KEY (`id_Store`)
    REFERENCES `fruit_punk`.`Stores` (`id_Store`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `fruit_punk`.`Reviews`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fruit_punk`.`Reviews` (
  `id_Review` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `text` LONGTEXT NOT NULL,
  `value_ranking` INT(5) NOT NULL,
  `id_User` INT NOT NULL,
  `id_Store` INT NOT NULL,
  PRIMARY KEY (`id_Review`),
  INDEX `fk_Reviews_Users1_idx` (`id_User` ASC) VISIBLE,
  INDEX `fk_Reviews_Stores1_idx` (`id_Store` ASC) VISIBLE,
  CONSTRAINT `fk_Reviews_Users1`
    FOREIGN KEY (`id_User`)
    REFERENCES `fruit_punk`.`Users` (`id_User`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Reviews_Stores1`
    FOREIGN KEY (`id_Store`)
    REFERENCES `fruit_punk`.`Stores` (`id_Store`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `fruit_punk`.`Users_has_Products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fruit_punk`.`Users_has_Products` (
  `id_User_Product` INT NOT NULL AUTO_INCREMENT,
  `id_User` INT NOT NULL,
  `id_Product` INT NOT NULL,
  `date_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_modified` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  INDEX `fk_Users_has_Products_Products1_idx` (`id_Product` ASC) VISIBLE,
  INDEX `fk_Users_has_Products_Users1_idx` (`id_User` ASC) VISIBLE,
  PRIMARY KEY (`id_User_Product`),
  CONSTRAINT `fk_Users_has_Products_Users1`
    FOREIGN KEY (`id_User`)
    REFERENCES `fruit_punk`.`Users` (`id_User`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Users_has_Products_Products1`
    FOREIGN KEY (`id_Product`)
    REFERENCES `fruit_punk`.`Products` (`id_Product`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `fruit_punk`.`Result_Comparative_Log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fruit_punk`.`Result_Comparative_Log` (
  `id_Result` INT NOT NULL AUTO_INCREMENT,
  `result` VARCHAR(255) NOT NULL,
  `id_User` INT NOT NULL,
  `id_Product` INT NOT NULL,
  PRIMARY KEY (`id_Result`),
  INDEX `fk_Result_Comparative_Log_Users_has_Products1_idx` (`id_User` ASC, `id_Product` ASC) VISIBLE,
  CONSTRAINT `fk_Result_Comparative_Log_Users_has_Products1`
    FOREIGN KEY (`id_User` , `id_Product`)
    REFERENCES `fruit_punk`.`Users_has_Products` (`id_User` , `id_Product`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `fruit_punk`.`Users_follow_Stores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fruit_punk`.`Users_follow_Stores` (
  `id_User` INT NOT NULL,
  `id_Store` INT NOT NULL,
  `date_followed` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_unfollowed` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_User`, `id_Store`),
  INDEX `fk_Users_has_Stores_Stores1_idx` (`id_Store` ASC) VISIBLE,
  INDEX `fk_Users_has_Stores_Users1_idx` (`id_User` ASC) VISIBLE,
  CONSTRAINT `fk_Users_has_Stores_Users1`
    FOREIGN KEY (`id_User`)
    REFERENCES `fruit_punk`.`Users` (`id_User`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Users_has_Stores_Stores1`
    FOREIGN KEY (`id_Store`)
    REFERENCES `fruit_punk`.`Stores` (`id_Store`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `fruit_punk`.`Products_has_Promotions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fruit_punk`.`Products_has_Promotions` (
  `id_Product` INT NOT NULL,
  `id_Promotion` INT NOT NULL,
  `date_applied` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_expired` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id_Product`, `id_Promotion`),
  INDEX `fk_Products_has_Promotions_Promotions1_idx` (`id_Promotion` ASC) VISIBLE,
  INDEX `fk_Products_has_Promotions_Products1_idx` (`id_Product` ASC) VISIBLE,
  CONSTRAINT `fk_Products_has_Promotions_Products1`
    FOREIGN KEY (`id_Product`)
    REFERENCES `fruit_punk`.`Products` (`id_Product`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Products_has_Promotions_Promotions1`
    FOREIGN KEY (`id_Promotion`)
    REFERENCES `fruit_punk`.`Promotions` (`id_Promotion`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

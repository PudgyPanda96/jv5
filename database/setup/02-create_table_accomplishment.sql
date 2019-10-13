CREATE DATABASE  IF NOT EXISTS `jv5`;
USE `jv5`;

DROP TABLE IF EXISTS `accomplishment`;

CREATE TABLE `accomplishment` (
	`accomplishment_id` int NOT NULL AUTO_INCREMENT,
    `user_id` int NOT NULL,
	`title` varchar(255) NOT NULL,
	`game` varchar(255),
    `issuer` varchar(255),
    `date` datetime NOT NULL,
    `description` varchar(1000),

    
    -- Audit Fields (do not touch) --
    `created_date` timestamp DEFAULT CURRENT_TIMESTAMP,
    `last_updated_date` timestamp DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`accomplishment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1
;



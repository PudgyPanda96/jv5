/*
CREATE DATABASE  IF NOT EXISTS `jv5`;
USE `jv5`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`user_id` int(11) NOT NULL AUTO_INCREMENT,
	`first_name` varchar(45) NOT NULL,
	`last_name` varchar(45) NOT NULL,
	`alias` varchar(45) NOT NULL,
	`email` varchar(80) NOT NULL,
	`country` varchar(45) DEFAULT NULL,
	`state` varchar(45) DEFAULT NULL,
	`city` varchar(45) DEFAULT NULL,
	`avatar` blob DEFAULT NULL,
    
    
    
    -- Audit Fields (do not touch) --
    `created_date` date DEFAULT CURRENT_TIMESTAMP,
    `last_updated_date` date DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1
;
*/


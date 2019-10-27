CREATE DATABASE  IF NOT EXISTS `jv5`;
USE `jv5`;

DROP TABLE IF EXISTS `experience`;

CREATE TABLE `experience` (
	`experience_id` int NOT NULL AUTO_INCREMENT,
    `user_id` int NOT NULL,
	`game` varchar(255) NOT NULL,
	`title` varchar(255) NOT NULL,
	`team` varchar(255),
	`start_date` datetime NOT NULL,
    `end_date` datetime,
    `description` varchar(1000),

    
    -- Audit Fields (do not touch) --
    `created_date` timestamp DEFAULT CURRENT_TIMESTAMP,
    `last_updated_date` timestamp DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`experience_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1
;



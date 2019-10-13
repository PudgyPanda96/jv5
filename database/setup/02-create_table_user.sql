CREATE DATABASE  IF NOT EXISTS `jv5`;
USE `jv5`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`user_id` int NOT NULL AUTO_INCREMENT,
    `username` varchar(255) NOT NULL,
	`password` varchar(255) NOT NULL,
	`first_name` varchar(255) NOT NULL,
	`last_name` varchar(255) NOT NULL,
	`alias` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL,
	`country` varchar(255),
	`state` varchar(255),
	`city` varchar(255),
	`profile_image` blob,
    `game` varchar(255),
    `game_role` varchar(255),
    `about` varchar(1000),
    `resume_pdf` blob,
    
    
    -- Audit Fields (do not touch) --
    `created_date` timestamp DEFAULT CURRENT_TIMESTAMP,
    `last_updated_date` timestamp DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1
;



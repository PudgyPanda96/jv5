CREATE DATABASE  IF NOT EXISTS `jv5`;
USE `jv5`;

DROP TABLE IF EXISTS `user_social_media`;

CREATE TABLE `user_social_media` (
	`user_social_media_id` int NOT NULL AUTO_INCREMENT,
    `user_id` int NOT NULL,
	`type` varchar(255) NOT NULL,
	`link` varchar(255) NOT NULL,

    
    -- Audit Fields (do not touch) --
    `created_date` timestamp DEFAULT CURRENT_TIMESTAMP,
    `last_updated_date` timestamp DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`user_social_media_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1
;



DELETE FROM `user`;
INSERT INTO `user` (user_id, username, password, first_name, last_name, alias, email, country, state, city, profile_image, game, game_role, about, resume_pdf, created_date, last_updated_date);
VALUES 
	(1,'kerblaster','password','Renard','Tumbokon','kerblaster','kerblaster@hotmail.com','United States','NJ','Cranford',null,'Fortnite','Solo','Dabs on kids then flosses on them', null, NOW(),NOW()),
	(2,'pudgypanda','password','Mike','Serpico','PudgyPanda','pudgypanda@hotmail.com','United States','NJ','Freehold',null,'SSBM','Ice Climbers','I wobble', null, NOW(),NOW()),
	(3,'llamuh','password','Aziz','Rahman','Llamuh','Llamuh@hotmail.com','United States','NJ','Piscataway',null,'Overwatch','Coach','I coach Rutgers Team', null, NOW(),NOW()),
	(4,'boxghost','password','Nick','Prezioso','Box Ghost','BoxGhost@hotmail.com','United States','NJ','Cranford',null,'Street Fighter','Ryu','Online God', null, NOW(),NOW()),
	(5,'jordank','password','Jordan','Standig','Jordank','jordank@hotmail.com','United States','NJ','Freehold',null,'SSBM','Solo','Chaingrabs fox', null, NOW(),NOW())
;

DELETE FROM `accomplishment`;
INSERT INTO `accomplishment` (accomplishment_id, user_id, title, game, issuer, date, description, created_date, last_updated_date)
VALUES
	(1, 5, 'Eated the Booty', 'Noods', 'Booty', NOW(), 'Something something Tinder', NOW(), NOW()),
    (2, 5, 'Beat Fable\'s Fox', 'SSBM', '', NOW(), 'Two stocked, ez!', NOW(), NOW()),
    (3, 1, '33rd at NJ Arcadian', 'SSBM', 'Yestercades', NOW(), 'Went 1-2', NOW(), NOW());
    
DELETE FROM `experience`;
INSERT INTO `experience` (experience_id, user_id, title, game, team, start_date, end_date, description, created_date, last_updated_date)
VALUES
	(1, 5, 'SSBB Player', 'SSBB', '', NOW()-1000, NOW()-500, '', NOW(), NOW()),
    (2, 5, 'SSBM Player', 'SSBM', 'RU', NOW()-500, 'CURRENT', 'I like Melee better than Brawl', NOW(), NOW()),
    (3, 1, 'Fortnite Player', 'Fortnite', '', NOW()-600, NOW()-200, 'I quit because Epic Games sucks!', NOW(), NOW());
    
DELETE FROM `user_social_media`;
INSERT INTO `user_social_media` (user_social_media_id, user_id, type, link, created_date, last_updated_date)
VALUES
	(1, 5, 'Facebook', 'http://www.facebook.com/jordan', NOW(), NOW()),
    (2, 5, 'Twitch', 'http://www.twitch.tv/jordan', NOW(), NOW()),
    (3, 1, 'Twitter', 'http://www.twitter.com', NOW(), NOW());    
    
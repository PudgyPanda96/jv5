DELETE FROM `user`;
INSERT INTO `user` (user_id, password, first_name, last_name, alias, email, country, state, city, profile_image, game, game_role, about, resume_pdf, created_date, last_updated_date)
VALUES 
	(1,'password','Renard','Tumbokon','kerblaster','kerblaster@hotmail.com','United States','NJ','Cranford',null,'Fortnite','Solo','Dabs on kids then flosses on them', null, NOW(),NOW()),
	(2,'password','Mike','Serpico','PudgyPanda','pudgypanda@hotmail.com','United States','NJ','Freehold',null,'SSBM','Ice Climbers','I wobble', null, NOW(),NOW()),
	(3,'password','Aziz','Rahman','Llamuh','Llamuh@hotmail.com','United States','NJ','Piscataway',null,'Overwatch','Coach','I coach Rutgers Team', null, NOW(),NOW()),
	(4,'password','Nick','Prezioso','Box Ghost','BoxGhost@hotmail.com','United States','NJ','Cranford',null,'Street Fighter','Ryu','Online God', null, NOW(),NOW()),
	(5,'password','Jordan','Standig','Jordank','jordank@hotmail.com','United States','NJ','Freehold',null,'SSBM','Solo','Chaingrabs fox', null, NOW(),NOW())
;

DELETE FROM `accomplishment`;
INSERT INTO `accomplishment` (accomplishment_id, user_id, title, game, issuer, date, description, created_date, last_updated_date)
VALUES
	(1, 5, 'Eated the Booty', 'Noods', 'Booty', '2015-09-11', 'Something something Tinder', NOW(), NOW()),
    (2, 5, 'Beat Fable\'s Fox', 'SSBM', '', '2019-10-25', 'Two stocked, ez!', NOW(), NOW()),
    (3, 1, '33rd at NJ Arcadian', 'SSBM', 'Yestercades', '2019-08-12', 'Went 1-2', NOW(), NOW());
    
DELETE FROM `experience`;
INSERT INTO `experience` (experience_id, user_id, title, game, team, start_date, end_date, description, created_date, last_updated_date)
VALUES
	(1, 5, 'SSBB Player', 'SSBB', '', '2017-06-15', '2018-01-27', '', NOW(), NOW()),
    (2, 5, 'SSBM Player', 'SSBM', 'RU', '2018-01-27', null, 'I like Melee better than Brawl', NOW(), NOW()),
    (3, 1, 'Fortnite Player', 'Fortnite', '', '2018-03-14', null, 'I quit because Epic Games sucks!', NOW(), NOW());
    
DELETE FROM `user_social_media`;
INSERT INTO `user_social_media` (user_social_media_id, user_id, type, link, created_date, last_updated_date)
VALUES
	(1, 5, 'Facebook', 'http://www.facebook.com/jordan', NOW(), NOW()),
    (2, 5, 'Twitch', 'http://www.twitch.tv/jordan', NOW(), NOW()),
    (3, 1, 'Twitter', 'http://www.twitter.com', NOW(), NOW());    
    

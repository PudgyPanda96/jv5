DELETE FROM `user`;
INSERT INTO `user` (user_id, username, password, first_name, last_name, alias, email, country, state, city, profile_image, game, game_role, about, resume_pdf, created_date, last_updated_date)
VALUES 
	(1,'kerblaster','password','Renard','Tumbokon','kerblaster','kerblaster@hotmail.com','United States','NJ','Cranford',null,'Fortnite','Solo','Dabs on kids then flosses on them', null, NOW(),NOW()),
	(2,'pudgypanda','password','Mike','Serpico','PudgyPanda','pudgypanda@hotmail.com','United States','NJ','Freehold',null,'SSBM','Ice Climbers','I wobble', null, NOW(),NOW()),
	(3,'llamuh','password','Aziz','Rahman','Llamuh','Llamuh@hotmail.com','United States','NJ','Piscataway',null,'Overwatch','Coach','I coach Rutgers Team', null, NOW(),NOW()),
	(4,'boxghost','password','Nick','Prezioso','Box Ghost','BoxGhost@hotmail.com','United States','NJ','Cranford',null,'Street Fighter','Ryu','Online God', null, NOW(),NOW()),
	(5,'jordank','password','Jordan','Standig','Jordank','jordank@hotmail.com','United States','NJ','Freehold',null,'SSBM','Solo','Chaingrabs fox', null, NOW(),NOW())
;
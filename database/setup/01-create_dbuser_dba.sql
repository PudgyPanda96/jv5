DROP USER IF EXISTS 'jv5_dba'@'localhost';

CREATE USER 'jv5_dba'@'localhost' IDENTIFIED BY 'p3nr0s3';		/* user@localhost .. password */ 
GRANT ALL PRIVILEGES ON * . * TO 'jv5_dba'@'localhost';
ALTER USER 'jv5_dba'@'localhost' IDENTIFIED WITH mysql_native_password BY 'p3nr0s3';


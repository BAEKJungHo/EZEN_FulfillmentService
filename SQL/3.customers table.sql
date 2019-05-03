CREATE TABLE customers (
  	c_id int(4) unsigned NOT NULL AUTO_INCREMENT,
	c_userId varchar(20) NOT NULL DEFAULT "",
 	c_name varchar(20) NOT NULL DEFAULT "",
  	c_password varchar(20) NOT NULL DEFAULT "",
	PRIMARY KEY(c_id),
	UNIQUE KEY(c_userId)
) AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

desc customers;
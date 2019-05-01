CREATE TABLE customers (
  	c_id int(4) unsigned NOT NULL AUTO_INCREMENT,
 	c_name varchar(20) NOT NULL DEFAULT "",
  	c_password varchar(20) NOT NULL DEFAULT "",
  	PRIMARY KEY (c_id)
) AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

desc customers;
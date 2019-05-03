CREATE TABLE admins (
  	a_id int(5) unsigned NOT NULL,
	a_userId varchar(20) NOT NULL DEFAULT ””,
 	a_name varchar(20) NOT NULL DEFAULT ””,
  	a_password varchar(20) NOT NULL DEFAULT “”,
  	PRIMARY KEY (a_id)
)  DEFAULT CHARSET=utf8;
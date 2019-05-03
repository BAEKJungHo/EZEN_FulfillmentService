  CREATE TABLE product_storage (
  	 p_id int(5) unsigned NOT NULL AUTO_INCREMENT,
 	 p_name varchar(50) NOT NULL DEFAULT "",
  	 p_imgName varchar(100) NOT NULL DEFAULT "",
	 p_price int(5) unsigned NOT NULL,
	 p_quantity int(255) unsigned NOT NULL,
	 p_adminId int(5) unsigned NOT NULL,
  	PRIMARY KEY (p_id),
  	FOREIGN KEY (p_adminId) REFERENCES admins(p_id)
  ) AUTO_INCREMENT=50001 DEFAULT CHARSET=utf8;

desc product_storage;
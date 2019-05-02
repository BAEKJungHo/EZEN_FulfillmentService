CREATE TABLE pay (
  	pay_id int(8) unsigned NOT NULL AUTO_INCREMENT,
	pay_adminId int(5) unsigned NOT NULL,
  	pay_price int(10) unsigned NOT NULL,
	pay_date datetime,
  	PRIMARY KEY (pay_id),
	FOREIGN KEY (pay_adminId) REFERENCES admins(a_id)
) AUTO_INCREMENT=20000001 DEFAULT CHARSET=utf8;
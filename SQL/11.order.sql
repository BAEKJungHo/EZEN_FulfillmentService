CREATE TABLE p_order (
  	o_id int(8) unsigned NOT NULL AUTO_INCREMENT,
	o_adminId int(5) unsigned NOT NULL,
  	o_quantity int(200) unsigned NOT NULL,
	o_price int(10) unsigned NOT NULL,
	o_totalPrice int(10) unsigned NOT NULL,
	o_date datetime,
  	PRIMARY KEY (o_id),
	FOREIGN KEY (o_adminId) REFERENCES admins(a_id)
) AUTO_INCREMENT=30000001 DEFAULT CHARSET=utf8;
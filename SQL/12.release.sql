CREATE TABLE p_release (
  	r_id int(8) unsigned NOT NULL AUTO_INCREMENT,
	r_transportId int(5) unsigned NOT NULL,
	r_shoppingId int(5) unsigned NOT NULL,
	r_invoiceId int(5) unsigned NOT NULL,
  	r_name varchar(10) NOT NULL DEFAULT "",
	r_tel varchar(15) NOT NULL DEFAULT "",
	r_address varchar(50) NOT NULL DEFAULT "",
	r_productName varchar(100) NOT NULL DEFAULT "",
	r_quantity int(10) unsigned NOT NULL,
	r_date datetime,
  	PRIMARY KEY (r_id),
	FOREIGN KEY (r_transportId) REFERENCES admins(a_id),
	FOREIGN KEY (r_shoppingId) REFERENCES admins(a_id),
	FOREIGN KEY (r_invoiceId) REFERENCES invoice(i_id)
) AUTO_INCREMENT=40000001 DEFAULT CHARSET=utf8;
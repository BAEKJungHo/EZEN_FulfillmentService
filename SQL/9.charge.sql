CREATE TABLE charge (
  	charge_id int(8) unsigned NOT NULL AUTO_INCREMENT,
	charge_adminId int(5) unsigned NOT NULL,
  	charge_invoiceId int(5) unsigned NOT NULL,
	charge_productName varchar(30) NOT NULL DEFAULT "",
	charge_date datetime,
  	PRIMARY KEY (charge_id),
	FOREIGN KEY (charge_adminId) REFERENCES admins(a_id)
) AUTO_INCREMENT=10000001 DEFAULT CHARSET=utf8;
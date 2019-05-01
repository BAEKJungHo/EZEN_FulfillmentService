CREATE TABLE bank (
  	bank_id int(8) unsigned NOT NULL AUTO_INCREMENT,
  	bank_adminId int(5) unsigned NOT NULL,
	bank_balance int(10) unsigned NOT NULL,
  	PRIMARY KEY (bank_id),
  	FOREIGN KEY (bank_adminId) REFERENCES admins(a_id)
) AUTO_INCREMENT=10000001 DEFAULT CHARSET=utf8;
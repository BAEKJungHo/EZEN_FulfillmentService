CREATE TABLE office_purchasing (
  	o_adminId int(5) unsigned NOT NULL,
  	o_productId int(5) unsigned NOT NULL,
 	o_productName varchar(50) NOT NULL,
  	PRIMARY KEY (o_adminId, o_productId),
  	FOREIGN KEY (o_adminId) REFERENCES admins(a_id),
  	FOREIGN KEY (o_productId) REFERENCES product_storage(p_id)
  ) DEFAULT CHARSET=utf8;
  
desc office_purchasing;

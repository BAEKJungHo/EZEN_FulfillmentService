CREATE TABLE invoice (
  	i_id int(5) unsigned NOT NULL AUTO_INCREMENT, 
	i_name varchar(10) NOT NULL DEFAULT "",
	i_tel varchar(15) NOT NULL DEFAULT "", 
	i_productId int(5) unsigned NOT NULL,
	i_productName varchar(100) NOT NULL DEFAULT "", 
	i_quantity int(255) NOT NULL,
	i_date datetime NOT NULL DEFAULT current_timestamp, 
	i_adminId int(5) unsigned NOT NULL,
  	PRIMARY KEY (i_id),
  	FOREIGN KEY (i_productId) REFERENCES product_storage(p_id),
  	FOREIGN KEY (i_adminId) REFERENCES admins(a_id)
  ) DEFAULT CHARSET=utf8;

desc invoice;
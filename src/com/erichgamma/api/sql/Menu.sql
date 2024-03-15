
CREATE TABLE IF NOT EXISTS menus(
  id INT NOT NULL AUTO_INCREMENT,
  item VARCHAR(20) NOT NULL,
  category VARCHAR(20) NOT NULL,
  CONSTRAINT menus_pk PRIMARY KEY(id)
);
DROP TABLES menus;

show Tables;
desc menus;


select * from menus;

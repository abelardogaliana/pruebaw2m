DROP TABLE IF EXISTS SUPERHEROES;

CREATE TABLE SUPERHEROES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  created_date DATETIME NOT NULL,
  name VARCHAR(255)
);
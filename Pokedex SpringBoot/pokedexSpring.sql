DROP DATABASE pokedexSpring;
CREATE DATABASE pokedexSpring;
USE pokedexSpring;

CREATE TABLE pokemon (id_pokemon INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
					  name VARCHAR(30) NOT NULL,
                      level SMALLINT NOT NULL);

CREATE TABLE type 	 (id_type INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
					  type VARCHAR(30) NOT NULL);

CREATE TABLE ability (id_ability INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
					  ability VARCHAR(30) NOT NULL);

CREATE TABLE pok_ab (fk_pokemon INT NOT NULL,
					 fk_ability INT NOT NULL,
                     FOREIGN KEY (fk_pokemon) REFERENCES pokemon (id_pokemon) ON DELETE CASCADE,
                     FOREIGN KEY (fk_ability) REFERENCES ability (id_ability) ON DELETE CASCADE);

CREATE TABLE pok_evo (fk_pokemon INT NOT NULL,
					  fk_evolution INT NOT NULL,
                      FOREIGN KEY (fk_pokemon) REFERENCES pokemon (id_pokemon) ON DELETE CASCADE,
                      FOREIGN KEY (fk_evolution) REFERENCES pokemon (id_pokemon) ON DELETE CASCADE);
				
CREATE TABLE pok_type (fk_pokemon INT NOT NULL,
					   fk_type INT NOT NULL,
                       FOREIGN KEY (fk_pokemon) REFERENCES pokemon (id_pokemon) ON DELETE CASCADE,
                       FOREIGN KEY (fk_type) REFERENCES type (id_type) ON DELETE CASCADE);

CREATE TABLE user (id_user INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
		           username VARCHAR(30) NOT NULL,
                   password VARCHAR(128) NOT NULL,
                   enabled TINYINT NOT NULL);

CREATE TABLE rol (id_rol INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
				  name VARCHAR(30) NOT NULL);

CREATE TABLE user_rol(fk_user INT NOT NULL,
					  fk_rol INT NOT NULL,
                      FOREIGN KEY (fk_user) REFERENCES user (id_user) ON DELETE CASCADE,
                      FOREIGN KEY (fk_rol) REFERENCES rol (id_rol) ON DELETE CASCADE);

INSERT INTO user (username, password, enabled) VALUES ("admin", "$2y$12$1eiZUWHOUkrBA72imlZ/KesWJzxfEGGxKbE0Hz/Glsqvd8ycNMHES", 1);
INSERT INTO user (username, password, enabled) VALUES ("user", "$2y$12$1eiZUWHOUkrBA72imlZ/KesWJzxfEGGxKbE0Hz/Glsqvd8ycNMHES", 1);

INSERT INTO rol (name) VALUES ("ADMIN");
INSERT INTO rol (name) VALUES ("USER");
INSERT INTO rol (name) VALUES ("CREATOR");
INSERT INTO rol (name) VALUES ("EDITOR");

INSERT INTO user_rol VALUES (1,1);
INSERT INTO user_rol VALUES (2,2);
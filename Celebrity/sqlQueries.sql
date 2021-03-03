CREATE SCHEMA `celebrityapp` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci ;

CREATE TABLE `celebrityapp`.`celebrities` (
  `id` 			INT 	PRIMARY KEY 	AUTO_INCREMENT,
  `name` 		VARCHAR(255),
  `canSing` 	TINYINT,
  `canAct` 		TINYINT,
  `canDance` 	TINYINT
)
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;

SELECT * FROM `celebrityapp`.`celebrities`;

INSERT INTO `celebrityapp`.`celebrities` (`name`, `canSing`, `canAct`, `canDance`) VALUES ('Eminem', 1, 1, 0);
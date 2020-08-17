/*
-- Query: SELECT `user_details`.`user_id`,
    `user_details`.`name`,
    `user_details`.`address`,
    `user_details`.`email_id`,
    `user_details`.`phone_number`,
    `user_details`.`username`,
    `user_details`.`password`,
    `user_details`.`failed_attempt`,
    `user_details`.`status`
FROM `payment`.`user_details`
LIMIT 0, 1000

-- Date: 2020-08-17 12:52
*/

CREATE TABLE `user_details` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email_id` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `failed_attempt` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `` (`user_id`,`name`,`address`,`email_id`,`phone_number`,`username`,`password`,`failed_attempt`,`status`) VALUES (1,'Tony Stark','Avengers HQ','iamironman@avengers.com','9898989','iamironman','iamtonystark',0,1);
INSERT INTO `` (`user_id`,`name`,`address`,`email_id`,`phone_number`,`username`,`password`,`failed_attempt`,`status`) VALUES (2,'Steve Rogers','Avengers HQ','captainamerica@avengers.com','11298989','captian_rogers','americasass',0,1);
INSERT INTO `` (`user_id`,`name`,`address`,`email_id`,`phone_number`,`username`,`password`,`failed_attempt`,`status`) VALUES (3,'Harry Potter','Hogwards School','harrypotter@hogwards.uk','0099123123','harry_porter','ifearvoldemort',0,1);
INSERT INTO `` (`user_id`,`name`,`address`,`email_id`,`phone_number`,`username`,`password`,`failed_attempt`,`status`) VALUES (4,'Bruce Wayne','Batcave','iambatman@dcuniverse.com','12121212','iambatman','savemartha',0,1);
INSERT INTO `` (`user_id`,`name`,`address`,`email_id`,`phone_number`,`username`,`password`,`failed_attempt`,`status`) VALUES (6,'John Snow','The Wall','johnsnow@dcuniverse.com','696969','johnsnow','youknownothing',0,1);
INSERT INTO `` (`user_id`,`name`,`address`,`email_id`,`phone_number`,`username`,`password`,`failed_attempt`,`status`) VALUES (7,'John Snow','The Wall','johnsnow@hbo.com','696969','johnsnow1','youknownothing',0,1);
INSERT INTO `` (`user_id`,`name`,`address`,`email_id`,`phone_number`,`username`,`password`,`failed_attempt`,`status`) VALUES (8,'Harvey Dent','Jessica Pearson','harvey@suits.com','12121212','harvey','suitup',0,1);

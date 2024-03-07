CREATE TABLE `wallet` (
  `User_id` int NOT NULL,
  `Current_Bal` int DEFAULT NULL,
  KEY `Current_Bal_idx` (`User_id`),
  CONSTRAINT `Current_Bal` FOREIGN KEY (`User_id`) REFERENCES `users` (`User_id`)
)
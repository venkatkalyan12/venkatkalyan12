CREATE TABLE `bankaccount` (
  `User_id` int NOT NULL,
  `BankAccNum` int NOT NULL,
  `Bank_Name` varchar(50) NOT NULL,
  `IFSC_Code` varchar(40) NOT NULL,
  `Acc_Type` enum('SAVINGS','SALARY','LOAN','CURRENT') NOT NULL,
  `BankAccount_pin` int NOT NULL,
  `Acc_Balance` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`BankAccNum`),
  UNIQUE KEY `BankAccNum_UNIQUE` (`BankAccNum`),
  CONSTRAINT `BankAccNum` FOREIGN KEY (`User_id`) REFERENCES `users` (`User_id`)
)

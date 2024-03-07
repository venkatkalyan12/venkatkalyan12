CREATE TABLE `transaction` (
  `Txn_Id` int NOT NULL,
  `Txn_Date&Time` datetime NOT NULL,
  `Txn_Source` varchar(30) NOT NULL,
  `Txn_Destination_Id` int NOT NULL,
  `Txn_Amount` int(10) unsigned zerofill NOT NULL,
  `User_id` int DEFAULT NULL,
  PRIMARY KEY (`Txn_Id`),
  UNIQUE KEY `Txn_Id_UNIQUE` (`Txn_Id`),
  UNIQUE KEY `Txn_Destination_Id_UNIQUE` (`Txn_Destination_Id`),
  CONSTRAINT `User`  FOREIGN KEY (`Txn_Id`) REFERENCES `users` (`User_id`)
)
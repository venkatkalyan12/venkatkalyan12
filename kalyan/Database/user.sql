CREATE TABLE `users` (
  User_id INT NOT NULL,
  `Firstt_Name` VARCHAR(45) NOT NULL,
  `Last_Name` VARCHAR(45) NOT NULL,
  `Date_Of_Birth` DATE NULL,
  `Phone_Number` int(12) NOT NULL,
  `Address` VARCHAR(45) NULL,
  `PassWord` CHAR(20) NOT NULL,
  PRIMARY KEY (`User_id`));

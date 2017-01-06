# Forum
Use test as database

Code for ques table

CREATE TABLE `ques` (
  `qid` int(11) NOT NULL AUTO_INCREMENT,
  `ques` varchar(200) DEFAULT NULL,
  `qauthor` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`qid`)
);

Code for ans table

CREATE TABLE `ans` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `qid` int(11) DEFAULT NULL,
  `ansname` varchar(200) DEFAULT NULL,
  `aauthor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  KEY `fk_idx` (`qid`),
  CONSTRAINT `fk` FOREIGN KEY (`qid`) REFERENCES `ques` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE
);

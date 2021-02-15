DROP TABLE if exists errands;
DROP TABLE if exists lists;

CREATE TABLE `errands` (
  `errand_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `list_id` int(11) DEFAULT NULL,
  `errand_desc` varchar(45) DEFAULT NULL,
  `errand_priority` int(11) DEFAULT NULL,
  `errand_deadline` varchar(45) DEFAULT NULL,
  `errand_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`errand_id`),
  KEY `task_list_id_idx` (`list_id`),
  CONSTRAINT `task_list_id` FOREIGN KEY (`list_id`) REFERENCES `lists` (`list_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `lists` (
  `list_id` int(11) NOT NULL AUTO_INCREMENT,
  `list_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`list_id`),
  UNIQUE KEY `list_id_UNIQUE` (`list_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
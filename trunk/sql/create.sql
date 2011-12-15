CREATE DATABASE `organization` /*!40100 DEFAULT CHARACTER SET latin1 */;


DROP TABLE IF EXISTS `organization`.`organization`;
CREATE TABLE  `organization`.`organization` (
  `org_id` int(10) NOT NULL auto_increment,
  `short_name` varchar(45) NOT NULL,
  `registered_name` varchar(100) NOT NULL,
  `addredd_city` varchar(45) NOT NULL,
  `address_state` varchar(2) NOT NULL,
  `address_country` varchar(45) NOT NULL,
  PRIMARY KEY  (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `organization`.`employee`;
CREATE TABLE  `organization`.`employee` (
  `emp_id` int(10) NOT NULL auto_increment,
  `first_name` varchar(45) NOT NULL,
  `middle_name` varchar(100) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `age` int(10) NOT NULL,
  `joining_date` datetime NOT NULL,
  `org_id` int(10) NOT NULL,
  `billing_id` int(10) default NULL,
  PRIMARY KEY  (`emp_id`),
  KEY `emp_org_FK` (`org_id`),
  KEY `emp_billing_FK` (`billing_id`),
  CONSTRAINT `emp_billing_FK` FOREIGN KEY (`billing_id`) REFERENCES `billing_details` (`billing_id`),
  CONSTRAINT `emp_org_FK` FOREIGN KEY (`org_id`) REFERENCES `organization` (`org_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `organization`.`billing_details`;
CREATE TABLE  `organization`.`billing_details` (
  `billing_id` int(11) NOT NULL auto_increment,
  `per_hour_billing` float NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `is_contractor` tinyint(1) NOT NULL,
  `contractor_name` varchar(100) NOT NULL,
  `emp_id` int(11) NOT NULL,
  PRIMARY KEY  (`billing_id`),
  KEY `billing_emp_FK` (`emp_id`),
  CONSTRAINT `billing_emp_FK` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE IF EXISTS `organization`.`billing_details`;
CREATE TABLE  `organization`.`billing_details` (
  `emp_id` int(10) unsigned NOT NULL,
  `org_id` int(10) unsigned NOT NULL,
  `per_hour_billing` float NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `contractor` tinyint(1) NOT NULL,
  `contractor_id` int(10) unsigned NOT NULL,
  `billing_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  USING BTREE (`billing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `organization`.`employee`;
CREATE TABLE  `organization`.`employee` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `first_name` varchar(45) NOT NULL,
  `middle_name` varchar(100) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  `joining_date` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `organization`.`organization`;
CREATE TABLE  `organization`.`organization` (
  `org_id` int(10) unsigned NOT NULL auto_increment,
  `short_name` varchar(45) NOT NULL,
  `registered_name` varchar(100) NOT NULL,
  `addredd_city` varchar(45) NOT NULL,
  `address_state` varchar(2) NOT NULL,
  `address_country` varchar(45) NOT NULL,
  PRIMARY KEY  (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

set foreign_key_checks = 0 ; 

-- new

ALTER TABLE `organization`.`organization_employee_billing` 
  ADD CONSTRAINT `billing_FK`
  FOREIGN KEY org_FK(org_id)
  REFERENCES `organization`.`billing_details` (billing_id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `billing_FK` (billing_id) ;

ALTER TABLE `organization`.`organization_employee_billing` ADD CONSTRAINT UNIQUE org_emp_biln_UQ (billing_id, emp_id, org_id);

ALTER TABLE `organization`.`employee` 
  ADD CONSTRAINT `emp_org_FK`
  FOREIGN KEY emp_org_FK(org_id)
  REFERENCES `organization`.`organization` (org_id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `emp_org_FK` (org_id) ;

delimiter $$

CREATE TABLE `organization_employee_billing` (
  `billing_id` int(10) NOT NULL,
  `emp_id` int(10) NOT NULL,
  `org_id` int(10) NOT NULL,
  UNIQUE KEY `org_emp_biln_UQ` (`billing_id`,`emp_id`,`org_id`),
  KEY `emp_FK` (`emp_id`),
  KEY `org_FK` (`org_id`),
  KEY `billing_FK` (`billing_id`),
  CONSTRAINT `billing_FK` FOREIGN KEY (`org_id`) REFERENCES `billing_details` (`billing_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `emp_FK` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `org_FK` FOREIGN KEY (`org_id`) REFERENCES `organization` (`org_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$



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
# Dump of table contacts
# ------------------------------------------------------------

DROP TABLE IF EXISTS `contacts`;

CREATE TABLE `contacts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `note` text,
  `gender` varchar(255) DEFAULT NULL,
  `avatar` text,
  `birth_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table email_contacts
# ------------------------------------------------------------

DROP TABLE IF EXISTS `email_contacts`;

CREATE TABLE `email_contacts` (
  `email` varchar(255) NOT NULL DEFAULT '',
  `contact_id` bigint(20) NOT NULL,
  PRIMARY KEY (`email`),
  FOREIGN KEY (contact_id) REFERENCES contacts(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table phone_contacts
# ------------------------------------------------------------

DROP TABLE IF EXISTS `phone_contacts`;

CREATE TABLE `phone_contacts` (
  `phone` varchar(255) NOT NULL DEFAULT '',
  `contact_id` bigint(20) NOT NULL,
  PRIMARY KEY (`phone`),
  FOREIGN KEY (contact_id) REFERENCES contacts(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

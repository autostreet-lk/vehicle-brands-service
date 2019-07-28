CREATE TABLE if not exists `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `vehicle_brands` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL UNIQUE,
  `created_by` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(100) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `vehicle_models` (
  `id` bigint(20) NOT NULL,
  `manufacturer_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(100) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKolwwc2kumg42n3av7nftua9ck` (`manufacturer_id`)
);

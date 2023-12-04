use b4kqgebpx5azhitvdtvz;
SET time_zone = "+05:30";

CREATE TABLE `invoice` (
  `invoice_autoId` int(11) NOT NULL auto_increment primary key,
  `invoice_number` int(11) NOT NULL unique,
  `customer_name` varchar(100) NOT NULL,
  `invoice_date` date NOT NULL,
  `invoice_address` varchar(256) not null,
  `customer_vat_no` varchar(50) not null
);

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL auto_increment primary key,
  `product_name` varchar(100) NOT NULL unique,
  `product_rate` float NOT NULL DEFAULT 0
);

CREATE TABLE `invoiceitems` (
  `item_auto_id` int(11) NOT NULL auto_increment primary key,
  `invoice_id` int(11) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `qty` int(11) NOT NULL default 0,
  `rate` float NOT NULL default 0,
  `price` real(12,2) NOT NULL default 0,
  `free_i` float NOT NULL DEFAULT 0
);

CREATE TABLE `proforma_invoice` (
  `invoice_autoId` int(11) NOT NULL auto_increment primary key,
  `invoice_number` int(11) NOT NULL unique,
  `customer_name` varchar(100) NOT NULL,
  `invoice_date` date NOT NULL,
  `invoice_address` varchar(256) not null,
  `customer_vat_no` varchar(50) not null
);

CREATE TABLE `proforma_invoiceitems` (
  `item_auto_id` int(11) NOT NULL auto_increment primary key,
  `invoice_id` int(11) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `qty` int(11) NOT NULL default 0,
  `rate` float NOT NULL default 0,
  `price` real(12,2) NOT NULL default 0,
  `free_i` float NOT NULL DEFAULT 0
);

CREATE TABLE `user` (
  `userid` int(11) NOT NULL auto_increment primary key,
  `username` varchar(100) NOT NULL unique,
  `password` varchar(256) NOT NULL,
  `email` varchar(100) NOT NULL unique,
  `telephone` varchar(15) NOT NULL unique
);

CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL auto_increment primary key,
  `customer_name` varchar(100) NOT NULL unique,
  `customer_address` varchar(256) NOT NULL,
  `customer_vat_no` varchar(50) NOT NULL unique
);

CREATE TABLE `inventory` (
  `product_name` varchar(100) NOT NULL primary key,
  `product_stock` float NOT NULL DEFAULT 0
);

insert into `user`(`username`,`password`,`email`,`telephone`) values ('admin',sha1('har123'),'mail.harshana.lk@gmail.com','+94773270038');
insert into `user`(`username`,`password`,`email`,`telephone`) values ('user',sha1('NBB682'),'','');

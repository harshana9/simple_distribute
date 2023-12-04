-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: b4kqgebpx5azhitvdtvz-mysql.services.clever-cloud.com:3306
-- Generation Time: Apr 08, 2023 at 04:23 PM
-- Server version: 8.0.22-13
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `b4kqgebpx5azhitvdtvz`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`uenmoomtemlvajs7`@`%` PROCEDURE `delete_all_items_of_proformainvoice` (IN `_invoice_id` INT)   BEGIN
	DECLARE _rollback BOOL DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
	START TRANSACTION;   
		/* DELETE EXISTING ITEMS IN PROFORMA */
        SET SQL_SAFE_UPDATES = 0;
        DELETE FROM `proforma_invoiceitems` 
        WHERE `invoice_id`=_invoice_id;
        SET SQL_SAFE_UPDATES = 1;
	IF _rollback THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
    
    /*return 1 means sucess */
    SELECT not(_rollback);
END$$

CREATE DEFINER=`uenmoomtemlvajs7`@`%` PROCEDURE `dispatch_report` (IN `last_distribute_proforma_date_first` DATE, IN `last_distribute_proforma_date_last` DATE, IN `next_distribute_proforma_date_first` DATE, IN `next_distribute_proforma_date_last` DATE)   BEGIN
	DROP TEMPORARY TABLE IF EXISTS temp_tbl0;
	DROP TEMPORARY TABLE IF EXISTS temp_tbl1;
    DROP TEMPORARY TABLE IF EXISTS temp_tbl2;
    DROP TEMPORARY TABLE IF EXISTS temp_tbl3;
    DROP TEMPORARY TABLE IF EXISTS temp_tbl4;
    
	/*This table contains last time perorma (now deleiverd & real invoice made) summery*/
	CREATE TEMPORARY TABLE temp_tbl0 SELECT 
		`proforma_invoiceitems`.`product_name`,
		sum(`proforma_invoiceitems`.`free_i`+`proforma_invoiceitems`.`qty`) as `last_proforma_dispatch`
	FROM `proforma_invoiceitems` 
		LEFT JOIN `proforma_invoice` ON `proforma_invoiceitems`.`invoice_id`=`proforma_invoice`.`invoice_number`
	WHERE 
		(`proforma_invoice`.`invoice_date` BETWEEN last_distribute_proforma_date_first AND last_distribute_proforma_date_last) 
	GROUP BY `proforma_invoiceitems`.`product_name`;
    
    /*This table contains last time real invoice summery*/
	CREATE TEMPORARY TABLE temp_tbl1 SELECT 
		`invoiceitems`.`product_name`,
		sum(`invoiceitems`.`qty`) as `last_invoiced_qty`,
		avg(`invoiceitems`.`rate`) as `last_invoiced_rate`,
		format(sum(`invoiceitems`.`price`),2) as `last_invoiced_sale`,
		sum(`invoiceitems`.`free_i`) as `last_invoiced_free_i`,
		sum(`invoiceitems`.`free_i`+`invoiceitems`.`qty`) as `last_invoiced_distribution`
	FROM `invoiceitems` 
		LEFT JOIN `invoice` ON `invoiceitems`.`invoice_id`=`invoice`.`invoice_number`
		LEFT JOIN `proforma_invoice` ON `invoice`.`invoice_number`=`proforma_invoice`.`invoice_number` 
	WHERE 
		(`proforma_invoice`.`invoice_date` BETWEEN last_distribute_proforma_date_first AND last_distribute_proforma_date_last) 
	GROUP BY `invoiceitems`.`product_name`;
    
    /*This table has this time proforma invice summery*/
	CREATE TEMPORARY TABLE temp_tbl2 SELECT 
		`proforma_invoiceitems`.`product_name`,
		sum(`proforma_invoiceitems`.`qty`) as `next_orders`,
		sum(`proforma_invoiceitems`.`free_i`) as `next_free_i`,
		sum(`proforma_invoiceitems`.`qty`+`proforma_invoiceitems`.`free_i`) as `next_total_order`,
        sum(`proforma_invoiceitems`.`qty`+`proforma_invoiceitems`.`free_i`)*`proforma_invoiceitems`.`rate` as `next_estimated_sale`
	FROM `proforma_invoiceitems`
	LEFT JOIN  `proforma_invoice` ON `proforma_invoiceitems`.`invoice_id`=`proforma_invoice`.`invoice_number` 
	WHERE (`proforma_invoice`.`invoice_date` BETWEEN next_distribute_proforma_date_first AND next_distribute_proforma_date_last) 
    GROUP BY `proforma_invoiceitems`.`product_name`;
    
    CREATE TEMPORARY TABLE temp_tbl3 SELECT
		`product`.`product_name`,
		CEILING(IFNULL(`temp_tbl0`.`last_proforma_dispatch`,0)) as `last_proforma_dispatch`,
		CEILING(IFNULL(`temp_tbl1`.`last_invoiced_qty`,0)) as `last_invoiced_qty`,
		IFNULL(`temp_tbl1`.`last_invoiced_rate`,0) as `last_invoiced_rate`,
		IFNULL(`temp_tbl1`.`last_invoiced_sale`,0) as `last_invoiced_sale`,
		CEILING(IFNULL(`temp_tbl1`.`last_invoiced_free_i`,0)) as `last_invoiced_free_i`,
		CEILING(IFNULL(`temp_tbl1`.`last_invoiced_distribution`,0)) as`last_invoiced_distribution`,
		CEILING(IFNULL(`temp_tbl2`.`next_orders`,0)) as `next_orders`,
		CEILING(IFNULL(`temp_tbl2`.`next_free_i`,0)) as `next_free_i`,
		CEILING(IFNULL(`temp_tbl2`.`next_total_order`,0)) as `next_total_order`,
                
		CEILING(IFNULL(`temp_tbl0`.`last_proforma_dispatch`,0)-IFNULL(`temp_tbl1`.`last_invoiced_distribution`,0)) AS `lorry_qty`,
        CEILING(IFNULL(`temp_tbl2`.`next_total_order`,0)-(IFNULL(`temp_tbl0`.`last_proforma_dispatch`,0)-IFNULL(`temp_tbl1`.`last_invoiced_distribution`,0))) AS `next_dispatch`,
		`temp_tbl2`.`next_estimated_sale` as `next_estimated_sale`
    FROM `product` 
		LEFT JOIN `temp_tbl0` ON `product`.`product_name`=`temp_tbl0`.`product_name`
        LEFT JOIN `temp_tbl1` ON `product`.`product_name`=`temp_tbl1`.`product_name`
        LEFT JOIN `temp_tbl2` ON `product`.`product_name`=`temp_tbl2`.`product_name`;
        
	SELECT * FROM `temp_tbl3`;
END$$

CREATE DEFINER=`uenmoomtemlvajs7`@`%` PROCEDURE `proforma_to_invoice` (IN `invoice_no` INT, IN `inv_date` DATE)   BEGIN
	DECLARE _rollback BOOL DEFAULT 0;
	DECLARE rowCount INT DEFAULT 0;
    DECLARE prodName VARCHAR(100) DEFAULT null;
    DECLARE prodQty INT DEFAULT 0;
	DECLARE i INT DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
	START TRANSACTION;
		/*change date of proforma*/
		UPDATE `proforma_invoice` SET `invoice_date`=inv_date
        WHERE `invoice_number`= invoice_no;
        
		/*create invoice*/
		INSERT INTO `invoice` SELECT * FROM `proforma_invoice`
		WHERE `invoice_number`= invoice_no;
        
        /*delete proforma*/
		DELETE FROM `proforma_invoice` 
        WHERE `invoice_number`= invoice_no;
        
        /*copy proforma items to invoice items*/
        INSERT INTO `invoiceitems` SELECT * FROM `proforma_invoiceitems` 
        WHERE `invoice_id`=invoice_no;
        
        /*delete items from proforma items*/
        SET SQL_SAFE_UPDATES = 0;
        DELETE FROM `proforma_invoiceitems` 
        WHERE `invoice_id`=invoice_no;
        SET SQL_SAFE_UPDATES = 1;
        
        /*get total qty of each item for update inventory*/
        DROP TEMPORARY TABLE IF EXISTS item_issue_qty;
        CREATE TEMPORARY TABLE IF NOT EXISTS item_issue_qty 
        SELECT `product_name`, (`qty`+`free_i`) AS `totqty` 
        FROM `invoiceitems` 
        WHERE `invoice_id`=invoice_no;
        
        /*loop through temp table and update inventory*/
		SELECT COUNT(*) FROM item_issue_qty INTO rowCount;
		SET i=0;
		WHILE i<rowCount DO 
			SELECT `product_name` INTO prodName FROM `item_issue_qty` LIMIT i,1;
            SELECT `totqty` INTO prodQty FROM `item_issue_qty` LIMIT i,1;
			UPDATE `product` SET `stock`=`stock`-prodQty 
            WHERE `product_name`=prodName;
			SET i = i + 1;
		END WHILE;
        
    IF _rollback THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
    
	/*return 1 means sucess */
    SELECT not(_rollback);
END$$

CREATE DEFINER=`uenmoomtemlvajs7`@`%` PROCEDURE `update_proforma_items` (IN `_invoice_id` INT, IN `_product_name` VARCHAR(100), IN `_qty` INT, IN `_rate` FLOAT, IN `_price` FLOAT, IN `_free_i` FLOAT)   BEGIN
	DECLARE _rollback BOOL DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
	START TRANSACTION;       
        /* INSERT AS NEW ITEM */
        insert into `proforma_invoiceitems`(`invoice_id`,`product_name`,`qty`,`rate`,`price`,`free_i`) values 
        (_invoice_id,_product_name,_qty,_rate,_price,_free_i);
        
	IF _rollback THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
    
    /*return 1 means sucess */
    SELECT not(_rollback);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerid` int NOT NULL,
  `customer_name` varchar(100) NOT NULL,
  `customer_address` varchar(256) DEFAULT NULL,
  `customer_vat_no` varchar(50) DEFAULT NULL,
  `customer_route` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerid`, `customer_name`, `customer_address`, `customer_vat_no`, `customer_route`) VALUES
(23, 'Ravi Rami', 'Hardware and Hotel,\nNo.46, Sumudu Uyana,\nHalwthura,\nBulathsinhala.', NULL, 'Rathnapura'),
(24, 'GJKGJGHKHB', NULL, NULL, 'Rathnapura');

-- --------------------------------------------------------

--
-- Table structure for table `customer_route`
--

CREATE TABLE `customer_route` (
  `routeid` int NOT NULL,
  `route` varchar(128) NOT NULL,
  `description` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer_route`
--

INSERT INTO `customer_route` (`routeid`, `route`, `description`) VALUES
(3, 'Horana', NULL),
(4, 'Columbo', NULL),
(5, 'Rathnapura', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoice_autoId` int NOT NULL,
  `invoice_number` int NOT NULL,
  `customer_name` varchar(100) NOT NULL,
  `invoice_date` date NOT NULL,
  `invoice_address` varchar(256) NOT NULL,
  `customer_vat_no` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `invoiceitems`
--

CREATE TABLE `invoiceitems` (
  `item_auto_id` int NOT NULL,
  `invoice_id` int NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `qty` int NOT NULL DEFAULT '0',
  `rate` float NOT NULL DEFAULT '0',
  `price` float NOT NULL DEFAULT '0',
  `free_i` float NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `product_rate` float NOT NULL DEFAULT '0',
  `stock` int NOT NULL DEFAULT '0',
  `product_category` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `product_rate`, `stock`, `product_category`) VALUES
(1, 'Butter Carol 1.5Kg', 0, 100, 'Biscuit'),
(2, 'Butter Carol 110g', 113.75, 200, 'Biscuit'),
(7, 'Butter Carol 270g', 315, 100, 'Biscuit'),
(8, 'Butter Carol 360g ', 385, 50, 'Biscuit'),
(9, 'Butter Carol 450g', 446.25, 0, 'Biscuit'),
(10, 'Golden Cow 70g [Ori]', 302.6, 0, 'Biscuit'),
(11, 'Golden Cow 70 [B]', 302.6, 0, 'Biscuit'),
(12, 'Golden Cow 70 [A]', 302.6, 10, 'Biscuit'),
(13, 'Golden Cow 110g [Ori]', 409.4, 0, 'Biscuit'),
(14, 'Golden Cow 110g [B]', 409.4, 0, 'Biscuit'),
(15, 'Golden Cow 110g [A]', 409.4, 0, 'Biscuit'),
(16, 'Milky Cookies 200g', 280, 0, 'Biscuit'),
(17, 'Milky Cookies 400g', 481.25, 0, 'Biscuit'),
(18, 'Lincon', 0, 0, 'Biscuit'),
(19, 'Lincon 270g', 0, 0, 'Biscuit'),
(20, 'Ginger Cookies 175g', 236.25, 0, 'Biscuit'),
(21, 'Choco Chip Cookies 75g', 166.25, 0, 'Biscuit'),
(22, 'Choco Cookies 180g', 315, 0, 'Biscuit'),
(23, 'Choco Cookies 300g', 516.25, 0, 'Biscuit'),
(24, 'Real Shorties 260g', 245, 0, 'Biscuit'),
(25, 'Marie Cookies 240g ', 245, 0, 'Biscuit'),
(26, 'Chocalate Cake ', 507.4, 0, 'Cake'),
(27, 'Madeira Cake', 498.8, 0, 'Cake'),
(28, 'Date Cake', 593.4, 0, 'Cake'),
(29, 'Friut Cake', 584.8, 0, 'Cake'),
(30, 'Swiss-Roll-Cho 200g', 406.7, 0, 'Cake'),
(31, 'SoftLog Cake [V] ', 332.5, 0, 'Cake'),
(32, 'SoftLog Cake  [L}', 332.5, 0, 'Cake'),
(33, 'SoftLog Cake [S]', 332.5, 0, 'Cake'),
(34, 'SoftLog Cake [C]', 332.5, 0, 'Biscuit'),
(35, 'Wafers 100g [v]', 123.2, 0, 'Biscuit'),
(36, 'Wafers 100g [cho]', 123.2, 0, 'Biscuit'),
(37, 'Wafers 100g [S/B]', 123.2, 0, 'Biscuit'),
(38, 'Wafers 100g [K/K]', 123.2, 0, 'Biscuit'),
(39, 'Wafers 250g [V]', 308, 0, 'Biscuit'),
(40, 'Wafers 250g [Cho]', 308, 0, 'Biscuit'),
(41, 'Wafers 250g [K/K]', 308, 0, 'Biscuit'),
(42, 'Wafers 250g [Cho/V]', 308, 0, 'Biscuit'),
(43, 'Wafers 400g [V]', 501.6, 0, 'Biscuit'),
(44, 'Wafers 400g [Cho]', 501.6, 0, 'Biscuit'),
(45, 'Wafers 400g [K/K]', 501.6, 0, 'Biscuit'),
(46, 'Wafers 400g [Cho/V]', 501.6, 0, 'Biscuit'),
(47, 'Vanila cookies 65g', 78.75, 0, 'Biscuit'),
(48, 'Vanila Cookies 150g', 166.25, 0, 'Biscuit');

-- --------------------------------------------------------

--
-- Table structure for table `product_category`
--

CREATE TABLE `product_category` (
  `category_id` int NOT NULL,
  `category_name` varchar(64) NOT NULL,
  `discount_rate` float DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_category`
--

INSERT INTO `product_category` (`category_id`, `category_name`, `discount_rate`) VALUES
(1, 'Biscuit', 4),
(2, 'Cake', 0);

-- --------------------------------------------------------

--
-- Table structure for table `proforma_invoice`
--

CREATE TABLE `proforma_invoice` (
  `invoice_autoId` int NOT NULL,
  `invoice_number` int NOT NULL,
  `customer_name` varchar(100) NOT NULL,
  `invoice_date` date NOT NULL,
  `invoice_address` varchar(256) NOT NULL,
  `customer_vat_no` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `proforma_invoiceitems`
--

CREATE TABLE `proforma_invoiceitems` (
  `item_auto_id` int NOT NULL,
  `invoice_id` int NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `qty` int NOT NULL DEFAULT '0',
  `rate` float NOT NULL DEFAULT '0',
  `price` float NOT NULL DEFAULT '0',
  `free_i` float NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userid` int NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(256) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telephone` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userid`, `username`, `password`, `email`, `telephone`) VALUES
(1, 'admin', 'd4be514b6109328073cdc8f8c87a58aea01b8798', 'mail.harshana.lk@gmail.com', '+94773270038'),
(2, 'user', '5d4d477ddde97ca95454cfae6b998cbf7e8fd913', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerid`),
  ADD UNIQUE KEY `customer_name` (`customer_name`),
  ADD UNIQUE KEY `customer_vat_no` (`customer_vat_no`);

--
-- Indexes for table `customer_route`
--
ALTER TABLE `customer_route`
  ADD PRIMARY KEY (`routeid`),
  ADD UNIQUE KEY `route` (`route`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoice_autoId`),
  ADD UNIQUE KEY `invoice_number` (`invoice_number`);

--
-- Indexes for table `invoiceitems`
--
ALTER TABLE `invoiceitems`
  ADD PRIMARY KEY (`item_auto_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD UNIQUE KEY `product_name` (`product_name`);

--
-- Indexes for table `product_category`
--
ALTER TABLE `product_category`
  ADD PRIMARY KEY (`category_id`),
  ADD UNIQUE KEY `category_name` (`category_name`);

--
-- Indexes for table `proforma_invoice`
--
ALTER TABLE `proforma_invoice`
  ADD PRIMARY KEY (`invoice_autoId`),
  ADD UNIQUE KEY `invoice_number` (`invoice_number`);

--
-- Indexes for table `proforma_invoiceitems`
--
ALTER TABLE `proforma_invoiceitems`
  ADD PRIMARY KEY (`item_auto_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `telephone` (`telephone`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customerid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `customer_route`
--
ALTER TABLE `customer_route`
  MODIFY `routeid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `invoice_autoId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `invoiceitems`
--
ALTER TABLE `invoiceitems`
  MODIFY `item_auto_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `product_category`
--
ALTER TABLE `product_category`
  MODIFY `category_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `proforma_invoice`
--
ALTER TABLE `proforma_invoice`
  MODIFY `invoice_autoId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `proforma_invoiceitems`
--
ALTER TABLE `proforma_invoiceitems`
  MODIFY `item_auto_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

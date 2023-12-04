-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: b4kqgebpx5azhitvdtvz-mysql.services.clever-cloud.com:3306
-- Generation Time: Apr 10, 2023 at 01:46 PM
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
CREATE DEFINER=`uenmoomtemlvajs7`@`%` PROCEDURE `bulk_dispatch` (IN `firstOrderNo` INT, IN `lastOrderNo` INT)   BEGIN
	DECLARE _rollback BOOL DEFAULT 0;
	DECLARE rowCount INT DEFAULT 0;
    DECLARE i INT DEFAULT 0;
    DECLARE dispatch INT DEFAULT 0;
    DECLARE prod VARCHAR(100) DEFAULT null;
    
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
	START TRANSACTION;
		DROP TEMPORARY TABLE IF EXISTS temp_tbl0;
		DROP TEMPORARY TABLE IF EXISTS temp_tbl1;
		
		/*Get sum of order qty with free issues */
		CREATE TEMPORARY TABLE temp_tbl0
		SELECT `product_name`, sum(`qty`+`free_i`) AS `qty`
		FROM `proforma_invoiceitems`
		WHERE `invoice_id` BETWEEN firstOrderNo AND lastOrderNo
		GROUP BY `product_name`;
		
		/*Get Qty need to dispach with respect to vehicle stock*/
		CREATE TEMPORARY TABLE temp_tbl1
		SELECT `temp_tbl0`.`product_name`,`product`.`vehicle_stock`,`temp_tbl0`.`qty`,
		`temp_tbl0`.`qty`-`product`.`vehicle_stock` AS `next_dispatch`
		FROM `temp_tbl0` LEFT JOIN `product`
		ON `temp_tbl0`.`product_name`=`product`.`product_name`;
		 
		/*loop through temp table and update stock to move items from stock to vehicle*/
		SELECT COUNT(*) FROM temp_tbl1 INTO rowCount;
		SET i=0;
		WHILE i<rowCount DO 
			SELECT `next_dispatch` INTO dispatch FROM `temp_tbl1` LIMIT i,1;
			SELECT `product_name` INTO prod FROM `temp_tbl1` LIMIT i,1;
			UPDATE `product` SET `stock`=`stock`-dispatch, `vehicle_stock`=`vehicle_stock`+dispatch
			WHERE `product_name`=prod;
			SET i = i + 1;
		END WHILE;
	IF _rollback THEN
        ROLLBACK;
    ELSE
        COMMIT;
        
		/*Give  Results for PDF */
		SELECT * FROM temp_tbl1;
    END IF;
END$$

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

CREATE DEFINER=`uenmoomtemlvajs7`@`%` PROCEDURE `dispatch_guide` (IN `firstOrderNo` INT, IN `lastOrderNo` INT)   BEGIN
	DECLARE _rollback BOOL DEFAULT 0;
	DECLARE rowCount INT DEFAULT 0;
    DECLARE i INT DEFAULT 0;
    DECLARE dispatch INT DEFAULT 0;
    DECLARE prod VARCHAR(100) DEFAULT null;
    
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
	START TRANSACTION;
		DROP TEMPORARY TABLE IF EXISTS temp_tbl0;
		DROP TEMPORARY TABLE IF EXISTS temp_tbl1;
		
		/*Get sum of order qty with free issues */
		CREATE TEMPORARY TABLE temp_tbl0
		SELECT `product_name`, sum(`qty`+`free_i`) AS `qty`
		FROM `proforma_invoiceitems`
		WHERE `invoice_id` BETWEEN firstOrderNo AND lastOrderNo
		GROUP BY `product_name`;
		
		/*Get Qty need to dispach with respect to vehicle stock*/
		CREATE TEMPORARY TABLE temp_tbl1
		SELECT `temp_tbl0`.`product_name`,`product`.`vehicle_stock`,`temp_tbl0`.`qty`,
		`temp_tbl0`.`qty`-`product`.`vehicle_stock` AS `next_dispatch`
		FROM `temp_tbl0` LEFT JOIN `product`
		ON `temp_tbl0`.`product_name`=`product`.`product_name`;
		 
		/*loop through temp table and update stock to move items from stock to vehicle*/
		SELECT COUNT(*) FROM temp_tbl1 INTO rowCount;
		SET i=0;
		WHILE i<rowCount DO 
			SELECT `next_dispatch` INTO dispatch FROM `temp_tbl1` LIMIT i,1;
			SELECT `product_name` INTO prod FROM `temp_tbl1` LIMIT i,1;
			UPDATE `product` SET `stock`=`stock`-dispatch, `vehicle_stock`=`vehicle_stock`+dispatch
			WHERE `product_name`=prod;
			SET i = i + 1;
		END WHILE;
	IF _rollback THEN
        ROLLBACK;
    ELSE
        COMMIT;
        
		/*Give  Results for PDF */
		SELECT * FROM temp_tbl1;
    END IF;
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
			UPDATE `product` SET `vehicle_stock`=`vehicle_stock`-prodQty 
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
  `customer_vat_no` varchar(50) NOT NULL,
  `discount_amount` float NOT NULL DEFAULT '0',
  `total_amount` float NOT NULL DEFAULT '0',
  `discounted_amount` float NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoice_autoId`, `invoice_number`, `customer_name`, `invoice_date`, `invoice_address`, `customer_vat_no`, `discount_amount`, `total_amount`, `discounted_amount`) VALUES
(28, 16575, 'Ravi Rami', '2023-04-09', 'Hardware and Hotel,\nNo.46, Sumudu Uyana,\nHalwthura,\nBulathsinhala.', '', 2558.33, 63958.2, 61399.9),
(30, 16577, 'Ravi Rami', '2023-04-09', 'Hardware and Hotel,\nNo.46, Sumudu Uyana,\nHalwthura,\nBulathsinhala.', '', 191.632, 11103.8, 10912.2),
(32, 16579, '', '2023-04-09', '', '', 0, 11353, 11353);

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

--
-- Dumping data for table `invoiceitems`
--

INSERT INTO `invoiceitems` (`item_auto_id`, `invoice_id`, `product_name`, `qty`, `rate`, `price`, `free_i`) VALUES
(86, 16575, 'Golden Cow 70g [Ori]', 100, 302.6, 30260, 0),
(87, 16575, 'Butter Carol 450g', 40, 446.25, 17850, 0),
(88, 16575, 'Golden Cow 70 [B]', 45, 302.6, 13617, 45),
(94, 16577, 'Butter Carol 360g ', 10, 385, 3850, 2),
(95, 16577, 'Chocalate Cake ', 3, 507.4, 1522.2, 0),
(98, 16579, 'Butter Carol 110g', 20, 113.75, 2275, 5),
(99, 16579, 'Golden Cow 70 [B]', 30, 302.6, 9078, 0);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `product_rate` float NOT NULL DEFAULT '0',
  `stock` int NOT NULL DEFAULT '0',
  `product_category` varchar(64) NOT NULL,
  `vehicle_stock` int NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `product_rate`, `stock`, `product_category`, `vehicle_stock`) VALUES
(1, 'Butter Carol 1.5Kg', 0, 0, 'Biscuit', 0),
(2, 'Butter Carol 110g', 113.75, 180, 'Biscuit', 0),
(7, 'Butter Carol 270g', 315, 0, 'Biscuit', 0),
(8, 'Butter Carol 360g ', 385, 0, 'Biscuit', 0),
(9, 'Butter Carol 450g', 446.25, 0, 'Biscuit', 0),
(10, 'Golden Cow 70g [Ori]', 302.6, 0, 'Biscuit', 0),
(11, 'Golden Cow 70 [B]', 302.6, 62, 'Biscuit', 0),
(12, 'Golden Cow 70 [A]', 302.6, 0, 'Biscuit', 0),
(13, 'Golden Cow 110g [Ori]', 409.4, 0, 'Biscuit', 0),
(14, 'Golden Cow 110g [B]', 409.4, 0, 'Biscuit', 0),
(15, 'Golden Cow 110g [A]', 409.4, 0, 'Biscuit', 0),
(16, 'Milky Cookies 200g', 280, 0, 'Biscuit', 0),
(17, 'Milky Cookies 400g', 481.25, 0, 'Biscuit', 0),
(18, 'Lincon', 0, 0, 'Biscuit', 0),
(19, 'Lincon 270g', 0, 0, 'Biscuit', 0),
(20, 'Ginger Cookies 175g', 236.25, 0, 'Biscuit', 0),
(21, 'Choco Chip Cookies 75g', 166.25, 0, 'Biscuit', 0),
(22, 'Choco Cookies 180g', 315, 0, 'Biscuit', 0),
(23, 'Choco Cookies 300g', 516.25, 0, 'Biscuit', 0),
(24, 'Real Shorties 260g', 245, 0, 'Biscuit', 0),
(25, 'Marie Cookies 240g ', 245, 0, 'Biscuit', 0),
(26, 'Chocalate Cake ', 507.4, 0, 'Cake', 0),
(27, 'Madeira Cake', 498.8, 0, 'Cake', 0),
(28, 'Date Cake', 593.4, 0, 'Cake', 0),
(29, 'Friut Cake', 584.8, 0, 'Cake', 0),
(30, 'Swiss-Roll-Cho 200g', 406.7, 0, 'Cake', 0),
(31, 'SoftLog Cake [V] ', 332.5, 0, 'Cake', 0),
(32, 'SoftLog Cake  [L}', 332.5, 0, 'Cake', 0),
(33, 'SoftLog Cake [S]', 332.5, 0, 'Cake', 0),
(34, 'SoftLog Cake [C]', 332.5, 0, 'Cake', 0),
(35, 'Wafers 100g [v]', 123.2, 0, 'Biscuit', 0),
(36, 'Wafers 100g [cho]', 123.2, 0, 'Biscuit', 0),
(37, 'Wafers 100g [S/B]', 123.2, 0, 'Biscuit', 0),
(38, 'Wafers 100g [K/K]', 123.2, 0, 'Biscuit', 0),
(39, 'Wafers 250g [V]', 308, 0, 'Biscuit', 0),
(40, 'Wafers 250g [Cho]', 308, 0, 'Biscuit', 0),
(41, 'Wafers 250g [K/K]', 308, 0, 'Biscuit', 0),
(42, 'Wafers 250g [Cho/V]', 308, 0, 'Biscuit', 0),
(43, 'Wafers 400g [V]', 501.6, 0, 'Biscuit', 0),
(44, 'Wafers 400g [Cho]', 501.6, 0, 'Biscuit', 0),
(45, 'Wafers 400g [K/K]', 501.6, 0, 'Biscuit', 0),
(46, 'Wafers 400g [Cho/V]', 501.6, 0, 'Biscuit', 0),
(47, 'Vanila cookies 65g', 78.75, 0, 'Biscuit', 0),
(48, 'Vanila Cookies 150g', 166.25, 0, 'Biscuit', 0);

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
  `customer_vat_no` varchar(50) NOT NULL,
  `discount_amount` float NOT NULL DEFAULT '0',
  `total_amount` float NOT NULL DEFAULT '0',
  `discounted_amount` float NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `proforma_invoice`
--

INSERT INTO `proforma_invoice` (`invoice_autoId`, `invoice_number`, `customer_name`, `invoice_date`, `invoice_address`, `customer_vat_no`, `discount_amount`, `total_amount`, `discounted_amount`) VALUES
(29, 16576, 'Ravi Rami', '2023-04-09', 'Hardware and Hotel,\nNo.46, Sumudu Uyana,\nHalwthura,\nBulathsinhala.', '', 838.1, 8381, 7542.9),
(31, 16578, '', '2023-04-09', '', '', 0, 0, 0),
(33, 16580, 'Ravi Rami', '2023-04-10', 'Hardware and Hotel,\nNo.46, Sumudu Uyana,\nHalwthura,\nBulathsinhala.', '', 60.52, 3026, 2965.48);

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

--
-- Dumping data for table `proforma_invoiceitems`
--

INSERT INTO `proforma_invoiceitems` (`item_auto_id`, `invoice_id`, `product_name`, `qty`, `rate`, `price`, `free_i`) VALUES
(89, 16576, 'Butter Carol 450g', 12, 446.25, 5355, 2),
(90, 16576, 'Golden Cow 70 [B]', 10, 302.6, 3026, 0),
(96, 16578, 'Butter Carol 110g', 20, 113.75, 2275, 5),
(97, 16578, 'Golden Cow 70 [B]', 30, 302.6, 9078, 0),
(100, 16580, 'Golden Cow 70 [A]', 10, 302.6, 3026, 0);

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
  MODIFY `invoice_autoId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `invoiceitems`
--
ALTER TABLE `invoiceitems`
  MODIFY `item_auto_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100;

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
  MODIFY `invoice_autoId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `proforma_invoiceitems`
--
ALTER TABLE `proforma_invoiceitems`
  MODIFY `item_auto_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

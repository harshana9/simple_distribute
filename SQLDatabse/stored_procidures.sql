CREATE DEFINER=`uenmoomtemlvajs7`@`%` PROCEDURE `dispatch_report`(
	IN last_distribute_proforma_date_first DATE,
    IN last_distribute_proforma_date_last DATE,
    IN next_distribute_proforma_date_first DATE,
    IN next_distribute_proforma_date_last DATE
)
BEGIN
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
		sum(`proforma_invoiceitems`.`qty`+`proforma_invoiceitems`.`free_i`) as `next_total_order`
	FROM `proforma_invoiceitems`
	LEFT JOIN  `proforma_invoice` ON `proforma_invoiceitems`.`invoice_id`=`proforma_invoice`.`invoice_number` 
	WHERE (`proforma_invoice`.`invoice_date` BETWEEN next_distribute_proforma_date_first AND next_distribute_proforma_date_last) 
    GROUP BY `proforma_invoiceitems`.`product_name`;
    
    SELECT
		`product`.`product_name`,
		IFNULL(`temp_tbl0`.`last_proforma_dispatch`,0) as `last_proforma_dispatch`,
		IFNULL(`temp_tbl1`.`last_invoiced_qty`,0) as `last_invoiced_qty`,
		IFNULL(`temp_tbl1`.`last_invoiced_rate`,0) as `last_invoiced_rate`,
		IFNULL(`temp_tbl1`.`last_invoiced_sale`,0) as `last_invoiced_sale`,
		IFNULL(`temp_tbl1`.`last_invoiced_free_i`,0) as `last_invoiced_free_i`,
		IFNULL(`temp_tbl1`.`last_invoiced_distribution`,0) as`last_invoiced_distribution`,
		IFNULL(`temp_tbl2`.`next_orders`,0) as `next_orders`,
		IFNULL(`temp_tbl2`.`next_free_i`,0) as `next_free_i`,
		IFNULL(`temp_tbl2`.`next_total_order`,0) as `next_total_order`,
                
		IFNULL(`temp_tbl0`.`last_proforma_dispatch`,0)-IFNULL(`temp_tbl1`.`last_invoiced_distribution`,0) AS `lorry_qty`,
        IFNULL(`temp_tbl2`.`next_total_order`,0)-(IFNULL(`temp_tbl0`.`last_proforma_dispatch`,0)-IFNULL(`temp_tbl1`.`last_invoiced_distribution`,0)) AS `next_dispatch`
    FROM `product` 
		LEFT JOIN `temp_tbl0` ON `product`.`product_name`=`temp_tbl0`.`product_name`
        LEFT JOIN `temp_tbl1` ON `product`.`product_name`=`temp_tbl1`.`product_name`
        LEFT JOIN `temp_tbl2` ON `product`.`product_name`=`temp_tbl2`.`product_name`;
END
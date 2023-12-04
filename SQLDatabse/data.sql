use b4kqgebpx5azhitvdtvz;

INSERT INTO `product` (`product_name`, `product_rate`) VALUES
('Butter Carol 1.5Kg', 0),
('Butter Carol 110g', 113.75),
('Butter Carol 360g X 4', 0),
('Butter Carol 360g X 8', 0),
('Butter Carol 450g', 0);

SELECT `product_id` INTO @p_id FROM `product` WHERE `product_name`='Butter Carol 1.5Kg';
UPDATE `product` SET `product_rate`='10.5' WHERE `product_id`=@p_id;
SELECT * from `invoice`;
drop table invoiceitems;
ALTER TABLE invoice DROP COLUMN m_s;

show tables;
select * from invoiceitems;
select * from proforma_invoiceitems;
select * from invoice;
select * from proforma_invoice;
select * from product;
select * from `inventory_enrty`;
SELECT `inventory_enrty_id` FROM `inventory_enrty` ORDER BY `date` DESC LIMIT 1;

ALTER TABLE invoice RENAME COLUMN invoice_adress TO invoice_address;

insert into `invoiceitems`(`invoice_id`,`product_id`,`qty`,`rate`,`free_i`)
	values();
insert into `invoice`(`invoice_number`,`customer_name`,`invoice_date`,`invoice_address`,`customer_vat_no`) values('464566','Test Store','2023-02-27','Horana','TN12334');

select count(host) from information_schema.processlist;
show status where variable_name = 'threads_connected';

delete from invoice where invoice_number>0;
delete from invoiceitems where item_auto_id>0;

SELECT `product_name`,sum(`qty`) as `qty`,avg(`rate`) as `rate`,format(sum(`price`),2) as `price`,sum(`free_i`) as `free_i` FROM `invoiceitems` LEFT JOIN `invoice` ON `invoiceitems`.`invoice_id`=`invoice`.`invoice_number` WHERE (`invoice`.`invoice_date` BETWEEN '2023-03-04' AND '2023-03-05') GROUP BY `invoiceitems`.`product_name`;

DROP TEMPORARY TABLE IF EXISTS temp_tbl1;
CREATE TEMPORARY TABLE temp_tbl1 SELECT 
	`proforma_invoiceitems`.`product_name`,
    sum(`invoiceitems`.`qty`) as `last_invoiced_qty`,
    avg(`invoiceitems`.`rate`) as `last_invoiced_rate`,
    format(sum(`invoiceitems`.`price`),2) as `last_invoiced_sale`,
    sum(`invoiceitems`.`free_i`) as `last_invoiced_free_i`,
    sum(`invoiceitems`.`free_i`+`invoiceitems`.`qty`) as `last_invoiced_distribution`,
    sum(`proforma_invoiceitems`.`free_i`+`proforma_invoiceitems`.`qty`) as `last_proforma_dispatch`,
    sum((`proforma_invoiceitems`.`free_i`+`proforma_invoiceitems`.`qty`)-(`invoiceitems`.`free_i`+`invoiceitems`.`qty`)) as `lorry_qty`
FROM `proforma_invoiceitems` LEFT JOIN `proforma_invoice` ON `proforma_invoiceitems`.`invoice_id`=`proforma_invoice`.`invoice_number`
LEFT JOIN `invoiceitems` ON `proforma_invoiceitems`.`product_name`=`invoiceitems`.`product_name` 
LEFT JOIN `invoice` ON `proforma_invoice`.`invoice_number`=`invoice`.`invoice_number` 
WHERE (`proforma_invoice`.`invoice_date` BETWEEN '2023-03-06' AND '2023-03-06') GROUP BY `proforma_invoiceitems`.`product_name`;
SELECT `temp_tbl1`.`product_name`,`temp_tbl1`.`last_invoiced_qty`,`temp_tbl1`.`last_invoiced_rate`,`temp_tbl1`.`last_invoiced_sale`,`temp_tbl1`.`last_invoiced_free_i`,`temp_tbl1`.`last_invoiced_distribution`,`temp_tbl1`.`last_proforma_dispatch`,`temp_tbl1`.`lorry_qty`, 
sum(`proforma_invoiceitems`.`qty`) as `next_orders`,sum(`proforma_invoiceitems`.`free_i`) as `next_free_i`,sum(`proforma_invoiceitems`.`qty`+`proforma_invoiceitems`.`free_i`) as `next_total_order`, sum(`proforma_invoiceitems`.`qty`+`proforma_invoiceitems`.`free_i`-`temp_tbl1`.`lorry_qty`) as `next_dispatch` 
FROM `proforma_invoiceitems` LEFT JOIN  `proforma_invoice` ON `proforma_invoiceitems`.`invoice_id`=`proforma_invoice`.`invoice_number` 
LEFT JOIN `temp_tbl1` ON `proforma_invoiceitems`.`product_name`=`temp_tbl1`.`product_name` 
WHERE (`proforma_invoice`.`invoice_date` BETWEEN '2023-03-07' AND '2023-03-07') GROUP BY `proforma_invoiceitems`.`product_name`;

dispatch_reportdispatch_reportCALL dispatch_report('2023-03-06','2023-03-06','2023-03-07','2023-03-07');
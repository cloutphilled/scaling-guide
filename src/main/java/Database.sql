select customer_id, first_name, last_name, country, postal_code, phone, email from customer;
select customer_id, first_name, last_name, country, postal_code, phone, email from customer where customer_id in (1);
select customer_id, first_name, last_name, country, postal_code, phone, email from customer where first_name LIKE 'L%';
select customer_id, first_name, last_name, country, postal_code, phone, email from customer order by customer_id limit 10 offset 20];
insert into customer(customer_id, first_name, last_name, country, postal_code, phone, email) values (10000, 'Peter', 'Hansen', 'Denmark', 123, 122356, '@');
update customer set first_name = 'banana' where customer_id = 1;
select max(country) from customer;
select invoice_id, customer_id, total from invoice where total = (select max(total) from invoice);
--select customer_id, first_name, last_name, country, postal_code, phone, email from customer where exists (select * from invoice where total = (select max(total) from invoice) order by total);
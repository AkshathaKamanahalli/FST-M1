--Activity 6 In this activity we will be sorting data from a table

-- Create a table named orders

create table orders(
    order_no int primary key, purchase_amount float, order_date date,
    customer_id int, salesman_id int);
Describe orders;

-- Add values to the table

INSERT ALL
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005)
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001)
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003)
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002)
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001)
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001)
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006)
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003)
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002)
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007)
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001)
SELECT 1 FROM DUAL;

SELECT * from orders;

--Activity 6 :Sorting and Filtering of values

--Get all salesman ids without any repeated values
SELECT DISTINCT salesman_id from orders;

--Display the order number ordered by date in ascending order
SELECT order_no,order_date from orders ORDER By order_date ASC;

--Display the order number ordered by purchase amount in descending order
SELECT order_no,purchase_amount from orders ORDER By purchase_amount DESC;

--Display the full data of orders that have purchase amount less than 500.
SELECT * from orders where purchase_amount < 500 order by purchase_amount ASC;

--Display the full data of orders that have purchase amount between 1000 and 2000.
SELECT * from orders where purchase_amount between 1000 and 2000;


SELECT * from orders;


--Activity 7:Using the orders table to perform aggregate operations using the set operators.


--Write an SQL statement to find the total purchase amount of all orders.
    select SUM(purchase_amount) As "Total Sum" from orders;

--Write an SQL statement to find the average purchase amount of all orders.
    select AVG(purchase_amount) As Avgerage_Amt from orders;

--Write an SQL statement to get the maximum purchase amount of all the orders.
    select MAX(purchase_amount) As Maximim_Amt from orders;

--Write an SQL statement to get the minimum purchase amount of all the orders.
    select MIN(purchase_amount) AS Minimum_Amt from orders;

--Write an SQL statement to find the number of salesmen listed in the table.
    select count(distinct salesman_id) As "Total Count" from orders;

--Activity 8:Aggregate operations using GROUP BY.

-- Write an SQL statement to find the highest purchase amount ordered by the each customer with their ID and highest purchase amount.
    select customer_id , MAX( purchase_amount) from orders group by customer_id order by customer_id;
    
--Write an SQL statement to find the highest purchase amount on '2012-08-17' for each salesman with their ID.
    SELECT salesman_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id, order_date;
    
--Write an SQL statement to find the highest purchase amount with their ID and order date, for only those customers who have a higher purchase amount within the list [2030, 3450, 5760, 6000].
    SELECT customer_id, order_date, MAX(purchase_amount)
    FROM orders
    GROUP BY customer_id, order_date
    HAVING MAX(purchase_amount) IN(2030, 3450, 5760, 6000);


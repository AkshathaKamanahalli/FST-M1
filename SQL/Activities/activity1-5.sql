--Activity 1 : Create the salesman table
CREATE TABLE salesman (salesman_id int PRIMARY KEY,salesman_name varchar(20),salesman_city varchar(20),commission int);
DESCRIBE salesman;

--Activity 2 : Instert Data into Salesman table
INSERT ALL
INTO salesman VALUES ('5001, 'James Hoog', 'New York', 15)
INTO salesman VALUES ('5002, 'Nail Knite', 'Paris', 13)
INTO salesman VALUES ('5005, 'Pit Alex', 'London', 11)
INTO salesman VALUES ('5006, 'McLyon', 'Paris', 14)
INTO salesman VALUES ('5007, 'Paul Adam', 'Rome', 13)
INTO salesman VALUES ('5003, 'Lauson Hen', 'San Jose',12)
SELECT 1 from DUAL;
--To display all the row
SELECT * FROM salesman;

--Activity 3 : Display data from Salesman

--Show data from the salesman_id and salesman_city columns
    select salesman_id,salesman_city from salesman;
--Show data of salesman from Paris
    select * from salesman where salesman_city='Paris';
--Show salesman_id and commission of Paul Adam
    select salesman_id,commission from salesman where salesman_name='Paul Adam'

--Activity 4 :To add a new column to salesman table

Alter TABLE salesman ADD (grade int);
        DESCRIBE salesman;
update salesman set grade=100;

SELECT * FROM salesman;

--Activity 5 -In this activity we will be updating the data in the salesman table.

--Update the grade score of salesmen from Rome to 200.
update salesman set grade=200 where salesman_city='Rome';
--Update the grade score of James Hoog to 300.
update salesman set grade=300 where salesman_name='James Hoog';
--Update the name McLyon to Pierre.
update salesman set salesman_name='Pierre' where salesman_name='McLyon';
--To display all the rows
select * from salesman;
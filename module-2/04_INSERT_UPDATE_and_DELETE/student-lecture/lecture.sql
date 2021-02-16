---------------------------------------------------------------------------------------------------------------------------------------
-- Referential Integrity - Enforcement of the Parent-Dependent relatiohnship
--                         ie. Ensure that every foreign key value has a matching primary key
--
-- Constraints are rules regarding the data that must be complied with:
--
--  NOT NULL - Column must have a value
--
--  UNIQUE   - Column value must be unique with the table 
--
--  PRIMARY KEY - Column is part of the unique identifier for a row in the table
--                UNIQUE and NOT NULL are implied
--
--  FOREIGN KEY - Column is part of a foreign key for the table.  
--                Value must have a matching value in the primary key of the parent table
--                Establishes the parent-dependent relationship
--
--  CHECK  -  Specifies acceptable values for a column - any simple WHERE predicate is allowed
--
--  DEFAULT - Specify a default value for column if no value is supplied on INSER
---------------------------------------------------------------------------------------------------------------------------------------
-- Unit Of Work (UOW) - A recoverable sequence of operations within an application process
--                      all steps to have completed pieces of work have been completed
-- 
-- BEGIN TRANSACTION - Mark the start of a unit of work
-- 
-- COMMIT - End a unit of work and save changes - automatically done if no errors
-- 
-- ROLLBACK - End a unit of work and undo changes - automatically done if errors
---------------------------------------------------------------------------------------------------------------------------------------
--  INSERT - add a row to a table
--
--  Format 1: INSERT INTO table-name 
--            (column-list)           -- must contain all non-null columns
--            VALUES(value-list)      -- order of values must match order of columns specified
--
--
--  Format 2: INSERT INTO table-name 
--            VALUES(value-list)      -- order of values must match order of columns as defined in the table
--
--
--  Format 3: INSERT INTO table-name 
--            (SELECT statement)      -- order of columns in the SELECT must match the order of columns as defined in the table
--                                    -- () are optional
--                                            
---------------------------------------------------------------------------------------------------------------------------------------
--  UPDATE - change data in a table
--
--  UPDATE table-name
--  SET column = new-value
--  WHERE condition            -- scope of update - if omitted, all rows are updated                                         
---------------------------------------------------------------------------------------------------------------------------------------
--  DELETE - Remove rows from a table
--
--  DELETE FROM table-name
--  WHERE condition            -- scope of delete - if omitted, all rows are deleted                                        
---------------------------------------------------------------------------------------------------------------------------------------
-- INSERT

-- 1. Add Klingon as a spoken language in the USA

--delete from countrylanguage where language = 'Klingon';

Begin transaction;   -- start a unit of work - in case something goes wrong, we undo/roll back and start over

-- The safest way (fewer opportunities for errors) is to inclue the column list in the INSERT

insert into countrylanguage                          -- add a row to the country language table
(countrycode, language, isofficial, percentage)      -- list of columns we are providing values for - all the non-null columns
values('USA', 'Klingon', true, 16)                   -- values for the columns in the order of the list above
;

--insert into countrylanguage                          -- add a row to the country language table
--(language, countrycode, isofficial, percentage)      -- list of columns we are providing values for - all the non-null columns
--values('Klingon', 'USA', true, 16)                   -- values for the columns in the order of the list above
--;

-- into countrylanguage                          -- add a row to the country language table
--values('USA', 'Klingon', true, 16)                   -- values for the columns in the order of definition for the table
--;
-- Optionally, we can do a select to make sure the insert worked
-- Since we are doing a rollback, we cannot look at the table after we run to see if the insert worked
select * 
 from countrylanguage
where countrycode = 'USA'
;

Rollback;  -- undo the changes in this unit of work until we are sure that they are done correctly
-- 2. Add Klingon as a spoken language in Great Britain

Begin transaction;
insert into countrylanguage
(countrycode, language, isofficial, percentage)      -- list of columns we are providing values for - all the non-null columns
values('GBR', 'Klingon', true, 36)                   -- values for the columns in the order of the list above
;

select * 
 from countrylanguage
where language = 'Klingon'
;
rollback;

-- UPDATE

-- 1. Update the capital of the US  A to Houston
begin transaction;

update country
   set capital = (select id from city where name = 'Houston') -- look up the ID for Houston in the city table and use it to set the capital
 where code = 'USA'  -- limit the update to just rows with the countrycode USA
;

select *
from country
where code = 'USA'
;

rollback;
-- 2. Update the capital of the USA to Washington DC and the head of state

begin transaction;

update country
   set capital = (select id from city where name = 'Washington'), -- code a comma when there is another column to be updated
       headofstate = 'Luke'                                       -- just code column-name = new-value -- do not repeat the set
 where code = 'USA'
            ;
select * from country where code = 'USA'
;
rollback;

-- DELETE

-- 1. Delete English as a spoken language in the USA
begin transaction;

delete from countrylanguage
where countrycode = (select code from country where name = 'United States')
and language = 'English'
;

select *
from countrylanguage
where countrycode = (select code from country where name = 'United States')
;

rollback;

-- 2. Delete all occurrences of the Klingon language 


-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?

-- 3. Try deleting the country USA. What happens?


-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA

-- 2. Try again. What happens?

-- 3. Let's relocate the USA to the continent - 'Outer Space'


-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.

-- 2. Try updating all of the cities to be in the USA and roll it back

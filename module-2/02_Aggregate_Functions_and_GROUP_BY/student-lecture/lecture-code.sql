--------------------------------------------------------------------------------------------------------
-- Ordering, Grouping Basic Functions Lecture Code
--------------------------------------------------------------------------------------------------------
--
-- ORDER BY -  Sequence of Rows in Result
--
--    ORDER BY          -- Ascending Sequence (low-high)
--    ORDER BY ASC      -- Ascending Sequence (low-high)
--    ORDER BY DESC     -- Descending Sequence (high-low)

-- There is no guarantee of the order of the rows in the result without an ORDER BY
-- You can run the same query 1000 times without an ORDER BY, and get the same result
-- The 1001st time might or might not be a different result
--
-- If the order of the rows in the result matter, code an ORDER BY

-- In Standard SQL, the ORDER BY is always last in the query, 
-- (postgreSQL) unless there is a LIMIT clause, which goes last



-- Show Populations of all countries in acscending order
select name, population
from country
order by population; -- if the order of the rows is important, code an ORDER BY
 -- without an ORDER BY, the rows in the result are in whatever order the database gives it to you. It may not be consistent.
 
select name, population
from country
order by population ASC; -- ASC is optional/default

-- Show Populations of all countries in descending order
select name, population
from country
order by population DESC;

-- Show  the n ames of countries and continents in ascending order
select name, continent
from country
order by continent desc, name;  -- to order by multiple columns, code column names separated by commas in the sequence you want them sorted. This will order continents in descending order, and name in ascending order.

select name, continent
from country
order by continent, name desc; -- this will order continents in ascending order, and name in descending order.

--------------------------------------------------------------------------------------------------------
-- Limiting the number of rows in the result
--
-- LIMIT n   - Limit the number of rows in the result - always goes at thE end of the SELECT
--
-- LIMIT is a postgreSQL extension to standard SQL (ANSI - American National Standard Institute, ISO - International Standards Organization)

-- Other database managers limit rows cut call it something different
-- You also have to code it somewhere else

-- LIMIT is always the last in the SELECT

-- Show the name and life expectancy of the countries with the 10 highest life expectancies.
select name, lifeexpectancy
from country
where lifeexpectancy is not null
order by lifeexpectancy desc -- show life expectancies from highest to lowest
limit 10 -- only return the first 10 rows in the result
;

-- Show the name and life expectancy of the countries with the 10 lowest life expectancies.
select name, lifeexpectancy
from country
where lifeexpectancy is not null
order by lifeexpectancy -- show life expectancies from loswest to highest
limit 10 -- only return the first 10 rows in the result
;

--------------------------------------------------------------------------------------------------------
-- Concatenating string/character values 
--
-- the concat operator (||) may be used to concatenate character (string) values in a result
--

-- Show the name & state in the format: "city-name, state"
-- of all cities in California, Oregon, or Washington.
-- sorted by state then city
select name || ', ' || district AS city_state
  from city
 where district = 'California' 
    or district = 'Oregon'
    or district = 'Washington'
-- where district IN('California', 'Oregon', 'Washington');  <<--- can also code it this way
order by district, city
;


--------------------------------------------------------------------------------------------------------
-- Aggregate functions - produce one row in result for each group specified
--                       rather than one row in the result for each row that matches the WHERE clause

-- The group used by the aggregate functions is determined by the GROUP BY clause
-- if no GROUP BY clause is specified, the group is the set of rows in the result
--
--     AVG(column-expression)   - arithmentic average for group of non-NULL values in expression 
--     SUM(column-expression)   - arithmentic sum for group of a non-NULL values in expression 
--     MIN(column-expression)   - lowest value for group of non-NULL values in expression 
--     MAX(column-expression)   - highest value for group of non-NULL values in expression 
--     COUNT(*)(row-expression) - number of rows in the group
--     COUNT(column-expression) - number of rows for the group of non-NULL values in expression 
--
-- When you code a GROUP BY, the only columns allowed on the SELECT are aggregate functions and columns listed in the GROUP BY
--
-- AVG(), SUM() may only bes used with numeric data types
-- MIN(), MAX() may be used with numeric, character, date, time datatypes
--
-- COUNT() is applied to rows (not columns)
--
--
-- Show average life expectancy in the world


-- Show the total population in Ohio


-- Show the surface area of the smallest country in the world


-- Show The 10 largest countries (by surface area) in the world
select name, surfacearea
from country
order by surfacearea desc
limit 10
;

-- Show the number of countries who declared independence in 1991
select count(*) as Number_Countries_Indep_Year_1991
from country
where indepyear = 1991
group by name
;

--------------------------------------------------------------------------------------------------------
-- GROUP BY  - Specify the group to which the aggregate functions apply
--
--      GROUP BY column-expression
--
-- When using a GROUP BY the SELECT is limited ot aggreggate functions or columns in the GROUP BY
--
--

-- Show the number of countries where each language is spoken, order show them from most countries to least
-- number of - count(*)
-- each - group by
select language, count(*)
from countrylanguage
group by language
order by 2 desc;



-- Show the average life expectancy of each continent ordered from highest to lowest
select continent, avg(lifeexpectancy) -- one row in the result with the average life expectancy across all countries
from country
where lifeexpectancy is not null
group by continent
order by 2 desc

;

-- Show average life expectancy in the world for each continent
select continent, avg(lifeexpectancy) as Avg_Life_Expectancy-- one row in the result for each continent the average life expectancy for that continent
  from country
  group by continent -- specify the groups we want for the aggregate function
;

-- Show the total population in Ohio
select sum(population) as Total_People_In_Ohio
from city
where district = 'Ohio'
;

-- Exclude Antarctica from consideration for average life expectancy



-- What is the sum of the population of cities in each state in the USA ordered by state name
select district, avg(population) as population
from city
where countrycode = 'USA'
group by district
order by district;


-- What is the average population of cities in each state in the USA ordered by state name


--------------------------------------------------------------------------------------------------------
-- SUBQUERIES - Using the result from one query (inner query) in another query (outer query)
--
-- Frequently used in a WHERE clause with an IN predicate:
--
--       WHERE column-name IN (SELECT column-name FROM some-table WHERE some-predicate)
--
-- Any WHERE predicate may be used to connect the subquery in a WHERE clause, but you must
-- be sure a single value is returned from the subquery. 
--
-- Subqueries may also be used in a SELECT as a column-specification or a FROM as a table
-- (These are advanced concepts we will discuss later, if there is time)
--
-- Show the cities under the same given government leader


-- Show countries with the same independece year


-- Show the cities cities whose country has not yet declared independence yet


--------------------------------------------------------------------------------------------------------
--
-- Additional samples
--
-- You may alias column and table names to provide more descriptive names
--
SELECT name AS CityName 
  FROM city AS cities

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)
SELECT name
     , population 
  FROM city 
 WHERE countryCode='USA' 
 ORDER BY name ASC, population DESC
;
-- Limiting results allows rows to be returned in 'limited' clusters where LIMIT says how many, 
-- and an optional OFFSET specifies number of rows to skip
SELECT name
     , population 
  FROM city 
  LIMIT 10 OFFSET 10
;
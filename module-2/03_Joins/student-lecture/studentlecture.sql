--
-- Show the country name, city name, district
-- 
-- We need data from more than one table - country table and city table
-- 
-- Whenever you need data from more than one table, you code a join
--
-- A join matches rows between tables based on a join condition
--
-- The join condition defines how rows between the tables should be matched
--
-- If names between the tables are duplicated, you must make them unique using tablename.column-name
--
-- There are two syntax's for coding a join:
--
--      1. Classic syntax - code all the tables on the from, and the join condition on the where clause
--      2. Modern syntax - code the type of join between the table names and the join condition on an ON clause
--
--
------------------------------------------------------------------------------------------------------------------------------
-- Classic Syntax Join (below)
------------------------------------------------------------------------------------------------------------------------------
select country.name, city.name, district    -- columns you want to see in the result
  from country, city                        -- table(s) with the columns you want
where country.code = city.countrycode       -- this is the join condition - we want the rows that match between city and country tables by countrycode
and country.code = 'USA'                    -- filtering condition allowed on the WHERE clause too
;

------------------------------------------------------------------------------------------------------------------------------
-- Modern Syntax Join (below)
------------------------------------------------------------------------------------------------------------------------------
select country.name, city.name, district    -- columns you want in the result
from country                                -- code one of the tables in the join
        inner join                          -- type join - inner join shows matches between the tables based on condition
        countrylanguage                     -- code the other table in the join
        on country.code = city.countrycode  -- this is the join condition - we want the rows that match between city and country tables by countrycode
where country.code = 'USA'
;








-- Subquery Example ---------------------------------------------------------------------------------------------------------


-- List of countries that speak english
-- 
-- The country language table has the country codes that speak each language
--
-- 1. Get a list of country codes that speak English from the countrylanguage table
-- 2. Get the name of the country from the country table if the code in the country table is in the list you just created in number 1.

-- A subquery is where the result of one select is used in another select
-- Used when data from one table is needed to search another table, or data from one table is needed in another
--
-- A subquery may only return one column (a list)
--
-- We needed the country codes from countrylanguage that spoke English to search country table for the names of those countries
--
-- Usually link the queries with an IN due to a list being returned from the subquery
--
-- The subquery is run first and the list returned from it, is plugged into the IN
--
-- You can generally nest up to 32,766 subqueries (more than you will ever need)
--
-- We needed the contrycode from countraylanguage that spoke english to search country table for the names of those countries

select name
from country
where code in (select countrycode               -- list of countrycodes
                  from countrylanguage          -- from countrylanguage table
                  where language = 'English')   -- where the language is English
;
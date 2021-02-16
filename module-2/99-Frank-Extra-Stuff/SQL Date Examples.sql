-- show today's date -- yyyy-mm-dd (European Format)
select current_date as today
;   

-- show today's date in mm/dd/yyyy format - to_char() to format date
select to_char(current_date, 'mm/dd/yyyy') as today
;
-- SQL will let you do date arithmetic - duration between two dates
-- how many days until Christmas this year - subtract two dates to get duration in days
select '12/25/2021' - current_date as day_until_Christmas
;
-- Use date() function to do arithmetic with two literal dates (non-SQL date)
-- be aware of result when calculating days between dates() - date() 
select  date('12/31/2021') - date('12/01/2021')  as days_in_December
;
-- add/subtract human time intervals to dates (and times and timestamps, too)
select to_char((current_date + interval '5 days') , 'mm/dd/yyyy') as five_days_from_now 
     , to_char((current_date + interval '1 month'), 'mm/dd/yyyy') as one_month_from_now
     , to_char((current_date - interval '1 day')  , 'mm/dd/yyyy') as yesterdays_date
     , current_date + interval '2 years' + interval '1 month'     as two_years_and_1_month_from_now
;
--SQL date arithment knows how long months are - date() produces timestamp yyyy-dd-mm hh:mm:ss
select date('10/30/2021') + interval '1 day' as month_w_31_days
      ,date('11/30/2021') + interval '1 day' as month_w_30_days
;
-- SQL date atrithmetic knows about leap years
select date('02/27/2021') + interval '2 days' as non_leap_year
     , date('02/27/2020') + interval '2 days' as leap_year
;

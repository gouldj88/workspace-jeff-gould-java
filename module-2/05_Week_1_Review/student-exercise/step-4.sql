-- select the park name, campground name, open_from_mm, open_to_mm & daily_fee ordered by park name and then campground name
select park.name, campground.name, open_from_mm, open_to_mm, daily_fee
from park
inner join campground
on park.park_id = campground.park_id
order by park.name, campground.name
;

-- select the park name and the total number of campgrounds for each park ordered by park name
select park.name, count(*)
from park
inner join campground
on park.park_id = campground.park_id
group by park.name
order by park.name
;


-- select the park name, campground name, site number, max occupancy, accessible, max rv length, utilities where the campground name is 'Blackwoods'
select park.name as park_name, campground.name as campground_name, site.site_number, site.max_occupancy, site.accessible, site.max_rv_length, site.utilities
from park
inner join campground
on park.park_id = campground.park_id
inner join site
on campground.campground_id = site.campground_id
where campground.name = 'Blackwoods'
;

/*
  select park name, campground, total number of sites (column alias 'number_of_sites') ordered by park
  -------------------------------------------------
    Acadia	Blackwoods	276
    Acadia	Seawall	198
    Acadia	Schoodic Woods	92
    Arches	"Devil's Garden"	49
    Arches	Canyon Wren Group Site	1
    Arches	Juniper Group Site	1
    Cuyahoga Valley	The Unnamed Primitive Campsites	5
  -------------------------------------------------
*/

select park.name, campground.name, count(*) as number_of_sites
from park
inner join campground
on park.park_id = campground.park_id
inner join site
on campground.campground_id = site.campground_id
group by campground.name, park.name
order by park.name, number_of_sites desc
;


-- select site number, reservation name, reservation from and to date ordered by reservation from date
select site_number, reservation.name, from_date, to_date
from site
inner join reservation
on reservation.site_id = site.site_id
order by from_date
;


/*
  select campground name, total number of reservations for each campground ordered by total reservations desc
  -------------------------------------------------
    Seawall	13
    Blackwoods	9
    "Devil's Garden"	7
    Schoodic Woods	7
    The Unnamed Primitive Campsites	5
    Canyon Wren Group Site	4
    Juniper Group Site	4
  -------------------------------------------------
*/

select campground.name, count(*)
from campground
inner join site
on campground.campground_id = site.campground_id
inner join reservation
on site.site_id = reservation.site_id
group by campground.name
order by count desc
;





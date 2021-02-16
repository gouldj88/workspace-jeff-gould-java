-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
begin transaction;
insert into actor (first_name, last_name)
values('HAMPTON', 'AVENUE');

select*
from actor;

rollback;

begin transaction;
insert into actor (first_name, last_name)
values('LISA', 'BYWAY');

select*
from actor;

rollback;


-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.

begin transaction;
insert into film (title, description, release_year, language_id, length)
values('EUCLIDEAN PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 198);

select *
from film;

rollback;

--delete from actor where actor_id = 219;

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.

begin transaction;
insert into film_actor (actor_id, film_id)
values((select actor_id from actor where first_name='HAMPTON'), (select film_id from film where title='EUCLIDEAN PI'));

select *
from film_actor;

-- 4. Add Mathmagical to the category table.
begin transaction;
insert into category (name)
values('Mathmagical');

select *
from category

rollback;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
begin transaction;
insert into film_category (film_id, category_id)
values((select film_id from film where title = 'EGG IGBY'), (select category_id from category where name = 'Mathmagical'));

insert into film_category (film_id, category_id)
values((select film_id from film where title = 'EUCLIDEAN PI'), (select category_id from category where name = 'Mathmagical'));

insert into film_category (film_id, category_id)
values((select film_id from film where title = 'KARATE MOON'), (select category_id from category where name = 'Mathmagical'));

insert into film_category (film_id, category_id)
values((select film_id from film where title = 'RANDOM GO'), (select category_id from category where name = 'Mathmagical'));

insert into film_category (film_id, category_id)
values((select film_id from film where title = 'YOUNG LANGUAGE'), (select category_id from category where name = 'Mathmagical'));

select *
from film_category;

rollback;




-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)
begin transaction;
update film
set rating = 'G'
where title = 'EUCLIDEAN PI';

update film
set rating = 'G'
where title = 'EGG IGBY';

update film
set rating = 'G'
where title = 'KARATE MOON';

update film
set rating = 'G'
where title = 'RANDOM GO';

update film
set rating = 'G'
where title = 'YOUNG LANGUAGE';


select *
from film;

rollback;


-- 7. Add a copy of "Euclidean PI" to all the stores.
begin transaction;
insert into inventory (film_id, store_id)
select(select film_id from film where title = 'EUCLIDEAN PI'),
store_id from store
;

rollback;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
delete from film
where title = 'EUCLIDEAN PI';
-- It failed because film has a relationship with film_actor and inventory

-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
delete from category
where name = 'Mathmagical';
-- If failed because there is a foreign key constraint on the film_category table

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
begin transaction;
delete from film_category
where category_id = (select category_id from category where name = 'Mathmagical');
rollback;
-- Yes it worked because film_category is a child (foreign key) table of the parent table film.



-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- It succeeded because we deleted the foreign key in the film_category table, which removed the contraint from the column
begin transaction;
delete from category
where name = 'Mathmagical';
rollback;

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.

-- All the information associated with Euclidean Pi in the foreign keys of the 
-- film_actor and film_category tables must be deleted before Euclidean PI can be removed from the film table.

  -- Undo all changes so we can run this again successfully
           -- Change to commit when we are absolutely sure we don't ever want to run this again
           -- Doing a commit will save all the dchanges and we cannot re-add some of the data due to unique constraints 
           -- caused by primary keys or we will inser data which is not good either
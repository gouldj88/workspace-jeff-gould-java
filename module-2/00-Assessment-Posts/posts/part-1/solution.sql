-- Select all columns from posts that are published
SELECT * from posts
where published = true
;

-- Select posted_by and body from comments that have a body and were created after Oct. 15, 2019

SELECT first_name || ', ' || last_name as posted_by, body from posts
inner join users
on posts.id = users.id
where posts.created > '2019-10-15'
and posts.body is not null
;


-- Select the name and published states from posts ordered by when they were created, earliest first
SELECT name, published from posts
order by created asc
;

-- Select the created date and the count of all the comments created on that date
SELECT created, count(*) from posts
group by created
;

-- Select the post name, comment posted_by and comment body for all posts created after Oct. 1st, 2019
SELECT name, first_name || ', ' || last_name as posted_by, body from posts
inner join users
on posts.id = users.id
where posts.created > '2019-10-01'
;


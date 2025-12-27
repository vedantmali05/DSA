# Write your MySQL query statement below
DELETE p1 
FROM Person p1
JOIN Person p2
ON p2.email = p1.email AND p1.id > p2.id;
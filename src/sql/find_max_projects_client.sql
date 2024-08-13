SELECT c.name, COUNT(e.client_id) AS frequency
FROM project e
JOIN client c ON e.client_id = c.id
GROUP BY c.name
HAVING frequency = (
    SELECT MAX(frequency)
    FROM (
        SELECT COUNT(client_id) AS frequency
        FROM project
        GROUP BY client_id
    ) AS subquery
);
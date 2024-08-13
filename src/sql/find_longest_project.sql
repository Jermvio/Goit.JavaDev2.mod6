SELECT id, TIMESTAMPDIFF(MONTH, START_DATE, FINISH_DATE) AS length_in_months
FROM project
WHERE TIMESTAMPDIFF(MONTH, START_DATE, FINISH_DATE) = (
        SELECT MAX(length_in_months)
        FROM (
            SELECT TIMESTAMPDIFF(MONTH, START_DATE, FINISH_DATE) AS length_in_months
            FROM project
        ) AS subquery
    );

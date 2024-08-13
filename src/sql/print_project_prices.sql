SELECT
    p.ID AS project_id,
    TIMESTAMPDIFF(MONTH, p.START_DATE, p.FINISH_DATE) * SUM(w.SALARY) AS project_cost
FROM
    project p
    JOIN project_worker pw ON p.ID = pw.PROJECT_ID
    JOIN worker w ON pw.WORKER_ID = w.ID
GROUP BY
    p.ID
ORDER BY
	project_cost DESC
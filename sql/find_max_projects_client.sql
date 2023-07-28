SELECT client.NAME, COUNT(project.ID) AS PROJECT_COUNT
FROM client
JOIN project ON client.ID = project.CLIENT_ID
GROUP BY client.NAME
HAVING COUNT(project.ID) = (
  SELECT MAX(project_count)
  FROM (
    SELECT COUNT(project.ID) AS project_count
    FROM client
    JOIN project ON client.ID = project.CLIENT_ID
    GROUP BY client.NAME
  ) AS project_counts
);
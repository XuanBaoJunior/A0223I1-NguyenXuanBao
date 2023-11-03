use
quanlysinhvien;

SELECT *
FROM Subject
WHERE Credit = (SELECT MAX(Credit) FROM Subject);


SELECT s.SubName, m.Mark
FROM Subject s
         JOIN Mark m ON s.SubId = m.SubId
WHERE m.Mark = (SELECT MAX(Mark) FROM Mark);

SELECT s.StudentName, AVG(m.Mark) AS AverageMark
FROM Student s
         LEFT JOIN Mark m ON s.StudentId = m.StudentId
GROUP BY s.StudentName
ORDER BY AverageMark DESC;


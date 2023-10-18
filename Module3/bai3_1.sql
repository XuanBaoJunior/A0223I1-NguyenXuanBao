use quanlysinhvien;

SELECT *
FROM Student
WHERE StudentName LIKE 'H%';

SELECT *
FROM Class
WHERE MONTH(StartDate) = 12;

SELECT *
FROM Subject
WHERE Credit BETWEEN 3 AND 5;

UPDATE Student
SET ClassId = 2
WHERE StudentName = 'Hung';

SELECT s.StudentName, sb.SubName, m.Mark
FROM Student s
JOIN Mark m ON s.StudentId = m.StudentId
JOIN Subject sb ON m.SubId = sb.SubId
ORDER BY m.Mark DESC, s.StudentName ASC;


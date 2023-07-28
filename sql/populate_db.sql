INSERT INTO worker(ID, name, birthday, level, salary)
VALUES (1, 'Nina Zahoruiko', '1988-03-20', 'Senior', 5900),
 (2, 'Bessy Jewel', '2003-07-09', 'Middle', 2600),
 (3, 'Nightly Jewel', '2006-02-09', 'Junior', 900),
 (4, 'Nicki Jewel', '2006-02-09', 'Junior', 800),
 (5, 'Milo Alloun', '2001-11-07', 'Trainee', 600),
 (6, 'Matis Nanoun', '1991-09-12', 'Trainee', 600),
 (7, 'Cornel Somename', '1996-05-13', 'Middle', 1300),
 (8, 'Iryna Yavorska', '1996-04-09', 'Senior', 5900),
 (9, 'John Doe', '1990-08-15', 'Senior', 6000),
 (10, 'Emma Smith', '1995-02-25', 'Middle', 3000),
 (11, 'Liam Johnson', '1998-12-10', 'Junior', 1200),
 (12, 'Olivia Brown', '1992-06-05', 'Junior', 1000),
 (13, 'William Davis', '1993-04-18', 'Trainee', 700),
 (14, 'Jozel Doe', '1981-03-08', 'Senior', 6000);

INSERT INTO client(ID, name)
VALUES (4, 'Flora'),
       (144, 'Flora'),
       (258, 'Fauna'),
       (546, 'John'),
       (644, 'Emma'),
       (749, 'Liam'),
       (847, 'Olivia'),
       (946, 'William'),
       (105, 'Sophia'),
       (117, 'James'),
       (127, 'Isabella'),
       (134, 'Michael');

INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE)
VALUES (111, 4, '2023-07-01', '2023-07-31'),
	(116, 4, '2023-07-01', '2023-08-31'),
        (117, 4, '2023-07-01', '2023-12-31'),
               (112, 546, '2023-08-01', '2023-08-31'),
               (113, 644, '2023-09-01', '2023-09-30'),
               (114, 749, '2023-10-01', '2023-10-31'),
               (115, 847, '2023-11-01', '2023-11-30');


INSERT INTO PROJECT_WORKER (PROJECT_ID , WORKER_ID )
VALUES (111, 1),
 (111, 8),
 (112, 2),
 (112, 3),
 (112, 4),
 (113, 6),
 (114, 5),
 (114, 7),
 (115, 1),
 (115, 8),
 (115, 10),
 (115, 12);
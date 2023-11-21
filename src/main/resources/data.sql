-- Inserting dummy data for Section table
INSERT INTO section (sec_id, course_id, Lec_id, sec_no) VALUES 
(1, 101, 'LEC001', 1),
(2, 102, 'LEC002', 2),
(3, 103, 'LEC003', 1),
(4, 104, 'LEC004', 3);

-- Inserting dummy data for Lecturer table
INSERT INTO lecturer (lec_email, Lec_id, lec_firstname, lec_lastname, lec_password) VALUES 
('john.lecturer@example.com', 'LEC001', 'John', 'Doe', 'lecturerPass123'),
('jane.lecturer@example.com', 'LEC002', 'Jane', 'Smith', 'lec456' ),
('bob.lecturer@example.com', 'LEC003', 'Bob', 'Johnson', 'secureLecPwd'),
('alice.lecturer@example.com', 'LEC004', 'Alice', 'Williams', 'lec789');

-- Inserting dummy data for Course table
INSERT INTO course (id,course_id, Lec_id, course_name, credit,course_sec) VALUES 
(1,101, 'LEC001', 'Mathematics', 4 ,10),
(2,102, 'LEC002', 'History',3, 5),
(3,103, 'LEC003', 'Physics', 4, 1),
(4,104, 'LEC004', 'Computer Science', 4, 6);

-- Inserting dummy data for Attendance table
INSERT INTO attendance (attendance_id, course_id, sec_id, std_num, date, status, week_no) VALUES 
(1, 101, 1, 1, CURRENT_DATE, 'Present', 1),
(2, 102, 2, 2, CURRENT_DATE, 'Absent', 1),
(3, 103, 1, 3, CURRENT_DATE, 'Present', 1),
(4, 104, 3, 4, CURRENT_DATE, 'Present', 1);

-- Inserting dummy data for AdminC table
INSERT INTO adminc (admin_email, admin_password) VALUES 
('admin@example.com', 'a1');

-- Inserting dummy data for Student table
INSERT INTO student (std_num, std_id, std_firstname, std_lastname, std_email, sec_id, std_password, c_id)
VALUES
  (1, 1001, 'Student1', 'Lastname1', 's1@example.com', 1, 's1', 101),
  (2, 1002, 'Student2', 'Lastname2', 'student2@example.com', 2, 'studentPass2', 102),
  (3, 1003, 'Student3', 'Lastname3', 'student3@example.com', 1, 'studentPass3', 103),
  (4, 1001, 'Student1', 'Lastname1', 'student1@example.com', 1, 'studentPass1', 104),
  (5, 1002, 'Student2', 'Lastname2', 'student2@example.com', 2, 'studentPass2', 101);

-- INSERT INTO ADMIN (ADMIN_ID, ADMIN_NAME) VALUES (01, 'AH PHAR');
-- INSERT INTO ADMIN (ADMIN_ID, ADMIN_NAME) VALUES (02, 'GEORGE');
-- INSERT INTO ADMIN (ADMIN_ID, ADMIN_NAME) VALUES (03, 'SMIZZ');


-- INSERT INTO LECTURER (LEC_ID, FIRST_NAME, LAST_NAME, LEC_EMAIL) VALUES ('L0001','AJARN','NACHA','nacha@lamduan.mfu.ac.th');
-- INSERT INTO LECTURER (LEC_ID, FIRST_NAME, LAST_NAME, LEC_EMAIL) VALUES ('L0002','AJARN','YING','ying@lamduan.mfu.ac.th');
-- INSERT INTO LECTURER (LEC_ID, FIRST_NAME, LAST_NAME, LEC_EMAIL) VALUES ('L0003','AJARN','SIRAK','sirak@lamduan.mfu.ac.th');
-- INSERT INTO LECTURER (LEC_ID, FIRST_NAME, LAST_NAME, LEC_EMAIL) VALUES ('L0004','AJARN','BONJOUR','bonjour@lamduan.mfu.ac.th');


-- INSERT INTO STUDENT (STD_NUM, STD_ID, FIRST_NAME, LAST_NAME, STD_EMAIL, SEC_ID) VALUES (1, 6531503132, 'AH','PHAR','6531503132@Lamduan.mfu.ac.th','1');
-- INSERT INTO STUDENT (STD_NUM, STD_ID, FIRST_NAME, LAST_NAME, STD_EMAIL, SEC_ID) VALUES (2, 6531503139, 'GEORGE','LARINCHANA','6531503139@Lamduan.mfu.ac.th','1');
-- INSERT INTO STUDENT (STD_NUM, STD_ID, FIRST_NAME, LAST_NAME, STD_EMAIL, SEC_ID) VALUES (3, 6531503142, 'HTET','LIN AUNG','6531503142@Lamduan.mfu.ac.th','1');
-- INSERT INTO STUDENT (STD_NUM, STD_ID, FIRST_NAME, LAST_NAME, STD_EMAIL, SEC_ID) VALUES (4, 6531503178, 'SAI','SENG MAIN','6531503178@Lamduan.mfu.ac.th','1');
-- INSERT INTO STUDENT (STD_NUM, STD_ID, FIRST_NAME, LAST_NAME, STD_EMAIL, SEC_ID) VALUES (5, 6531503190, 'THIRI','SHWE SIN','6531503190@Lamduan.mfu.ac.th','1');
-- INSERT INTO STUDENT (STD_NUM, STD_ID, FIRST_NAME, LAST_NAME, STD_EMAIL, SEC_ID) VALUES (6, 6531503194, 'YOON','MOH MOH AUNG','6531503194@Lamduan.mfu.ac.th','1');


-- INSERT INTO PASSWORD (PASSWORD_ID, STD_ID, LEC_ID, ADMIN_ID) VALUES ('password', 6531503132, NULL, NULL);
-- INSERT INTO PASSWORD (PASSWORD_ID, STD_ID, LEC_ID, ADMIN_ID) VALUES ('password', NULL, 'L0001', NULL);
-- INSERT INTO PASSWORD (PASSWORD_ID, STD_ID, LEC_ID, ADMIN_ID) VALUES ('password', NULL, NULL, 01);


-- INSERT INTO SECTION (SEC_ID, COURSE_ID, LEC_ID, SEC_NO) VALUES(1, 1305217, 'L0003', 01);
-- INSERT INTO SECTION (SEC_ID, COURSE_ID, LEC_ID, SEC_NO) VALUES(2, 1305217, 'L0003', 01);
-- INSERT INTO SECTION (SEC_ID, COURSE_ID, LEC_ID, SEC_NO) VALUES(3, 1305215, 'L0001', 03);
-- INSERT INTO SECTION (SEC_ID, COURSE_ID, LEC_ID, SEC_NO) VALUES(4, 1305215, 'L0001', 05);
-- INSERT INTO SECTION (SEC_ID, COURSE_ID, LEC_ID, SEC_NO) VALUES(5, 1501208, 'L0002', 06);


-- INSERT INTO COURSE (COURSE_ID, COURSE_NAME, CREDIT) VALUES (1305217, 'SOFTWARE REQUIREMENTS ANALYSIS ANS SPECIFICATION', 03);
-- INSERT INTO COURSE (COURSE_ID, COURSE_NAME, CREDIT) VALUES (1305215, 'WEB APPLICATION DEVELOPMENT', 03);
-- INSERT INTO COURSE (COURSE_ID, COURSE_NAME, CREDIT) VALUES (1501208, 'DATABASE SYSTEMS', 03);


-- INSERT INTO ATTENCANCE (ATTENCANCE_ID, STD_NUM, DATE, STATUS, WEEK_NO) VALUES (1, 1, '2023-11-15 18:00:00', 'Y', 01 );
-- INSERT INTO ATTENCANCE (ATTENCANCE_ID, STD_NUM, DATE, STATUS, WEEK_NO) VALUES (2, 6, '2023-11-15 18:00:00', 'Y', 01 );
-- INSERT INTO ATTENCANCE (ATTENCANCE_ID, STD_NUM, DATE, STATUS, WEEK_NO) VALUES (3, 2, '2023-11-15 18:00:00', 'Y', 01 );
-- INSERT INTO ATTENCANCE (ATTENCANCE_ID, STD_NUM, DATE, STATUS, WEEK_NO) VALUES (4, 3, '2023-11-15 18:00:00', 'Y', 01 );
-- INSERT INTO ATTENCANCE (ATTENCANCE_ID, STD_NUM, DATE, STATUS, WEEK_NO) VALUES (5, 5, '2023-11-15 18:00:00', 'Y', 01 );
-- INSERT INTO ATTENCANCE (ATTENCANCE_ID, STD_NUM, DATE, STATUS, WEEK_NO) VALUES (6, 4, '2023-11-15 18:00:00', 'Y', 01 );






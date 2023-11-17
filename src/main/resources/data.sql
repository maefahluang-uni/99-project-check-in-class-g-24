-- Inserting dummy data for Section table
INSERT INTO section (sec_id, course_id, Lec_id, sec_no) VALUES 
(1, 101, 'LEC001', 1),
(2, 102, 'LEC002', 2),
(3, 103, 'LEC003', 1),
(4, 104, 'LEC004', 3);

-- Inserting dummy data for Lecturer table
INSERT INTO lecturer (lec_email, Lec_id, lec_firstname, lec_lastname, lec_password) VALUES 
('john.lecturer@example.com', 'LEC001', 'John', 'Doe', 'lecturerPass123'),
('jane.lecturer@example.com', 'LEC002', 'Jane', 'Smith', 'lec456'),
('bob.lecturer@example.com', 'LEC003', 'Bob', 'Johnson', 'secureLecPwd'),
('alice.lecturer@example.com', 'LEC004', 'Alice', 'Williams', 'lec789');

-- Inserting dummy data for Course table
INSERT INTO course (course_id, Lec_id, course_name, credit) VALUES 
(101, 'LEC001', 'Mathematics', 4),
(102, 'LEC002', 'History', 3),
(103, 'LEC003', 'Physics', 4),
(104, 'LEC004', 'Computer Science', 3);

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

-- AdminC data
INSERT INTO AdminC (admin_email, admin_password) VALUES
('admin1@example.com', 'password1'),
('admin2@example.com', 'password2'),
('admin3@example.com', 'password3');

-- Lecturer data
INSERT INTO Lecturer (Lec_id, lec_firstname, lec_lastname, lec_email, lec_password) VALUES
('LEC001', 'Professor', 'Smith', 'prof.smith@example.com', 'p1'),
('LEC002', 'Dr.', 'Jones', 'dr.jones@example.com', 'p2'),
('LEC003', 'Ms.', 'Brown', 'ms.brown@example.com', 'p3');

-- Student data
INSERT INTO Student (std_num, std_id, std_firstname, std_lastname, std_email, sec_id, std_password) VALUES
(1, 1001, 'John', 'Doe', 'john.doe@example.com', 1, 'password1'),
(2, 1002, 'Jane', 'Smith', 'jane.smith@example.com', 2, 'password2'),
(3, 1003, 'Bob', 'Johnson', 'bob.johnson@example.com', 1, 'password3');


-- Section data
INSERT INTO Section (sec_id, course_id, Lec_id, sec_no) VALUES
(1, 101, 'LEC001', 1),
(2, 102, 'LEC002', 2),
(3, 103, 'LEC003', 1);


-- Course data
INSERT INTO Course (course_id, course_name, credit) VALUES
(101, 'Mathematics', 3),
(102, 'History', 3),
(103, 'Physics', 3);

-- Attendance data
INSERT INTO Attendance (attendance_id, course_id, sec_id, std_num, date, status, week_no) VALUES
(1, 101, 1, 1, '2023-01-15', 'Present', 1),
(2, 102, 2, 2, '2023-01-15', 'Absent', 1),
(3, 103, 1, 3, '2023-01-16', 'Present', 2);

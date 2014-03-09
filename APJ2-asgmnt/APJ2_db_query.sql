use master
go
create database db_student
go
use db_student
go
create table Students(
	Student_ID int NOT NULL IDENTITY,
	Name varchar(20),
	[Address] varchar(25),
	Tel_no varchar(15),
	DOB date,
	Sex varchar(1),
	CONSTRAINT pk_Students PRIMARY KEY clustered (Student_ID asc)
)
go
create table Courses(
	Course_ID int NOT NULL IDENTITY,
	Title varchar(30),
	[Hours] int,
	CONSTRAINT pk_Courses PRIMARY KEY clustered (Course_ID asc)
)
go
create table StudentCourses(
	StudentCourse_ID int not null IDENTITY,
	Course_ID int NOT NULL,
	Student_ID int NOT NULL,
	Date_to_join date,
	CONSTRAINT pk_StudentCourses PRIMARY KEY clustered (StudentCourse_ID asc),
	CONSTRAINT fk_Courses_StudentCourses_CourseID
		FOREIGN KEY (Course_ID)
		REFERENCES Courses (Course_ID),
	CONSTRAINT fk_Students_StudentCourses_StudentID
		FOREIGN KEY (Student_ID)
		REFERENCES Students (Student_ID)
)
go
create table Marks(
	Mark_ID int not null IDENTITY,
	Mark int,
	[Date] date,
	StudentCourse_ID int not null,
	CONSTRAINT pk_Marks primary key clustered (Mark_ID asc),
	CONSTRAINT fk_StudentCourses_Marks_StudentCourseID
		FOREIGN KEY (StudentCourse_ID)
		REFERENCES StudentCourses (StudentCourse_ID)
)
go
INSERT INTO Students (Name, [Address], Tel_no, DOB, Sex)
VALUES
	('Student1', 'HaNoi', 0937228804, '1987-12-30', 'M'),
	('Student2', 'HaLong', 0937223454, '1957-12-30', 'F'),
	('Student3', 'QuangNinh', 0937234804, '1944-12-30', 'M')
go 
INSERT INTO Courses (Title, [Hours])
VALUES
	('Toan', 120),
	('Van', 150)
go
INSERT INTO StudentCourses (Course_ID, Student_ID, Date_to_join)
VALUES
	(1, 1, '2002-12-2'),
	(1, 2, '2004-12-2'),
	(2, 3, '2006-12-2')
/*
go 
INSERT INTO Marks (Mark, [Date], StudentCourse_ID)
VALUES
	(4, '2003-12-3', 1),
	(5, '2005-02-2', 2)
*/
go
CREATE TRIGGER trg_StudentCourse_delete 
ON Students
INSTEAD OF DELETE 
AS BEGIN
	DELETE FROM StudentCourses
    WHERE Student_ID IN (SELECT Student_ID FROM DELETED)

	DELETE Students
    FROM DELETED D
    INNER JOIN Students T ON T.Student_ID = D.Student_ID
END


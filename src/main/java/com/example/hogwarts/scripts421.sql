ALTER TABLE student
ADD constraint age CHECK (age > 16);

ALTER TABLE student
ALTER COLUMN name SET NOT NULL;
	
ALTER TABLE faculty
ADD CONSTRAINT name_colour  UNIQUE (name,colour);
	
ALTER TABLE student
ADD constraint age DEFAULT (20);


CREATE TABLE people
age TEXT,
name TEXT,
license TEXT PRIMARY KEY,
TEXT REFERENCES car (license)

CREATE TABLE car
model TEXT
cost TEXT;

SELECT student.name, student.age, faculty.name FROM student NNER JOIN faculty
ON student.name = faculty.name;


	

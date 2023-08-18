CREATE TABLE student (
	id INTEGER PRIMARY KEY;
	age INTEGER;
	name TEXT;
    ADD CONSTRAINT age_constraint CHECK (age > 16);
	ADD CONSTRAINT age_constraint DEFAULT 20;
	name TEXT NOT NULL,
	name TEXT UNIQUE
	
);

CREATE TABLE faculty (
id INTEGER PRIMARY KEY;
name TEXT;
colour TEXT;
)
// ком для пула
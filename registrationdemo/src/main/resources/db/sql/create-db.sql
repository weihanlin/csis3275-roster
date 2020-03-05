DROP TABLE users IF EXISTS;
DROP TABLE registrations IF EXISTS;
DROP TABLE students IF EXISTS;
DROP TABLE courses IF EXISTS;


CREATE TABLE users (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50)
);

CREATE TABLE students (
  email VARCHAR(50) PRIMARY KEY,
  name VARCHAR(50),
  password VARCHAR(20)
);

CREATE TABLE courses (
  code VARCHAR(50) PRIMARY KEY,
  name VARCHAR(200)
);

CREATE TABLE registrations(
  email VARCHAR(50),
  code VARCHAR(50),
  foreign key (email) references students(email),
  foreign key (code) references courses(code)
);

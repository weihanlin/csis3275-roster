DROP TABLE companies_employees IF EXISTS;
DROP TABLE users_companies IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE employees IF EXISTS;
DROP TABLE companies IF EXISTS;


CREATE TABLE users (
  users_id    INT PRIMARY KEY,
  user_name  VARCHAR(30),
  email VARCHAR(50)
);

CREATE TABLE employees (
  employee_id INT PRIMARY KEY AUTO_INCREMENT,
  email VARCHAR(50) UNIQUE,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  login_id VARCHAR(50) UNIQUE,
  password VARCHAR(20),
  availability VARCHAR(500),
  position VARCHAR(30)
);

CREATE TABLE companies (
  code VARCHAR(50) PRIMARY KEY,
  company_name VARCHAR(200),
  address VARCHAR(200)
);

CREATE TABLE users_companies (
  users_id INT,
  code VARCHAR(50),
  foreign key (users_id) references users(users_id),
  foreign key (code) references companies(code)
);

CREATE TABLE companies_employees (
  code VARCHAR(50),
  employee_id INT,
  FOREIGN KEY (code) REFERENCES companies(code),
  FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);
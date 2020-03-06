INSERT INTO users VALUES (1, 'mkyong', 'mkyong@gmail.com');
INSERT INTO users VALUES (2, 'alex', 'alex@yahoo.com');
INSERT INTO users VALUES (3, 'joel', 'joel@gmail.com');

INSERT INTO employees VALUES(1, 'lis@douglascollege.ca', 'Simon', 'Li', 'Li1','123456' , 0);
INSERT INTO employees VALUES(2, 'wongi5@douglascollege.ca', 'Ivan', 'Wong', 'Wong1', '654321', 1);

INSERT INTO companies VALUES('C001', 'Amazon Pizza','3333 12th Ave, Vancouver, BC V13 B33');
INSERT INTO companies VALUES('C002', 'Microsoft Ice','4444 13th Street, Burnaby, BC V13 G23');

INSERT INTO jobs VALUES (1, 'C001', 'Sales');
INSERT INTO jobs VALUES (2, 'C001', 'HR');

INSERT INTO users_companies VALUES(2, 'C001');

INSERT INTO companies_employees VALUES('C001', 1, 2);
INSERT INTO companies_employees VALUES('C001', 2, 1);



CREATE TABLE membersalary
(
		id int NOT NULL auto_increment primary key,
	    studentnumber VARCHAR(15) NOT NULL,
        contributiondate DATE,
        contribution  VARCHAR(100) NOT NULL,
        FOREIGN KEY (studentnumber) REFERENCES staff (studentnumber)
			ON DELETE CASCADE
            ON UPDATE CASCADE
) ENGINE = INNODB
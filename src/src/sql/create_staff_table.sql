
CREATE TABLE staff
(
	staffname VARCHAR(10) NOT NULL,
    staffpassword VARCHAR(20) NOT NULL,
    staffsubject  VARCHAR(15) NOT NULL,
    studentnumber VARCHAR(15) NOT NULL PRIMARY KEY,
    staffposition VARCHAR(10) NOT NULL,
    telnumber	  VARCHAR(15)
)engine = innodb;
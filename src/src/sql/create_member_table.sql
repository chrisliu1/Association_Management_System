
CREATE TABLE member
(
	membername VARCHAR(10) NOT NULL,
    membersubject  VARCHAR(15) NOT NULL,
    studentnumber VARCHAR(15) NOT NULL PRIMARY KEY,
    telnumber	  VARCHAR(15),
    remaintime 			INT
)engine = innodb;
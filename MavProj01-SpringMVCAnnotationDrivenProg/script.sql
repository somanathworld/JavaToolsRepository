create table emp(   
  empno    numeric(4,0),   
  ename    varchar(10),   
  job      varchar(9),   
  mgr      numeric(4,0),   
  hiredate date,   
  sal      numeric(7,2),   
  comm     numeric(7,2),   
  deptno   numeric(2,0),   
  addrs		varchar(40),
  mobno    numeric(10),
  gender	varchar(3),
  hobbies  	varchar(30),
  qualification varchar(30),
  dob      date,
  resumepath	varchar(30),
  photopath		varchar(30),
  constraint pk_emp primary key (empno),   
  constraint fk_deptno foreign key (deptno) references dept (deptno)   
);

------

create table dept( deptno numeric(2,0), dname varchar(14),loc varchar(13), constraint pk_dept primary key (deptno));

insert into DEPT (DEPTNO, DNAME, LOC) values (10, 'ACCOUNTING', 'NEW YORK'),(20, 'RESEARCH', 'DALLAS'),(30, 'SALES', 'CHICAGO'),(40, 'OPERATIONS', 'BOSTON')
# mysql_board
=================


## Tables
Before you install this project, you need to make the tables.

- Board

  ```
  create table b0328 (<br/>
  b_no INT NOT NULL AUTO_INCREMENT PRIMARY KEY,<br/> 
  name varchar(100), <br/>
  email varchar(100),<br/> 
  title varchar(300),<br/> 
  content varchar(4000), <br/>
  reg_date date, <br/>
  reply_cnt integer<br/>
  );
  ```

- Member

  ```
  create table m0328 (<br/>
  m_no INT NOT NULL AUTO_INCREMENT PRIMARY KEY, <br/>
  name varchar(100), <br/>
  email varchar(100), <br/>
  pw varchar(100)<br/>
  );
  ```
  
- File

  ```
  create table f0328 (<br/>
  f_no INT NOT NULL AUTO_INCREMENT PRIMARY KEY, <br/>
  b_no INT, <br/>
  ori_name varchar(100), <br/>
  real_name varchar(100), <br/>
  file_path varchar(500), <br/>
  reg_date date, <br/>
  file_size integer<br/>
  );
  ```
  
- Reply

  ```
  create table r0328 (<br/>r_no INT NOT NULL AUTO_INCREMENT PRIMARY KEY, <br/>
  b_no integer, <br/>
  name varchar(400), <br/>
  content varchar(1000), <br/>
  email varchar(400),<br/>
  eg_date date<br/>
  );
  ```

## Requirement

This project runs in these enviroments below:

> Enviroments:
>
> * MySQL
> * Spring 3.1
> * JDK 8
> * MAVEN

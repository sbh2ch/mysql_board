# mysql_board

## Tables
Before you install this project, you need to make the tables.

- Board

  ```
  create table b0328 (
    b_no INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    name varchar(100), 
    email varchar(100), 
    title varchar(300), 
    content varchar(4000),
    reg_date date, 
    reply_cnt INT
  );
  ```

- Member

  ```
  create table m0328 (
    m_no INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    name varchar(100), 
    email varchar(100), 
    pw varchar(100)
  );
  ```
  
- File

  ```
  create table f0328 (
    f_no INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    b_no INT, 
    ori_name varchar(100),
    real_name varchar(100),
    file_path varchar(500),
    reg_date date, 
    file_size int
  );
  ```
  
- Reply

  ```
  create table r0328 (
    r_no INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    b_no integer, 
    name varchar(400), 
    content varchar(1000),
    email varchar(400),
    reg_date date
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

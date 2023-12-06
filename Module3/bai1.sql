create database students_management;

use students_management;

create table student(
id int not null auto_increment primary key,
name varchar(45),
age int,
country varchar(45)
);

create table class(
id int not null auto_increment primary key,
name varchar(100)
);

create table teacher(
id int not null auto_increment primary key,
name varchar(100),
age int,
country varchar(255)
);
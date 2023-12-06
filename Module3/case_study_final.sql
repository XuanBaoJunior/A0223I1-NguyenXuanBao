create database case_study_final;
use case_study_final;

create table positionn(
position_id int primary key auto_increment,
position_name varchar(45)
);

create table education_degree(
education_degree_id int primary key auto_increment,
education_degree_name varchar(45)
);

create table division(
division_id int primary key auto_increment,
division_name varchar(45)
);

create table role(
role_id int primary key auto_increment,
role_name varchar(255)
);

create table user(
username varchar(255) primary key,
password varchar(255)
);

create table user_role(
role_id int,
username varchar(255),
primary key(role_id, username),
foreign key (role_id) references role(role_id),
foreign key (username) references user(username)
);

create table attach_service(
attach_service_id int primary key auto_increment,
attach_service_name varchar(45),
attach_service_cost double,
attach_service_unit int,
attach_service_status varchar(45)
);

create table employee(
employee_id int primary key,
employee_name varchar(45) not null,
employee_birthday date not null,
employee_id_card varchar(45) not null,
employee_salary double not null,
employee_phone varchar(45) not null,
employee_email varchar(45),
employee_address varchar(45),
position_id int,
education_degree_id int,
division_id int,
username varchar(255),
foreign key (position_id) references positionn(position_id),
foreign key (education_degree_id) references education_degree(education_degree_id),
foreign key (division_id) references division(division_id),
foreign key (username) references user(username)
);

create table customer_type(
customer_type_id int primary key,
customer_type_name varchar(45)
);

create table customer(
customer_id int primary key,
customer_type_id int,
foreign key (customer_type_id) references customer_type(customer_type_id),
customer_name varchar(45) not null,
customer_birthday date not null,
customer_gender bit(1) not null,
customer_id_card varchar(45) not null,
customer_phone varchar(45) not null,
customer_email varchar(45),
customer_address varchar(45)
);

create table rent_type(
rent_type_id int primary key,
rent_type_name varchar(45),
rent_type_cost double
);

create table service_type(
service_type_id int primary key,
service_type_name varchar(45)
);

create table service(
service_id int primary key,
service_name varchar(45) not null,
service_area int,
service_cost double not null,
service_max_people int,
rent_type_id int,
service_type_id int,
foreign key (rent_type_id) references rent_type(rent_type_id),
foreign key (service_type_id) references service_type(service_type_id),
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int
);

create table contract(
contract_id int primary key,
contract_start_date datetime,
contract_end_date datetime,
contract_deposit double,
contract_total_money double,
employee_id int,
customer_id int,
service_id int,
foreign key (employee_id) references employee(employee_id),
foreign key (customer_id) references customer(customer_id),
foreign key (service_id) references service(service_id)
);

create table contract_detail(
contract_detail_id int primary key auto_increment,
contract_id int,
attach_service_id int,
foreign key (contract_id) references contract(contract_id),
foreign key (attach_service_id) references attach_service(attach_service_id),
quantity int
);


-- Thêm dữ liệu vào bảng positionn
INSERT INTO positionn (position_name) VALUES
('Manager'),
('Developer'),
('Designer');

-- Thêm dữ liệu vào bảng education_degree
INSERT INTO education_degree (education_degree_name) VALUES
('Bachelor'),
('Master'),
('PhD');

-- Thêm dữ liệu vào bảng division
INSERT INTO division (division_name) VALUES
('IT Department'),
('Marketing'),
('Human Resources');

-- Thêm dữ liệu vào bảng role
INSERT INTO role (role_name) VALUES
('Admin'),
('User');

-- Thêm dữ liệu vào bảng user
INSERT INTO user (username, password) VALUES
('admin', 'admin123'),
('user1', 'password123'),
('user2', 'password456');

-- Thêm dữ liệu vào bảng user_role
INSERT INTO user_role (role_id, username) VALUES
(1, 'admin'),
(2, 'user1'),
(2, 'user2');

-- Thêm dữ liệu vào bảng attach_service
INSERT INTO attach_service (attach_service_name, attach_service_cost, attach_service_unit, attach_service_status) VALUES
('WiFi', 10.0, 1, 'Active'),
('Breakfast', 15.0, 1, 'Active'),
('Airport Shuttle', 20.0, 1, 'Inactive');

-- Thêm dữ liệu vào bảng employee
INSERT INTO employee (employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username) VALUES
(1, 'John Doe', '1990-01-15', '123456789', 50000.0, '123-456-7890', 'john.doe@example.com', '123 Main St', 1, 1, 1, 'admin'),
(2, 'Jane Smith', '1985-05-20', '987654321', 60000.0, '987-654-3210', 'jane.smith@example.com', '456 Oak St', 2, 2, 2, 'user1');

-- Thêm dữ liệu vào bảng customer_type
INSERT INTO customer_type (customer_type_id, customer_type_name) VALUES
(1, 'Regular'),
(2, 'VIP');

-- Thêm dữ liệu vào bảng customer
INSERT INTO customer (customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) VALUES
(1, 1, 'Customer 1', '1995-03-10', 1, '789012345', '456-789-0123', 'customer1@example.com', '789 Pine St'),
(2, 2, 'Customer 2', '1988-08-25', 0, '543210987', '321-654-0987', 'customer2@example.com', '123 Cedar St');

-- Thêm dữ liệu vào bảng rent_type
INSERT INTO rent_type (rent_type_id, rent_type_name, rent_type_cost) VALUES
(1, 'Daily', 100.0),
(2, 'Weekly', 500.0),
(3, 'Monthly', 2000.0);

-- Thêm dữ liệu vào bảng service_type
INSERT INTO service_type (service_type_id, service_type_name) VALUES
(1, 'Room'),
(2, 'Meeting Room'),
(3, 'Swimming Pool');

-- Thêm dữ liệu vào bảng service
INSERT INTO service (service_id, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors) VALUES
(1, 'Standard Room', 30, 80.0, 2, 1, 1, 'Standard', 'Free WiFi', NULL, NULL),
(2, 'Conference Room', 50, 200.0, 30, 2, 2, 'Conference Setup', 'Projector, Whiteboard', NULL, NULL),
(3, 'Outdoor Pool', 200, 50.0, 100, 1, 3, NULL, 'Poolside Bar', 500.0, NULL);

-- Thêm dữ liệu vào bảng contract
INSERT INTO contract (contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id) VALUES
(1, '2023-01-01', '2023-02-01', 50.0, 500.0, 1, 1, 1),
(2, '2023-03-01', '2023-04-01', 100.0, 1000.0, 2, 2, 2);

-- Thêm dữ liệu vào bảng contract_detail
INSERT INTO contract_detail (contract_id, attach_service_id, quantity) VALUES
(1, 1, 2),
(2, 2, 1);
















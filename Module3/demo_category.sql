create database demo_category;
use demo_category;

create table product(
id_product int primary key auto_increment,
name_product varchar(255),
color_product varchar(45),
describe_product varchar(45),
id_category int,
foreign key (id_category) references category(id_category)
);

create table category(
id_category int primary key auto_increment,
type_category varchar(45)
);

-- Insert data into the 'category' table
insert into category(type_category) values
    ('Electronics'),
    ('Clothing'),
    ('Home and Garden');

-- Insert data into the 'product' table
insert into product(name_product, color_product, describe_product, id_category) values
    ('Smartphone', 'Black', 'High-performance phone', 1),
    ('T-shirt', 'Blue', 'Comfortable cotton T-shirt', 2);
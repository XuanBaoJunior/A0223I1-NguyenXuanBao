create database bai2_2;

use bai2_2;

create table customer_qlbh(
	c_id int primary key,
    c_name varchar(100),
    c_age int
);

create table order_qlbh(
	o_id int primary key,
    c_id int,
    o_date date,
    o_total_price double,
    foreign key (c_id) references customer_qlbh(c_id)
);

create table product(
	p_id int primary key,
    p_name varchar(100),
    p_price double
);


create table order_detail(
	o_id int,
    p_id int,
    od_qty varchar(150),
    primary key (o_id, p_id),
    foreign key (o_id) references order_qlbh(o_id),
    foreign key (p_id) references product(p_id)
);


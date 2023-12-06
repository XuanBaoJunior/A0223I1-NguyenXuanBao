	create database if not exists product_bank;
	use product_bank;

	create table if not exists Bank (
	id int primary key auto_increment,
	name varchar(255) not null
	);

	create table if not exists Product(
	id_product int primary key auto_increment,
	name text not null,
	number int not null,
	mota text,
	id int not null,
	foreign key(id) references Bank(id)
	);

	insert into Bank(name)
	values ('TechcomBank'), ('VietcomBank');

	insert into Product(name, number, mota, id) 
	values ('Bao', 1017972541, 'Ok', 2), ('Anh', 888009999, 'Ok', 1);
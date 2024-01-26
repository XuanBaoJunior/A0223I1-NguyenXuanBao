create database xe_co;

use xe_co;

create table loai_xe(
id_loai_xe int auto_increment primary key,
ten_loai_xe varchar(50),
gia_xe double,
nam_san_xuat int,
id_nuoc_san_xuat int,
foreign key (id_nuoc_san_xuat) references san_xuat(id_nuoc_san_xuat)
);

create table san_xuat(
id_nuoc_san_xuat int auto_increment primary key,
nuoc_san_xuat varchar(50)
);

insert into san_xuat values (1, "Nhat Ban"), (2, "Duc");

insert into loai_xe values (1, "Toyota", 2500000, 2022, 1), (2, "Mercedes", 3500000, 2022, 2);


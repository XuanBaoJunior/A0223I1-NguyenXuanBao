create database quan_ly_sach;
use quan_ly_sach;

create table book (
 id_book int NOT NULL AUTO_INCREMENT,
 name_book varchar(120) NOT NULL,
 author varchar(100) NOT NULL,
 quatity varchar(120) NOT NULL,
 description varchar(100),  
 PRIMARY KEY (id_book)
);

create table student(
id_student int not null auto_increment,
name_student varchar(50) not null,
class_student varchar(30) not null,
primary key (id_student)
);

create table detail(
id_book int not null,
id_student int not null,
primary key (id_book, id_student), foreign key (id_book) references book(id_book), foreign key (id_student) references student(id_student)
);

create table the_muon_sach(
ma_muon varchar(50) not null,
trang_thai varchar(100) not null,
ngay_muon date not null,
ngay_tra date not null,
id_book int not null,
id_student int not null,
primary key (ma_muon), foreign key (id_book) references book(id_book), foreign key (id_student) references student(id_student)
);

insert into book(name_book, author, quatity, description) values ("Sổ đỏ", "Vũ Trọng Phụng", "Hay tuyệt vời", 10),
																("Truyện kiều", "Nguyễn Du", "Quá hay", 15);
                                                                
insert into student(name_student, class_student) values ("Nguyen Xuan Bao", "A0323I1"),
																("Le Quang Anh","A0223I1");
                                                                
insert into the_muon_sach(ma_muon, trang_thai, ngay_muon, ngay_tra, id_book, id_student) 
values 
("M001", "Đang mượn", '2023-11-15', '2023-12-15', 1, 1),
("M002", "Đã trả", '2023-10-01', '2023-10-15', 2, 2);

select ma_muon,trang_thai,ngay_muon,ngay_tra,name_book,name_student 
from the_muon_sach
 inner join book 
 on the_muon_sach.id_book = book.id_book
 inner join student 
 on the_muon_sach.id_student = student.id_student
 
 DELIMITER //
 create procedure search_by_ma_muon (in search_ma_muon varchar (10))
 begin
	select ma_muon,trang_thai,ngay_muon,ngay_tra,name_book,name_student 
from the_muon_sach
 inner join book 
 on the_muon_sach.id_book = book.id_book
 inner join student 
 on the_muon_sach.id_student = student.id_student
 where ma_muon = search_ma_muon;
 end
// DELIMITER ;
 call search_by_ma_muon("M001")
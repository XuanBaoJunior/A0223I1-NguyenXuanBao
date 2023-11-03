create
database bai2;

use
bai2;

create table phieu_xuat
(
    so_px     int primary key,
    ngay_xuat date
);

create table vat_tu
(
    ma_vtu  int primary key,
    ten_vtu varchar(50)
);

create table phieu_nhap
(
    so_pn     int primary key,
    ngay_nhap date
);

create table nha_cc
(
    ma_ncc  int primary key,
    ten_ncc varchar(50),
    dia_chi varchar(100)
);

create table don_dh
(
    so_dh   int primary key,
    ngay_dh date,
    ma_cc   int,
    foreign key (ma_cc) references nha_cc (ma_ncc)
);


create table sdt
(
    id     int auto_increment primary key,
    sdt    varchar(20),
    ma_ncc int,
    foreign key (ma_ncc) references nha_cc (ma_ncc)
);

create table phieu_xuat_teach_vat_tu
(
    so_px   int,
    ma_vtu  int,
    dg_xuat varchar(100),
    sl_xuat varchar(100),
    primary key (so_px, ma_vtu),
    foreign key (so_px) references phieu_xuat (so_px),
    foreign key (ma_vtu) references vat_tu (ma_vtu)
);

create table vat_tu_teach_phieu_nhap
(
    ma_vtu  int,
    so_pn   int,
    dg_nhap varchar(100),
    sl_nhap varchar(100),
    primary key (ma_vtu, so_pn),
    foreign key (ma_vtu) references vat_tu (ma_vtu),
    foreign key (so_pn) references phieu_nhap (so_pn)
);

create table vat_tu_teach_don_dh
(
    ma_vtu int,
    so_dh  int,
    primary key (ma_vtu, so_dh),
    foreign key (ma_vtu) references vat_tu (ma_vtu),
    foreign key (so_dh) references don_dh (so_dh)
);

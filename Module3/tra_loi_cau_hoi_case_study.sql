-- cau 2
SELECT * 
FROM nhan_vien
WHERE LEFT(ho_ten, 1) IN ('H', 'T', 'K') AND LENGTH(ho_ten) <= 15;

-- cau 3
SELECT *
FROM khach_hang
WHERE TIMESTAMPDIFF(YEAR, ngay_sinh, CURDATE()) BETWEEN 18 AND 50
AND (dia_chi LIKE '%Đà Nẵng%' OR dia_chi LIKE '%Quảng Trị%');

-- cau 4
SELECT kh.ma_khach_hang, kh.ho_ten AS ten_khach_hang, COUNT(hd.ma_hop_dong) AS so_lan_dat_phong
FROM khach_hang kh
JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
JOIN loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
WHERE lk.ten_loai_khach = 'Diamond'
GROUP BY kh.ma_khach_hang, ten_khach_hang
ORDER BY so_lan_dat_phong ASC;

-- cau 5
SELECT
    kh.ma_khach_hang,
    kh.ho_ten,
    lk.ten_loai_khach,
    hd.ma_hop_dong,
    dv.ten_dich_vu,
    hd.ngay_lam_hop_dong,
    hd.ngay_ket_thuc,
    SUM(dvdk.gia * hdt.so_luong) + hd.tien_dat_coc AS tong_tien
FROM
    khach_hang kh
LEFT JOIN
    hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
LEFT JOIN
    dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
LEFT JOIN
    loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
LEFT JOIN
    hop_dong_chi_tiet hdt ON hd.ma_hop_dong = hdt.ma_hop_dong
LEFT JOIN
    dich_vu_di_kem dvdk ON hdt.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
GROUP BY
    kh.ma_khach_hang,
    kh.ho_ten,
    lk.ten_loai_khach,
    hd.ma_hop_dong,
    dv.ten_dich_vu,
    hd.ngay_lam_hop_dong,
    hd.ngay_ket_thuc,
    hd.tien_dat_coc;
    
-- cau 6
SELECT
    dv.ma_dich_vu,
    dv.ten_dich_vu,
    dv.dien_tich,
    dv.chi_phi_thue,
    ldv.ten_loai_dich_vu
FROM
    dich_vu dv
JOIN
    loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
WHERE
    dv.ma_dich_vu NOT IN (
        SELECT DISTINCT ma_dich_vu
        FROM hop_dong hd
        WHERE hd.ngay_lam_hop_dong >= '2021-01-01' AND hd.ngay_lam_hop_dong <= '2021-03-31'
    );
    
-- cau 7
SELECT
    dv.ma_dich_vu,
    dv.ten_dich_vu,
    dv.dien_tich,
    dv.so_nguoi_toi_da,
    dv.chi_phi_thue,
    ldv.ten_loai_dich_vu
FROM
    dich_vu dv
JOIN
    loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
WHERE
    dv.ma_dich_vu IN (
        SELECT DISTINCT ma_dich_vu
        FROM hop_dong hd
        WHERE YEAR(hd.ngay_lam_hop_dong) = 2020
    )
    AND dv.ma_dich_vu NOT IN (
        SELECT DISTINCT ma_dich_vu
        FROM hop_dong hd
        WHERE YEAR(hd.ngay_lam_hop_dong) = 2021
    );
-- cau 8
-- cach 1
SELECT DISTINCT ho_ten
FROM khach_hang;
-- cach 2
SELECT MIN(ho_ten) AS ho_ten
FROM khach_hang
GROUP BY ho_ten;
-- cach 3
SELECT ho_ten
FROM (
    SELECT ho_ten, ROW_NUMBER() OVER(PARTITION BY ho_ten ORDER BY ngay_sinh DESC) AS rn
    FROM khach_hang
) AS ranked
WHERE rn = 1;

-- cau 9
SELECT 
    EXTRACT(MONTH FROM ngay_lam_hop_dong) AS thang,
    COUNT(DISTINCT ma_khach_hang) AS so_luong_khach_hang
FROM hop_dong
WHERE YEAR(ngay_lam_hop_dong) = 2021
GROUP BY thang
ORDER BY thang;

-- cau 10
SELECT
    hd.ma_hop_dong,
    hd.ngay_lam_hop_dong,
    hd.ngay_ket_thuc,
    hd.tien_dat_coc,
    SUM(hdt.so_luong) AS so_luong_dich_vu_di_kem
FROM
    hop_dong hd
LEFT JOIN
    hop_dong_chi_tiet hdt ON hd.ma_hop_dong = hdt.ma_hop_dong
GROUP BY
    hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc;
    
-- cau 11
SELECT hdt.ma_hop_dong_chi_tiet, kh.ho_ten AS ten_khach_hang, dk.ten_dich_vu_di_kem
FROM khach_hang kh
INNER JOIN loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
INNER JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
INNER JOIN hop_dong_chi_tiet hdt ON hd.ma_hop_dong = hdt.ma_hop_dong
INNER JOIN dich_vu_di_kem dk ON hdt.ma_dich_vu_di_kem = dk.ma_dich_vu_di_kem
WHERE (lk.ten_loai_khach = 'Diamond') 
AND (kh.dia_chi LIKE '%Vinh%' OR kh.dia_chi LIKE '%Quảng Ngãi%');

-- cau 12
SELECT 
    hd.ma_hop_dong,
    nv.ho_ten AS ho_ten_nhan_vien,
    kh.ho_ten AS ho_ten_khach_hang,
    kh.so_dien_thoai AS so_dien_thoai_khach_hang,
    dv.ten_dich_vu,
    SUM(hdt.so_luong) AS so_luong_dich_vu_di_kem,
    hd.tien_dat_coc
FROM hop_dong hd
INNER JOIN nhan_vien nv ON hd.ma_nhan_vien = nv.ma_nhan_vien
INNER JOIN khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
INNER JOIN hop_dong_chi_tiet hdt ON hd.ma_hop_dong = hdt.ma_hop_dong
INNER JOIN dich_vu_di_kem dk ON hdt.ma_dich_vu_di_kem = dk.ma_dich_vu_di_kem
INNER JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
WHERE DATE_FORMAT(hd.ngay_lam_hop_dong, '%Y-%m') BETWEEN '2020-10' AND '2020-12'
AND hd.ma_hop_dong NOT IN (
    SELECT DISTINCT hd2.ma_hop_dong
    FROM hop_dong hd2
    WHERE DATE_FORMAT(hd2.ngay_lam_hop_dong, '%Y-%m') BETWEEN '2021-01' AND '2021-06'
)
GROUP BY hd.ma_hop_dong, hd.tien_dat_coc;

-- cau 13
SELECT 
    dk.ten_dich_vu_di_kem,
    COUNT(hdt.ma_hop_dong_chi_tiet) AS so_lan_su_dung
FROM dich_vu_di_kem dk
INNER JOIN hop_dong_chi_tiet hdt ON dk.ma_dich_vu_di_kem = hdt.ma_dich_vu_di_kem
GROUP BY dk.ten_dich_vu_di_kem
ORDER BY so_lan_su_dung DESC;

-- cau 14
SELECT
    hd.ma_hop_dong,
    ldv.ten_loai_dich_vu,
    dk.ten_dich_vu_di_kem,
    COUNT(hdt.ma_dich_vu_di_kem) AS so_lan_su_dung
FROM dich_vu_di_kem dk
INNER JOIN hop_dong_chi_tiet hdt ON dk.ma_dich_vu_di_kem = hdt.ma_dich_vu_di_kem
INNER JOIN hop_dong hd ON hdt.ma_hop_dong = hd.ma_hop_dong
INNER JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
INNER JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
GROUP BY hd.ma_hop_dong, ldv.ten_loai_dich_vu, dk.ten_dich_vu_di_kem
HAVING so_lan_su_dung = 1;

-- cau 15
 SELECT
    nv.ma_nhan_vien,
    nv.ho_ten,
    td.ten_trinh_do,
    bp.ten_bo_phan,
    nv.so_dien_thoai,
    nv.dia_chi
FROM nhan_vien nv
INNER JOIN trinh_do td ON nv.ma_trinh_do = td.ma_trinh_do
INNER JOIN bo_phan bp ON nv.ma_bo_phan = bp.ma_bo_phan
WHERE nv.ma_nhan_vien IN (
    SELECT hd.ma_nhan_vien
    FROM hop_dong hd
    WHERE YEAR(hd.ngay_lam_hop_dong) BETWEEN 2020 AND 2021
    GROUP BY hd.ma_nhan_vien
    HAVING COUNT(hd.ma_hop_dong) <= 3
);

-- cau 16
DELETE FROM nhan_vien
WHERE ma_nhan_vien NOT IN (
    SELECT DISTINCT ma_nhan_vien
    FROM hop_dong
    WHERE YEAR(ngay_lam_hop_dong) BETWEEN 2019 AND 2021
);

-- cau 17
UPDATE khach_hang
SET ten_loai_khach = 'Diamond'
WHERE ma_khach_hang IN (
    SELECT ma_khach_hang
    FROM hop_dong hd
    WHERE YEAR(hd.ngay_lam_hop_dong) = 2021
    GROUP BY hd.ma_khach_hang
    HAVING SUM(hd.tien_dat_coc) > 10000000
);

-- cau 18
-- Xóa thông tin trong bảng hop_dong_chi_tiet
DELETE FROM hop_dong_chi_tiet
WHERE ma_hop_dong IN (
    SELECT ma_hop_dong
    FROM hop_dong
    WHERE YEAR(ngay_lam_hop_dong) < 2021
);

-- Xóa thông tin trong bảng hop_dong
DELETE FROM hop_dong
WHERE YEAR(ngay_lam_hop_dong) < 2021;

-- Xóa thông tin trong bảng khach_hang
DELETE FROM khach_hang
WHERE ma_khach_hang NOT IN (
    SELECT ma_khach_hang
    FROM hop_dong
);

-- cau 19
UPDATE dich_vu_di_kem
SET gia = gia * 2
WHERE ma_dich_vu_di_kem IN (
    SELECT ma_dich_vu_di_kem
    FROM hop_dong_chi_tiet hdt
    JOIN hop_dong hd ON hdt.ma_hop_dong = hd.ma_hop_dong
    WHERE YEAR(hd.ngay_lam_hop_dong) = 2020
    GROUP BY ma_dich_vu_di_kem
    HAVING COUNT(*) > 10
);

-- cau 20
SELECT ma_nhan_vien AS id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
FROM nhan_vien
UNION
SELECT ma_khach_hang AS id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
FROM khach_hang;

-- cau 21
CREATE VIEW v_nhan_vien AS
SELECT nv.ma_nhan_vien, nv.ho_ten, nv.dia_chi
FROM nhan_vien nv
WHERE nv.dia_chi = 'Hải Châu'
AND EXISTS (
    SELECT 1
    FROM hop_dong hd
    WHERE hd.ma_nhan_vien = nv.ma_nhan_vien
    AND hd.ngay_lam_hop_dong = '2019-12-12'
);

-- cau 22
DELIMITER //
CREATE TRIGGER update_nhan_vien_dia_chi
BEFORE UPDATE ON v_nhan_vien FOR EACH ROW
BEGIN
    UPDATE nhan_vien
    SET dia_chi = 'Liên Chiểu'
    WHERE ma_nhan_vien = NEW.ma_nhan_vien;
END;
//
DELIMITER ;

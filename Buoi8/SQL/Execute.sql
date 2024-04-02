-- Lay ve all nhan vien
SELECT	* FROM	NhanVien AS nv
-- Lay ve nhan vien co ho Le
SELECT	* FROM	NhanVien AS nv WHERE  nv.hoten LIKE 'Le%'
-- Tinh TBC cuar HSL
SELECT	AVG(nv.hsl) FROM	NhanVien AS nv 
-- Them vao 1 nhan vien
INSERT INTO NhanVien(manv, hoten, gioitinh, ngaysinh, hsl, email, phone) VALUES('nv1', 'Thanh Nhan', 1, '1999-02-02' , 5, 'e@husc.edu.vn', 5)
-- Tang HSL len 2 cho nhanvien co manv = 'nv1'
UPDATE NhanVien
SET hsl = 2
WHERE manv = 'nv1'
-- Xoa nhan vien nv1
DELETE FROM NhanVien WHERE manv='nv1'
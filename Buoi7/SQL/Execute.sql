-- Lay ve all nhan vien
SELECT	* FROM	NhanVien AS nv
-- Lay ve nhan vien co ho Le
SELECT	* FROM	NhanVien AS nv WHERE  nv.hoten LIKE 'Le%'
-- Tinh TBC cuar HSL
SELECT	AVG(nv.hsl) FROM	NhanVien AS nv 
-- Them vao 1 nhan vien
INSERT INTO NhanVien VALUES('nv6', 'A', 0, '2000-05-05', 4, 'd@husc.edu.vn', 4)
-- Tang HSL len 2 cho nhanvien co manv = 'nv1'
UPDATE NhanVien SET hsl = 2 WHERE manv = 'nv1'
-- Xoa nhan vien nv1
DELETE FROM NhanVien WHERE manv='nv1'

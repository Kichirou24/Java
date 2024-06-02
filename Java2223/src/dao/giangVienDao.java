package dao;

import java.sql.PreparedStatement;

import bean.giangVienBean;

public class giangVienDao {
	public int insertSQL(giangVienBean gv) throws Exception{
		nguoiDao nDao = new nguoiDao();
		String sql = "INSERT INTO GiangVien(maGiangVien, hoTen, loaiHopDong, heSoLuong, phuCap) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement cmd = nDao.cn.prepareStatement(sql);
		cmd.setString(1, gv.getMaGiangVien());
		cmd.setString(2, gv.getHoTen());
		cmd.setString(3, gv.getLoaiHopDong());
		cmd.setDouble(4, gv.getHeSoLuong());
		cmd.setDouble(5, gv.getPhuCap());
		
		int kq = cmd.executeUpdate();
		cmd.close();
		nDao.cn.close();
		return kq;
	}
}

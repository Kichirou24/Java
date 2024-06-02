package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.giangVienBean;
import bean.nguoiBean;
import bean.nhanVienBean;

public class nhanVienDao {
	public int insertSQL(nhanVienBean nv) throws Exception{
		nguoiDao nDao = new nguoiDao();
		String sql = "INSERT INTO NhanVien(maNhanVien, hoTen, loaiHopDong, heSoLuong) VALUES(?, ?, ?, ?)";
		PreparedStatement cmd = nDao.cn.prepareStatement(sql);
		cmd.setString(1, nv.getMaNhanVien());
		cmd.setString(2, nv.getHoTen());
		cmd.setString(3, nv.getLoaiHopDong());
		cmd.setDouble(4, nv.getHeSoLuong());
		
		int kq = cmd.executeUpdate();
		cmd.close();
		nDao.cn.close();
		return kq;
	}
	
	public ArrayList<String> statisticsSQL() throws Exception{
		ArrayList<String> ds = new ArrayList<String>();
		
		nguoiDao nDao = new nguoiDao();
		nDao.connect();
		
		String sql = "SELECT loaiHopDong, COUNT(loaiHopDong) 'soLuong' FROM NhanVien GROUP BY loaiHopDong";
		PreparedStatement cmd = nDao.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			String loaiHopDong = rs.getString(1);
			Integer soLuong = rs.getInt(2);
			ds.add(loaiHopDong + ',' + soLuong);
		}

		return ds;
	}
}

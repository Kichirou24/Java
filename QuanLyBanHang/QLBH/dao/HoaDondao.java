package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.HoaDonbean;

public class HoaDondao {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public ArrayList<HoaDonbean> load() throws Exception{
		ArrayList<HoaDonbean> ds = new ArrayList<HoaDonbean>();
		try {
			KetNoidao kn = new KetNoidao();
			kn.KetNoi();
			
			String sql = "SELECT * FROM LSBanHang";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next())
			{
				String maHang = rs.getString("mahang");
				String tenHang = rs.getString("tenhang");
				Date ngayMuaHang = rs.getDate("ngaymua");
				Integer soLuongMua = rs.getInt("soluongmua");
				Double gia = rs.getDouble("gia");
				
				ds.add(new HoaDonbean(maHang, tenHang, ngayMuaHang, soLuongMua, gia));
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
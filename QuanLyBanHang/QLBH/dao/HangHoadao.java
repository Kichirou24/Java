package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.HangHoabean;

public class HangHoadao {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public ArrayList<HangHoabean> getHang() throws Exception {
		ArrayList<HangHoabean> ds = new ArrayList<HangHoabean>();
		try {
			FileReader f = new FileReader("hang.txt");		
			BufferedReader r = new BufferedReader(f);
			
			while(true)
			{
				String st = r.readLine();
				if (st == null || st == "")
					break;
				
				String[] sp = st.split("[;]");
				
				String maHang = sp[0].trim();
				String tenHang = sp[1].trim();
				Date ngayNhapHang = sdf.parse(sp[2]);
				Integer soLuong = Integer.parseInt(sp[3]);
				Double gia = Double.parseDouble(sp[4]);
				ds.add(new HangHoabean(maHang, tenHang, ngayNhapHang, soLuong, gia));
			}
			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public ArrayList<HangHoabean> getHangHoa() throws Exception{
		ArrayList<HangHoabean> ds = new ArrayList<HangHoabean>();
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		
		String sql = "SELECT * FROM HangHoa";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		while (rs.next())
		{
			String maHang = rs.getString(1);
			String tenHang = rs.getString(2);
			Date ngayNhapHang = rs.getDate(3);
			Integer soLuong = rs.getInt(4);
			Double gia = rs.getDouble(5);
			
			ds.add(new HangHoabean(maHang, tenHang, ngayNhapHang, soLuong, gia));
		}
		
		rs.close();
		kn.cn.close();
		return ds;
	}
	
	public int delete(String maHang) throws Exception{
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		
		String sql = "DELETE FROM HangHoa WHERE mahang=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maHang);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
	
	public int update(String maHang, String tenHang, Date ngayNhapHang, Integer soLuong, Double gia) throws Exception{
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		
		String sql = "UPDATE HangHoa SET soLuong = ? WHERE mahang = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		cmd.setInt(1, soLuong);
		cmd.setString(2, maHang);
		
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
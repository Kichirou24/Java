package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.BanHangbean;
import bean.Hangbean;

public class Hangdao {	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public ArrayList<Hangbean> getHang() throws Exception {
		ArrayList<Hangbean> ds = new ArrayList<Hangbean>();
		try {
			FileReader f = new FileReader("hang.txt");		
			BufferedReader r = new BufferedReader(f);
			
			while(true)
			{
				String st = r.readLine();
				if (st == null || st == "")
					break;
				
				String[] sp = st.split("[;]");
				
				String maHang = sp[0];
				String tenHang = sp[1];
				Date ngayNhapHang = sdf.parse(sp[2]);
				Integer soLuong = Integer.parseInt(sp[3]);
				Double gia = Double.parseDouble(sp[4]);
				ds.add(new Hangbean(maHang, tenHang, ngayNhapHang, soLuong, gia));
			}
			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public ArrayList<Hangbean> load() throws Exception{
		ArrayList<Hangbean> ds = new ArrayList<Hangbean>();
		try {
			KetNoidao kn = new KetNoidao();
			kn.KetNoi();
			
			String sql = "SELECT * FROM HangHoa";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next())
			{
				String maHang = rs.getString("mahang");
				String tenHang = rs.getString("tenhang");
				Date ngayNhapHang = rs.getDate("ngaynhaphang");
				Integer soLuong = rs.getInt("soluong");
				Double gia = rs.getDouble("gia");
				
				ds.add(new Hangbean(maHang, tenHang, ngayNhapHang, soLuong, gia));
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public void upload() throws Exception{
		BanHangdao bhdao = new BanHangdao();
		Hangdao hdao = new Hangdao();
		
		for (Hangbean h : hdao.load())
		{
			for (BanHangbean bh : bhdao.loadDS())
			{
				if (h.getMaHang().trim().equals(bh.getMaHang().trim()))
				{
					hdao.update(h.getMaHang(), h.getTenhang(), h.getNgayNhapHang(), h.getSoLuong() - bh.getSoLuongMua(), h.getGia());
					continue;
				}
			}
		}
	}
	
	public int insert(String maHang, String tenHang, Date ngayNhapHang, Integer soLuong, Double gia) throws Exception
	{
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		
		String sql = "INSERT INTO HangHoa (mahang, tenhang, ngaynhaphang, soluong, gia) VALUES(?,?,?,?,?)";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		cmd.setString(1, maHang);
		cmd.setString(2, tenHang);
		cmd.setDate(3, new java.sql.Date(ngayNhapHang.getTime()));
		cmd.setInt(4, soLuong);
		cmd.setDouble(5, gia);
		
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
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
		
		String sql = "UPDATE HangHoa SET soluong = ? WHERE mahang = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		cmd.setInt(1, soLuong);
		cmd.setString(2, maHang);
		
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}

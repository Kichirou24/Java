package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.BanHangbean;

public class BanHangdao {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public ArrayList<BanHangbean> load() throws Exception{
		ArrayList<BanHangbean> ds = new ArrayList<BanHangbean>();
		try {
			KetNoidao kn = new KetNoidao();
			kn.KetNoi();
			
			String sql = "SELECT * FROM HoaDon";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next())
			{
				String maHang = rs.getString("mahang");
				String tenHang = rs.getString("tenhang");
				Date ngayMuaHang = rs.getDate("ngaymua");
				Integer soLuongMua = rs.getInt("soluongmua");
				Double gia = rs.getDouble("gia");
				
				ds.add(new BanHangbean(maHang, tenHang, ngayMuaHang, soLuongMua, gia));
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public void add(BanHangbean bh) throws Exception
	{
		FileWriter fw = new FileWriter("donhang.txt", true);
		PrintWriter w = new PrintWriter(fw);
		w.println(bh.toString());
		w.close();
	}
	
	public void addnull() throws Exception
	{
		FileWriter fw = new FileWriter("donhang.txt");
		PrintWriter w = new PrintWriter(fw);
		w.close();
	}
	
	public ArrayList<BanHangbean> loadDS() throws Exception
	{
		ArrayList<BanHangbean> ds = new ArrayList<BanHangbean>();
		
		try {
			FileReader f = new FileReader("donhang.txt");
			BufferedReader r = new BufferedReader(f);
			
			while(true)
			{
				String st = r.readLine();
				if (st == null || st == "")
					break;
				
				String[] sp = st.split("[;]");
				
				String maHang = sp[0];
				String tenHang = sp[1];
				Date ngayMua = sdf.parse(sp[2]);
				Integer soLuongMua = Integer.parseInt(sp[3]);
				Double gia = Double.parseDouble(sp[4]);
				
				Boolean update = false;
				
				for (BanHangbean bh : ds)
				{
					if (bh.getMaHang().trim().equals(maHang.trim()))
					{
						bh.setSoLuongMua(bh.getSoLuongMua() + soLuongMua);
						update = true;
					}
				}
				if (update == false)
					ds.add(new BanHangbean(maHang, tenHang, ngayMua, soLuongMua, gia));
			}
			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public int insert(String maHang, String tenHang, Date ngayMua, Integer soLuongMua, Double gia) throws Exception
	{
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String sql = "INSERT INTO HoaDon (mahang, tenhang, ngaymua, soluongmua, gia) VALUES(?,?,?,?,?)";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		Date date = new Date();
		cmd.setString(1, maHang);
		cmd.setString(2, tenHang);
		cmd.setTimestamp(3, java.sql.Timestamp.valueOf(sdf.format(date)));
		cmd.setInt(4, soLuongMua);
		cmd.setDouble(5, gia);
		
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public Double getThanhTien(ArrayList<BanHangbean> dsBH) {
		Double thanhTien = 0.0;
		
		for (BanHangbean bh : dsBH)
		{
			thanhTien += (bh.getGia() * bh.getSoLuongMua());
		}
		
		return thanhTien;
	}
}

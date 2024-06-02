package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.nvBean;

public class nvDao {
	public ArrayList<nvBean> getNV() throws Exception
	{
		ArrayList<nvBean> ds = new ArrayList<nvBean>();
		
		FileReader f = new FileReader("ketqua.txt");
		BufferedReader r = new BufferedReader(f);
		
		String line = "";
		while ((line = r.readLine()) != null)
		{
			String[] sp = line.split("[,]");
			if (sp.length == 4)
			{
				String maGV = sp[0];
				String hoTen = sp[1];
				String loaiHopDong = sp[2];
				Double heSoLuong = Double.parseDouble(sp[3]);
				
				ds.add(new nvBean(maGV, hoTen, loaiHopDong, heSoLuong));
				System.out.println(line);
			}
		}
		r.close();
		return ds;
	}
	
	public int saveSQL(nvBean nv) throws Exception{
		nguoiDao nDao = new nguoiDao();
		nDao.connect();

		String sql = "INSERT INTO NhanVien(maNV, hoTen, loaiHopDong, heSoLuong) VALUES(?, ?, ?, ?)";
		PreparedStatement cmd = nDao.cn.prepareStatement(sql);
		cmd.setString(1, nv.getMaNV());
		cmd.setString(2, nv.getHoTen());
		cmd.setString(3, nv.getLoaiHopDong());
		cmd.setDouble(4, nv.getHeSoLuong());
		
		int kq = cmd.executeUpdate();
		cmd.close();
		nDao.cn.close();
		return kq;
	}
}

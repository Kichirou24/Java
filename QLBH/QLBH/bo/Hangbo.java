package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.Hangbean;
import dao.Hangdao;

public class Hangbo {
	Hangdao hdao = new Hangdao();
	
	ArrayList<Hangbean> ds = new ArrayList<Hangbean>();
	
	public ArrayList<Hangbean> getHang() throws Exception{
		//ds = hdao.getHang();
		ds = hdao.load();
		return ds;
	}
	
	public void upload() throws Exception 
	{
		hdao.upload();
	}
	
	public int insert(String maHang, String tenHang, Date ngayNhapHang, Integer soLuong, Double gia) throws Exception{
		for (Hangbean h : ds)
			if (h.getMaHang().equals(maHang))
				return 0;
		ds.add(new Hangbean(maHang, tenHang, ngayNhapHang, soLuong, gia));
		return hdao.insert(maHang, tenHang, ngayNhapHang, soLuong, gia);
	}
	
	public int delete(String maHang) throws Exception {
		return hdao.delete(maHang);
	}
	
	public int update(String maHang, String tenHang, Date ngayNhapHang, Integer soLuong, Double gia) throws Exception{
		return hdao.update(maHang, tenHang, ngayNhapHang, soLuong, gia);
	}
	
	public void save() throws Exception{
		for (Hangbean h1 : ds)
		{
			for (Hangbean h2 : hdao.load())
			{
				if (h1.getMaHang().trim().equals(h2.getMaHang().trim()))
					continue;
			}
			hdao.insert(h1.getMaHang(), h1.getTenhang(), h1.getNgayNhapHang(), h1.getSoLuong(), h1.getGia());
		}
	}
}
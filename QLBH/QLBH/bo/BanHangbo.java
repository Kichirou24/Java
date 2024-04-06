package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.BanHangbean;
import bean.Hangbean;
import dao.BanHangdao;
import dao.Hangdao;

public class BanHangbo {
	BanHangdao bhdao = new BanHangdao();
	Hangdao hdao = new Hangdao();
	ArrayList<BanHangbean> ds = new ArrayList<BanHangbean>();
	public ArrayList<BanHangbean> getHang() throws Exception{
		//ds = hdao.getHang();
		ds = bhdao.load();
		return ds;
	}
	
	public void add(BanHangbean bh) throws Exception
	{
		bhdao.add(bh);
	}
	
	public int insert(String maHang, String tenHang, Date ngayMua, Integer soLuongMua, Double gia) throws Exception
	{
		return bhdao.insert(maHang, tenHang, ngayMua, soLuongMua, gia);
	}
}

package bo;

import java.util.ArrayList;

import bean.NhanVienbean;

public class NhanVienbo {
	Nguoibo nbo = new Nguoibo();
	
	ArrayList<NhanVienbean> ds;
	
	public ArrayList<NhanVienbean> getDS() throws Exception{
		nbo.getDS();
		ds = nbo.getDSNV();
		return ds;
	}
}

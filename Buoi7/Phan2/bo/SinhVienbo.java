package bo;

import java.util.ArrayList;

import bean.SinhVienbean;

public class SinhVienbo {
	Nguoibo nbo = new Nguoibo();
	
	ArrayList<SinhVienbean> ds;
	
	public ArrayList<SinhVienbean> getDS() throws Exception{
		nbo.getDS();
		ds = nbo.getDSSV();
		return ds;
	}
	
	public ArrayList<SinhVienbean> getDSTheoLop(String lop) throws Exception{
		ArrayList<SinhVienbean> tam = new ArrayList<SinhVienbean>();
		for (SinhVienbean sv : ds)
			if (sv.getTenLop().equals(lop))
				tam.add(sv);
		return tam;
	}
}

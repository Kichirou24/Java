package bo;

import java.util.ArrayList;

import bean.CaoDangbean;
import bean.DaiHocbean;
import bean.SinhVienbean;
import dao.SinhViendao;

public class SinhVienbo {
	SinhViendao svdao = new SinhViendao();
	
	ArrayList<SinhVienbean> ds;
	
	public ArrayList<SinhVienbean> getDS() throws Exception {
		ds = svdao.getDS();
		return ds;
	}
	
	public ArrayList<SinhVienbean> getDSSVDH() throws Exception {
		ArrayList<SinhVienbean> tam = new ArrayList<SinhVienbean>();
		for (SinhVienbean sv : ds)
			if (sv instanceof DaiHocbean) {
				 tam.add(sv);
			}
		return tam;
	}
	
	public ArrayList<SinhVienbean> getDSSVCD() throws Exception {
		ArrayList<SinhVienbean> tam = new ArrayList<SinhVienbean>();
		for (SinhVienbean sv : ds)
			if (sv instanceof CaoDangbean) {
				 tam.add(sv);
			}
		return tam;
	}
}

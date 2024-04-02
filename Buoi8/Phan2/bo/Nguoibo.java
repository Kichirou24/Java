package bo;

import java.util.ArrayList;

import bean.Nguoibean;
import bean.NhanVienbean;
import bean.SinhVienbean;
import dao.Nguoidao;

public class Nguoibo {
	Nguoidao ndao = new Nguoidao();
	
	ArrayList<Nguoibean> ds;
	
	public ArrayList<Nguoibean> getDS() throws Exception{
		ds = ndao.get();
		return ds;
	}
	
	public ArrayList<NhanVienbean> getDSNV() throws Exception{
		ArrayList<NhanVienbean> tam = new ArrayList<NhanVienbean>();
		for (Nguoibean ng : ds)
			if (ng instanceof NhanVienbean) {
				tam.add((NhanVienbean)ng);				
			}
		return tam;
	}
	
	public ArrayList<SinhVienbean> getDSSV() throws Exception{
		ArrayList<SinhVienbean> tam = new ArrayList<SinhVienbean>();
		for (Nguoibean ng : ds)
			if (ng instanceof SinhVienbean) {
				tam.add((SinhVienbean)ng);				
			}
		return tam;
	}
	
	public ArrayList<Nguoibean> getDSNu() throws Exception{
		ArrayList<Nguoibean> tam = new ArrayList<Nguoibean>();
		for (Nguoibean nguoi : ds)
			if (nguoi.isGioiTinh() == false)
				tam.add(nguoi);
		return tam;
	}
	
	public ArrayList<Nguoibean> getDSTheoTuoi(int tuoi) throws Exception{
		ArrayList<Nguoibean> tam = new ArrayList<Nguoibean>();
		for (Nguoibean nguoi : ds)
			if (nguoi.getTuoi() >= tuoi)
				tam.add(nguoi);
		return tam;
	}
	
	public double tbcTuoi() throws Exception{
		double sum = 0.0;
		for (Nguoibean nguoi : ds)
			sum += nguoi.getTuoi();

		double dtb = (sum/(ds.size()));
		return dtb;
	}
}

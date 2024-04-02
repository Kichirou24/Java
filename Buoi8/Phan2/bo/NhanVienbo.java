package bo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.NhanVienbean;
import dao.NhanViendao;

public class NhanVienbo {
	SimpleDateFormat sdf = new SimpleDateFormat();
	Nguoibo nbo = new Nguoibo();
	NhanViendao nvdao = new NhanViendao();
	
	ArrayList<NhanVienbean> ds;
	
	public ArrayList<NhanVienbean> getNV() throws Exception{
		ds = nvdao.getNV();
		return ds;
	}
	
	public int delete(String manv) throws Exception {
		return nvdao.deleteNV(manv);
	}
	
	public int update(String manv, Double hsl) throws Exception{
		return nvdao.updateNV(manv, hsl);
	}
	
	public int insert(String maNV, String hoTen, boolean gioiTinh, Date ngaySinh, Double hSL, String email, String phone) throws Exception {
		for (NhanVienbean nv : ds)
			if (nv.getMaNV().equals(maNV))
			{
				System.out.println("Nhan vien " + maNV + " da ton tai");
				return 0;
			}
		return nvdao.insertNV(maNV, hoTen, gioiTinh, ngaySinh, hSL, email, phone);
	}
	
	public void save(String tf) throws Exception{
		FileReader f = new FileReader(tf);
		BufferedReader r = new BufferedReader(f);
		NhanVienbo nvbo = new NhanVienbo();
		while(true)
		{
			String st = r.readLine();
			if (st == null || st == "")
				break;
			String[] sp = st.split("[,]");
			String manv = sp[0];
			String hoten = sp[1];
			boolean gioitinh = Boolean.parseBoolean(sp[2]);
			Date ngaysinh = sdf.parse(sp[3]);
			Double hsl = Double.parseDouble(sp[4]);
			String email = sp[5];
			String phone = sp[6];
			nvbo.insert(manv, hoten, gioitinh, ngaysinh, hsl, email, phone);
		}
		r.close();
	}
}

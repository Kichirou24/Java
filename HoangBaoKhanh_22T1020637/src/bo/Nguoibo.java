package bo;

import java.util.ArrayList;

import bean.Nguoi;
import bean.SinhVien;
import dao.Nguoidao;
import dao.SinhViendao;

public class Nguoibo {
	ArrayList<Nguoi> ds = new ArrayList<Nguoi>();

	
	
	public static ArrayList<SinhVien> findName(String name) throws Exception{
		ArrayList<SinhVien> list = SinhViendao.getSV();
		ArrayList<SinhVien> ans = new ArrayList<SinhVien>();
	for(SinhVien sv: list) {
		if(sv.getHoTen().toLowerCase().contains(name.toLowerCase())) {
			ans.add(sv);
		}
	}
	return ans;	
}
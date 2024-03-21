package bo;

import java.util.ArrayList;

import bean.NhanVien;
import dao.NhanViendao;

public class NhanVienbo {
	public static Double TongLuongNV() throws Exception {
		ArrayList<NhanVien> list = NhanViendao.getNV();
		Double sum = 0.0;
		for(NhanVien nv: list) {
			sum += nv.tienluong();
		}
		return sum;
	}
}
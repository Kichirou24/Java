package bo;

import java.util.ArrayList;

import bean.HangHoabean;
import dao.HangHoadao;

public class HangHoabo {
	HangHoadao hhdao = new HangHoadao();
	ArrayList<HangHoabean> ds = new ArrayList<HangHoabean>();
	public ArrayList<HangHoabean> getHangHoa() throws Exception{
	//	return hhdao.getHang(); // get data file
		return hhdao.getHangHoa(); // get data sql
	}
	
	
}
package bo;

import java.util.ArrayList;

import bean.giangVienBean;
import bean.nguoiBean;
import dao.giangVienDao;

public class giangVienBo {
	giangVienDao gvDao = new giangVienDao();
	ArrayList<giangVienBean> ds = new ArrayList<giangVienBean>();
	
	public int insertSQL(nguoiBean nguoi) throws Exception{
		String[] sp = nguoi.toString().split("[,]");
		if (nguoi instanceof giangVienBean)
			for (giangVienBean gv : ds)
				if (gv.getMaGiangVien().equals(sp[0]))
					return 0;
		giangVienBean newGV = new giangVienBean(sp[0], sp[1], sp[2], Double.parseDouble(sp[3]), Double.parseDouble(sp[4]));
		ds.add(newGV);
		return gvDao.insertSQL(newGV);
	}
}

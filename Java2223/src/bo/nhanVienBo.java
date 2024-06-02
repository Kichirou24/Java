package bo;

import java.util.ArrayList;

import bean.nguoiBean;
import bean.nhanVienBean;
import dao.nhanVienDao;

public class nhanVienBo {
	nhanVienDao nvDao = new nhanVienDao();
	ArrayList<nhanVienBean> ds = new ArrayList<nhanVienBean>();
	public int insertSQL(nguoiBean nguoi) throws Exception{
		String[] sp = nguoi.toString().split("[,]");
		if (nguoi instanceof nhanVienBean)
			for (nhanVienBean nv : ds)
				if (nv.getMaNhanVien().equals(sp[0]))
					return 0;
		nhanVienBean newNV = new nhanVienBean(sp[0], sp[1], sp[2], Double.parseDouble(sp[3]));
		ds.add(newNV);
		return nvDao.insertSQL(newNV);
	}
	
	public ArrayList<String> statistics() throws Exception{
		return nvDao.statisticsSQL();
	}
}

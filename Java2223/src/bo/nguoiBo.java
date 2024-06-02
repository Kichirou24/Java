package bo;

import java.util.ArrayList;

import bean.nguoiBean;
import dao.nguoiDao;

public class nguoiBo {
	ArrayList<nguoiBean> ds = new ArrayList<nguoiBean>();
	nguoiDao nDao = new nguoiDao();
	
	public void readFileDanhSach() throws Exception{
		nDao.readFileDanhSach();
	}
	
	public ArrayList<nguoiBean> readFileKetQua() throws Exception{
		ds = nDao.readFileKetQua();
		return ds;
	}
}

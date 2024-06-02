package bo;

import java.util.ArrayList;

import dao.nguoiDao;

public class nguoiBo {
	ArrayList<String> ds = new ArrayList<String>();
	nguoiDao nDao = new nguoiDao();
	public ArrayList<String> getAndSave() throws Exception
	{
		ds = nDao.getAndSave();
		return ds;
	}
}

package bo;

import java.util.ArrayList;

import bean.gvBean;
import dao.gvDao;

public class gvBo {
	gvDao gv = new gvDao();
	ArrayList<gvBean> ds = new ArrayList<gvBean>();
	
	public ArrayList<gvBean> getGV() throws Exception
	{
		ds = gv.getGV();
		return ds;
	}
	
	public int saveSQL(gvBean g) throws Exception {
		for (gvBean gg : ds)
		{
			if (gg.equals(g))
			{
				return 0;
			}
		}
		return gv.saveSQL(g);
	}
}
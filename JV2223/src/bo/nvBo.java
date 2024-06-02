package bo;

import java.util.ArrayList;

import bean.nvBean;
import dao.nvDao;

public class nvBo {
	nvDao nv = new nvDao();
	ArrayList<nvBean> ds = new ArrayList<nvBean>();
	
	public ArrayList<nvBean> getNV() throws Exception
	{
		ds = nv.getNV();
		return ds;
	}
	
	public int saveSQL(nvBean n) throws Exception {
		for (nvBean nn : ds)
		{
			if (nn.equals(n))
			{
				return 0;
			}
		}
		return nv.saveSQL(n);
	}
}

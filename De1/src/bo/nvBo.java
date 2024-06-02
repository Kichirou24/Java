package bo;

import java.util.ArrayList;

import bean.nvBean;
import dao.nvDao;

public class nvBo {
	nvDao nvD = new nvDao();
	ArrayList<nvBean> ds = new ArrayList<nvBean>();
	ArrayList<nvBean> dsNVCT = new ArrayList<nvBean>();
	ArrayList<nvBean> dsSQL = new ArrayList<nvBean>();
	public void showFile() throws Exception{
		nvD.showFile();
	}
	
	public ArrayList<nvBean> readFile() throws Exception{
		ds = nvD.readFile();
		return ds;
	}
	
	public void insertSQL(ArrayList<nvBean> dsNV) throws Exception{
		dsSQL = nvD.getSQL();
		for (nvBean nv : dsNV)
		{
			for (nvBean nvHT : dsSQL)
				if (nvHT.getMaNV().equals(nv.getMaNV()))
				{
					System.out.println("Nhan vien co ma " + nv.getMaNV() + " da ton tai");
					break;
				}
			if (nvD.insertSQL(nv) == 1)
			{
				System.out.println("Them thanh cong nhan vien co ma " + nv.getMaNV());
				dsSQL.add(nv);
			}
		}
	}
	
	public ArrayList<nvBean> showSQL() throws Exception{
		dsNVCT = nvD.showSQL();
		return dsNVCT;
	}
}

package view;

import java.util.ArrayList;

import bean.gvBean;
import bean.nvBean;
import bo.gvBo;
import bo.nguoiBo;
import bo.nvBo;

public class nguoiView {
	public static void main(String[] args) throws Exception{
		nguoiBo nBo = new nguoiBo();
		nvBo nv = new nvBo();
		gvBo gv = new gvBo();
		
		ArrayList<nvBean> dsNV = new ArrayList<nvBean>();
		ArrayList<gvBean> dsGV = new ArrayList<gvBean>();		
		
		System.out.println("Cau 2: Danh sach nhan vien, giang vien hop le: ");
		nBo.getAndSave();
		
		System.out.println("Cau 3: Danh sach nhan vien: ");
		dsNV = nv.getNV();
		
		System.out.println("Cau 3: Danh sach giang vien: ");
		dsGV = gv.getGV();
		
		for (nvBean n : dsNV)
		{
			nv.saveSQL(n);
		}
		
		for (gvBean g : dsGV)
		{
			gv.saveSQL(g);
		}
		
		System.out.println("Cau 4: Luu vao DB");
		
		
	}
}

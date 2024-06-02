package view;

import java.util.ArrayList;

import bean.nvBean;
import bo.nvBo;

public class nvView {
	
	public static void main(String[] args) throws Exception{
		nvBo bo = new nvBo();
		System.out.println("--------- Cau 2 ---------");
		
		bo.showFile();
		
		System.out.println("--------- Cau 3 ---------");
		
		ArrayList<nvBean> ds = bo.readFile();
		
		System.out.println("--------- Cau 4 ---------");
		
		bo.insertSQL(ds);
		
		System.out.println("--------- Cau 5 ---------");
		
		ArrayList<nvBean> dsNVCT = bo.showSQL();
		
	}
}

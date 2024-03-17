package bean;

import java.util.Date;

public class SinhVienBean {
	private String maSinhVien;
	private Double dtb;
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public Double getDtb() {
		return dtb;
	}
	public void setDtb(Double dtb) {
		this.dtb = dtb;
	}
	
	public SinhVienBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SinhVienBean [maSinhVien=" + maSinhVien + ", dtb=" + dtb + "]";
	}
	
	
}

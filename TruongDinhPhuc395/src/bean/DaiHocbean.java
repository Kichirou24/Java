package bean;

import java.util.Date;

public class DaiHocbean extends SinhVienbean {
	private Boolean diemNCKH;
	private Boolean dKNN;
	
	public DaiHocbean(String maSV, String hoTen, Date ngaySinh, Double diemTB) {
		super(maSV, hoTen, ngaySinh, diemTB);
		// TODO Auto-generated constructor stub
	}
	public DaiHocbean(String maSV, String hoTen, Date ngaySinh, Double diemTB, Boolean diemNCKH, Boolean dKNN) {
		super(maSV, hoTen, ngaySinh, diemTB);
		this.diemNCKH = diemNCKH;
		this.dKNN = dKNN;
	}
	public Boolean getDiemNCKH() {
		return diemNCKH;
	}
	public void setDiemNCKH(Boolean diemNCKH) {
		this.diemNCKH = diemNCKH;
	}
	public Boolean getdKNN() {
		return dKNN;
	}
	public void setdKNN(Boolean dKNN) {
		this.dKNN = dKNN;
	}
	
	@Override
	public String toString() {
		return super.toString() + ";" + (diemNCKH == true ? "Đạt" : "Không Đạt") + ";" + (dKNN == true ? "Đạt" : "Không Đạt");
	}
}

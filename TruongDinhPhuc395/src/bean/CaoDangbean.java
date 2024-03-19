package bean;

import java.util.Date;

public class CaoDangbean extends SinhVienbean {
	private Boolean diemN;

	public Boolean getDiemN() {
		return diemN;
	}

	public void setDiemN(Boolean diemN) {
		this.diemN = diemN;
	}

	public CaoDangbean(String maSV, String hoTen, Date ngaySinh, Double diemTB) {
		super(maSV, hoTen, ngaySinh, diemTB);
		// TODO Auto-generated constructor stub
	}

	public CaoDangbean(String maSV, String hoTen, Date ngaySinh, Double diemTB, Boolean diemN) {
		super(maSV, hoTen, ngaySinh, diemTB);
		this.diemN = diemN;
	}

	@Override
	public String toString() {
		return super.toString() + ";" + (diemN == true ? "Đạt" : "Không Đạt");
	}
	
}

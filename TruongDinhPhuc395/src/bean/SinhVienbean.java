package bean;

import java.util.Date;

public class SinhVienbean {
	private String maSV;
	private String hoTen;
	private Date ngaySinh;
	private Double diemTB;
	
	public SinhVienbean(String maSV, String hoTen, Date ngaySinh, Double diemTB) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diemTB = diemTB;
	}

	public SinhVienbean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getMaSV() {
		return maSV;
	}



	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}



	public String getHoTen() {
		return hoTen;
	}



	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}



	public Date getNgaySinh() {
		return ngaySinh;
	}



	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}



	public Double getDiemTB() {
		return diemTB;
	}



	public void setDiemTB(Double diemTB) {
		this.diemTB = diemTB;
	}



	@Override
	public String toString() {
		return maSV + ";" + hoTen + ";" + ngaySinh + ";" + diemTB;
	}
	
	
}

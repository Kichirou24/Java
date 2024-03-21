package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SinhVien extends Nguoi {
	private String maSV;
	private Double diemmon1;
	private Double diemmon2;
	public SinhVien(String hoTen, Date ngaySinh, String maSV, Double diemmon1, Double diemmon2) {
		super(hoTen, ngaySinh);
		this.maSV = maSV;
		this.diemmon1 = diemmon1;
		this.diemmon2 = diemmon2;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public Double getDiemmon1() {
		return diemmon1;
	}
	public void setDiemmon1(Double diemmon1) {
		this.diemmon1 = diemmon1;
	}
	public Double getDiemmon2() {
		return diemmon2;
	}
	public void setDiemmon2(Double diemmon2) {
		this.diemmon2 = diemmon2;
	}
	public Double getDiemTB() {
		return (diemmon1 + diemmon2) / 2;
	}
	public Object[] toObject() {
		Object[] obj = new Object[6];
		obj[0] = getMaSV();
		obj[1] = getHoTen();
		obj[2] = new SimpleDateFormat("dd/MM/yyyy").format(getNgaySinh());
		obj[3] = getDiemmon1();
		obj[4] = getDiemmon2();
		obj[5] = getDiemTB();
		return obj;
	}
	@Override
	public String toString() {
		return  getMaSV() + ";" + getHoTen() +";" +
				new SimpleDateFormat("dd/MM/yyyy").format(getNgaySinh())+";"+
				getDiemmon1().toString() + ";" + getDiemmon2().toString();
	}
	
	
}

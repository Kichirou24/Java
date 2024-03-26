package bean;

import java.util.Date;

public class NhanVienbean extends Nguoibean {
	public String maNV;
	public Double hSL;
	public String email;
	public String phone;
	
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public Double gethSL() {
		return hSL;
	}
	public void sethSL(Double hSL) {
		this.hSL = hSL;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getsDT() {
		return phone;
	}
	public void setsDT(String sDT) {
		this.phone = sDT;
	}
	public NhanVienbean(String maNV, String hoTen, boolean gioiTinh, Date ngaySinh, Double hSL, String email,
			String phone) {
		super(hoTen, gioiTinh, ngaySinh);
		this.maNV = maNV;
		this.hSL = hSL;
		this.email = email;
		this.phone = phone;
	}
	public NhanVienbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return maNV + ";" + super.toString() + ";" + hSL + ";" + email + ";" + phone;
	}
	
	
}

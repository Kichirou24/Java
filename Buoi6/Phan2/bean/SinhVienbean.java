package bean;

import java.util.Date;

public class SinhVienbean extends Nguoibean {
	public String mSV;
	public String tenLop;
	public Double dTB;
	
	public SinhVienbean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVienbean(String mSV, String hoTen, boolean gioiTinh, Date ngaySinh,  String tenLop, Double dTB) {
		super(hoTen, gioiTinh, ngaySinh);
		this.mSV = mSV;
		this.tenLop = tenLop;
		this.dTB = dTB;
	}

	public String getmSV() {
		return mSV;
	}

	public void setmSV(String mSV) {
		this.mSV = mSV;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public Double getdTB() {
		return dTB;
	}

	public void setdTB(Double dTB) {
		this.dTB = dTB;
	}

	@Override
	public String toString() {
		return mSV + ";" + super.toString() + ";" + tenLop + ";" + dTB;
	}
	
	
}

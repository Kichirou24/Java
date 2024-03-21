package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NhanVien extends Nguoi {
	private String maNV;
	private Double heSoLuong;
	public NhanVien(String hoTen, Date ngaySinh, String maNV, Double heSoLuong) {
		super(hoTen, ngaySinh);
		this.maNV = maNV;
		this.heSoLuong = heSoLuong;
	}
	public NhanVien() {
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public Double getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(Double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public Double tienluong() {
		return heSoLuong * 1600000;
	}
	public Object[] toObject() {
		Object[] obj = new Object[5];
		obj[0] = getMaNV();
		obj[1] = getHoTen();
		obj[2] = (new SimpleDateFormat("dd/MM/yyyy")).format(getNgaySinh());
		obj[3] = getHeSoLuong();
		obj[4] = tienluong();
		return obj;
		}
	@Override
	public String toString() {
		return getMaNV() + ";" + 
			   getHoTen() + ";" + 
	           new SimpleDateFormat("dd/MM/yyyy").format(getNgaySinh()) +";"+ 
			   getHeSoLuong().toString();
	}
	
	
}

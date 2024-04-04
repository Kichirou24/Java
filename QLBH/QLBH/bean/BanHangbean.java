package bean;

import java.util.Date;

public class BanHangbean extends Hangbean {
	private Integer soHoaDon;
	private Date ngayMua;
	private Integer soLuongMua;
	public Integer getSoHoaDon() {
		return soHoaDon;
	}
	public void setSoHoaDon(Integer soHoaDon) {
		this.soHoaDon = soHoaDon;
	}
	public Date getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}
	public Integer getSoLuongMua() {
		return soLuongMua;
	}
	public void setSoLuongMua(Integer soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	public BanHangbean() {
		
	}
	
	
}

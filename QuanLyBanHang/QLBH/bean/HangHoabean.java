package bean;

import java.util.Date;

public class HangHoabean {
	private String maHang;
	private String tenHang;
	private Date ngayNhapHang;
	private Integer soLuong;
	private Double gia;
	
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	public Date getNgayNhapHang() {
		return ngayNhapHang;
	}
	public void setNgayNhapHang(Date ngayNhapHang) {
		this.ngayNhapHang = ngayNhapHang;
	}
	public Integer getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}
	public Double getGia() {
		return gia;
	}
	public void setGia(Double gia) {
		this.gia = gia;
	}
	public HangHoabean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HangHoabean(String maHang, String tenHang, Date ngayNhapHang, Integer soLuong, Double gia) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.ngayNhapHang = ngayNhapHang;
		this.soLuong = soLuong;
		this.gia = gia;
	}
	@Override
	public String toString() {
		return maHang + ";" + tenHang + ";" + ngayNhapHang + ";" + soLuong + ";" + gia;
	}
}

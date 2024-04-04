package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hangbean {
	private String maHang;
	private String tenHang;
	private Date ngayNhapHang;
	private Integer soLuong;
	private Double gia;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	public String getTenhang() {
		return tenHang;
	}
	public void setTenhang(String tenhang) {
		this.tenHang = tenhang;
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
	public Hangbean(String maHang, String tenHang, Date ngayNhapHang, Integer soLuong, Double gia) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.ngayNhapHang = ngayNhapHang;
		this.soLuong = soLuong;
		this.gia = gia;
	}
	public Hangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		String date = sdf.format(ngayNhapHang);
		return maHang + ";" + tenHang + ";" + date + ";" + soLuong + ";" + gia;
	}
}
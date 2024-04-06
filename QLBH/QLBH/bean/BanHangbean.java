package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BanHangbean extends Hangbean {
	private Date ngayMua;
	private Integer soLuongMua;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public BanHangbean(String maHang, String tenHang, Date ngayMua, Integer soLuongMua, Double gia) {
//		super(maHang, tenHang, gia);
		super.setMaHang(maHang);
		super.setTenhang(tenHang);
		super.setGia(gia);
		this.soLuongMua = soLuongMua;
		Date currentDate = new Date();
		this.ngayMua = currentDate;
		// TODO Auto-generated constructor stub
	}
	public Date getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(Date ngayMua) {
		Date currentDate = new Date();
		this.ngayMua = currentDate;
	}
	public Integer getSoLuongMua() {
		return soLuongMua;
	}
	public void setSoLuongMua(Integer soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	public Double getThanhTien() {
		return super.getGia() * soLuongMua;
	}
	
	@Override
	public String toString() {
		return getMaHang() + ";" + getTenhang() + ";" + sdf.format(ngayMua) + ";" + soLuongMua + ";" + getGia();
	}
}

package bean;

public class ChiTietHoaDonbean extends HangHoabean {
	private Integer maChiTietHoaDon;
	private String maHang;
	private Integer soLuongMua;
	public Integer getMaChiTietHoaDon() {
		return maChiTietHoaDon;
	}
	public void setMaChiTietHoaDon(Integer maChiTietHoaDon) {
		this.maChiTietHoaDon = maChiTietHoaDon;
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	public Integer getSoLuongMua() {
		return soLuongMua;
	}
	public void setSoLuongMua(Integer soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	public ChiTietHoaDonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDonbean(Integer maChiTietHoaDon, Integer maHoaDon, String maHang, Integer soLuongMua) {
		super();
		this.maChiTietHoaDon = maChiTietHoaDon;
		this.maHang = maHang;
		this.soLuongMua = soLuongMua;
	}
	@Override
	public String toString() {
		return maChiTietHoaDon + ";" + getMa + ";" + maHang + ";" + soLuongMua;
	}
}

package bean;

public class nguoiBean {
	private String hoTen, loaiHopDong;
	private double heSoLuong;
	public nguoiBean(String hoTen, String loaiHopDong, double heSoLuong) {
		super();
		this.hoTen = hoTen;
		this.loaiHopDong = loaiHopDong;
		this.heSoLuong = heSoLuong;
	}
	public nguoiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getLoaiHopDong() {
		return loaiHopDong;
	}
	public void setLoaiHopDong(String loaiHopDong) {
		this.loaiHopDong = loaiHopDong;
	}
	public double getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
}

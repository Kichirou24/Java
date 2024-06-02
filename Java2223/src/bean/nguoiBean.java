package bean;

public class nguoiBean {
	private String hoTen;
	private String loaiHopDong;
	private double heSoLuong;
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
	public Double getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(Double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public nguoiBean(String hoTen, String loaiHopDong, double heSoLuong) {
		super();
		this.hoTen = hoTen;
		this.loaiHopDong = loaiHopDong;
		this.heSoLuong = heSoLuong;
	}
//	public nguoiBean() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	@Override
	public String toString() {
		return hoTen + "," + loaiHopDong + "," + heSoLuong;
	}
	
	
}

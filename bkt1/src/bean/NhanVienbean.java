package bean;

public class NhanVienbean {
	private String maNV;
	private String hoTen;
	private String loaiHopDong;
	private int heSoLuong;
	
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
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
	public int getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(int heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public NhanVienbean(String maNV, String hoTen, String loaiHopDong, int heSoLuong) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.loaiHopDong = loaiHopDong;
		this.heSoLuong = heSoLuong;
	}
	public NhanVienbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return maNV + ";" + hoTen + ";" + loaiHopDong + ";" + heSoLuong;
	}
}

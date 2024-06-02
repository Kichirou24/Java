package bean;

public class nvBean {
	private String maNV;
	private String hoTen;
	private String loaiHopDong;
	private double heSoLuong;
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
	public double getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	/**
	 * @param maNV
	 * @param hoTen
	 * @param loaiHopDong
	 * @param heSoLuong
	 */
	public nvBean(String maNV, String hoTen, String loaiHopDong, double heSoLuong) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.loaiHopDong = loaiHopDong;
		this.heSoLuong = heSoLuong;
	}
	/**
	 * 
	 */
	public nvBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return maNV + ',' + hoTen + ',' + loaiHopDong + ',' + heSoLuong;
	}
	
	
}

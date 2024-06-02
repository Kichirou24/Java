package bean;

public class nvBean extends nguoiBean {
	private String maNV;

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public nvBean(String maNV, String hoTen, String loaiHopDong, double heSoLuong) {
		super(hoTen, loaiHopDong, heSoLuong);
		this.maNV = maNV;
	}

	public nvBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public nvBean(String hoTen, String loaiHopDong, double heSoLuong) {
		super(hoTen, loaiHopDong, heSoLuong);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return maNV + ',' + getHoTen() + ',' + getLoaiHopDong() + ',' + getHeSoLuong();
	}	
}

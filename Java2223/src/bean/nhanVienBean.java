package bean;

public class nhanVienBean extends nguoiBean{
	private String maNhanVien;

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public nhanVienBean(String maNhanVien, String hoTen, String loaiHopDong, double heSoLuong) {
		super(hoTen, loaiHopDong, heSoLuong);
		this.maNhanVien = maNhanVien;
	}

	/**
	 * 
	 */
//	public nhanVienBean() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public String toString() {
		return maNhanVien + "," + super.toString();
	}
}

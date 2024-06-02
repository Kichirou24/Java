package bean;

public class giangVienBean extends nguoiBean{
	private String maGiangVien;
	private double phuCap;
	public String getMaGiangVien() {
		return maGiangVien;
	}
	public void setMaGiangVien(String maGiangVien) {
		this.maGiangVien = maGiangVien;
	}
	public Double getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(Double phuCap) {
		this.phuCap = phuCap;
	}
	
	public giangVienBean(String maGiangVien, String hoTen, String loaiHopDong, double heSoLuong, double phuCap) {
		super(hoTen, loaiHopDong, heSoLuong);
		this.maGiangVien = maGiangVien;
		this.phuCap = phuCap;
	}
//	public giangVienBean() {
//		super();
//		// TODO Auto-generated constructor stub
//	}	
	@Override
	public String toString() {
		return maGiangVien + "," + super.toString() + "," + phuCap;
	}
	
	
}

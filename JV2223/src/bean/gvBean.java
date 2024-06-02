package bean;

public class gvBean extends nguoiBean{
	private String maGV;
	private double phuCap;
	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	public double getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}
	public gvBean(String maGV, double phuCap) {
		super();
		this.maGV = maGV;
		this.phuCap = phuCap;
	}
	public gvBean(String maGV, String hoTen, String loaiHopDong, double heSoLuong, double phuCap) {
		super(hoTen, loaiHopDong, heSoLuong);
		this.maGV = maGV;
		this.phuCap = phuCap;
	}
	public gvBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public gvBean(String hoTen, String loaiHopDong, double heSoLuong) {
		super(hoTen, loaiHopDong, heSoLuong);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return maGV + ',' + getHoTen() + ',' + getLoaiHopDong() + ',' + getHeSoLuong() + ',' + phuCap;
	}
}

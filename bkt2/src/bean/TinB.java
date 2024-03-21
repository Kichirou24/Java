package bean;

public class TinB {
	private String maSV;
	private String hoTen;
	private Double diemExcel;
	private Double diemPowerpoint;
	private Double diemWeb;
	private Double diemTB;	
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Double getDiemExcel() {
		return diemExcel;
	}
	public void setDiemExcel(Double diemExcel) {
		this.diemExcel = diemExcel;
	}
	public Double getDiemPowerpoint() {
		return diemPowerpoint;
	}
	public void setDiemPowerpoint(Double diemPowerpoint) {
		this.diemPowerpoint = diemPowerpoint;
	}
	public Double getDiemWeb() {
		return diemWeb;
	}
	public void setDiemWeb(Double diemWeb) {
		this.diemWeb = diemWeb;
	}
	public Double getDiemTB() {
		return diemTB;
	}
	public void setDiemTB(Double diemTB) {
		this.diemTB = diemTB;
	}
	public TinB() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Double tinhDTB()
	{
		Double dtb = (diemExcel + diemPowerpoint + diemWeb)/3;
		dtb = Math.ceil(dtb * 100) / 100;
		return dtb;
	}
	
	public TinB(String maSV, String hoTen, Double diemExcel, Double diemPowerpoint, Double diemWeb) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.diemExcel = diemExcel;
		this.diemPowerpoint = diemPowerpoint;
		this.diemWeb = diemWeb;
		tinhDTB();
	}
	@Override
	public String toString() {
		return maSV + ";" + hoTen + ";" + diemExcel + ";" + diemPowerpoint + ";" + diemWeb + ";" + diemTB;
	}
	
	
}

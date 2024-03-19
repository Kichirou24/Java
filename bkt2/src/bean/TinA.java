package bean;

public class TinA {
	private String maSV;
	private String hoTen;
	private Double diemWin;
	private Double diemWord;
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
	public Double getDiemWin() {
		return diemWin;
	}
	public void setDiemWin(Double diemWin) {
		this.diemWin = diemWin;
	}
	public Double getDiemWord() {
		return diemWord;
	}
	public void setDiemWord(Double diemWord) {
		this.diemWord = diemWord;
	}
	public Double getDiemTB() {
		return diemTB;
	}
	public void setDiemTB(Double diemTB) {
		this.diemTB = diemTB;
	}
	public TinA() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Double tinhDTB()
	{
		Double dtb = (diemWord + diemWin)/2;
		dtb = Math.ceil(dtb * 100) / 100;
		return dtb;
	}
	
	public TinA(String maSV, String hoTen, Double diemWin, Double diemWord) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.diemWin = diemWin;
		this.diemWord = diemWord;
		tinhDTB();
	}
	@Override
	public String toString() {
		return maSV + ";" + hoTen + ";" + diemWin + ";" + diemWord + ";" + diemTB;
	}
	
	
}

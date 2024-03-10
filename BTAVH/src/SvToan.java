
public class SvToan {
	private String MaSv;
	private String HoTen;
	private double Dm1;
	private double Dm2;
	private double Dm3;
	
	public String getMaSv() {
		return MaSv;
	}

	public void setMaSv(String maSv) {
		MaSv = maSv;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public double getDm1() {
		return Dm1;
	}

	public void setDm1(double dm1) {
		Dm1 = dm1;
	}

	public double getDm2() {
		return Dm2;
	}

	public void setDm2(double dm2) {
		Dm2 = dm2;
	}

	public double getDm3() {
		return Dm3;
	}

	public void setDm3(double dm3) {
		Dm3 = dm3;
	}

	public double getDtb() {
		return (Dm1 + Dm2 + Dm3)/3;
	}
	
	public String getKetQua() {
		return getDtb() >= 5 ? "Dau" : "Rot";
	}
	
	public void HienThi()
	{
		System.out.println(MaSv + "|" + HoTen + "|" + Dm1 + "|" + Dm2 + "|" + Dm3 + "|" + getDtb() + "|" + getKetQua());
	}
	
	public String getThongTin() {
		return MaSv + "|" + HoTen + "|" + Dm1 + "|" + Dm2 + "|" + + Dm3 + "|" + getDtb() + "|" + getKetQua();
	}
}

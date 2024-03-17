package bean;

import java.util.Date;

public class NhanVienBean extends NguoiBean {
    private String manv;
    private String email;
    private String sodienthoai;
    private String hesoluong;
    public NhanVienBean(String hoten, Boolean gioitinh, Date ngaysinh, String manv, String email, String sodienthoai,
            String hesoluong) {
        super(hoten, gioitinh, ngaysinh); // Gọi lên hàm tạo là lớp cha và truyền lên 3 tham số!!!!
        this.manv = manv;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.hesoluong = hesoluong;
    }// Phát sinh các hàm get, set, toString:
    public String getManv() {
        return manv;
    }
    public void setManv(String manv) {
        this.manv = manv;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSodienthoai() {
        return sodienthoai;
    }
    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }
    public String getHesoluong() {
        return hesoluong;
    }
    public void setHesoluong(String hesoluong) {
        this.hesoluong = hesoluong;
    }
    @Override
    public String toString() {
        return "NhanVienBean " + super.toString() + " [manv=" + manv + ", email=" + email + ", sodienthoai=" + sodienthoai + ", hesoluong="
                + hesoluong + "]";
    }

}
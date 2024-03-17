package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NguoiBean {
    private String hoten;
    private Boolean gioitinh;
    private Date ngaysinh;
    public NguoiBean() {
        super();
        // TODO Auto-generated constructor stub
    }
    public NguoiBean(Boolean gioitinh, Date ngaysinh) {
        super();
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
    }
    public NguoiBean(String hoten, Boolean gioitinh, Date ngaysinh) {
        super();
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
    }
    public String getHoten() {
        return hoten;
    }
    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    public Boolean getGioitinh() {
        return gioitinh;
    }
    public void setGioitinh(Boolean gioitinh) {
        this.gioitinh = gioitinh;
    }
    public Date getNgaysinh() {
        return ngaysinh;
    }
    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
    @Override
    public String toString() {
        SimpleDateFormat dd=new SimpleDateFormat("dd/MM/yyyy");
        String ngay=dd.format(ngaysinh);
        return "Hoten:" + hoten + ", Gioitinh:" + gioitinh + ", Ngaysinh:" + ngay + ", Tuoi:"+getTuoi(ngay) ;
    }
    public int getTuoi(String ngaysinh) {
        String year=ngaysinh.split("[/]")[2];
        Date y=new Date();
        SimpleDateFormat dd=new SimpleDateFormat("dd/MM/yyyy");
        String nht=dd.format(y);
        return Integer.parseInt(nht.split("[/]")[2]) -  Integer.parseInt(year);
    }


}
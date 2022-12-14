package quanlyduan.thannhan;

import quanlyduan.cauhinh.CauHinh;

import java.text.ParseException;
import java.util.Date;

public class ThanNhan {
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String moiQuanHe;

    public ThanNhan() throws ParseException {
        CauHinh.sc.nextLine();
        System.out.print("Ho ten: ");
        this.hoTen = CauHinh.sc.nextLine();
        System.out.print("Ngay sinh: ");
        this.ngaySinh = CauHinh.f.parse(CauHinh.sc.nextLine());
        System.out.print("Gioi tinh: ");
        this.gioiTinh = CauHinh.sc.nextLine();
        System.out.print("Moi quan he: ");
        this.moiQuanHe = CauHinh.sc.nextLine();
    }

    public ThanNhan(String hoTen, Date ngaySinh, String gioiTinh, String moiQuanHe) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.moiQuanHe = moiQuanHe;
    }

    @Override
    public String toString() {
        return String.format("\n=\nHo ten: %s\nNgay sinh: %s\nGioi tinh: %s\nMoi quan he: %s",
                this.hoTen, CauHinh.f.format(this.ngaySinh), this.gioiTinh, this.moiQuanHe);
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMoiQuanHe() {
        return moiQuanHe;
    }

    public void setMoiQuanHe(String moiQuanHe) {
        this.moiQuanHe = moiQuanHe;
    }
}

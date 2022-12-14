package quanlyduan.nhanvien;

import quanlyduan.cauhinh.CauHinh;
import quanlyduan.cauhinh.LoaiNhanVien;
import quanlyduan.phongban.PhongBan;

import java.util.Date;

public class LapTrinhVien extends NhanVien {
    private double luongOT;

    public LapTrinhVien(String hoTen, Date ngaySinh, String email, String gioiTinh,
                        PhongBan phongBan, LoaiNhanVien loaiNhanVien, double luongOT) {
        super(hoTen, ngaySinh, email, gioiTinh, phongBan, loaiNhanVien);
        this.luongOT = luongOT;
    }

    @Override
    public double getHeSo() {
        return 1.5;
    }

    @Override
    public double tinhLuong() {
        System.out.printf("\nNhap luong OT cua nhan vien %s: ", this.hoTen.toUpperCase());
        this.luongOT = CauHinh.sc.nextDouble();
        return this.getHeSo() * LUONG_CO_BAN + this.getLuongOT();
    }

    public double getLuongOT() {
        return luongOT;
    }

    public void setLuongOT(double luongOT) {
        this.luongOT = luongOT;
    }
}

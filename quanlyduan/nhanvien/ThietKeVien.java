package quanlyduan.nhanvien;

import quanlyduan.cauhinh.CauHinh;
import quanlyduan.cauhinh.LoaiNhanVien;
import quanlyduan.phongban.PhongBan;

import java.util.Date;

public class ThietKeVien extends NhanVien {
    private double bonus;

    public ThietKeVien(String hoTen, Date ngaySinh, String email, String gioiTinh,
                       PhongBan phongBan, LoaiNhanVien loaiNhanVien, double bonus) {
        super(hoTen, ngaySinh, email, gioiTinh, phongBan, loaiNhanVien);
        this.bonus = bonus;
    }

    @Override
    public double getHeSo() {
        return 1.5;
    }

    @Override
    public double tinhLuong() {
        System.out.printf("\nNhap bonus cua nhan vien %s: ", this.hoTen.toUpperCase());
        this.bonus = CauHinh.sc.nextDouble();
        return this.getHeSo() * LUONG_CO_BAN + this.bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}

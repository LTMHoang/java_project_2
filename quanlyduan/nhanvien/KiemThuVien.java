package quanlyduan.nhanvien;

import quanlyduan.cauhinh.CauHinh;
import quanlyduan.cauhinh.LoaiNhanVien;
import quanlyduan.phongban.PhongBan;

import java.util.Date;

public class KiemThuVien extends NhanVien {
    private int errors;

    public KiemThuVien(String hoTen, Date ngaySinh, String email, String gioiTinh,
                       PhongBan phongBan, LoaiNhanVien loaiNhanVien, int errors) {
        super(hoTen, ngaySinh, email, gioiTinh, phongBan, loaiNhanVien);
        this.errors = errors;
    }

    @Override
    public double getHeSo() {
        return 1.5;
    }

    @Override
    public double tinhLuong() {
        System.out.printf("\nNhap so loi quan trong ma nhan vien %s phat hien: ", this.hoTen.toUpperCase());
        this.errors = CauHinh.sc.nextInt();
        return this.getHeSo() * LUONG_CO_BAN + this.getErrors() * 0.2;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }
}

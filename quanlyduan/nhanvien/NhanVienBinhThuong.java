package quanlyduan.nhanvien;

import quanlyduan.cauhinh.LoaiNhanVien;
import quanlyduan.phongban.PhongBan;

import java.util.Date;

public class NhanVienBinhThuong extends NhanVien {
    public NhanVienBinhThuong (String hoTen, Date ngaySinh, String email, String gioiTinh,
                               PhongBan phongBan, LoaiNhanVien loaiNhanVien) {
        super(hoTen, ngaySinh, email, gioiTinh, phongBan, loaiNhanVien);
    }

    @Override
    public double getHeSo() {
        return 1.5;
    }

    @Override
    public double tinhLuong() {
        return this.getHeSo() * LUONG_CO_BAN;
    }
}

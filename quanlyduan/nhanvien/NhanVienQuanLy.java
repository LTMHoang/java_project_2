package quanlyduan.nhanvien;

import quanlyduan.cauhinh.CauHinh;
import quanlyduan.cauhinh.LoaiNhanVien;
import quanlyduan.phongban.PhongBan;

import java.util.Date;
import java.util.List;

public class NhanVienQuanLy extends NhanVien {
    private Date ngayNhanChuc;
    private List<PhongBan> danhSachPhongBanQuanLy;

    public NhanVienQuanLy(String hoTen, Date ngaySinh, String email, String gioiTinh,
                          PhongBan phongBan, LoaiNhanVien loaiNhanVien, Date ngayNhanChuc) {
        super(hoTen, ngaySinh, email, gioiTinh, phongBan, loaiNhanVien);
        this.ngayNhanChuc = ngayNhanChuc;
    }

    @Override
    public String toString() {
        return String.format("%s\nNgay nhan chuc: %s", super.toString(), CauHinh.f.format(this.ngayNhanChuc));
    }

    @Override
    public double getHeSo() {
        return 2;
    }

    @Override
    public double tinhLuong() {
        return this.getHeSo() * LUONG_CO_BAN;
    }

    public Date getNgayNhanChuc() {
        return ngayNhanChuc;
    }

    public void setNgayNhanChuc(Date ngayNhanChuc) {
        this.ngayNhanChuc = ngayNhanChuc;
    }

    public List<PhongBan> getDanhSachPhongBanQuanLy() {
        return danhSachPhongBanQuanLy;
    }

    public void setDanhSachPhongBanQuanLy(List<PhongBan> danhSachPhongBanQuanLy) {
        this.danhSachPhongBanQuanLy = danhSachPhongBanQuanLy;
    }
}

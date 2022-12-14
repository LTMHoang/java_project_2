package quanlyduan.phongban;

import quanlyduan.cauhinh.CauHinh;
import quanlyduan.nhanvien.NhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhongBan {
    private String tenPhongBan;
    private List<NhanVien> danhSachNhanVienTrucThuoc;

    public PhongBan() {
        System.out.print("Ten phong ban: ");
        CauHinh.sc.nextLine();
        this.tenPhongBan = CauHinh.sc.nextLine();
        this.danhSachNhanVienTrucThuoc = new ArrayList<>();
    }

    public PhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
        this.danhSachNhanVienTrucThuoc = new ArrayList<>();
    }

    public boolean isCoNhanVien(NhanVien nhanVien) {
        return this.getDanhSachNhanVienTrucThuoc().stream().filter(nv -> nv.getMaNhanVien().
                contains(nhanVien.getMaNhanVien())).collect(Collectors.toList()).size() == 0;
    }

    public void themNhanVien(NhanVien nhanVien) {
        if (this.isCoNhanVien(nhanVien))
            this.getDanhSachNhanVienTrucThuoc().add(nhanVien);
        else
            System.out.println("NHAN VIEN NAY DA TRUC THUOC PHONG BAN NAY");
    }

    public void xoaNhanVien(NhanVien nhanVien) {
        if (!this.isCoNhanVien(nhanVien))
            this.getDanhSachNhanVienTrucThuoc().remove(nhanVien);
        else
            System.out.println("NHAN VIEN NAY CHUA TRUC THUOC PHONG BAN NAY");
    }

    public void hienThiDanhSachNhanVien() {
        if (this.getDanhSachNhanVienTrucThuoc().size() != 0)
            this.getDanhSachNhanVienTrucThuoc().stream().forEach(nv -> System.out.println(nv));
        else
            System.out.println("PHONG BAN NAY CHUA CO NHAN VIEN NAO");
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public List<NhanVien> getDanhSachNhanVienTrucThuoc() {
        return danhSachNhanVienTrucThuoc;
    }

    public void setDanhSachNhanVienTrucThuoc(List<NhanVien> danhSachNhanVienTrucThuoc) {
        this.danhSachNhanVienTrucThuoc = danhSachNhanVienTrucThuoc;
    }
}

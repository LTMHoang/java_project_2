package quanlyduan.nhanvien;

import quanlyduan.cauhinh.CauHinh;
import quanlyduan.cauhinh.LoaiNhanVien;
import quanlyduan.duan.DuAn;
import quanlyduan.phongban.PhongBan;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyNhanVien {
    private List<NhanVien> danhSachNhanVien = new ArrayList<>();

    public NhanVien nhapNhanVien(PhongBan pb) throws ParseException {
        System.out.print("\nHo ten: ");
        String hoTen = CauHinh.sc.nextLine();
        System.out.print("Ngay sinh (dd/MM/yyyy): ");
        String ngaySinh = CauHinh.sc.nextLine();
        System.out.print("Email: ");
        String email = CauHinh.sc.nextLine();
        System.out.print("Gioi tinh: ");
        String gioiTinh = CauHinh.sc.nextLine();
        System.out.print("Loai nhan vien:\n1. NHAN_VIEN_BINH_THUONG\n2. NHAN_VIEN_QUAN_LY\n3. lAP_TRINH_VIEN\n" +
                "4. KIEM_THU_VIEN\n5. THIET_KE_VIEN\nChon: ");
        switch (CauHinh.sc.nextInt()) {
            case 1:
                CauHinh.sc.nextLine();
                return new NhanVienBinhThuong(hoTen, CauHinh.f.parse(ngaySinh), email, gioiTinh, pb ,LoaiNhanVien.NHAN_VIEN_BINH_THUONG);
            case 2:
                System.out.print("Nhap ngay nhan chuc: ");
                CauHinh.sc.nextLine();
                String ngayNhanChuc = CauHinh.sc.nextLine();
                return new NhanVienQuanLy(hoTen, CauHinh.f.parse(ngaySinh), email, gioiTinh, pb , LoaiNhanVien.NHAN_VIEN_QUAN_LY,
                        CauHinh.f.parse(ngayNhanChuc));
            case 3:
                CauHinh.sc.nextLine();
                return new LapTrinhVien(hoTen, CauHinh.f.parse(ngaySinh), email, gioiTinh, pb , LoaiNhanVien.LAP_TRINH_VIEN, 0);
            case 4:
                CauHinh.sc.nextLine();
                return new KiemThuVien(hoTen, CauHinh.f.parse(ngaySinh), email, gioiTinh, pb , LoaiNhanVien.LAP_TRINH_VIEN, 0);
            case 5:
                CauHinh.sc.nextLine();
                return new ThietKeVien(hoTen, CauHinh.f.parse(ngaySinh), email, gioiTinh, pb , LoaiNhanVien.LAP_TRINH_VIEN, 0);
        }
        return null;
    }

    public void themNhanVien(NhanVien... nv) {
        this.danhSachNhanVien.addAll(Arrays.asList(nv));
    }

    public void xoaNhanVien(NhanVien nv) {
        nv.getThongTinPB().xoaNhanVien(nv);
        for (DuAn da: nv.getDanhSachDuAnThamGia())
            da.xoaNhanVien(nv);
        this.danhSachNhanVien.remove(nv);
    }

    public void tinhLuongCacNhanVien() {
        for (NhanVien nv: this.danhSachNhanVien) {
            nv.setLuong(nv.tinhLuong());
        }
    }

    public void xuatBangLuongCacNhanVien() {
        System.out.println("=== BANG LUONG ===");
        this.danhSachNhanVien.stream().forEach(nv -> System.out.printf("Nhan vien %s - Luong: %,.1f Trieu VND\n",
                nv.getHoTen().toUpperCase(), nv.getLuong()));
    }

    public void hienThi() {
        if (this.danhSachNhanVien.size() == 0)
            System.out.println("KHONG CO NHAN VIEN NAO");
        else
            this.danhSachNhanVien.stream().forEach(nv -> System.out.println(nv));
    }

    public void hienThi(List<NhanVien> danhSach) {
        if (danhSach.size() == 0)
            System.out.println("KHONG CO NHAN VIEN NAO");
        else {
            danhSach.sort((nv1, nv2) -> {
                int ma1 = Integer.parseInt(nv1.getMaNhanVien());
                int ma2 = Integer.parseInt(nv2.getMaNhanVien());
                return ma1 > ma2 ? 1 : (ma1 < ma2 ? -1 : 0);
            });
            danhSach.stream().forEach(nv -> System.out.println(nv));
        }
    }

    public List<NhanVien> timKiem(String tuKhoa) {
        return this.danhSachNhanVien.stream().filter(nv -> nv.getMaNhanVien().contains(tuKhoa)
                || nv.getHoTen().contains(tuKhoa)
        ).collect(Collectors.toList());
    }

    public List<NhanVien> timKiem(Date ngay) {
        return this.danhSachNhanVien.stream().filter(nv -> nv.getNgaySinh().equals(ngay)).collect(Collectors.toList());
    }

    public List<NhanVien> timKiem(int dau, int cuoi) {
        return this.danhSachNhanVien.stream().filter(nv -> nv.tinhTuoi() >= dau
                && nv.tinhTuoi() <= cuoi).collect(Collectors.toList());
    }

    public void xemDanhSachDuAnCuaNhanVien(String maNhanVien) {
        for(NhanVien nv: this.timKiem(maNhanVien))
            nv.hienThiDuAnThamGia();
    }

    public void xemDanhSachThanNhanCuaNhanVien(String maNhanVien) {
        for(NhanVien nv: this.timKiem(maNhanVien))
            nv.hienThiDanhSachThanNhan();
    }


    public List<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public void setDanhSachNhanVien(List<NhanVien> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }
}

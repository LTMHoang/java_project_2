package quanlyduan.duan;

import quanlyduan.cauhinh.CauHinh;
import quanlyduan.nhanvien.NhanVien;
import quanlyduan.nhanvien.QuanLyNhanVien;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class    QuanLyDuAn {
    private List<DuAn> danhSachDuAn = new ArrayList<>();

    public DuAn nhapDuAn() throws ParseException {
        return new DuAn();
    }

    public void themDuAn(DuAn... da) {
        this.danhSachDuAn.addAll(Arrays.asList(da));
    }

    public void xoaDuAn(DuAn da) {
        for (NhanVien d: da.getDanhSachNhanVienThamGia()) {
            d.xoaDuAnThamGia(da);
        }
        this.danhSachDuAn.remove(da);
    }

    public void suaDuAn(QuanLyNhanVien quanLyNhanVien) throws ParseException {
            System.out.println("\n=== DANH SACH DU AN ===");
            this.hienThi();
            System.out.print("\nNhap ten du an ban muon sua: ");
            CauHinh.sc.nextLine();
            for (DuAn da: this.timKiem(CauHinh.sc.nextLine())) {
                System.out.printf("Ban muon sua gi?\n1. Ma du an: %s\n2. Ten du an: %s\n3. Thoi diem bat dau: %s\n4. Thoi diem du kien ket thuc: %s" +
                                "\n5. Tong kinh phi dau tu: %,.1f Trieu VND\n6. Sua chu nhiem du an" +
                                "\n7. Sua nhan vien tham gia du an\n8. Thoat\nChon: ",
                        da.getMaDuAn(), da.getTenDuAn(), CauHinh.f.format(da.getNgayBatDauDuAn()),
                        CauHinh.f.format(da.getNgayDuKienKetThucDuAn()), da.getTongKinhPhi());
                switch (CauHinh.sc.nextInt()) {
                    case 1:
                        System.out.print("\nNhap noi dung ban muon sua: ");
                        CauHinh.sc.nextLine();
                        da.setMaDuAn(CauHinh.sc.nextLine());
                        break;
                    case 2:
                        System.out.print("\nNhap noi dung ban muon sua: ");
                        CauHinh.sc.nextLine();
                        da.setTenDuAn(CauHinh.sc.nextLine());
                        break;
                    case 3:
                        System.out.print("\nNhap noi dung ban muon sua: ");
                        CauHinh.sc.nextLine();
                        da.setNgayBatDauDuAn(CauHinh.f.parse(CauHinh.sc.nextLine()));
                        break;
                    case 4:
                        System.out.print("\nNhap noi dung ban muon sua: ");
                        CauHinh.sc.nextLine();
                        da.setNgayDuKienKetThucDuAn(CauHinh.f.parse(CauHinh.sc.nextLine()));
                        break;
                    case 5:
                        System.out.print("\nNhap noi dung ban muon sua: ");
                        CauHinh.sc.nextLine();
                        da.setTongKinhPhi(CauHinh.sc.nextDouble());
                        break;
                    case 6:
                        System.out.println("=== DANH SACH NHAN VIEN HIEN TAI ===");
                        quanLyNhanVien.hienThi();
                        System.out.print("\nNhap ma nhan vien ban dung de thay the: ");
                        CauHinh.sc.nextLine();
                        for (NhanVien nv: quanLyNhanVien.timKiem(CauHinh.sc.nextLine())) {
                            nv.themDuAnThamGia(da);
                            da.themChuNhiem(nv);
                        }
                        break;
                    case 7:
                        System.out.println("=== DANH SACH NHAN VIEN HIEN TAI ===");
                        quanLyNhanVien.hienThi();
                        System.out.print("\nBan muon\n1. Them nhan vien cho du an\n2. Xoa nhan vien khoi du an" +
                                "\n3. Thoat\nChon: ");
                        switch (CauHinh.sc.nextInt()) {
                            case 1:
                                System.out.print("\nNhap ma nhan vien ban muon them: ");
                                CauHinh.sc.nextLine();
                                for (NhanVien nv: quanLyNhanVien.timKiem(CauHinh.sc.nextLine())) {
                                    nv.themDuAnThamGia(da);
                                    da.themNhanVien(nv);
                                }
                                break;
                            case 2:
                                System.out.print("\nNhap ma nhan vien ban muon xoa: ");
                                CauHinh.sc.nextLine();
                                for (NhanVien nv: quanLyNhanVien.timKiem(CauHinh.sc.nextLine())) {
                                    nv.xoaDuAnThamGia(da);
                                    da.themNhanVien(nv);
                                }
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
    }

    public void ganChuNhiemDuAn(QuanLyNhanVien quanLyNhanVien) {
        System.out.println("=== DANH SACH DU AN HIEN TAI ===");
        this.hienThi();
        System.out.print("\nNhap ma du an ban muon gan: ");
        CauHinh.sc.nextLine();
        String maDuAn = CauHinh.sc.nextLine();
        System.out.println("=== DANH SACH NHAN VIEN HIEN TAI ===");
        quanLyNhanVien.hienThi();
        System.out.print("\nNhap ma nhan vien ban gan: ");
        String maNhanVien = CauHinh.sc.nextLine();
        for (DuAn duAn: this.timKiem(maDuAn)) {
            for (NhanVien nhanVien: quanLyNhanVien.timKiem(maNhanVien)) {
                nhanVien.themDuAnThamGia(duAn);
                duAn.themChuNhiem(nhanVien);
            }
        }
    }

    public void ganNhanVienChoDuAn(QuanLyNhanVien quanLyNhanVien) {
        System.out.println("=== DANH SACH DU AN HIEN TAI ===");
        this.hienThi();
        System.out.print("\nNhap ma du an ban muon gan: ");
        CauHinh.sc.nextLine();
        String maDuAn = CauHinh.sc.nextLine();
        System.out.println("=== DANH SACH NHAN VIEN HIEN TAI ===");
        quanLyNhanVien.hienThi();
        System.out.print("\nNhap ma nhan vien ban gan: ");
        String maNhanVien = CauHinh.sc.nextLine();
        for (DuAn duAn: this.timKiem(maDuAn)) {
            for (NhanVien nhanVien: quanLyNhanVien.timKiem(maNhanVien)) {
                nhanVien.themDuAnThamGia(duAn);
                duAn.themNhanVien(nhanVien);
            }
        }
    }

    public void sapXep() {
        this.danhSachDuAn.sort((da1, da2) -> {
            double t1 = da1.getTongKinhPhi();
            double t2 = da2.getTongKinhPhi();
            return -(t1 > t2 ? 1 : (t1 < t2 ? -1 : 0));
        });
    }

    public void sapXep(List<DuAn> danhSach) {
        danhSach.sort((da1, da2) -> {
            double t1 = da1.getTongKinhPhi();
            double t2 = da2.getTongKinhPhi();
            return -(t1 > t2 ? 1 : (t1 < t2 ? -1 : 0));
        });
    }

    public void hienThi() {
        this.sapXep();
        this.danhSachDuAn.stream().forEach(da -> System.out.println(da));
    }

    public void hienThi(List<DuAn> da) {
        this.sapXep(da);
        da.stream().forEach(d -> System.out.println(d));
    }

    public List<DuAn> timKiem(String tuKhoa) {
        return this.danhSachDuAn.stream().filter(da -> da.getTenDuAn().toLowerCase().contains(tuKhoa.toLowerCase())
        || da.getMaDuAn().contains(tuKhoa)
        ).collect(Collectors.toList());
    }

    public List<DuAn> timKiem(Date ngay) {
        return this.danhSachDuAn.stream().filter(ds -> ds.getNgayBatDauDuAn().equals(ngay)).collect(Collectors.toList());
    }

    public void xemDanhSachNhanVienCuaDuAn(String maDuAn) {
        this.timKiem(maDuAn).get(0).hienThiDanhSachNhanVien();
    }

    public List<DuAn> getDanhSachDuAn() {
        return danhSachDuAn;
    }

    public void setDanhSachDuAn(List<DuAn> danhSachDuAn) {
        this.danhSachDuAn = danhSachDuAn;
    }
}

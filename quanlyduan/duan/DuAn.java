package quanlyduan.duan;

import quanlyduan.cauhinh.CauHinh;
import quanlyduan.nhanvien.NhanVien;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DuAn {
    private static int dem = 0;
    private String maDuAn;
    private String tenDuAn;
    private Date ngayBatDauDuAn;
    private Date ngayDuKienKetThucDuAn;
    private double tongKinhPhi;
    private NhanVien chuNhiemDuAn;
    private List<NhanVien> danhSachNhanVienThamGia;

    {
        this.setMaDuAn(String.format("%02d", ++dem));
    }

    public DuAn() throws ParseException {
        System.out.print("\nTen du an: ");
        this.tenDuAn = CauHinh.sc.nextLine();
        System.out.print("Ngay bat dau du an: ");
        this.ngayBatDauDuAn = CauHinh.f.parse(CauHinh.sc.nextLine());
        System.out.print("Ngay du kien ket thuc du an: ");
        this.ngayDuKienKetThucDuAn = CauHinh.f.parse(CauHinh.sc.nextLine());
        System.out.print("Tong kinh phi: ");
        this.tongKinhPhi = CauHinh.sc.nextDouble();
        this.chuNhiemDuAn = null;
        this.danhSachNhanVienThamGia = new ArrayList<>();
    }

    public DuAn(String tenDuAn, Date ngayBatDauDuAn, Date ngayDuKienKetThucDuAn, double tongKinhPhi) {
        this.tenDuAn = tenDuAn;
        this.ngayBatDauDuAn = ngayBatDauDuAn;
        this.ngayDuKienKetThucDuAn = ngayDuKienKetThucDuAn;
        this.tongKinhPhi = tongKinhPhi;
        this.chuNhiemDuAn = null;
        this.danhSachNhanVienThamGia = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("\n=\nMa du an: %s\nTen du an: %s\nNgay bat dau du an: %s\nNgay du kien ket thuc du an: %s" +
                "\nTong kinh phi dau tu: %,.1f Trieu VNĐ", this.maDuAn, this.tenDuAn, CauHinh.f.format(this.ngayBatDauDuAn), CauHinh.f.format(this.ngayDuKienKetThucDuAn),
                this.tongKinhPhi);
    }

    public boolean isCoNhanVien(NhanVien nhanVien) {
        return this.getDanhSachNhanVienThamGia().stream().filter(nv -> nv.getMaNhanVien().
                contains(nhanVien.getMaNhanVien())).collect(Collectors.toList()).size() == 0;
    }

    public void themNhanVien(NhanVien nhanVien) {
        if (this.isCoNhanVien(nhanVien)) {
            if (this.danhSachNhanVienThamGia.size() == 10)
                System.out.println("DU AN DA DAT SO LUONG NHAN VIEN THAM GIA TOI DA");
            else {
                this.getDanhSachNhanVienThamGia().add(nhanVien);
                if (this.danhSachNhanVienThamGia.size() < 5)
                    System.out.println("DU AN CHUA DAT SO LUONG NHAN VIEN THAM GIA TOI THIEU");
            }
        }
        else
            System.out.println("NHAN VIEN DANG THAM GIA DU AN NAY");
    }

    public void xoaNhanVien(NhanVien nhanVien) {
        if (!this.isCoNhanVien(nhanVien))
            this.getDanhSachNhanVienThamGia().remove(nhanVien);
        else
            System.out.println("NHAN VIEN CHUA THAM GIA DU AN NAY");
    }

    public boolean isChuNhiem() {
        return this.getChuNhiemDuAn() == null;
    }

    public void themChuNhiem(NhanVien chuNhiemDuAn) {
        if (this.isChuNhiem()) {
            this.themNhanVien(chuNhiemDuAn);
            this.setChuNhiemDuAn(chuNhiemDuAn);
        }
        else {
            System.out.println(this.getChuNhiemDuAn());
            System.out.print("Hien tai nhan vien tren dang chu nhiem du an nay. Ban co muon thay doi khong? Co (1)/ Khong (0): ");
            switch (CauHinh.sc.nextInt()) {
                case 1:
                    this.themNhanVien(chuNhiemDuAn);
                    this.setChuNhiemDuAn(chuNhiemDuAn);
                    break;
                default:
                    break;
            }
        }
    }

    public void xoaChuNhiem() {
        this.setChuNhiemDuAn(null);
    }

    public void hienThiDanhSachNhanVien() {
        System.out.println("== CHU NHIEM DU AN ==");
        if (this.isChuNhiem())
            System.out.println("CHUA CO CHU NHIEM");
        else
            System.out.println(this.getChuNhiemDuAn());

        System.out.println("\n== NHAN VIEN DANG THAM GIA DU AN ==");
        if (this.getDanhSachNhanVienThamGia().size() == 0)
            System.out.println("CHUA CO NHAN VIEN");
        else
            this.getDanhSachNhanVienThamGia().stream().forEach(nv -> System.out.println(nv));
    }

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public Date getNgayBatDauDuAn() {
        return ngayBatDauDuAn;
    }

    public void setNgayBatDauDuAn(Date ngayBatDauDuAn) {
        this.ngayBatDauDuAn = ngayBatDauDuAn;
    }

    public Date getNgayDuKienKetThucDuAn() {
        return ngayDuKienKetThucDuAn;
    }

    public void setNgayDuKienKetThucDuAn(Date ngayDuKienKetThucDuAn) {
        this.ngayDuKienKetThucDuAn = ngayDuKienKetThucDuAn;
    }

    public double getTongKinhPhi() {
        return tongKinhPhi;
    }

    public void setTongKinhPhi(double tongKinhPhi) {
        this.tongKinhPhi = tongKinhPhi;
    }

    public NhanVien getChuNhiemDuAn() {
        return chuNhiemDuAn;
    }

    public void setChuNhiemDuAn(NhanVien chuNhiemDuAn) {
        this.chuNhiemDuAn = chuNhiemDuAn;
    }

    public List<NhanVien> getDanhSachNhanVienThamGia() {
        return danhSachNhanVienThamGia;
    }

    public void setDanhSachNhanVienThamGia(List<NhanVien> danhSachNhanVienThamGia) {
        this.danhSachNhanVienThamGia = danhSachNhanVienThamGia;
    }
}

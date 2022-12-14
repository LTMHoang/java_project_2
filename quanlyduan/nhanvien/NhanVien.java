package quanlyduan.nhanvien;

import quanlyduan.cauhinh.CauHinh;
import quanlyduan.cauhinh.LoaiNhanVien;
import quanlyduan.duan.DuAn;
import quanlyduan.phongban.PhongBan;
import quanlyduan.thannhan.ThanNhan;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public abstract class NhanVien {
    protected static final double LUONG_CO_BAN = 5;
    private static int dem = 0;
    protected String maNhanVien;
    protected String hoTen;
    protected Date ngaySinh;
    protected String email;
    protected String gioiTinh;
    protected PhongBan thongTinPB;
    protected LoaiNhanVien loaiNV;
    protected List<DuAn> danhSachDuAnThamGia;
    protected List<ThanNhan> danhSachThanNhan;

    protected double luong;

    {
        this.setMaNhanVien(String.format("%03d", ++dem));
    }

    public NhanVien(String hoTen, Date ngaySinh, String email, String gioiTinh, PhongBan phongBan, LoaiNhanVien loaiNhanVien) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.thongTinPB = phongBan;
        this.loaiNV = loaiNhanVien;
        this.danhSachDuAnThamGia = new ArrayList<>();
        this.danhSachThanNhan = new ArrayList<>();
    }

    public abstract double getHeSo();
    public abstract double tinhLuong();

    @Override
    public String toString() {
        return String.format("\n=\nMa nhan vien: %s\nHo ten: %s\nNgay sinh: %s\nEmail: %s\nGioi tinh: %s\nPhong ban: %s" +
                "\nLoai nhan vien: %s", this.maNhanVien, this.hoTen, CauHinh.f.format(this.ngaySinh), this.email, this.gioiTinh,
                this.thongTinPB.getTenPhongBan(), this.loaiNV);
    }

    public int tinhTuoi() {
        String[] ngay = CauHinh.f.format(this.ngaySinh).split("/");
        LocalDate dob = LocalDate.parse(ngay[2] + "-" + ngay[1] + "-" + ngay[0]);
        LocalDate ngayHienTai = LocalDate.now();
        return Period.between(dob, ngayHienTai).getYears();
    }

    public boolean isCoDuAn(DuAn duAn) {
        return this.getDanhSachDuAnThamGia().stream().filter(da -> da.getMaDuAn().contains(duAn.getMaDuAn())).
                collect(Collectors.toList()).size() == 0;
    }

    public void themDuAnThamGia(DuAn duAn) {
        if(this.isCoDuAn(duAn)) {
            if (this.danhSachDuAnThamGia.size() == 3)
                System.out.println("SO DU AN NHAN VIEN THAM GIA DA DAT TOI DA");
            else
                this.getDanhSachDuAnThamGia().add(duAn);
        }
        else
            System.out.println("NHAN VIEN DANG THAM GIA DU AN NAY");
    }

    public void xoaDuAnThamGia(DuAn duAn) {
        if(!this.isCoDuAn(duAn))
            this.getDanhSachDuAnThamGia().remove(duAn);
        else
            System.out.println("NHAN VIEN CHUA THAM GIA DU AN NAY");
    }

    public void hienThiDuAnThamGia() {
        if (this.getDanhSachDuAnThamGia().size() != 0)
            this.getDanhSachDuAnThamGia().stream().forEach(da -> System.out.println(da));
        else
            System.out.println("NHAN VIEN NAY CHUA THAM GIA DU AN NAO");
    }

    public boolean isCoThanNhan(ThanNhan thanNhan) {
        return this.getDanhSachThanNhan().stream().filter(tn -> tn.getHoTen().contains(thanNhan.getHoTen()) &&
                CauHinh.f.format(tn.getNgaySinh()).contains(CauHinh.f.format(thanNhan.getNgaySinh())) &&
                tn.getGioiTinh().contains(thanNhan.getGioiTinh()) && tn.getMoiQuanHe().contains(thanNhan.getMoiQuanHe()))
                .collect(Collectors.toList()).size() == 0;
    }

    public void themThanNhan(ThanNhan thanNhan) {
        if (this.isCoThanNhan(thanNhan))
            this.getDanhSachThanNhan().add(thanNhan);
        else
            System.out.println("NHAN VIEN DA CO THAN NHAN NAY");
    }

    public void xoaThanNhan(ThanNhan thanNhan) {
        if (!this.isCoThanNhan(thanNhan))
            this.getDanhSachThanNhan().remove(thanNhan);
        else
            System.out.println("NHAN VIEN CHUA CO THAN NHAN NAY");
    }

    public void hienThiDanhSachThanNhan() {
        if (this.getDanhSachThanNhan().size() != 0)
            this.getDanhSachThanNhan().stream().forEach(tn -> System.out.println(tn));
        else
            System.out.println("NHAN VIEN NAY CHUA CO THONG TIN THAN NHAN NAO");
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public PhongBan getThongTinPB() {
        return thongTinPB;
    }

    public void setThongTinPB(PhongBan thongTinPB) {
        this.thongTinPB = thongTinPB;
    }

    public LoaiNhanVien getLoaiNV() {
        return loaiNV;
    }

    public void setLoaiNV(LoaiNhanVien loaiNV) {
        this.loaiNV = loaiNV;
    }

    public List<DuAn> getDanhSachDuAnThamGia() {
        return danhSachDuAnThamGia;
    }

    public void setDanhSachDuAnThamGia(List<DuAn> danhSachDuAnThamGia) {
        this.danhSachDuAnThamGia = danhSachDuAnThamGia;
    }

    public List<ThanNhan> getDanhSachThanNhan() {
        return danhSachThanNhan;
    }

    public void setDanhSachThanNhan(List<ThanNhan> danhSachThanNhan) {
        this.danhSachThanNhan = danhSachThanNhan;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
}

package quanlyduan.phongban;

import quanlyduan.nhanvien.NhanVien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyPhongBan {
    private List<PhongBan> danhSachPhongBan = new ArrayList<>();

    public void themPhongBan(PhongBan... pb) {
        this.danhSachPhongBan.addAll(Arrays.asList(pb));
    }

    public void xoaPhongBan(PhongBan pb) {
        for (NhanVien nv: pb.getDanhSachNhanVienTrucThuoc())
            nv.setThongTinPB(null);
        this.danhSachPhongBan.remove(pb);
    }

    public List<PhongBan> timKiem(String tuKhoa) {
        return this.danhSachPhongBan.stream().filter(pb -> pb.getTenPhongBan().toLowerCase().contains(tuKhoa.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<PhongBan> getDanhSachPhongBan() {
        return danhSachPhongBan;
    }

    public void setDanhSachPhongBan(List<PhongBan> danhSachPhongBan) {
        this.danhSachPhongBan = danhSachPhongBan;
    }
}

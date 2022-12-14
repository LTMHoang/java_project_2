package quanlyduan.cauhinh;

import quanlyduan.duan.QuanLyDuAn;
import quanlyduan.nhanvien.*;
import quanlyduan.phongban.PhongBan;
import quanlyduan.phongban.QuanLyPhongBan;
import quanlyduan.thannhan.ThanNhan;

import java.text.ParseException;

public class Menu {
    public static void main(String[] args) throws ParseException {

        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        QuanLyDuAn quanLyDuAn = new QuanLyDuAn();
        QuanLyPhongBan quanLyPhongBan = new QuanLyPhongBan();

        do {
            System.out.print("\nMenu\n1. Quan ly nhan vien\n2. Quan ly du an\n3. Thoat\nChon: ");
            switch (CauHinh.sc.nextInt()) {
                case 1:
                    System.out.print("\n=== QUAN LY NHAN VIEN ===\n1. Them nhan vien\n2. Xoa nhan vien\n3. Tinh luong cac nhan vien" +
                            "\n4. Tim kiem\n5. Xem danh sach du an cua nhan vien\n6. Xem danh sach than nhan cua nhan vien" +
                            "\n7. Thoat\nChon: ");
                    switch (CauHinh.sc.nextInt()) {
                        case 1:
                            int dem = 0;
                            do {
                                System.out.printf("\nNhap nhan vien thu %d", ++dem);
                                System.out.print("\n=== DANH SACH PHONG BAN ===");
                                int demPB = 1;
                                for (PhongBan pb: quanLyPhongBan.getDanhSachPhongBan()) {
                                    System.out.printf("\n%d. %s", demPB++, pb.getTenPhongBan());
                                }
                                System.out.print("\nChon: ");
                                PhongBan phongBan = quanLyPhongBan.getDanhSachPhongBan().get(CauHinh.sc.nextInt() - 1);
                                CauHinh.sc.nextLine();
                                NhanVien nv = quanLyNhanVien.nhapNhanVien(phongBan);
                                System.out.println("Thong tin than nhan");
                                do {
                                    nv.themThanNhan(new ThanNhan());

                                    System.out.print("\nBan co muon tiep tuc? Co (1)/ Khong (0): ");
                                } while (CauHinh.sc.nextInt() != 0);
                                phongBan.themNhanVien(nv);
                                quanLyNhanVien.themNhanVien(nv);

                                System.out.print("\nBan co muon tiep tuc? Co (1)/ Khong (0): ");
                            } while (CauHinh.sc.nextInt() != 0);
                            System.out.println("\nTHEM THANH CONG");
                            break;
                        case 2:
                            System.out.println("\n=== DANH SACH NHAN VIEN ===");
                            quanLyNhanVien.hienThi();
                            do {
                                System.out.print("\nNhap ma nhan vien ban muon xoa: ");
                                CauHinh.sc.nextLine();
                                String maNV = CauHinh.sc.nextLine();
                                if (quanLyNhanVien.timKiem(maNV).size() == 0)
                                    System.out.println("KHONG TIM THAY NHAN VIEN NAY");
                                else
                                    quanLyNhanVien.xoaNhanVien(quanLyNhanVien.timKiem(maNV).get(0));

                                System.out.print("\nBan co muon tiep tuc? Co (1)/ Khong (0): ");
                            } while (CauHinh.sc.nextInt() != 0);
                            System.out.println("\nXOA THANH CONG");
                            break;
                        case 3:
                            quanLyNhanVien.tinhLuongCacNhanVien();
                            quanLyNhanVien.xuatBangLuongCacNhanVien();
                            System.out.println();
                            break;
                        case 4:
                            System.out.print("\n=== TIM KIEM NHAN VIEN ===\n1. Theo ho ten\n2. Theo ngay sinh\n3. Theo phong ban" +
                                    "\n4. Theo tuoi\n5. Thoat\nChon: ");
                            switch (CauHinh.sc.nextInt()) {
                                case 1:
                                    System.out.print("\nNhap ho ten ban muon tim: ");
                                    CauHinh.sc.nextLine();
                                    String hoTen = CauHinh.sc.nextLine();
                                    System.out.println("\n=== DANH SACH NHAN VIEN TIM THAY ===");
                                    if (quanLyNhanVien.timKiem(hoTen).size() == 0)
                                        System.out.println("KHONG TIM THAY NHAN VIEN NAO");
                                    else
                                        quanLyNhanVien.hienThi(quanLyNhanVien.timKiem(hoTen));
                                    break;
                                case 2:
                                    System.out.print("\nNhap ngay sinh ban muon tim: ");
                                    CauHinh.sc.nextLine();
                                    String ngaySinh = CauHinh.sc.nextLine();
                                    System.out.println("\n=== DANH SACH NHAN VIEN TIM THAY ===");
                                    if (quanLyNhanVien.timKiem(CauHinh.f.parse(ngaySinh)).size() == 0)
                                        System.out.println("KHONG TIM THAY NHAN VIEN NAO");
                                    else
                                        quanLyNhanVien.hienThi(quanLyNhanVien.timKiem(CauHinh.f.parse(ngaySinh)));
                                    break;
                                case 3:
                                    System.out.print("\nNhap phong ban ban muon tim: ");
                                    CauHinh.sc.nextLine();
                                    String phongBan = CauHinh.sc.nextLine();
                                    System.out.println("\n=== DANH SACH NHAN VIEN TIM THAY ===");
                                    if (quanLyPhongBan.timKiem(phongBan).size() == 0)
                                        System.out.println("KHONG TIM THAY NHAN VIEN NAO");
                                    else {
                                        quanLyPhongBan.timKiem(phongBan).get(0).hienThiDanhSachNhanVien();
                                    }
                                    break;
                                case 4:
                                    System.out.print("\n=== THEO TUOI ===\n1. Tuoi cu the\n2. Khoang\n3. Thoat\nChon: ");
                                    switch (CauHinh.sc.nextInt()) {
                                        case 1:
                                            System.out.print("\nNhap so tuoi ban muon tim: ");
                                            int st = CauHinh.sc.nextInt();
                                            System.out.println("\n=== DANH SACH NHAN VIEN TIM THAY ===");
                                            if (quanLyNhanVien.timKiem(st, st).size() == 0)
                                                System.out.println("KHONG TIM THAY NHAN VIEN NAO");
                                            else
                                                quanLyNhanVien.hienThi(quanLyNhanVien.timKiem(st, st));
                                            break;
                                        case 2:
                                            System.out.print("\nNhap khoang tuoi ban muon tim: ");
                                            int dau = CauHinh.sc.nextInt();
                                            int cuoi = CauHinh.sc.nextInt();
                                            System.out.println("\n=== DANH SACH NHAN VIEN TIM THAY ===");
                                            if (quanLyNhanVien.timKiem(dau, cuoi).size() == 0)
                                                System.out.println("KHONG TIM THAY NHAN VIEN NAO");
                                            else
                                                quanLyNhanVien.hienThi(quanLyNhanVien.timKiem(dau, cuoi));
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 5:
                            System.out.println("=== DANH SACH NHAN VIEN ===");
                            quanLyNhanVien.hienThi();
                            System.out.print("\nNhap ma nhan vien ban muon xem du an: ");
                            CauHinh.sc.nextLine();
                            String maNV = CauHinh.sc.nextLine();
                            System.out.println("\n=== DANH SACH DU AN ===");
                            quanLyNhanVien.xemDanhSachDuAnCuaNhanVien(maNV);
                            break;
                        case 6:
                            System.out.println("=== DANH SACH NHAN VIEN ===");
                            quanLyNhanVien.hienThi();
                            System.out.print("\nNhap ma nhan vien ban muon xem than nhan: ");
                            CauHinh.sc.nextLine();
                            String maNV1 = CauHinh.sc.nextLine();
                            System.out.println("\n=== DANH SACH THAN NHAN ===");
                            quanLyNhanVien.xemDanhSachThanNhanCuaNhanVien(maNV1);
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.print("\n=== QUAN LY DU AN ===\n1. Them du an\n2. Xoa du an\n3. Sua du an" +
                            "\n4. Xem danh sach nhan vien cua du an\n5. Tim kiem du an\n6. Gan chu nhiem du an" +
                            "\n7. Gan nhan vien cho du an\n8. Thoat\nChon: ");
                    switch (CauHinh.sc.nextInt()) {
                        case 1:
                            int dem = 0;
                            do {
                                System.out.printf("\nNhap du an thu %d", ++dem);
                                CauHinh.sc.nextLine();
                                quanLyDuAn.themDuAn(quanLyDuAn.nhapDuAn());
                                System.out.print("\nBan co muon tiep tuc khong? Co (1)/ Khong (0): ");
                            } while (CauHinh.sc.nextInt() != 0);
                            System.out.println("\nTHEM THANH CONG");
                            break;
                        case 2:
                            System.out.println("\n=== DANH SACH DU AN ===");
                            quanLyDuAn.hienThi();
                            do {
                                System.out.print("\nNhap ma du an ban muon xoa: ");
                                CauHinh.sc.nextLine();
                                String maDA = CauHinh.sc.nextLine();
                                if (quanLyDuAn.timKiem(maDA).size() == 0)
                                    System.out.println("KHONG TIM THAY DU AN NAY");
                                else
                                    quanLyDuAn.xoaDuAn(quanLyDuAn.timKiem(maDA).get(0));

                                System.out.print("\nBan co muon tiep tuc? Co (1)/ Khong (0): ");
                            } while (CauHinh.sc.nextInt() != 0);
                            System.out.println("\nXOA THANH CONG");
                            break;
                        case 3:
                            do {
                                quanLyDuAn.suaDuAn(quanLyNhanVien);
                                System.out.print("Ban co muon tiep tuc khong? Co (1)/ Khong (0): ");
                            } while (CauHinh.sc.nextInt() != 0);
                            System.out.println("\nSUA THANH CONG");
                            break;
                        case 4:
                            System.out.println("=== DANH SACH DU AN ===");
                            quanLyDuAn.hienThi();
                            System.out.print("\nNhap ma du an ban muon xem nhan vien: ");
                            CauHinh.sc.nextLine();
                            String maDA = CauHinh.sc.nextLine();
                            quanLyDuAn.xemDanhSachNhanVienCuaDuAn(maDA);
                            break;
                        case 5:
                            System.out.print("\n=== TIM KIEM DU AN ===\n1. Theo ten du an\n2. Theo ngay bat dau du an\n3. Thoat" +
                                    "\nChon: ");
                            switch (CauHinh.sc.nextInt()) {
                                case 1:
                                    System.out.print("\nNhap ten du an ban muon tim: ");
                                    CauHinh.sc.nextLine();
                                    String tenDuAn = CauHinh.sc.nextLine();
                                    System.out.println("\n=== DANH SACH DU AN TIM THAY ===");
                                    if (quanLyDuAn.timKiem(tenDuAn).size() == 0)
                                        System.out.println("KHONG TIM THAY DU AN NAO");
                                    else {
                                        quanLyDuAn.hienThi(quanLyDuAn.timKiem(tenDuAn));
                                    }
                                    break;
                                case 2:
                                    System.out.print("\nNhap ngay bat dau du an ban muon tim: ");
                                    CauHinh.sc.nextLine();
                                    String ngayBatDau = CauHinh.sc.nextLine();
                                    System.out.println("\n=== DANH SACH DU AN TIM THAY ===");
                                    if (quanLyDuAn.timKiem(CauHinh.f.parse(ngayBatDau)).size() == 0)
                                        System.out.println("KHONG TIM THAY DU AN NAO");
                                    else {
                                        quanLyDuAn.hienThi(quanLyDuAn.timKiem(CauHinh.f.parse(ngayBatDau)));
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 6:
                            do {
                                quanLyDuAn.ganChuNhiemDuAn(quanLyNhanVien);

                                System.out.print("\nBan co muon tiep tuc? Co (1)/ Khong (0): ");
                            } while(CauHinh.sc.nextInt() != 0);
                            System.out.println("GAN THANH CONG");
                            break;
                        case 7:
                            do {
                                quanLyDuAn.ganNhanVienChoDuAn(quanLyNhanVien);

                                System.out.print("\nBan co muon tiep tuc? Co (1)/ Khong (0): ");
                            } while(CauHinh.sc.nextInt() != 0);
                            System.out.println("GAN THANH CONG");
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }

            System.out.print("\nBan co muon tiep tuc khong? Co (1)/ Khong (0): ");
        } while (CauHinh.sc.nextInt() != 0);
    }
}

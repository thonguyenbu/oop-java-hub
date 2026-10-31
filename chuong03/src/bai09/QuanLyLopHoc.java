package bai09;

/*
 * Bài 9 - Quản lý lớp học: in danh sách, tìm theo mã, thống kê xếp loại
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class QuanLyLopHoc {

    static SinhVien timTheoMa(SinhVien[] ds, String ma) {
        for (SinhVien sv : ds) {
            if (sv != null && sv.getMaSoSinhVien().equals(ma)) return sv;
        }
        return null;
    }

    static void inDanhSach(SinhVien[] ds) {
        System.out.printf("%-10s %-20s %-12s %6s %8s   %s%n",
                "MSSV", "HỌ TÊN", "NGÀY SINH", "ĐTB", "TÍN CHỈ", "XẾP LOẠI");
        System.out.println("-".repeat(76));
        for (SinhVien sv : ds) System.out.println(sv.moTa());
        System.out.println("-".repeat(76));
    }

    static void thongKeXepLoai(SinhVien[] ds) {
        String[] cacLoai = {"Xuất sắc", "Giỏi", "Khá", "Trung bình", "Yếu"};
        System.out.printf("%-14s %8s%n", "XẾP LOẠI", "SỐ SV");
        System.out.println("-".repeat(23));
        for (String loai : cacLoai) {
            int dem = 0;
            for (SinhVien sv : ds) if (sv.xepLoaiHocLuc().equals(loai)) dem++;
            System.out.printf("%-14s %8d%n", loai, dem);
        }
        System.out.println("-".repeat(23));
    }

    public static void main(String[] args) {
        SinhVien[] lop = {
            new SinhVien("050101", "Nguyễn Văn An",   "12/03/2006", 3.45, 62),
            new SinhVien("050102", "Trần Thị Bình",   "05/07/2006", 3.82, 68),
            new SinhVien("050103", "Lê Văn Cường",    "21/11/2005", 2.75, 55),
            new SinhVien("050104", "Phạm Thị Dung",   "30/01/2006", 3.25, 64),
            new SinhVien("050105", "Hoàng Văn Em",    "17/09/2006", 1.85, 38),
            new SinhVien("050106", "Vũ Thị Giang",    "08/05/2005", 3.68, 70),
            new SinhVien("050107", "Đặng Văn Hải",    "24/12/2006", 2.10, 45),
            new SinhVien("050108", "Bùi Thị Hoa",     "03/04/2006", 2.95, 60),
            new SinhVien("050109", "Ngô Văn Khoa",    "19/08/2005", 3.55, 66),
            new SinhVien("050110", "Lý Thị Lan",      "11/06/2006", 3.90, 72)
        };

        System.out.println("DANH SÁCH LỚP HTTT-K11");
        inDanhSach(lop);
        System.out.println("Số sinh viên đã tạo (bộ đếm tĩnh): "
                + SinhVien.getSoSinhVienDaTao());

        System.out.println();
        System.out.println("TÌM SINH VIÊN THEO MÃ");
        String[] canTim = {"050104", "050999"};
        for (String ma : canTim) {
            SinhVien sv = timTheoMa(lop, ma);
            if (sv == null) System.out.println("  " + ma + " -> không tìm thấy");
            else System.out.println("  " + ma + " -> " + sv.getHoTen()
                    + ", ĐTB " + sv.getDiemTrungBinh() + ", " + sv.xepLoaiHocLuc());
        }

        System.out.println();
        System.out.println("THỐNG KÊ THEO XẾP LOẠI HỌC LỰC");
        thongKeXepLoai(lop);

        System.out.println();
        System.out.println("Kiểm tra ràng buộc điểm trung bình:");
        lop[0].setDiemTrungBinh(4.5);
        System.out.println("  ĐTB của 050101 sau khi thử gán 4.5: "
                + lop[0].getDiemTrungBinh());
    }
}

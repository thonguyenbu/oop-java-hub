package jdbc;

/*
 * Mục 6.2 – 6.4 - Kết nối JDBC, PreparedStatement, CRUD và giao dịch
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import chung.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

public class DemoThaoTacDuLieu {

    static void inDanhMuc(String tieuDe, List<SanPham> ds) {
        System.out.println(tieuDe);
        System.out.printf("  %-6s %-24s %12s %6s%n",
                "MÃ", "TÊN SẢN PHẨM", "ĐƠN GIÁ", "TỒN");
        for (SanPham sp : ds) System.out.println("  " + sp);
    }

    public static void main(String[] args) throws Exception {
        try (Connection cn = KetNoiCSDL.moKetNoi()) {
            SanPhamDAO dao = new SanPhamDAO(cn);

            System.out.println("=== 6.4.1(a) THÊM (INSERT) ===");
            dao.them(new SanPham("SP001", "Cà phê hòa tan G7",
                    new BigDecimal("65000"), 120));
            dao.them(new SanPham("SP002", "Bánh quy bơ",
                    new BigDecimal("42000"), 85));
            dao.them(new SanPham("SP003", "Nước suối 500ml",
                    new BigDecimal("6000"), 500));
            dao.them(new SanPham("SP004", "Cà phê phin giấy",
                    new BigDecimal("32000"), 40));
            inDanhMuc("Sau khi thêm 4 sản phẩm:", dao.layTatCa());

            System.out.println();
            System.out.println("=== 6.4.1(b) TRUY VẤN (SELECT) ===");
            SanPham mot = dao.timTheoKhoa("SP002");
            System.out.println("  timTheoKhoa(SP002) -> " + mot.getTenSanPham()
                    + ", giá " + mot.getDonGia().toPlainString());
            System.out.println("  timTheoKhoa(SP999) -> " + dao.timTheoKhoa("SP999"));
            inDanhMuc("  Tìm theo tên chứa \"Cà phê\":", dao.timTheoTen("Cà phê"));

            System.out.println();
            System.out.println("=== 6.4.1(c) SỬA (UPDATE) ===");
            mot.setDonGia(new BigDecimal("45000"));
            System.out.println("  capNhat(SP002) -> " + dao.capNhat(mot));
            System.out.println("  Giá SP002 sau khi sửa: "
                    + dao.timTheoKhoa("SP002").getDonGia().toPlainString());
            SanPham khongCo = new SanPham("SP999", "X", BigDecimal.ONE, 0);
            System.out.println("  capNhat(SP999) -> " + dao.capNhat(khongCo));

            System.out.println();
            System.out.println("=== 6.4.1(d) XÓA (DELETE) ===");
            System.out.println("  xoaTheoKhoa(SP004) -> " + dao.xoaTheoKhoa("SP004"));
            System.out.println("  xoaTheoKhoa(SP004) lần hai -> " + dao.xoaTheoKhoa("SP004"));
            System.out.println("  Số sản phẩm còn lại: " + dao.soLuong());

            System.out.println();
            System.out.println("=== 6.4.2 GIAO DỊCH - trường hợp THÀNH CÔNG ===");
            BanHangService dv = new BanHangService(cn);
            int soDon = dv.lapDonHang("KH001", List.of(
                    new DongDatHang("SP001", 3), new DongDatHang("SP003", 10)));
            System.out.println("  Lập đơn thành công, số đơn = " + soDon);
            inDanhMuc("  Tồn kho sau khi lập đơn:", dao.layTatCa());

            System.out.println();
            System.out.println("=== 6.4.2 GIAO DỊCH - trường hợp THẤT BẠI, phải hoàn tác ===");
            try {
                dv.lapDonHang("KH002", List.of(
                        new DongDatHang("SP001", 5),       // đủ hàng, bị trừ trước
                        new DongDatHang("SP002", 9999)));  // không đủ hàng -> lỗi
            } catch (SQLException e) {
                System.out.println("  Bị từ chối: " + e.getMessage());
            }
            inDanhMuc("  Tồn kho sau khi hoàn tác (phải giống lần in trước):",
                    dao.layTatCa());

            try (Statement st = cn.createStatement();
                 ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM DonHang")) {
                rs.next();
                System.out.println("  Số đơn hàng trong bảng DonHang: " + rs.getInt(1));
            }
        }
    }
}

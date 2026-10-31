package jdbc;

/*
 * Mục 6.2 – 6.4 - Kết nối JDBC, PreparedStatement, CRUD và giao dịch
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import java.sql.*;

public class DemoTiemSQL {

    // CÁCH SAI: ghép chuỗi
    static int demSanPhamSai(Connection cn, String tuKhoa) throws SQLException {
        String sql = "SELECT COUNT(*) FROM SanPham WHERE TenSanPham LIKE '%"
                   + tuKhoa + "%'";
        System.out.println("  Câu lệnh gửi đi: " + sql);
        try (Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            rs.next();
            return rs.getInt(1);
        }
    }

    // CÁCH ĐÚNG: tham số hóa
    static int demSanPhamDung(Connection cn, String tuKhoa) throws SQLException {
        String sql = "SELECT COUNT(*) FROM SanPham WHERE TenSanPham LIKE ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, "%" + tuKhoa + "%");
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        }
    }

    /** Nạp dữ liệu mẫu để chương trình chạy độc lập được. */
    static void napDuLieuMau(Connection cn) throws SQLException {
        String[][] duLieu = {
            {"SP001", "Cà phê hòa tan G7", "65000", "120"},
            {"SP002", "Bánh quy bơ",       "42000",  "85"},
            {"SP003", "Nước suối 500ml",    "6000", "500"}
        };
        String sql = "INSERT INTO SanPham (MaSanPham, TenSanPham, DonGia, SoLuongTon) "
                   + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            for (String[] d : duLieu) {
                ps.setString(1, d[0]);
                ps.setString(2, d[1]);
                ps.setBigDecimal(3, new java.math.BigDecimal(d[2]));
                ps.setInt(4, Integer.parseInt(d[3]));
                ps.executeUpdate();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        try (Connection cn = KetNoiCSDL.moKetNoi()) {
            napDuLieuMau(cn);          // ba sản phẩm, đúng một tên chứa "Cà phê"

            String tuKhoaBinhThuong = "Cà phê";
            String tuKhoaDocHai = "' OR '1'='1";

            System.out.println("=== Cách SAI - ghép chuỗi ===");
            System.out.println("Tìm \"" + tuKhoaBinhThuong + "\":");
            System.out.println("  Kết quả: "
                    + demSanPhamSai(cn, tuKhoaBinhThuong) + " sản phẩm");
            System.out.println("Tìm với chuỗi độc hại " + tuKhoaDocHai + " :");
            System.out.println("  Kết quả: " + demSanPhamSai(cn, tuKhoaDocHai)
                    + " sản phẩm  <-- LỘ TOÀN BỘ BẢNG");

            System.out.println();
            System.out.println("=== Cách ĐÚNG - PreparedStatement ===");
            System.out.println("Tìm \"" + tuKhoaBinhThuong + "\": "
                    + demSanPhamDung(cn, tuKhoaBinhThuong) + " sản phẩm");
            System.out.println("Tìm với chuỗi độc hại: "
                    + demSanPhamDung(cn, tuKhoaDocHai)
                    + " sản phẩm  <-- bị coi là dữ liệu, không phải mã lệnh");
        }
    }
}

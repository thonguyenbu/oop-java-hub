package jdbc;

/*
 * Mục 6.2 – 6.4 - Kết nối JDBC, PreparedStatement, CRUD và giao dịch
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class DonHangDAO {

    private final Connection cn;

    public DonHangDAO(Connection cn) { this.cn = cn; }

    public int themVaLaySoDon(String maKhachHang, LocalDate ngayDat, BigDecimal tongTien)
            throws SQLException {
        String sql = "INSERT INTO DonHang (MaKhachHang, NgayDat, TongTien) VALUES (?, ?, ?)";
        try (PreparedStatement ps =
                 cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, maKhachHang);
            ps.setDate(2, Date.valueOf(ngayDat));
            ps.setBigDecimal(3, tongTien);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        throw new SQLException("Không lấy được số đơn sinh tự động.");
    }

    public void themChiTiet(int soDon, String maSanPham, int soLuong,
                            BigDecimal donGiaBan) throws SQLException {
        String sql = "INSERT INTO ChiTietDonHang (SoDon, MaSanPham, SoLuong, DonGiaBan) "
                   + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, soDon);
            ps.setString(2, maSanPham);
            ps.setInt(3, soLuong);
            ps.setBigDecimal(4, donGiaBan);
            ps.executeUpdate();
        }
    }
}

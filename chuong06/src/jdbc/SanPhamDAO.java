package jdbc;

/*
 * Mục 6.2 – 6.4 - Kết nối JDBC, PreparedStatement, CRUD và giao dịch
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import chung.*;
import java.math.BigDecimal;

public class SanPhamDAO implements KhoDuLieu<SanPham, String> {
 
    private final Connection cn;          // kết nối do bên ngoài cung cấp
 
    public SanPhamDAO(Connection cn) { this.cn = cn; }
 
    /** Chuyển một dòng của ResultSet thành một đối tượng SanPham. */
    private SanPham docMotDong(ResultSet rs) throws SQLException {
        return new SanPham(
            rs.getString("MaSanPham"),
            rs.getString("TenSanPham"),
            rs.getBigDecimal("DonGia"),
            rs.getInt("SoLuongTon"));
    }
 
    @Override
    public void them(SanPham sp) throws SQLException {
        String sql = "INSERT INTO SanPham (MaSanPham, TenSanPham, DonGia, SoLuongTon) "
                   + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, sp.getMaSanPham());
            ps.setString(2, sp.getTenSanPham());
            ps.setBigDecimal(3, sp.getDonGia());
            ps.setInt(4, sp.getSoLuongTon());
            ps.executeUpdate();
        }
    }
 
    @Override
    public boolean capNhat(SanPham sp) throws SQLException {
        String sql = "UPDATE SanPham SET TenSanPham = ?, DonGia = ?, SoLuongTon = ? "
                   + "WHERE MaSanPham = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, sp.getTenSanPham());
            ps.setBigDecimal(2, sp.getDonGia());
            ps.setInt(3, sp.getSoLuongTon());
            ps.setString(4, sp.getMaSanPham());
            return ps.executeUpdate() > 0;
        }
    }
 
    @Override
    public boolean xoaTheoKhoa(String ma) throws SQLException {
        String sql = "DELETE FROM SanPham WHERE MaSanPham = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, ma);
            return ps.executeUpdate() > 0;
        }
    }
 
    @Override
    public SanPham timTheoKhoa(String ma) throws SQLException {
        String sql = "SELECT MaSanPham, TenSanPham, DonGia, SoLuongTon "
                   + "FROM SanPham WHERE MaSanPham = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, ma);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? docMotDong(rs) : null;
            }
        }
    }
 
    @Override
    public List<SanPham> layTatCa() throws SQLException {
        String sql = "SELECT MaSanPham, TenSanPham, DonGia, SoLuongTon "
                   + "FROM SanPham ORDER BY MaSanPham";
        List<SanPham> ds = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) ds.add(docMotDong(rs));
        }
        return ds;
    }
 
    public List<SanPham> timTheoTen(String tuKhoa) throws SQLException {
        String sql = "SELECT MaSanPham, TenSanPham, DonGia, SoLuongTon "
                   + "FROM SanPham WHERE TenSanPham LIKE ? ORDER BY TenSanPham";
        List<SanPham> ds = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, "%" + tuKhoa + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) ds.add(docMotDong(rs));
            }
        }
        return ds;
    }
 
    /** Trừ tồn kho, gộp việc kiểm tra vào chính câu lệnh UPDATE. */
    public boolean truTonKho(String ma, int soLuong) throws SQLException {
        String sql = "UPDATE SanPham SET SoLuongTon = SoLuongTon - ? "
                   + "WHERE MaSanPham = ? AND SoLuongTon >= ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, soLuong);
            ps.setString(2, ma);
            ps.setInt(3, soLuong);
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public int soLuong() throws SQLException {
        String sql = "SELECT COUNT(*) FROM SanPham";
        try (PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getInt(1);
        }
    }
}

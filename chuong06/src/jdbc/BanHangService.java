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
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BanHangService {

    private final Connection cn;

    public BanHangService(Connection cn) { this.cn = cn; }

    /**
     * Lập một đơn hàng gồm nhiều dòng. Toàn bộ thao tác nằm trong một giao dịch:
     * hoặc mọi bảng đều được cập nhật, hoặc không bảng nào bị thay đổi.
     */
    public int lapDonHang(String maKhachHang, List<DongDatHang> cacDong)
            throws SQLException {
        SanPhamDAO spDao = new SanPhamDAO(cn);
        DonHangDAO dhDao = new DonHangDAO(cn);

        boolean tuDongCommitCu = cn.getAutoCommit();
        cn.setAutoCommit(false);                       // bắt đầu giao dịch
        try {
            BigDecimal tongTien = BigDecimal.ZERO;
            // giá tại thời điểm bán
            Map<String, BigDecimal> giaBan = new LinkedHashMap<>();
            for (DongDatHang d : cacDong) {
                SanPham sp = spDao.timTheoKhoa(d.getMaSanPham());
                if (sp == null) {
                    throw new SQLException("Không có sản phẩm " + d.getMaSanPham());
                }
                if (!spDao.truTonKho(d.getMaSanPham(), d.getSoLuong())) {
                    throw new SQLException("Không đủ tồn kho cho " + d.getMaSanPham()
                            + " (còn " + sp.getSoLuongTon()
                            + ", cần " + d.getSoLuong() + ")");
                }
                giaBan.put(d.getMaSanPham(), sp.getDonGia());
                tongTien = tongTien.add(
                        sp.getDonGia().multiply(BigDecimal.valueOf(d.getSoLuong())));
            }

            int soDon = dhDao.themVaLaySoDon(maKhachHang, LocalDate.now(), tongTien);
            for (DongDatHang d : cacDong) {
                dhDao.themChiTiet(soDon, d.getMaSanPham(), d.getSoLuong(),
                        giaBan.get(d.getMaSanPham()));
            }

            cn.commit();                                // xác nhận giao dịch
            return soDon;
        } catch (SQLException | RuntimeException e) {
            cn.rollback();                              // hoàn tác toàn bộ
            throw e;
        } finally {
            cn.setAutoCommit(tuDongCommitCu);           // trả kết nối về trạng thái cũ
        }
    }
}

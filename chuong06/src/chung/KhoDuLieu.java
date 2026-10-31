package chung;

/*
 * Lớp dùng chung - Lớp thực thể và giao diện kho dữ liệu dùng chung
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import java.sql.SQLException;
import java.util.List;

public interface KhoDuLieu<T, K> {
    void them(T doiTuong) throws SQLException;
    boolean capNhat(T doiTuong) throws SQLException;
    boolean xoaTheoKhoa(K khoa) throws SQLException;
    T timTheoKhoa(K khoa) throws SQLException;
    List<T> layTatCa() throws SQLException;
    int soLuong() throws SQLException;
}

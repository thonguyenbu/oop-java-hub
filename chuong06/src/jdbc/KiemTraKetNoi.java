package jdbc;

/*
 * Mục 6.2 – 6.4 - Kết nối JDBC, PreparedStatement, CRUD và giao dịch
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import java.sql.Connection;
import java.sql.SQLException;

public class KiemTraKetNoi {
    public static void main(String[] args) {
        try (Connection cn = KetNoiCSDL.moKetNoi()) {
            System.out.println("Kết nối thành công!");
            System.out.println("  Hệ quản trị: "
                    + cn.getMetaData().getDatabaseProductName());
            System.out.println("  Phiên bản  : "
                    + cn.getMetaData().getDatabaseProductVersion());
            System.out.println("  Driver     : "
                    + cn.getMetaData().getDriverVersion());
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại.");
            System.out.println("  Mã lỗi   : " + e.getErrorCode());
            System.out.println("  SQLState : " + e.getSQLState());
            System.out.println("  Thông báo: " + e.getMessage());
        }
    }
}

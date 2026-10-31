package jdbc;

/*
 * Mục 6.2 – 6.4 - Kết nối JDBC, PreparedStatement, CRUD và giao dịch
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class KetNoiCSDL {
 
    private static final String URL =
        "jdbc:sqlserver://localhost:1433;databaseName=MiniMart;"
      + "encrypt=true;trustServerCertificate=true";
    private static final String NGUOI_DUNG = "sa";
    private static final String MAT_KHAU = "MatKhau@123";
 
    private KetNoiCSDL() { }        // lớp tiện ích, không tạo đối tượng
 
    public static Connection moKetNoi() throws SQLException {
        return DriverManager.getConnection(URL, NGUOI_DUNG, MAT_KHAU);
    }
}

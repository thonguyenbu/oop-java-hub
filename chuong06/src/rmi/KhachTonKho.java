package rmi;

/*
 * Mục 6.10.3 - Gọi phương thức từ xa với Java RMI
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class KhachTonKho {
    public static void main(String[] args) throws Exception {
        Registry soDangKy = LocateRegistry.getRegistry("localhost", 1099);
        TraCuuTonKho kho =
                (TraCuuTonKho) soDangKy.lookup("TraCuuTonKho");
        System.out.println("Tồn kho SP001 = " + kho.tonKho("SP001"));
        System.out.println("Tồn kho SP009 = " + kho.tonKho("SP009"));
    }
}

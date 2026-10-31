package rmi;

/*
 * Mục 6.10.3 - Gọi phương thức từ xa với Java RMI
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class MayChuTonKho implements TraCuuTonKho {

    private static final Map<String, Integer> KHO =
            Map.of("SP001", 120, "SP002", 85);

    @Override
    public int tonKho(String maSanPham) {
        return KHO.getOrDefault(maSanPham, 0);
    }

    public static void main(String[] args) throws Exception {
        TraCuuTonKho cot = (TraCuuTonKho)
                UnicastRemoteObject.exportObject(new MayChuTonKho(), 0);
        Registry soDangKy = LocateRegistry.createRegistry(1099);
        soDangKy.rebind("TraCuuTonKho", cot);
        System.out.println("TraCuuTonKho sẵn sàng tại cổng 1099.");
    }
}

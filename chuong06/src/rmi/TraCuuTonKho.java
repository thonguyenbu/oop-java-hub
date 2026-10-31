package rmi;

/*
 * Mục 6.10.3 - Gọi phương thức từ xa với Java RMI
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TraCuuTonKho extends Remote {
    int tonKho(String maSanPham) throws RemoteException;
}

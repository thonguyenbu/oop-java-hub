package vd41;

/*
 * Ví dụ 4.1 - Rò rỉ dữ liệu qua getter trả về mảng bên trong
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

import java.util.Arrays;

public class DemoRoRiDuLieu {
    public static void main(String[] args) {
        SanPham sp = new SanPham("SP001", 65000);
        sp.doiGia(68000);
        sp.doiGia(70000);
 
        System.out.println("Lịch sử giá (đúng): " + Arrays.toString(sp.getLichSuGia()));
 
        double[] roRi = sp.getLichSuGiaSai();
        roRi[0] = 999999;
        System.out.println("Sau khi sửa qua getLichSuGiaSai(): "
                           + Arrays.toString(sp.getLichSuGia()));
 
        double[] banSao = sp.getLichSuGia();
        banSao[0] = 111111;
        System.out.println("Sau khi sửa qua getLichSuGia():    "
                           + Arrays.toString(sp.getLichSuGia()));
    }
}

package vd272;

import java.util.ArrayList;
import java.util.List;
public class GioHang {
    public static void main(String[] args) {
        List<String> gioHang = new ArrayList<>();
        gioHang.add("SP001");
        gioHang.add("SP002");
        gioHang.add("SP003");
        gioHang.add(1, "SP009");          // chèn vào vị trí 1
        System.out.printf("Giỏ hàng: %s | size = %d%n", gioHang, gioHang.size());
        gioHang.remove("SP002");
        System.out.printf("Sau khi bỏ SP002: %s%n", gioHang);
        System.out.printf("Có SP003 không? %b | vị trí: %d%n",
                          gioHang.contains("SP003"), gioHang.indexOf("SP003"));
        for (String ma : gioHang) {
            System.out.print(ma + " ");
        }
        System.out.println();
    }
}

package vd273;

import java.util.*;
public class TapHopMa {
    public static void main(String[] args) {
        Set<String> daMua = new HashSet<>();
        daMua.add("SP001");
        daMua.add("SP002");
        daMua.add("SP001");               // bị bỏ qua vì trùng
        System.out.println("HashSet (loại trùng): size = " + daMua.size());
        Set<String> theoThuTu = new LinkedHashSet<>(List.of("SP005", "SP001", "SP003", "SP001"));
        System.out.println("LinkedHashSet: " + theoThuTu);
        Set<String> daSapXep = new TreeSet<>(List.of("SP005", "SP001", "SP003"));
        System.out.println("TreeSet:       " + daSapXep);
    }
}

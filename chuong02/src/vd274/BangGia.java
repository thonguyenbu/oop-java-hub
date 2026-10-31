package vd274;

import java.util.*;
public class BangGia {
    public static void main(String[] args) {
        Map<String, Double> bangGia = new HashMap<>();
        bangGia.put("SP001", 19900.0);
        bangGia.put("SP002", 42000.0);
        bangGia.put("SP003", 6000.0);
        System.out.printf("Giá SP002 = %s%n", bangGia.get("SP002"));
        System.out.printf("Giá SP099 = %s%n", bangGia.getOrDefault("SP099", 0.0));
        System.out.printf("Có SP003? %b%n", bangGia.containsKey("SP003"));
        for (Map.Entry<String, Double> muc : new TreeMap<>(bangGia).entrySet()) {
            System.out.printf("  %s -> %.0f%n", muc.getKey(), muc.getValue());
        }
    }
}

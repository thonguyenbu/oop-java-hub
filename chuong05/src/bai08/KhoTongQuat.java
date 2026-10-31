package bai08;

/*
 * Bài 8 - Lớp tổng quát KhoTongQuat<T extends Comparable<T>>
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.util.*;

public class KhoTongQuat<T extends Comparable<T>> {
    private final List<T> danhSach = new ArrayList<>();
 
    public void them(T x) { if (x != null && !danhSach.contains(x)) danhSach.add(x); }
    public boolean xoa(T x) { return danhSach.remove(x); }
    public int soLuong() { return danhSach.size(); }
 
    public List<T> sapXepTuNhien() {
        List<T> banSao = new ArrayList<>(danhSach);
        Collections.sort(banSao);
        return banSao;
    }
    public List<T> sapXepTheo(Comparator<T> boSoSanh) {
        List<T> banSao = new ArrayList<>(danhSach);
        banSao.sort(boSoSanh);
        return banSao;
    }
    public T lonNhat() { return danhSach.isEmpty() ? null : Collections.max(danhSach); }
    public T nhoNhat() { return danhSach.isEmpty() ? null : Collections.min(danhSach); }
    public Set<T> tapDuyNhat() { return new LinkedHashSet<>(danhSach); }
}

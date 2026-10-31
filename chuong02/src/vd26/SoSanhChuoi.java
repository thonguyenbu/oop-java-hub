package vd26;

public class SoSanhChuoi {
    public static void main(String[] args) {
        String a = "SP001";
        String b = "SP001";
        String c = new String("SP001");
        System.out.printf("a == b        -> %b%n", a == b);
        System.out.printf("a == c        -> %b%n", a == c);
        System.out.printf("a.equals(c)   -> %b%n", a.equals(c));
        String nhap = "  sp001  ";
        System.out.printf("Sau strip+upper: [%s]%n", nhap.strip().toUpperCase());
        System.out.printf("equalsIgnoreCase -> %b%n",
                a.equalsIgnoreCase(nhap.strip()));
    }
}

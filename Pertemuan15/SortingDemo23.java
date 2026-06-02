package Pertemuan15;

import java.util.ArrayList;
import java.util.Collections;

public class SortingDemo23 {
    public static void main(String[] args) {
        ArrayList<String> daftarSiswa = new ArrayList<>();
        daftarSiswa.add("Zainab");
        daftarSiswa.add("Andi");
        daftarSiswa.add("Rara");
        Collections.sort(daftarSiswa);

        System.out.println("=== Sorting String ===");
        System.out.println(daftarSiswa);

        ArrayList<Customer23> customers = new ArrayList<>();
        customers.add(new Customer23(1, "Zakia"));
        customers.add(new Customer23(5, "Budi"));
        customers.add(new Customer23(4, "Cica"));
        customers.add(new Customer23(100, "Rosa"));

        customers.sort((c1, c2) -> c1.name.compareTo(c2.name));
        System.out.println("\n=== Sorting object Customer berdasarkan name ===");
        System.out.println(customers);
    }
}

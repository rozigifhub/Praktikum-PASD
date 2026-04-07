import java.util.Scanner;

public class MahasiswaDemo23 {
    static double readDoubleFlexible(Scanner sc) {
        String token = sc.next().trim();
        token = token.replace(',', '.');
        return Double.parseDouble(token);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MahasiswaBerprestasi23 daftar = new MahasiswaBerprestasi23();

        Mahasiswa23 m1 = new Mahasiswa23("A11", "Andi", "TI-1A", 3.42);
        Mahasiswa23 m2 = new Mahasiswa23("A12", "Budi", "TI-1A", 3.87);
        Mahasiswa23 m3 = new Mahasiswa23("A13", "Citra", "TI-1A", 3.12);
        Mahasiswa23 m4 = new Mahasiswa23("A14", "Dina", "TI-1A", 3.65);
        Mahasiswa23 m5 = new Mahasiswa23("A15", "Eka", "TI-1A", 3.25);

        daftar.tambah(m1);
        daftar.tambah(m2);
        daftar.tambah(m3);
        daftar.tambah(m4);
        daftar.tambah(m5);

        System.out.println("Data mahasiswa:");
        daftar.tampil();

        System.out.print("Masukkan IPK yang dicari (Sequential Search): ");
        double cari = readDoubleFlexible(sc);

        int posisi = daftar.sequentialSearch(cari);
        daftar.tampilPosisi(cari, posisi);
        daftar.tampilDataSearch(cari, posisi);

        System.out.println("\nData mahasiswa setelah sorting IPK ASC (untuk Binary Search):");
        daftar.insertionSortAsc();
        daftar.tampil();

        System.out.print("Masukkan IPK yang dicari (Binary Search): ");
        double cari2 = readDoubleFlexible(sc);

        int posisi2 = daftar.findBinarySearch(cari2);
        daftar.tampilPosisi(cari2, posisi2);
        daftar.tampilDataSearch(cari2, posisi2);

        sc.close();
    }
}

import java.util.Scanner;

public class MahasiswaDemoInput23 {
    static double readDoubleFlexible(Scanner sc) {
        String token = sc.next().trim();
        token = token.replace(',', '.');
        return Double.parseDouble(token);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int n = sc.nextInt();
        sc.nextLine();

        MahasiswaBerprestasi23 daftar = new MahasiswaBerprestasi23(n);

        for (int i = 0; i < n; i++) {
            System.out.println("\nData mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            double ipk = readDoubleFlexible(sc);
            sc.nextLine();

            daftar.tambah(new Mahasiswa23(nim, nama, kelas, ipk));
        }

        System.out.println("\nData mahasiswa:");
        daftar.tampil();

        System.out.print("Masukkan IPK yang dicari (Sequential Search): ");
        double cari = readDoubleFlexible(sc);
        int pos = daftar.sequentialSearch(cari);
        daftar.tampilPosisi(cari, pos);
        daftar.tampilDataSearch(cari, pos);

        daftar.insertionSortAsc();
        System.out.println("\nData mahasiswa setelah sorting IPK ASC (untuk Binary Search):");
        daftar.tampil();

        System.out.print("Masukkan IPK yang dicari (Binary Search): ");
        double cari2 = readDoubleFlexible(sc);
        int pos2 = daftar.findBinarySearch(cari2);
        daftar.tampilPosisi(cari2, pos2);
        daftar.tampilDataSearch(cari2, pos2);

        sc.close();
    }
}

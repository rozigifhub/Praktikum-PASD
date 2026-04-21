package CM1;

import java.util.Scanner;

public class CM1 {

    static void printMenu() {
        System.out.println("\n=== Sistem Manajemen Peminjaman Buku Ruang Baca JTI ===");
        System.out.println("1. Tampilkan data mahasiswa");
        System.out.println("2. Tampilkan data buku");
        System.out.println("3. Tampilkan data peminjaman buku");
        System.out.println("4. Hitung keterlambatan dan total denda");
        System.out.println("5. Urutkan peminjaman berdasarkan denda terbesar");
        System.out.println("6. Cari peminjaman berdasarkan NIM");
        System.out.println("7. Cari peminjaman berdasarkan Nama");
        System.out.println("8. Menampilkan tahun buku terbesar ");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    static int readIntMenu(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Input harus angka. Pilih menu: ");
        }
        return sc.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RuangBacaJTI23 sistem = new RuangBacaJTI23();

        int pilihan;
        do {
            printMenu();
            pilihan = readIntMenu(sc);
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    sistem.tampilkanDataMahasiswa();
                    break;
                case 2:
                    sistem.tampilkanDataBuku();
                    break;
                case 3:
                    sistem.tampilkanDataPeminjaman();
                    break;
                case 4:
                    sistem.tampilkanPerhitunganDenda();
                    break;
                case 5:
                    sistem.tampilkanPeminjamanUrutDendaTerbesar();
                    break;
                case 6:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nim = sc.nextLine().trim();
                    sistem.cariPeminjamanByNim(nim);
                    break;
                case 7:
                    System.out.println("Masukkan Nama yang dicari");
                    String nama = sc.nextLine().trim();
                    sistem.cariPeminjamanLinearSearch(nama);
                case 8:
                    sistem.tampilkanTahunBukuTerbesar();
                case 0:
                    System.out.println("Keluar.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (pilihan != 0);

        sc.close();
    }
}

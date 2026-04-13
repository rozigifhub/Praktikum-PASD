package CM1;

import java.util.Scanner;

public class CM1New23 {
    static void printMenu() {
        System.out.println("\n=== Sistem Manajemen Peminjaman Buku Ruang Baca JTI (Versi Baru) ===");
        System.out.println("1. Input data mahasiswa");
        System.out.println("2. Tampilkan data buku dan mahasiswa");
        System.out.println("3. Tampilkan data peminjaman buku");
        System.out.println("4. Hitung keterlambatan dan total denda");
        System.out.println("5. Urutkan peminjaman berdasarkan denda terbesar (pilih algoritma)");
        System.out.println("6. Cari peminjaman berdasarkan NIM");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    static int readInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print(prompt);
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    static String readLineNonEmpty(Scanner sc, String prompt) {
        String s;
        do {
            System.out.print(prompt);
            s = sc.nextLine().trim();
        } while (s.isEmpty());
        return s;
    }

    static int menuSortingAlgoritma(Scanner sc) {
        System.out.println("\nPilih algoritma sorting:");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Bubble Sort");
        int pilih = readInt(sc, "Pilihan: ");
        if (pilih < 1 || pilih > 3) {
            System.out.println("Pilihan tidak valid, default: Insertion Sort.");
            pilih = 1;
        }
        return pilih;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RuangBacaJT23 sistem = new RuangBacaJT23();

        int pilihan;
        do {
            printMenu();
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Input harus angka. Pilih menu: ");
            }
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1: {
                    String nim = readLineNonEmpty(sc, "NIM   : ");
                    String nama = readLineNonEmpty(sc, "Nama  : ");
                    String prodi = readLineNonEmpty(sc, "Prodi : ");
                    boolean ok = sistem.tambahMahasiswa(nim, nama, prodi);
                    if (ok) {
                        System.out.println("Mahasiswa berhasil ditambahkan.");
                    } else {
                        System.out.println("Gagal menambahkan mahasiswa (NIM kosong atau sudah ada).");
                    }
                    break;
                }
                case 2:
                    sistem.tampilkanDataBukuDanMahasiswa();
                    break;
                case 3:
                    sistem.tampilkanDataPeminjaman();
                    break;
                case 4:
                    sistem.tampilkanPerhitunganDenda();
                    break;
                case 5: {
                    int alg = menuSortingAlgoritma(sc);
                    sistem.tampilkanPeminjamanUrutDendaTerbesar(alg);
                    break;
                }
                case 6: {
                    String nimCari = readLineNonEmpty(sc, "Masukkan NIM yang dicari: ");
                    sistem.cariPeminjamanByNim(nimCari);
                    break;
                }
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


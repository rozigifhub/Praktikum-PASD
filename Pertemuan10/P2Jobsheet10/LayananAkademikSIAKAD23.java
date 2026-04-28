package Pertemuan10.P2Jobsheet10;

import java.util.Scanner;

public class LayananAkademikSIAKAD23 {
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

    static void menu() {
        System.out.println("\n=== Menu Layanan Akademik (SIAKAD) ===");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Panggil Antrian");
        System.out.println("3. Lihat Antrian Terdepan");
        System.out.println("4. Lihat Semua Antrian");
        System.out.println("5. Cek Jumlah Antrian");
        System.out.println("6. Cek Antrian Paling Belakang");
        System.out.println("0. Keluar");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianLayanan23 antrian = new AntrianLayanan23(5);

        int pilihan;
        do {
            menu();
            pilihan = readInt(sc, "Pilih: ");

            switch (pilihan) {
                case 1: {
                    String nim = readLineNonEmpty(sc, "NIM   : ");
                    String nama = readLineNonEmpty(sc, "Nama  : ");
                    String prodi = readLineNonEmpty(sc, "Prodi : ");
                    String kelas = readLineNonEmpty(sc, "Kelas : ");
                    antrian.enqueue(new Mahasiswa23(nim, nama, prodi, kelas));
                    break;
                }
                case 2: {
                    Mahasiswa23 dipanggil = antrian.dequeue();
                    if (dipanggil != null) {
                        System.out.println("\nMahasiswa dipanggil:");
                        dipanggil.tampilkanData();
                    }
                    break;
                }
                case 3:
                    antrian.peek();
                    break;
                case 4:
                    antrian.print();
                    break;
                case 5:
                    System.out.println("Jumlah antrian: " + antrian.getJumlahAntrian());
                    break;
                case 6:
                    antrian.lihatAkhir();
                    break;
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


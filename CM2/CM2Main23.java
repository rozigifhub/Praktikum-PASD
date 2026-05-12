package CM2;

import java.util.Scanner;

public class CM2Main23 {
    static String readLineNonEmpty(Scanner sc, String prompt) {
        String value;
        do {
            System.out.print(prompt);
            value = sc.nextLine().trim();
        } while (value.isEmpty());
        return value;
    }

    static int readInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print(prompt);
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    static void menu() {
        System.out.println("\n=== Sistem Antrean Royal Delish ===");
        System.out.println("1. Tambah antrian");
        System.out.println("2. Cetak antrian");
        System.out.println("3. Hapus antrian + input pesanan");
        System.out.println("4. Laporan pesanan");
        System.out.println("0. Keluar");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianPembeli23 antrian = new AntrianPembeli23();
        int pilihan;

        do {
            menu();
            pilihan = readInt(sc, "Pilih menu: ");

            switch (pilihan) {
                case 1: {
                    String nama = readLineNonEmpty(sc, "Nama pembeli : ");
                    String noHp = readLineNonEmpty(sc, "No HP        : ");
                    antrian.tambahAntrian(nama, noHp);
                    antrian.tampilkanRingkasSetelahTambah();
                    break;
                }
                case 2:
                case 3:
                case 4:
                    System.out.println("Menu ini belum dikerjakan karena pengerjaan dibatasi 25% sesuai permintaan.");
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

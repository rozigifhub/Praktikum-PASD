package Pertemuan9;

import java.util.Scanner;

public class SuratDemo23 {
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

    static char readJenisIzin(Scanner sc, String prompt) {
        char c;
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim().toUpperCase();
            if (s.length() == 1) {
                c = s.charAt(0);
                if (c == 'S' || c == 'I') {
                    return c;
                }
            }
            System.out.println("Input jenis izin harus 'S' (sakit) atau 'I' (izin).");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackSurat23 stack = new StackSurat23(10);

        int pilih;
        do {
            System.out.println("\n=== Menu Surat Izin Mahasiswa ===");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin (Verifikasi)");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat berdasarkan Nama Mahasiswa");
            System.out.println("0. Keluar");
            pilih = readInt(sc, "Pilih: ");

            switch (pilih) {
                case 1: {
                    String id = readLineNonEmpty(sc, "ID Surat       : ");
                    String nama = readLineNonEmpty(sc, "Nama Mahasiswa : ");
                    String kelas = readLineNonEmpty(sc, "Kelas          : ");
                    char jenis = readJenisIzin(sc, "Jenis Izin (S/I): ");
                    int durasi = readInt(sc, "Durasi (hari)  : ");
                    stack.push(new Surat23(id, nama, kelas, jenis, durasi));
                    break;
                }
                case 2: {
                    Surat23 s = stack.pop();
                    if (s != null) {
                        System.out.println("\nSurat diproses (diverifikasi):");
                        stack.tampilRingkas(s);
                    }
                    break;
                }
                case 3: {
                    Surat23 s = stack.peek();
                    System.out.println("\nSurat terakhir:");
                    stack.tampilRingkas(s);
                    break;
                }
                case 4: {
                    String namaCari = readLineNonEmpty(sc, "Masukkan nama mahasiswa: ");
                    boolean ketemu = stack.cariByNama(namaCari);
                    if (!ketemu) {
                        System.out.println("Surat untuk nama " + namaCari + " tidak ditemukan.");
                    }
                    break;
                }
                case 0:
                    System.out.println("Keluar.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (pilih != 0);

        sc.close();
    }
}


package Pertemuan10.TugasKRS;

import java.util.Scanner;

public class KRSMain23 {
    static final int MAX_ANTRIAN = 10;
    static final int MAKS_DITANGANI_DPA = 30;

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
        System.out.println("\n=== Menu Antrian Persetujuan KRS (DPA) ===");
        System.out.println("1. Tambah Antrian (Daftar Mahasiswa)");
        System.out.println("2. Panggil Antrian untuk Proses KRS (2 mahasiswa)");
        System.out.println("3. Tampilkan Semua Antrian");
        System.out.println("4. Tampilkan 2 Antrian Terdepan");
        System.out.println("5. Tampilkan Antrian Paling Akhir");
        System.out.println("6. Cek Antrian Kosong");
        System.out.println("7. Cek Antrian Penuh");
        System.out.println("8. Kosongkan Antrian");
        System.out.println("9. Cetak Jumlah Antrian");
        System.out.println("10. Cetak Jumlah yang Sudah Proses KRS");
        System.out.println("11. Cetak Jumlah yang Belum Proses KRS (dari kuota 30)");
        System.out.println("0. Keluar");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS23 antrian = new AntrianKRS23(MAX_ANTRIAN);
        int sudahProses = 0;

        int pilihan;
        do {
            menu();
            pilihan = readInt(sc, "Pilih: ");

            switch (pilihan) {
                case 1: {
                    if (sudahProses >= MAKS_DITANGANI_DPA) {
                        System.out.println("Kuota DPA (30 mahasiswa) sudah terpenuhi. Tidak bisa menerima antrian baru.");
                        break;
                    }
                    String nim = readLineNonEmpty(sc, "NIM   : ");
                    String nama = readLineNonEmpty(sc, "Nama  : ");
                    String prodi = readLineNonEmpty(sc, "Prodi : ");
                    String kelas = readLineNonEmpty(sc, "Kelas : ");
                    antrian.enqueue(new MahasiswaKRS23(nim, nama, prodi, kelas));
                    break;
                }
                case 2: {
                    if (sudahProses >= MAKS_DITANGANI_DPA) {
                        System.out.println("Kuota DPA (30 mahasiswa) sudah terpenuhi. Proses KRS dihentikan.");
                        break;
                    }
                    int diprosesSekarang = 0;
                    for (int i = 0; i < 2; i++) {
                        if (sudahProses >= MAKS_DITANGANI_DPA) {
                            break;
                        }
                        MahasiswaKRS23 mhs = antrian.dequeue();
                        if (mhs == null) {
                            break;
                        }
                        diprosesSekarang++;
                        sudahProses++;
                        System.out.println("\nDipanggil untuk proses KRS:");
                        mhs.tampilkanData();
                    }
                    if (diprosesSekarang == 0) {
                        System.out.println("Antrian kosong. Tidak ada yang diproses.");
                    } else {
                        System.out.println("\nJumlah diproses pada panggilan ini: " + diprosesSekarang);
                    }
                    break;
                }
                case 3:
                    antrian.printAll();
                    break;
                case 4:
                    antrian.printFront2();
                    break;
                case 5:
                    antrian.lihatAkhir();
                    break;
                case 6:
                    System.out.println("Antrian kosong: " + antrian.isEmpty());
                    break;
                case 7:
                    System.out.println("Antrian penuh: " + antrian.isFull());
                    break;
                case 8:
                    antrian.clear();
                    break;
                case 9:
                    System.out.println("Jumlah antrian saat ini: " + antrian.getJumlahAntrian());
                    break;
                case 10:
                    System.out.println("Jumlah yang sudah proses KRS: " + sudahProses);
                    break;
                case 11:
                    System.out.println("Jumlah yang belum proses KRS (dari kuota 30): " + (MAKS_DITANGANI_DPA - sudahProses));
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


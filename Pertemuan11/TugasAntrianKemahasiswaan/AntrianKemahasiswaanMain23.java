package Pertemuan11.TugasAntrianKemahasiswaan;

import java.util.Scanner;

public class AntrianKemahasiswaanMain23 {
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
        System.out.println("\n=== Antrian Layanan Unit Kemahasiswaan (Queue Linked List) ===");
        System.out.println("1. Daftar & Tambah Antrian");
        System.out.println("2. Panggil Antrian (Dequeue)");
        System.out.println("3. Cek Antrian Kosong");
        System.out.println("4. Cek Antrian Penuh");
        System.out.println("5. Kosongkan Antrian");
        System.out.println("6. Lihat Antrian Terdepan");
        System.out.println("7. Lihat Antrian Paling Akhir");
        System.out.println("8. Cetak Jumlah Mahasiswa yang Masih Mengantre");
        System.out.println("0. Keluar");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueLinkedList23 antrian = new QueueLinkedList23(10);

        int pilih;
        do {
            menu();
            pilih = readInt(sc, "Pilih: ");
            switch (pilih) {
                case 1: {
                    String nim = readLineNonEmpty(sc, "NIM   : ");
                    String nama = readLineNonEmpty(sc, "Nama  : ");
                    String prodi = readLineNonEmpty(sc, "Prodi : ");
                    String kelas = readLineNonEmpty(sc, "Kelas : ");
                    antrian.enqueue(new MahasiswaAntri23(nim, nama, prodi, kelas));
                    break;
                }
                case 2: {
                    MahasiswaAntri23 dipanggil = antrian.dequeue();
                    if (dipanggil != null) {
                        System.out.println("\nMahasiswa dipanggil:");
                        dipanggil.tampilkanData();
                    }
                    break;
                }
                case 3:
                    System.out.println("Antrian kosong: " + antrian.isEmpty());
                    break;
                case 4:
                    System.out.println("Antrian penuh: " + antrian.isFull());
                    break;
                case 5:
                    antrian.clear();
                    break;
                case 6: {
                    MahasiswaAntri23 depan = antrian.peekFront();
                    if (depan == null) {
                        System.out.println("Antrian kosong.");
                    } else {
                        System.out.println("\nAntrian terdepan:");
                        depan.tampilkanData();
                    }
                    break;
                }
                case 7: {
                    MahasiswaAntri23 belakang = antrian.peekRear();
                    if (belakang == null) {
                        System.out.println("Antrian kosong.");
                    } else {
                        System.out.println("\nAntrian paling akhir:");
                        belakang.tampilkanData();
                    }
                    break;
                }
                case 8:
                    System.out.println("Jumlah mahasiswa yang masih mengantre: " + antrian.getJumlahAntrian());
                    break;
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


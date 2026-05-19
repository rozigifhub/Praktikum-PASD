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

    static void tampilkanMenuUtama() {
        System.out.println("\n=== Sistem Antrean Royal Delish ===");
        System.out.println("1. Tambah antrian");
        System.out.println("2. Cetak antrian");
        System.out.println("3. Hapus antrian + input pesanan");
        System.out.println("4. Laporan pesanan");
        System.out.println("5. Lihat antrean depan");
        System.out.println("6. Lihat antrean belakang");
        System.out.println("7. Cari by nama");
        System.out.println("8. Batal antrean");
        System.out.println("0. Keluar");
    }

    static void tampilkanMenuMakanan() {
        System.out.println("\nDaftar Menu Makanan");
        System.out.println("1. Nasi Goreng - Rp 18000");
        System.out.println("2. Mie Goreng - Rp 15000");
        System.out.println("3. Ayam Geprek - Rp 20000");
        System.out.println("4. Sate Ayam - Rp 25000");
        System.out.println("5. Es Teh - Rp 5000");
    }

    static Pesanan23 buatPesananDariPilihan(int pilihan, Pembeli23 pembeli) {
        switch (pilihan) {
            case 1:
                return new Pesanan23(101, "Nasi Goreng", 18000, pembeli);
            case 2:
                return new Pesanan23(102, "Mie Goreng", 15000, pembeli);
            case 3:
                return new Pesanan23(103, "Ayam Geprek", 20000, pembeli);
            case 4:
                return new Pesanan23(104, "Sate Ayam", 25000, pembeli);
            case 5:
                return new Pesanan23(105, "Es Teh", 5000, pembeli);
            default:
                return null;
        }
    }

    // static Pesanan23 inputPesanan(Scanner sc, Pembeli23 pembeli) {
    //     tampilkanMenuMakanan();
    //     int pilihanMenu = readInt(sc, "Pilih makanan: ");
    //     Pesanan23 pesanan = buatPesananDariPilihan(pilihanMenu, pembeli);

    //     while (pesanan == null) {
    //         System.out.println("Pilihan makanan tidak tersedia.");
    //         pilihanMenu = readInt(sc, "Pilih makanan: ");
    //         pesanan = buatPesananDariPilihan(pilihanMenu, pembeli);
    //     }
    //     return pesanan;
    // }
    static Pesanan23 inputPesanan(Scanner sc, Pembeli23 pembeli) {
        int kodePesanan = readInt(sc, "Kode Pesanan : ");
        String namaPesanan = readLineNonEmpty(sc, "Nama Pesanan : ");
        int harga = readInt(sc, "Harga Pesanan : ");

        return new Pesanan23(kodePesanan, namaPesanan, harga, pembeli);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianPembeli23 antrian = new AntrianPembeli23();
        DaftarPesanan23 daftarPesanan = new DaftarPesanan23();
        int pilihan;

        do {
            tampilkanMenuUtama();
            pilihan = readInt(sc, "Pilih menu: ");

            switch (pilihan) {
                case 1: {
                    String nama = readLineNonEmpty(sc, "Nama pembeli : ");
                    String noHp = readLineNonEmpty(sc, "No HP        : ");
                    antrian.tambahAntrian(nama, noHp);
                    break;
                }
                case 2:
                    antrian.cetakAntrian();
                    break;
                case 3: {
                    if (antrian.isEmpty()) {
                        System.out.println("Antrian masih kosong.");
                        break;
                    }

                    antrian.cetakAntrian();
                    // int noAntrian = readInt(sc, "Masukkan no antrean yang dipanggil: ");
                    // Pembeli23 pembeli = antrian.hapusAntrian(noAntrian);
                    Pembeli23 pembeli = antrian.hapusAntrianDepan();


                    if (pembeli == null) {
                        System.out.println("Nomor antrean tidak ditemukan.");
                        break;
                    }

                    System.out.println("\nPembeli menuju kasir:");
                    pembeli.tampil();
                    Pesanan23 pesanan = inputPesanan(sc, pembeli);
                    daftarPesanan.tambahPesanan(pesanan);

                    System.out.println(pembeli.namaPembeli + " telah memesan " + pesanan.namaPesanan);
                    System.out.println("Pesanan berhasil disimpan.");
                    System.out.println("Sisa antrean setelah pemanggilan:");
                    antrian.cetakAntrian();
                    break;
                }
                case 4:
                    daftarPesanan.tampilkanLaporanTerurut();
                    break;
                case 5:
                    antrian.lihatAntreanDepan();
                case 6:
                    antrian.lihatAntreanBelakang();
                case 7:
                    System.out.print("Tulis nama: ");
                    String nama = sc.nextLine();
                    daftarPesanan.linearSearchByNama(nama);
                case 8:  {
                    if (antrian.isEmpty()) {
                        System.out.println("Antrian masih kosong.");
                        break;
                    }

                    antrian.cetakAntrian();
                    int noAntrian = readInt(sc, "Masukkan nomor antrean yang dibatalkan: ");
                    Pembeli23 batal = antrian.batalAntrian(noAntrian);

                    if (batal == null) {
                        System.out.println("Nomor antrean tidak ditemukan.");
                    } else {
                        System.out.println("Antrean berikut berhasil dibatalkan:");
                        batal.tampil();
                    }
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

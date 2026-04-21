package Pertemuan9;

import java.util.Scanner;

public class MahasiswaDemo23 {
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

    static void tampilMahasiswa(Mahasiswa23 mhs) {
        if (mhs == null) {
            System.out.println("Data tidak ada.");
            return;
        }
        System.out.println("NIM   : " + mhs.nim);
        System.out.println("Nama  : " + mhs.nama);
        System.out.println("Kelas : " + mhs.kelas);
        System.out.println("Nilai : " + (mhs.nilai == -1 ? "Belum dinilai" : mhs.nilai));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackTugasMahasiswa23 stack = new StackTugasMahasiswa23(5);

        int pilih;
        do {
            System.out.println("\n=== Menu Stack Tugas Mahasiswa ===");
            System.out.println("1. Kumpulkan Tugas (Push)");
            System.out.println("2. Nilai Tugas (Pop)");
            System.out.println("3. Lihat Tugas Teratas (Peek)");
            System.out.println("4. Lihat Semua Tugas (Print)");
            System.out.println("5. Lihat Tugas Terbawah");
            System.out.println("6. Hitung Jumlah Tugas Terkumpul");
            System.out.println("0. Keluar");
            pilih = readInt(sc, "Pilih: ");

            switch (pilih) {
                case 1: {
                    String nim = readLineNonEmpty(sc, "NIM   : ");
                    String nama = readLineNonEmpty(sc, "Nama  : ");
                    String kelas = readLineNonEmpty(sc, "Kelas : ");
                    stack.push(new Mahasiswa23(nim, nama, kelas));
                    break;
                }
                case 2: {
                    Mahasiswa23 mhs = stack.pop();
                    if (mhs != null) {
                        System.out.println("\nTugas diambil untuk dinilai:");
                        tampilMahasiswa(mhs);
                        int nilai = readInt(sc, "Masukkan nilai tugas: ");
                        mhs.tugasDinilai(nilai);
                        System.out.println("\nSetelah dinilai:");
                        tampilMahasiswa(mhs);
                        System.out.println("Nilai biner: " + stack.konversiDesimalKeBiner(mhs.nilai));
                    }
                    break;
                }
                case 3: {
                    Mahasiswa23 mhs = stack.peek();
                    System.out.println("\nTugas teratas:");
                    tampilMahasiswa(mhs);
                    break;
                }
                case 4:
                    stack.print();
                    break;
                case 5: {
                    Mahasiswa23 mhs = stack.peekBottom();
                    System.out.println("\nTugas terbawah (yang pertama kali mengumpulkan):");
                    tampilMahasiswa(mhs);
                    break;
                }
                case 6:
                    System.out.println("Jumlah tugas yang sudah terkumpul: " + stack.jumlahTugasTerkumpul());
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

package Pertemuan12.Jobsheet12;

import java.util.Scanner;

public class DoubleLinkedListMain23 {
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

    static double readDoubleFlexible(Scanner sc, String prompt) {
        System.out.print(prompt);
        String token = sc.nextLine().trim().replace(',', '.');
        while (token.isEmpty()) {
            System.out.print(prompt);
            token = sc.nextLine().trim().replace(',', '.');
        }
        return Double.parseDouble(token);
    }

    static Mahasiswa23 inputMahasiswa(Scanner sc) {
        String nim = readLineNonEmpty(sc, "NIM   : ");
        String nama = readLineNonEmpty(sc, "Nama  : ");
        String kelas = readLineNonEmpty(sc, "Kelas : ");
        double ipk = readDoubleFlexible(sc, "IPK   : ");
        return new Mahasiswa23(nim, nama, kelas, ipk);
    }

    static void menu() {
        System.out.println("\n=== Menu Double Linked List ===");
        System.out.println("1. Tambah data di awal");
        System.out.println("2. Tambah data di akhir");
        System.out.println("3. Tambah data pada index tertentu");
        System.out.println("4. Sisipkan data setelah NIM tertentu");
        System.out.println("5. Cari data berdasarkan NIM");
        System.out.println("6. Tampilkan seluruh data");
        System.out.println("7. Tampilkan data secara terbalik");
        System.out.println("8. Hapus data paling awal");
        System.out.println("9. Hapus data paling akhir");
        System.out.println("0. Keluar");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoubleLinkedList23 list = new DoubleLinkedList23();
        int pilihan;

        do {
            menu();
            pilihan = readInt(sc, "Pilih menu: ");

            switch (pilihan) {
                case 1:
                    list.addFirst(inputMahasiswa(sc));
                    break;
                case 2:
                    list.addLast(inputMahasiswa(sc));
                    break;
                case 3: {
                    Mahasiswa23 data = inputMahasiswa(sc);
                    int index = readInt(sc, "Index: ");
                    list.add(data, index);
                    break;
                }
                case 4: {
                    String keyNim = readLineNonEmpty(sc, "Sisip setelah NIM: ");
                    Mahasiswa23 data = inputMahasiswa(sc);
                    list.insertAfter(keyNim, data);
                    break;
                }
                case 5: {
                    String keyNim = readLineNonEmpty(sc, "Cari NIM: ");
                    Node23 found = list.search(keyNim);
                    if (found == null) {
                        System.out.println("Data tidak ditemukan.");
                    } else {
                        System.out.println("Data ditemukan:");
                        found.data.tampil();
                    }
                    break;
                }
                case 6:
                    list.print();
                    break;
                case 7:
                    list.printReverse();
                    break;
                case 8:
                    list.removeFirst();
                    break;
                case 9:
                    list.removeLast();
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

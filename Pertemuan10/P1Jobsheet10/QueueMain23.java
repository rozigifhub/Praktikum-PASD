package Pertemuan10.P1Jobsheet10;

import java.util.Scanner;

public class QueueMain23 {
    static void menu() {
        System.out.println("\n=== Menu Queue ===");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Peek");
        System.out.println("4. Print");
        System.out.println("5. Clear");
        System.out.println("0. Keluar");
        System.out.print("Pilih: ");
    }

    static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Input harus angka. Pilih: ");
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");
        int n = readInt(sc);
        Queue23 Q = new Queue23(n);

        int pilih;
        do {
            menu();
            pilih = readInt(sc);
            switch (pilih) {
                case 1:
                    System.out.print("Masukkan data baru: ");
                    int dataMasuk = readInt(sc);
                    Q.enqueue(dataMasuk);
                    break;
                case 2:
                    int dataKeluar = Q.dequeue();
                    System.out.println("Data yang dikeluarkan: " + dataKeluar);
                    break;
                case 3:
                    Q.peek();
                    break;
                case 4:
                    Q.print();
                    break;
                case 5:
                    Q.clear();
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


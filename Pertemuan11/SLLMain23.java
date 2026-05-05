package Pertemuan11;

import java.util.Scanner;

public class SLLMain23 {
    static String readLineNonEmpty(Scanner sc, String prompt) {
        String s;
        do {
            System.out.print(prompt);
            s = sc.nextLine().trim();
        } while (s.isEmpty());
        return s;
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

    public static void main(String[] args) {
        SingleLinkedList23 singLL = new SingleLinkedList23();

        System.out.println("Data awal:");
        singLL.print();

        // Data awal sesuai instruksi (4 mahasiswa)
        Mahasiswa23 mhs1 = new Mahasiswa23("111", "Andi", "TI-1A", 3.45);
        Mahasiswa23 mhs2 = new Mahasiswa23("112", "Budi", "TI-1A", 3.70);
        Mahasiswa23 mhs3 = new Mahasiswa23("113", "Citra", "TI-1A", 3.20);
        Mahasiswa23 mhs4 = new Mahasiswa23("114", "Dina", "TI-1A", 3.90);

        System.out.println("\nAddFirst(mhs1)");
        singLL.addFirst(mhs1);
        singLL.print();

        System.out.println("\nAddLast(mhs2)");
        singLL.addLast(mhs2);
        singLL.print();

        System.out.println("\nInsertAfter(key=111, mhs3)");
        singLL.insertAfter("111", mhs3);
        singLL.print();

        System.out.println("\nInsertAt(index=2, mhs4)");
        singLL.insertAt(2, mhs4);
        singLL.print();

        // Modifikasi pertanyaan 2.1.2 no 3: input dari keyboard
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== Input 1 data mahasiswa dari keyboard (modifikasi pertanyaan) ===");
        Mahasiswa23 mhsInput = inputMahasiswa(sc);
        singLL.addLast(mhsInput);
        System.out.println("\nSetelah addLast(data input):");
        singLL.print();

        // Percobaan 2: akses dan hapus
        System.out.println("\n=== Percobaan 2: Akses & Hapus Data ===");
        System.out.println("Data pada index 0:");
        Mahasiswa23 d0 = singLL.getData(0);
        if (d0 != null) {
            d0.tampilInformasi();
        }

        String cariNim = readLineNonEmpty(sc, "\nCari indexOf berdasarkan NIM: ");
        int idx = singLL.indexOf(cariNim);
        System.out.println("Index NIM " + cariNim + " = " + idx);

        System.out.println("\nRemoveFirst()");
        singLL.removeFirst();
        singLL.print();

        System.out.println("\nRemoveLast()");
        singLL.removeLast();
        singLL.print();

        String hapusNim = readLineNonEmpty(sc, "\nRemove berdasarkan NIM: ");
        singLL.remove(hapusNim);
        singLL.print();

        System.out.print("\nRemoveAt index: ");
        int hapusIdx = Integer.parseInt(sc.nextLine().trim());
        singLL.removeAt(hapusIdx);
        singLL.print();

        sc.close();
    }
}


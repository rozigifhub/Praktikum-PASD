import java.util.Scanner;

public class Array23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan jumlah Mata Kuliah: ");
        int jumlahMK = sc.nextInt();
        sc.nextLine();

        String[] mk = new String[jumlahMK];

        int[] sks = new int[jumlahMK];

        double[] nilaiAngka = new double[mk.length];
        String[] nilaiHuruf = new String[mk.length];
        double[] nilaiSetara = new double[mk.length];

        // input data mk + sks
        for (int i = 0;i < jumlahMK; i++){
            System.out.println("Nama MK ke-" + (i + 1) + ":");
            mk[i] = sc.nextLine();

            System.out.print("SKS untuk " + mk[i] + ": ");
            sks[i] = sc.nextInt();
            sc.nextLine(); // buang enter
        }

        System.out.println("================================");
        System.out.println("Program Menghitung IP Semester");
        System.out.println("================================");


        for (int i = 0; i < mk.length; i++) {
            nilaiAngka[i] = inputNilai1sampai100(sc, "masukkan nilai Angka untuk MK " + mk[i] + ": ");
            nilaiHuruf[i] = konversiHuruf(nilaiAngka[i]);
            nilaiSetara[i] = konversiSetara(nilaiAngka[i]);
        }

        System.out.println("\n================================");
        System.out.println("hasil Konversi Nilai");
        System.out.println("================================\n");
        
        System.out.printf("%-40s %12s %12s %12s%n", "MK", "Nilai Angka", "Nilai Huruf", "Bobot Nilai");
        for (int i = 0; i < mk.length; i++) {
            System.out.printf("%-40s %12.2f %12s %12.2f%n",
                    mk[i], nilaiAngka[i], nilaiHuruf[i], nilaiSetara[i]);
        }

        double ip = hitungIP(nilaiSetara, sks);
        System.out.printf("%nIP : %.2f%n", ip);

        sc.close();
    }

    static double inputNilai1sampai100(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (!sc.hasNextDouble()) {
                System.out.println("Input harus angka (bukan teks).");
                sc.next();
                continue;
            }

            double nilai = sc.nextDouble();
            if (nilai < 1 || nilai > 100) {
                System.out.println("Nilai harus 1 sampai 100.");
                continue;
            }

            return nilai;
        }
    }

    static String konversiHuruf(double n) {
        if (n > 80 && n <= 100) return "A";
        else if (n > 73 && n <= 80) return "B+";
        else if (n > 65 && n <= 73) return "B";
        else if (n > 60 && n <= 65) return "C+";
        else if (n > 50 && n <= 60) return "C";
        else if (n > 39 && n <= 50) return "D";
        else return "E";
    }

    static double konversiSetara(double n) {
        if (n > 80 && n <= 100) return 4.0;
        else if (n > 73 && n <= 80) return 3.5;
        else if (n > 65 && n <= 73) return 3.0;
        else if (n > 60 && n <= 65) return 2.5;
        else if (n > 50 && n <= 60) return 2.0;
        else if (n > 39 && n <= 50) return 1.0;
        else return 0.0;
    }

    static double hitungIP(double[] setara, int[] sks) {
        double totalBobot = 0;
        int totalSks = 0;

        for (int i = 0; i < setara.length; i++) {
            totalBobot += setara[i] * sks[i];
            totalSks += sks[i];
        }
        return totalBobot / totalSks;
    }
}

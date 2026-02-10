import java.util.Scanner;
public class pemilihan23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Program Menghitung Nilai Akhir");
        System.out.print("masukkan nilai tugas ");
        int NTugas = inputNilai1sampai100(sc);
        System.out.print("masukkan nilai Kuis ");
        int NKuis = inputNilai1sampai100(sc);
        System.out.print("masukkan nilai UAS ");
        int NUas = inputNilai1sampai100(sc);
        System.out.print("masukkan nilai UTS ");
        int NUts = inputNilai1sampai100(sc);

        double total = NTugas*0.2 + NKuis*0.2 + NUts*0.3 + NUas*0.3;
        String nilaiHuruf = hasil(NTugas, NKuis, NUas, NUts);
        System.out.println("============");
        System.out.println("Nilai akhir: " + total);
        System.out.println("Nilai Huruf: " + nilaiHuruf);


        System.out.println("============");
        if(nilaiHuruf == "B" || nilaiHuruf == "B+" || nilaiHuruf == "A" || nilaiHuruf == "C+" || nilaiHuruf == "C"){
            System.out.println("Selamat anda lulus");
        } else {
            System.out.print("Tidak lulus");
        }
        


        sc.close();
    }

    static String hasil(int NTugas, int NKuis, int NUts, int NUas) {
        double n = NTugas*0.2 + NKuis*0.2 + NUts*0.3 + NUas*0.3;

        String nilaiHuruf;
        if (n > 80 && n <= 100) {
            nilaiHuruf = "A";
        } else if (n > 73 && n <= 80) {
            nilaiHuruf = "B+";
        } else if (n > 65 && n <= 73) {
            nilaiHuruf = "B";
        } else if (n > 60 && n <= 65) {
            nilaiHuruf = "C+";
        } else if (n > 50 && n <= 60) {
            nilaiHuruf = "C";
        } else if (n > 39 && n <= 50) {
            nilaiHuruf = "D";
        } else { // n <= 39
            nilaiHuruf = "E";
        }

        return nilaiHuruf;
}

    



    static int inputNilai1sampai100(Scanner sc) {
        while (true) {
            System.out.print("Masukkan nilai (1-100): ");

            if (!sc.hasNextInt()) {          // kalau yang diketik bukan angka
                System.out.println("Input harus angka (bukan teks).");
                sc.next();                   // buang token yang salah
                continue;
            }

            int nilai = sc.nextInt();
            if (nilai < 1 || nilai > 100) {
                System.out.println("Nilai harus 1 sampai 100.");
                continue;
            }

            return nilai; // valid
        }
    }
    
}

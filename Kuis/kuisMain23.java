import java.util.Scanner;

public class kuisMain23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Pesanan, id_unik;
        int jumlah_Pesanan, no_antrian, jml_customer, kurangi, tambah;

        menu();
        System.out.println("Masukkan jumlah customer: ");
        jml_customer = sc.nextInt();
        kuis23[] arrayCustomer = new kuis23[jml_customer];
        

        for(int i = 0; i < jml_customer; i++){
            System.out.println("Nama customer ke-" + (i + 1));
            System.out.println("Masukkan Pesanan: ");
            Pesanan = sc.nextLine();
            System.out.println("Masukkan no_antrian: ");
            no_antrian = sc.nextInt();
            System.out.println("Masukkan id unik: ");
            id_unik = sc.nextLine();
            System.out.println("Masukkan jumlah pesanan: ");
            jumlah_Pesanan = sc.nextInt();
            System.out.println("Kurangi jumlah pesanan: ");
            kurangi = sc.nextInt();
            System.out.println("Tambah jumlah pesanan: ");
            tambah = sc.nextInt();

            jumlah_Pesanan = jumlah_Pesanan + tambah - kurangi

            arrayCustomer[i] = new kuis23();
            arrayCustomer[i].tambahData(id_unik, Pesanan, jumlah_Pesanan, no_antrian, tambah, kurangi);
        }

        for(int i = 0; i < jml_customer; i++ ){
            arrayCustomer[i].cetakInfo
        }


        sc.close();
    }


    static void menu(){
        System.out.println("====================================");
        System.out.println("Kopi : Americano, Luwak, Kapal Api");
        System.out.println("Makanan : Nasi goreng, Mie Goreng");
        System.out.println("=====================================");
    } 
}

public class kuis23 {
    public String id_unik, Pesanan;
    public int jumlah_Pesanan, no_antrian, Kurangi, tambah;

    public kuis23(String id_unik, String Pesanan, int jumlah_pesanan, int no_antrian, int kurangi, int tambah){
        tambahData(id_unik, Pesanan, jumlah_pesanan, no_antrian, kurangi, tambah);
    }
    public kuis23(){

    }
    void tambahData(String id_unik, String Pesanan, int jumlah_Pesanan, int no_antrian, int kurangi, int tambah) {
        this.id_unik = id_unik;
        this.Pesanan = Pesanan;
        this.jumlah_Pesanan = jumlah_Pesanan;
        this.no_antrian = no_antrian;
    }

    void cetakInfo(){
        System.out.println("Pesanan: " + Pesanan);
        System.out.println();
    }
    

}

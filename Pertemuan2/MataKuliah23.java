public class MataKuliah23 {
    String kodeMK;
    String nama;
    int sks;
    int jumlahJam;

    void tampilinInformasi(){
        System.out.println("Kode MK: " + kodeMK);
        System.out.println("Nama: " + nama);
        System.out.println("Sks: " + sks);
        System.out.println("jumlahJam: " + jumlahJam);
    }

    void ubahSKS(int sksBaru){
        sks = sksBaru;
        System.out.println("Sks sudah diperbarui");
    }

    void tambahJam(int jam){
        jumlahJam = jumlahJam + jam;
    }

    void kurangJam(int jam){
        if (jumlahJam <= jam){
            System.out.println("Pengurangan jam gagal");
            return;
        }
        jumlahJam = jumlahJam - jam;
        System.out.println("Jam saat ini: " + jumlahJam);
    }

    public MataKuliah23(){
        
    }

    public MataKuliah23(String kode, String nm, int SKS, int jam){
        this.kodeMK = kode;
        this.nama = nm;
        this.jumlahJam = jam;
        this.sks = SKS;
        
    }
    public static void main(String[] args) {
        
    }
}

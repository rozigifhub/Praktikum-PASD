public class MataKuliahMain23 {
    public static void main(String[] args) {
        MataKuliah23 mk1 = new MataKuliah23("1", "Aljabar Linear", 4, 10);
        MataKuliah23 mk2 = new MataKuliah23();
        mk2.kodeMK = "2";
        mk2.nama = "Kalkulus 2";
        mk2.jumlahJam = 12;
        mk2.sks = 3;

        mk1.tampilinInformasi();
        mk2.tampilinInformasi();

        mk1.ubahSKS(5);
        mk1.tambahJam(2);
        mk1.tampilinInformasi();

        mk1.kurangJam(5);
        mk1.tampilinInformasi();

    }
}

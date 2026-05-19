package CM2_copy;

public class Pesanan23 {
    int kodePesanan;
    String namaPesanan;
    int harga;
    Pembeli23 pembeli;

    public Pesanan23(int kodePesanan, String namaPesanan, int harga, Pembeli23 pembeli) {
        this.kodePesanan = kodePesanan;
        this.namaPesanan = namaPesanan;
        this.harga = harga;
        this.pembeli = pembeli;
    }

    void tampil() {
        System.out.printf(
                "%-10d %-20s %-12d %-10d %-20s %s%n",
                kodePesanan,
                namaPesanan,
                harga,
                pembeli.noAntrian,
                pembeli.namaPembeli,
                pembeli.noHp);
    }
}

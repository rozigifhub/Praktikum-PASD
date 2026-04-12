package CM1;

public class Buku23 {
    String kodeBuku;
    String judul;
    int tahunTerbit;

    public Buku23(String kodeBuku, String judul, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    void tampil() {
        System.out.printf("%-5s %-15s %d%n", kodeBuku, judul, tahunTerbit);
    }
}

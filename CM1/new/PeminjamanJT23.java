package CM1;

public class PeminjamanJT23 {
    static final int BATAS_MAKS_PINJAM_HARI = 5;
    static final int DENDA_PER_HARI = 2000;

    String nim;
    String namaMahasiswa;
    Buku23 buku;
    int lamaPinjamHari;

    int hariTerlambat;
    int totalDenda;

    public PeminjamanJT23(String nim, String namaMahasiswa, Buku23 buku, int lamaPinjamHari) {
        this.nim = nim;
        this.namaMahasiswa = namaMahasiswa;
        this.buku = buku;
        this.lamaPinjamHari = lamaPinjamHari;
        hitungDenda();
    }

    int hitungDenda() {
        hariTerlambat = Math.max(0, lamaPinjamHari - BATAS_MAKS_PINJAM_HARI);
        totalDenda = hariTerlambat * DENDA_PER_HARI;
        return totalDenda;
    }

    String getNamaTampil(Mahasiswa23 mhs) {
        if (mhs != null) {
            return mhs.nama;
        }
        return namaMahasiswa != null ? namaMahasiswa : "-";
    }

    void tampilRingkas(Mahasiswa23 mhs) {
        System.out.printf("%-6s %-10s %-15s %d%n", nim, getNamaTampil(mhs), buku.judul, lamaPinjamHari);
    }

    void tampilDenganDenda(Mahasiswa23 mhs) {
        System.out.printf("%-6s %-10s %-15s %4d %4d Rp %,d%n", nim, getNamaTampil(mhs), buku.judul, lamaPinjamHari,
                hariTerlambat, totalDenda);
    }
}

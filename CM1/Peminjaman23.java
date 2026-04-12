package CM1;

public class Peminjaman23 {
    static final int BATAS_MAKS_PINJAM_HARI = 5;
    static final int DENDA_PER_HARI = 2000;

    Mahasiswa23 mahasiswa;
    Buku23 buku;
    int lamaPinjamHari;
    int hariTerlambat;
    int totalDenda;

    public Peminjaman23(Mahasiswa23 mahasiswa, Buku23 buku, int lamaPinjamHari) {
        this.mahasiswa = mahasiswa;
        this.buku = buku;
        this.lamaPinjamHari = lamaPinjamHari;
        hitungDenda();
    }

    int hitungDenda() {
        hariTerlambat = Math.max(0, lamaPinjamHari - BATAS_MAKS_PINJAM_HARI);
        totalDenda = hariTerlambat * DENDA_PER_HARI;
        return totalDenda;
    }

    void tampil() {
        System.out.printf("%-6s %-10s %-15s %d%n", mahasiswa.nim, mahasiswa.nama, buku.judul, lamaPinjamHari);
    }

    void tampilDenganDenda() {
        System.out.printf("%-6s %-10s %-15s %4d %4d Rp %,d%n", mahasiswa.nim, mahasiswa.nama, buku.judul, lamaPinjamHari,
                hariTerlambat, totalDenda);
    }
}

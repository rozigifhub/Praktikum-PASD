public class DosenMain23 {
    public static void main(String[] args) {
        Dosen23 dsn1 = new Dosen23();
        dsn1.idDosen = "D001";
        dsn1.nama = "Dosen Satu";
        dsn1.statusAktif = true;
        dsn1.tahunBergabung = 2020;
        dsn1.bidangKeahlian = "Algoritma";

        Dosen23 dsn2 = new Dosen23("D002", "Dosen Dua", false, 2018, "Struktur Data");

        dsn1.tampilInformasi();
        System.out.println("Masa kerja (dsn1): " + dsn1.hitungMasaKerja(2026) + " tahun");
        dsn1.ubahKeahlian("Basis Data");
        dsn1.setStatusAktif(false);
        dsn1.tampilInformasi();

        System.out.println();

        dsn2.tampilInformasi();
        System.out.println("Masa kerja (dsn2): " + dsn2.hitungMasaKerja(2026) + " tahun");
        dsn2.setStatusAktif(true);
        dsn2.ubahKeahlian("Pemrograman Java");
        dsn2.tampilInformasi();
    }
}


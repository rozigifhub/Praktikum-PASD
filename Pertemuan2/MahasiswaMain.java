public class MahasiswaMain<NoAbsen> {
    public static void main(String[] args) {
        Mahasiswa23 mhs1 = new Mahasiswa23();
        mhs1.nama = "Muhammad Ali Farhan";
        mhs1.nim  = "2241720171";
        mhs1.kelas = "S1 2J";
        mhs1.ipk = 3.55;

        mhs1.tampilkanInformasi();
        mhs1.ubahKelas("S1 2K");
        mhs1.updateIPK(3.60);
        mhs1.tampilkanInformasi();

        Mahasiswa23 mhs2 = new Mahasiswa23("Annisa Nabila", "269272378", 3.25, "TI 2L");
        mhs2.updateIPK(3.30);
        mhs2.tampilkanInformasi();

        Mahasiswa23 mhsRozi = new Mahasiswa23("Muhammad Zainur Roziqin", "254107020081", 4.0, "TI 1G");
        mhsRozi.tampilkanInformasi();
    }
}

package CM1;

public class Mahasiswa23 {
    String nim;
    String nama;
    String prodi;

    public Mahasiswa23(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    void tampil() {
        System.out.printf("%-6s %-10s %s%n", nim, nama, prodi);
    }
}

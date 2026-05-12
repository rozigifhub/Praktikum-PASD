package CM2;

public class Pembeli23 {
    int noAntrian;
    String namaPembeli;
    String noHp;

    public Pembeli23(int noAntrian, String namaPembeli, String noHp) {
        this.noAntrian = noAntrian;
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
    }

    void tampil() {
        System.out.printf("%-10d %-20s %s%n", noAntrian, namaPembeli, noHp);
    }
}

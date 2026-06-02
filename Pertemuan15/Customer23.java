package Pertemuan15;

public class Customer23 {
    public int id;
    public String name;

    public Customer23() {
    }

    public Customer23(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " Nama: " + this.name;
    }
}

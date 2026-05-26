package Pertemuan14;

public class Node23 {
    Mahasiswa23 mahasiswa;
    Node23 left;
    Node23 right;

    public Node23() {
    }

    public Node23(Node23 left, Mahasiswa23 mahasiswa, Node23 right) {
        this.left = left;
        this.mahasiswa = mahasiswa;
        this.right = right;
    }
}

package Pertemuan12.Jobsheet12;

public class Node23 {
    Mahasiswa23 data;
    Node23 prev;
    Node23 next;

    public Node23(Node23 prev, Mahasiswa23 data, Node23 next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}

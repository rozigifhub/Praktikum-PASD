package UAS;

public class Node {
    Mahasiswa data;
    Node left, right;

    Node(Mahasiswa data) {
        this.data = data;
        left = right = null;
    }
}

package Pertemuan14;

public class BinaryTreeMain23 {
    public static void main(String[] args) {
        BinaryTree23 bst = new BinaryTree23();

        bst.add(new Mahasiswa23("22001", "Andi", "TI-1A", 3.72));
        bst.add(new Mahasiswa23("22002", "Budi", "TI-1A", 3.40));
        bst.add(new Mahasiswa23("22003", "Citra", "TI-1B", 3.90));
        bst.add(new Mahasiswa23("22004", "Dinda", "TI-1B", 3.25));
        bst.add(new Mahasiswa23("22005", "Eka", "TI-1C", 3.55));
        bst.add(new Mahasiswa23("22006", "Fajar", "TI-1C", 3.82));

        System.out.println("=== Traversal InOrder (setelah add iteratif) ===");
        bst.traverseInOrder(bst.root);

        System.out.println("Find IPK 3.90 : " + bst.find(3.90));
        System.out.println("Find IPK 3.10 : " + bst.find(3.10));

        System.out.println("\n=== Traversal PreOrder ===");
        bst.traversePreOrder(bst.root);

        System.out.println("\n=== Traversal PostOrder ===");
        bst.traversePostOrder(bst.root);

        System.out.println("\n=== Delete IPK 3.40 ===");
        bst.delete(3.40);
        bst.traverseInOrder(bst.root);

        System.out.println("\n=== Add Rekursif ===");
        bst.addRekursif(new Mahasiswa23("22007", "Gina", "TI-1D", 3.65));
        bst.traverseInOrder(bst.root);

        System.out.println();
        bst.cariMinIPK();
        System.out.println();
        bst.cariMaxIPK();
        System.out.println();
        bst.tampilMahasiswaIPKdiAtas(3.50);
    }
}

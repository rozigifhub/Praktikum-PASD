package Belajar.Tree;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(new Mahasiswa("22001", "Andi", 3.72));
        tree.add(new Mahasiswa("22002", "Budi", 3.40));
        tree.add(new Mahasiswa("22003", "Citra", 3.90));
        tree.add(new Mahasiswa("22004", "Dinda", 3.25));
        tree.add(new Mahasiswa("22005", "Eka", 3.55));

        System.out.println("=== InOrder ===");
        tree.inOrder(tree.root);

        System.out.println("\n=== PreOrder ===");
        tree.preOrder(tree.root);

        System.out.println("\n=== PostOrder ===");
        tree.postOrder(tree.root);

        System.out.println("\nFind 3.90: " + tree.find(3.90));
        System.out.println("Find 3.10: " + tree.find(3.10));

        System.out.print("\nIPK minimum: ");
        tree.cariMin();

        System.out.print("IPK maksimum: ");
        tree.cariMax();

        tree.addRekursif(new Mahasiswa("22006", "Fajar", 3.82));
        System.out.println("\n=== Setelah addRekursif ===");
        tree.inOrder(tree.root);

        System.out.println("\n=== Setelah delete 3.40 ===");
        tree.delete(3.40);
        tree.inOrder(tree.root);

        BinaryTreeArray treeArray = new BinaryTreeArray(10);
        treeArray.add(new Mahasiswa("22001", "Andi", 3.72));
        treeArray.add(new Mahasiswa("22002", "Budi", 3.40));
        treeArray.add(new Mahasiswa("22003", "Citra", 3.90));
        treeArray.add(new Mahasiswa("22004", "Dinda", 3.25));
        treeArray.add(new Mahasiswa("22005", "Eka", 3.55));

        System.out.println("\n=== BinaryTreeArray InOrder ===");
        treeArray.traverseInOrder(0);

        System.out.println("\n=== BinaryTreeArray PreOrder ===");
        treeArray.traversePreOrder(0);
    }
}

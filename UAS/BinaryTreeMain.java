package UAS;
import java.util.Scanner;


public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        // // tree.add(new Mahasiswa("22001", "Andi", 3.72));
        // // tree.add(new Mahasiswa("22002", "Budi", 3.40));
        // // tree.add(new Mahasiswa("22003", "Citra", 3.90));
        // // tree.add(new Mahasiswa("22004", "Dinda", 3.25));
        // // tree.add(new Mahasiswa("22005", "Eka", 3.55));

        // System.out.println("=== InOrder ===");
        // tree.inOrder(tree.root);

        // System.out.println("\n=== PreOrder ===");
        // tree.preOrder(tree.root);

        // System.out.println("\n=== PostOrder ===");
        // tree.postOrder(tree.root);

        // System.out.println("\nFind 3.90: " + tree.find(3.90));
        // System.out.println("Find 3.10: " + tree.find(3.10));

        // System.out.print("\nIPK minimum: ");
        // tree.cariMin();

        // System.out.print("IPK maksimum: ");
        // tree.cariMax();

        // // tree.addRekursif(new Mahasiswa("22006", "Fajar", 3.82));
        // System.out.println("\n=== Setelah addRekursif ===");
        // tree.inOrder(tree.root);

        // System.out.println("\n=== Setelah delete 3.40 ===");
        // tree.delete(3.40);
        // tree.inOrder(tree.root);

        //Test case UAS
        tree.add(new Mahasiswa("220101001", "Andi", "TI-1A", 3.95));
        tree.add(new Mahasiswa("220101002", "Budi", "TI-1A", 3.20));
        tree.add(new Mahasiswa("220101003", "Sinta", "TI-1B", 3.82));
        tree.add(new Mahasiswa("220101004", "Rina", "TI-1B", 3.45));
        tree.add(new Mahasiswa("220101005", "Dimas", "TI-1C", 2.75));
        tree.add(new Mahasiswa("220101006", "Fajar", "TI-1C", 3.10));
        tree.add(new Mahasiswa("220101007", "Nabila", "TI-1D", 3.76));
        tree.add(new Mahasiswa("220101008", "Rizky", "TI-1D", 3.50));
        tree.add(new Mahasiswa("220101009", "Aulia", "TI-1E", 3.88));
        tree.add(new Mahasiswa("220101010", "Kevin", "TI-1E", 3.00));

        System.out.print("Cari mahasiswa by nama: ");
        String nama = sc.nextLine();
        tree.cariNama(nama);

        System.out.print("Cari 3 ipk tertinggi ");
        tree.ipkTertinggi();

        System.out.println("Cari kelas: ");
        String kelas = sc.nextLine();
        tree.cariKelas(kelas);
        sc.close();
    }
}

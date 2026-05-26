package Pertemuan14;

public class BinaryTreeArrayMain23 {
    public static void main(String[] args) {
        BinaryTreeArray23 bta = new BinaryTreeArray23();

        Mahasiswa23[] dataMahasiswa = {
                new Mahasiswa23("22001", "Andi", "TI-1A", 3.72),
                new Mahasiswa23("22002", "Budi", "TI-1A", 3.40),
                new Mahasiswa23("22003", "Citra", "TI-1B", 3.90),
                new Mahasiswa23("22004", "Dinda", "TI-1B", 3.25),
                new Mahasiswa23("22005", "Eka", "TI-1C", 3.55),
                new Mahasiswa23("22006", "Fajar", "TI-1C", 3.82),
                new Mahasiswa23("22007", "Gina", "TI-1D", 3.65)
        };

        bta.populateData(dataMahasiswa, 6);
        System.out.println("=== Traverse InOrder (Array Tree) ===");
        bta.traverseInOrder(0);

        System.out.println("=== Traverse PreOrder (Array Tree) ===");
        bta.traversePreOrder(0);

        System.out.println("=== Add data baru ke array tree ===");
        bta.add(new Mahasiswa23("22008", "Hana", "TI-1D", 3.77));
        bta.traversePreOrder(0);
    }
}

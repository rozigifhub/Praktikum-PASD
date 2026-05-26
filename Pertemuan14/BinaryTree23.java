package Pertemuan14;

public class BinaryTree23 {
    Node23 root;

    public BinaryTree23() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void add(Mahasiswa23 mahasiswa) {
        Node23 newNode = new Node23(null, mahasiswa, null);
        if (isEmpty()) {
            root = newNode;
            return;
        }

        Node23 current = root;
        Node23 parent = null;
        while (true) {
            parent = current;
            if (mahasiswa.ipk < current.mahasiswa.ipk) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else if (mahasiswa.ipk > current.mahasiswa.ipk) {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            } else {
                System.out.println("IPK " + mahasiswa.ipk + " sudah ada, data tidak ditambahkan.");
                return;
            }
        }
    }

    boolean find(double ipk) {
        Node23 current = root;
        while (current != null) {
            if (ipk < current.mahasiswa.ipk) {
                current = current.left;
            } else if (ipk > current.mahasiswa.ipk) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    void traversePreOrder(Node23 node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            System.out.println();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traverseInOrder(Node23 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            System.out.println();
            traverseInOrder(node.right);
        }
    }

    void traversePostOrder(Node23 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
            System.out.println();
        }
    }

    Node23 getSuccessor(Node23 del) {
        Node23 successorParent = del;
        Node23 successor = del;
        Node23 current = del.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(double ipk) {
        if (isEmpty()) {
            System.out.println("Tree kosong.");
            return;
        }

        Node23 parent = root;
        Node23 current = root;
        boolean isLeftChild = false;

        while (current != null && current.mahasiswa.ipk != ipk) {
            parent = current;
            if (ipk < current.mahasiswa.ipk) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
        }

        if (current == null) {
            System.out.println("Data dengan IPK " + ipk + " tidak ditemukan.");
            return;
        }

        // Case 1: node leaf
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // Case 2: hanya punya left child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }
        // Case 3: hanya punya right child
        else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        // Case 4: punya dua child
        else {
            Node23 successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }

        System.out.println("Data dengan IPK " + ipk + " berhasil dihapus.");
    }

    void addRekursif(Mahasiswa23 mahasiswa) {
        root = addRekursif(root, mahasiswa);
    }

    private Node23 addRekursif(Node23 current, Mahasiswa23 mahasiswa) {
        if (current == null) {
            return new Node23(null, mahasiswa, null);
        }

        if (mahasiswa.ipk < current.mahasiswa.ipk) {
            current.left = addRekursif(current.left, mahasiswa);
        } else if (mahasiswa.ipk > current.mahasiswa.ipk) {
            current.right = addRekursif(current.right, mahasiswa);
        } else {
            System.out.println("IPK " + mahasiswa.ipk + " sudah ada, data tidak ditambahkan.");
        }
        return current;
    }

    void cariMinIPK() {
        if (isEmpty()) {
            System.out.println("Tree kosong.");
            return;
        }

        Node23 current = root;
        while (current.left != null) {
            current = current.left;
        }

        System.out.println("Mahasiswa dengan IPK minimum:");
        current.mahasiswa.tampilInformasi();
    }

    void cariMaxIPK() {
        if (isEmpty()) {
            System.out.println("Tree kosong.");
            return;
        }

        Node23 current = root;
        while (current.right != null) {
            current = current.right;
        }

        System.out.println("Mahasiswa dengan IPK maksimum:");
        current.mahasiswa.tampilInformasi();
    }

    void tampilMahasiswaIPKdiAtas(double ipkBatas) {
        if (isEmpty()) {
            System.out.println("Tree kosong.");
            return;
        }

        System.out.println("Mahasiswa dengan IPK di atas " + ipkBatas + ":");
        tampilMahasiswaIPKdiAtas(root, ipkBatas);
    }

    private void tampilMahasiswaIPKdiAtas(Node23 node, double ipkBatas) {
        if (node == null) {
            return;
        }

        tampilMahasiswaIPKdiAtas(node.left, ipkBatas);
        if (node.mahasiswa.ipk > ipkBatas) {
            node.mahasiswa.tampilInformasi();
            System.out.println();
        }
        tampilMahasiswaIPKdiAtas(node.right, ipkBatas);
    }
}

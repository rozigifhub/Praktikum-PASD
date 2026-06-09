package UAS;

public class BinaryTree {
    Node root;

    boolean isEmpty() {
        return root == null;
    }

    void add(Mahasiswa data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (true) {
            parent = current;

            if (data.ipk < current.data.ipk) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else if (data.ipk > current.data.ipk) {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            } else {
                return;
            }
        }
    }

    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data.nama + " " + node.data.ipk);
            inOrder(node.right);
        }
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data.nama + " " + node.data.ipk);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data.nama + " " + node.data.ipk);
        }
    }

    boolean find(double ipk) {
        Node current = root;

        while (current != null) {
            if (ipk < current.data.ipk) {
                current = current.left;
            } else if (ipk > current.data.ipk) {
                current = current.right;
            } else {
                return true;
            }
        }

        return false;
    }

    void cariMin() {
        if (root == null) {
            return;
        }

        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        System.out.println(current.data.nama);
    }

    void cariMax() {
        if (root == null) {
            return;
        }

        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        System.out.println(current.data.nama);
    }

    void addRekursif(Mahasiswa data) {
        root = addRekursif(root, data);
    }

    Node addRekursif(Node current, Mahasiswa data) {
        if (current == null) {
            return new Node(data);
        }

        if (data.ipk < current.data.ipk) {
            current.left = addRekursif(current.left, data);
        } else if (data.ipk > current.data.ipk) {
            current.right = addRekursif(current.right, data);
        }
        return current;
    }

    Node getSuccessor(Node del) {
        Node successorParent = del;
        Node successor = del;
        Node current = del.right;

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
            System.out.println("Tree kosong");
            return;
        }

        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        while (current != null && current.data.ipk != ipk) {
            parent = current;
            if (ipk < current.data.ipk) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
        }

        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return;
        }

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
    }

    //UAS
    void cariNama(String nama) {
        Node hasil = cariNama(root, nama);

        if (hasil != null) {
            System.out.println("Data ditemukan:");
            System.out.println(hasil.data.nim + " " + hasil.data.nama + " " + hasil.data.kelas + " " + hasil.data.ipk);
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    Node cariNama(Node node, String nama) {
        if (node == null) {
            return null;
        }

        if (node.data.nama.equalsIgnoreCase(nama)) {
            return node;
        }

        Node foundLeft = cariNama(node.left, nama);
        if (foundLeft != null) {
            return foundLeft;
        }

        return cariNama(node.right, nama);
    }

    void ipkTertinggi() {
        if (root == null) {
            return;
        }

        Node current = root;
        Node current1 = current.right;
        while (current.right != null) {
            current = current.right;
            if (current.right != null){
                current1 = current.right;
            }
        }
        System.out.println(current.data.nama);
        System.out.println(current1.data.nama);
    }

    void cariKelas(String kelas) {
        Node hasil = cariKelas(root, kelas);

        if (hasil != null) {
            System.out.println("Data ditemukan:");
            System.out.println(hasil.data.nim + " " + hasil.data.nama + " " + hasil.data.kelas + " " + hasil.data.ipk);
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    Node cariKelas(Node node, String kelas) {
        if (node == null) {
            return null;
        }

        if (node.data.kelas.equalsIgnoreCase(kelas)) {
            return node;
        }

        Node foundLeft = cariKelas(node.left, kelas);
        if (foundLeft != null) {
            return foundLeft;
        }

        return cariKelas(node.right, kelas);
    }    

}

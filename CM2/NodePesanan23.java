package CM2;

public class NodePesanan23 {
    Pesanan23 data;
    NodePesanan23 prev;
    NodePesanan23 next;

    public NodePesanan23(NodePesanan23 prev, Pesanan23 data, NodePesanan23 next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}

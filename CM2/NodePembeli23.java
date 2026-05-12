package CM2;

public class NodePembeli23 {
    Pembeli23 data;
    NodePembeli23 prev;
    NodePembeli23 next;

    public NodePembeli23(NodePembeli23 prev, Pembeli23 data, NodePembeli23 next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}

package Belajar.Graph;

public class GraphMain {
    public static void main(String[] args) {
        Graph g = new Graph(6);

        // 0 = Rumah
        // 1 = Indomaret
        // 2 = Sekolah
        // 3 = Masjid
        // 4 = Kampus
        // 5 = Rumah Sakit

        // no wieght
        // g.addEdge(0, 1);
        // g.addEdge(0, 2);
        // g.addEdge(1, 3);
        // g.addEdge(2, 4);

        g.addEdge(0, 1, 2); // Rumah - Indomaret = 2 km
        g.addEdge(0, 2, 5); // Rumah - Sekolah = 5 km
        g.addEdge(1, 3, 3); // Indomaret - Masjid = 3 km
        g.addEdge(2, 4, 4); // Sekolah - Kampus = 4 km
        g.addEdge(4, 5, 6); // Kampus - Rumah Sakit = 6 km
        g.addEdge(1, 4, 7); // Indomaret - Kampus = 7 km


        System.out.println("Adjacency Matrix:");
        g.printGraph();

        boolean[] visited = new boolean[6];
        System.out.print("DFS: ");
        g.dfs(0, visited);

        System.out.println();
        System.out.print("BFS: ");
        g.bfs(0);

        System.out.println();
        System.out.print("Dijkstra: ");
        g.dijkstra(5);

        System.out.println("Degree 0 = " + g.degree(0));
        System.out.println("Degree 1 = " + g.degree(1));
        System.out.println("Degree 4 = " + g.degree(4));
    }
}

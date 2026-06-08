package Belajar.Graph;

import java.util.Arrays;

public class Graph {
    int vertex;
    int[][] adjMatrix;

    Graph(int v) {
        vertex = v;
        adjMatrix = new int[v][v];
    }

    // no weight
    // void addEdge(int from, int to) {
    //     adjMatrix[from][to] = 1;
    //     adjMatrix[to][from] = 1;
    // }

    // directed graph
    // void addEdge(int from, int to, int weight) {
    //     adjMatrix[from][to] = weight;
    // }

    // Undirected graph
    void addEdge(int from, int to, int weight) {
        adjMatrix[from][to] = weight;
        adjMatrix[to][from] = weight;
    }

    void printGraph() {
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    // no weight = adjMatrix[start][i] == 1 && !visited[i]
    void dfs(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < vertex; i++) {
            if (adjMatrix[start][i] != 0 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    void bfs(int start) {
        boolean[] visited = new boolean[vertex];
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            //adjMatrix[current][i] == 1 && !visited[i] for no weight
            for (int i = 0; i < vertex; i++) {
                if (adjMatrix[current][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    int minDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < vertex; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    void dijkstra(int start) {
        int[] distance = new int[vertex];
        boolean[] visited = new boolean[vertex];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for (int count = 0; count < vertex - 1; count++) {
            int u = minDistance(distance, visited);

            if (u == -1) {
                break;
            }

            visited[u] = true;

            for (int v = 0; v < vertex; v++) {
                if (!visited[v]
                        && adjMatrix[u][v] != 0
                        && distance[u] != Integer.MAX_VALUE
                        && distance[u] + adjMatrix[u][v] < distance[v]) {
                    distance[v] = distance[u] + adjMatrix[u][v];
                }
            }
        }

        System.out.println("Jarak terpendek dari vertex " + start + ":");
        for (int i = 0; i < vertex; i++) {
            System.out.println(start + " -> " + i + " = " + distance[i]);
        }
    }

    int degree(int v) {
        int degree = 0;
        for (int i = 0; i < vertex; i++) {
            if (adjMatrix[v][i] != 0) {
                degree++;
            }
        }
        return degree;
    }

    int inDegree(int v) {
        int in = 0;
        for (int i = 0; i < vertex; i++) {
            if (adjMatrix[i][v] != 0) {
                in++;
            }
        }
        return in;
    }

    int outDegree(int v) {
        int out = 0;
        for (int i = 0; i < vertex; i++) {
            if (adjMatrix[v][i] != 0) {
                out++;
            }
        }
        return out;
    }
}
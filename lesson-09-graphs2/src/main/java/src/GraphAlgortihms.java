package src;

import java.util.*;

public class GraphAlgortihms {

    /**
     * Returnerer en liste af grafens knuder fundet ved et dybdeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> dfs(Graph<V> graph, V v) {
        // TODO Opgave 2 --> ...

        List<V> visited = new ArrayList<>();
        dfsRekursion(graph, v, visited);

        return visited;
    }

    private static <V> void dfsRekursion(Graph<V> graph, V v, List<V> visited) {

        visited.add(v);

        for (V neighbor : graph.neighbors(v)) {
            if (!visited.contains(neighbor)) {
                dfsRekursion(graph, neighbor, visited);
            }
        }

    }

    public static void main(String[] args) {
        Graph<Integer> graph = new EdgeListGraph<>();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(8);
        graph.addVertex(9);
        graph.addVertex(7);
        graph.addVertex(10);
        graph.addVertex(11);
        graph.addVertex(6);
        graph.addVertex(5);
        graph.addVertex(3);
        graph.addVertex(2);
        graph.addVertex(4);

        graph.addVertex(12);




        graph.addEdge(0,1);
        graph.addEdge(0,9);

        graph.addEdge(9,8);
        graph.addEdge(1,8);

        graph.addEdge(8,7);
        graph.addEdge(7,10);
        graph.addEdge(7,11);
        graph.addEdge(7,6);
        graph.addEdge(7,3);

        graph.addEdge(10,11);
        graph.addEdge(6,5);

        graph.addEdge(5,3);
        graph.addEdge(3,4);
        graph.addEdge(3,2);


        System.out.println(dfs(graph, 0));
    }




    /**
     * Returnerer en liste af grafens knuder fundet ved et breddeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> bfs(Graph<V> graph, V v) {
        // TODO Opgave 3 --> ...

        List<V> visited = new ArrayList<>();
        Queue<V> queue = new LinkedList<>();

        visited.add(v);
        queue.add(v);

        while (!queue.isEmpty()) {
            V current = queue.remove();

            for (V neighbor : graph.neighbors(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }

    /**
     * Returnerer om grafen er sammenhængende
     * Pre: Grafen er ikke tom
     */
    public static <V> boolean connected(Graph<V> graph) {
        // TODO Opgave 4

        // Ingen knuder = sammenhængende XD
        if (graph.numVertices() == 0) {
            return true;
        }

        V v = graph.vertices().getFirst();

        List<V> list = dfs(graph, v);


        return graph.numVertices() == list.size();
    }

    /**
     * Returnerer om der er en vej fra v1 til v2 i graph
     */
    public static <V> boolean isPath(Graph<V> graph, V v1, V v2) {
        // TODO Opgave 5

        return dfs(graph, v1).contains(v2);
    }
}
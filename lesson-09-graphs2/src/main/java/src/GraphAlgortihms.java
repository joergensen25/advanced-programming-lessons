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
        return false;
    }

    /**
     * Returnerer om der er en vej fra v1 til v2 i graph
     */
    public static <V> boolean isPath(Graph<V> graph, V v1, V v2) {
        // TODO Opgave 5
        return false;
    }
}
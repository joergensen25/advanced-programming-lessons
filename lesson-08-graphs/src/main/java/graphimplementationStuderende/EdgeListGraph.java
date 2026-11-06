package graphimplementationStuderende;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EdgeListGraph<V> implements Graph<V> {

    public static void main(String[] args) {
        Graph<Integer> graph = new EdgeListGraph<>();

        // Knuder/Vertices
        graph.addVertex(15);
        graph.addVertex(38);
        graph.addVertex(6);
        graph.addVertex(123);
        graph.addVertex(66);

        // Kanter/Edges med vægte
        // Vi arbejder kun med ikke-orienterede grafer ({15, 38} er det samme som {38, 15})
        graph.addEdge(15, 38, 10);
        graph.addEdge(15, 6, 23);
        graph.addEdge(15, 66, 90);

        graph.addEdge(38, 123, 55);
        graph.addEdge(38, 66, 2);

        graph.addEdge(123, 6, 7);
        graph.addEdge(123, 66, 76);

        graph.addEdge(66, 6, 8);

        graph.printGraph();

        System.out.println(largestVertex(graph));
    }

    // List with all the vertices in the graph.
    private List<V> vertices = new ArrayList<>();
    // List with all the edges in the graph.
    private List<Edge<V>> edges = new ArrayList<>();

    /**
     * Construct an empty graph
     */
    public EdgeListGraph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    /** Return the number of vertices in the graph */
    public int numVertices() {
        return vertices.size();
    }

    @Override
    /** Return the number of edges in the graph */
    public int numEdges() {
        return edges.size();
    }

    @Override
    /** Return a list with the vertices in the graph. */
    public List<V> vertices() {
        return new ArrayList<>(vertices);
    }

    @Override
    /** Return a list with the edges in the graph. */
    public List<Edge<V>> edges() {
        return new ArrayList<Edge<V>>(edges);
    }


    @Override
    /**
     * Return a list with the neighbors of the specified vertex.
     * Pre: The vertex is in the graph.
     */
    public List<V> neighbors(V v) {
        List<V> result = new ArrayList<>();
        for (Edge<V> e : edges) {
            if (e.getV().equals(v)) {
                result.add(e.getU());
            } else if (e.getU().equals(v)) {
                result.add(e.getV());
            }
        }
        return result;
    }


    @Override
    /**
     * Return the incident edges to the specified vertex.
     * Pre: The vertex is in the graph.
     */
    public List<Edge<V>> incidentEdges(V v) {
        List<Edge<V>> result = new ArrayList<>();
        for (Edge<V> e : edges) {
            if (e.getV().equals(v)) {
                result.add(e);
            } else if (e.getU().equals(v)) {
                result.add(e);
            }
        }
        return result;
    }

    @Override
    /**
     * Return the degree for the specified vertex.
     * Pre: The vertex is in the graph.
     */
    public int degree(V v) {
        return neighbors(v).size();
    }

    @Override
    /**
     * Return true, if the specified vertices are neighbors.
     * Pre: The vertices are vertices in the graph.
     */
    public boolean areAdjacent(V v, V u) {
        // TODO

        for (Edge<V> edge : edges) {

            if (edge.getV().equals(v) && edge.getU().equals(u)
                    || edge.getV().equals(u) && edge.getU().equals(v)) {
                return true;
            }

        }
        return false;
    }

    @Override
    /** Print the vertices and the edges. */
    public void printGraph() {
        System.out.println("Vertices: " + vertices);
        System.out.println("Edges: " + edges);
    }


    @Override
    /**
     * Add a vertex to the graph.
     * Pre: The vertex is not in the graph before this addition.     */
    public void addVertex(V v) {
        if (!vertices.contains(v)) {
            vertices.add(v);
        }
    }


    @Override
    /**
     * Add an edge with weight 0 between the specified vertices to the graph.
     * Pre: Before addition, the vertices are in the graph, and the edge is not in the graph.
     */
    public void addEdge(V v, V u) {
        addEdge(v, u, 0);
    }

    @Override
    /**
     * Add an edge with the specified weight between the specified vertices to the graph.
     * Pre: Before addition, the vertices are in the graph, and the edge is not in the graph.
     * Pre: The weight is not negative.
     */
    public void addEdge(V v, V u, int e) {
        edges.add(new Edge<V>(v, u, e));
    }

    @Override
    /**
     * Remove the specified vertex from the graph.
     * Pre: The vertex is in the graph
     */
    public void removeVertex(V v) {

        // TODO

        vertices.remove(v);

        edges.removeIf(edge -> edge.getV().equals(v) || edge.getU().equals(v));


    }

    @Override
    /**
     * Remove the edge between the specified vertices from the graph.
     * Pre: The vertices are vertices in the graph,
     *   and The graph has an edge between the vertices.
     */
    public void removeEdge(V v, V u) {
        // TODO

        Iterator<Edge<V>> iterator = edges.iterator();

        while (iterator.hasNext()) {

            Edge<V> edge = iterator.next();

            if (edge.getV().equals(v) && edge.getU().equals(u) ||
                    edge.getV().equals(u) && edge.getU().equals(v)) {

                iterator.remove();
                return;
            }
        }


    }


    public static int largestVertex(Graph<Integer> graph) {
        int stoerste = Integer.MIN_VALUE;

        if (graph.vertices().isEmpty()) {
            return 0;
        }

        for (Integer vertex : graph.vertices()) {
            if (vertex > stoerste) {
                stoerste = vertex;
            }
        }
        return stoerste;
    }

}


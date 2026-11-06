import graphimplementationStuderende.EdgeListGraph;
import graphimplementationStuderende.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static graphimplementationStuderende.EdgeListGraph.largestVertex;
import static org.junit.jupiter.api.Assertions.*;

public class EdgeListGraphTest {

private Graph<Integer> graph;

    @BeforeEach
    void setUp() {
        graph = new EdgeListGraph<>();

        graph.addVertex(10);
        graph.addVertex(20);
        graph.addVertex(30);

        graph.addEdge(10, 20, 5);
        graph.addEdge(10, 30, 10);
        graph.addEdge(20, 30, 3);
    }


    @Test
    void testLargestVertexWhenGraphEmpty() {
        graph.removeVertex(10);
        graph.removeVertex(20);
        graph.removeVertex(30);
        assertEquals(0, largestVertex(graph));
    }

    @Test
    void testLargestVertexWhenGraphNotEmpty() {

        assertEquals(30, largestVertex(graph));
    }

    @Test
    void testAreAdjacentTrue() {
        assertTrue(graph.areAdjacent(10, 20));
    }


    @Test
    void testAreAdjacentFalse() {

    }


    @Test
    void testRemoveVertex() {

        graph.removeVertex(10);

        assertFalse(graph.vertices().contains(10));
        assertEquals(2, graph.numVertices());

    }

    @Test
    void testRemoveEdge() {

        graph.removeEdge(10, 20);

        assertFalse(graph.areAdjacent(10, 20));

        assertEquals(2, graph.numEdges());
        assertEquals(3, graph.numVertices());

    }

}

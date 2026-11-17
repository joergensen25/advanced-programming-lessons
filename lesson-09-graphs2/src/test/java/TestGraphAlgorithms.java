import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.EdgeListGraph;
import src.Graph;
import src.GraphAlgortihms;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestGraphAlgorithms {

    private Graph<Integer> graph;

    @BeforeEach
    void setUp() {
        graph = new EdgeListGraph<>();

        graph.addVertex(6);
        graph.addVertex(5);
        graph.addVertex(3);
        graph.addVertex(2);
        graph.addVertex(4);
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(8);
        graph.addVertex(9);
        graph.addVertex(7);
        graph.addVertex(10);
        graph.addVertex(11);

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
    }


    @Test
    void testIfDepthFirst() {


        //Act
        List<Integer> expected = List.of(0, 1, 8, 9, 7, 10, 11, 6, 5, 3, 4, 2);

        List<Integer> actual = GraphAlgortihms.dfs(graph, 0);

        //Assert

        assertEquals(expected, actual);

    }




    @Test
    void testIfBreadthFirst() {

        //Act
        List<Integer> expected = List.of(0, 1, 9, 8, 7, 10, 11, 6, 3, 5, 4, 2);

        List<Integer> actual = GraphAlgortihms.bfs(graph, 0);

        // Assert
        assertEquals(expected, actual);

    }

    @Test
    void testIfDisconnected() {

        assertFalse(GraphAlgortihms.connected(graph));
    }

    @Test
    void testIfConnected() {
        graph.addEdge(12, 11);

        assertTrue(GraphAlgortihms.connected(graph));
    }


    @Test
    void testIfPathBetween() {

        assertTrue(GraphAlgortihms.isPath(graph, 0, 11));
    }

    @Test
    void testIfNoPathBetween() {
        assertFalse(GraphAlgortihms.isPath(graph, 10, 12));
    }
 }

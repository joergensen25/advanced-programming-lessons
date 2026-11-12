import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.EdgeListGraph;
import src.Graph;
import src.GraphAlgortihms;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGraphAlgorithms {

    private Graph<Integer> graph;
    @BeforeEach
    void setUp() {
        graph = new EdgeListGraph<>();

        graph.addVertex(123);
        graph.addVertex(66);
        graph.addVertex(38);
        graph.addVertex(6);
        graph.addVertex(15);


        graph.addEdge(123, 38);
        graph.addEdge(123, 6);
        graph.addEdge(123, 66);

        graph.addEdge(38, 15);
        graph.addEdge(38, 66);

        graph.addEdge(66, 6);
        graph.addEdge(66, 15);

        graph.addEdge(6, 15);
    }


    @Test
    void testIfDepthFirst() {


        //Act
        List<Integer> expected = List.of(123, 38, 15, 66, 6);

        List<Integer> actual = GraphAlgortihms.dfs(graph, 123);

        //Assert

        assertEquals(expected, actual);


    }




    @Test
    void testIfBreadthFirst() {

        //Act
        List<Integer> actual = GraphAlgortihms.bfs(graph, 123);


    }
 }

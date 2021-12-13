package Graph_code;
import api.DirectedWeightedGraph;
import api.NodeData;
;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DirectedWeightedGraphAlgorithmsImplTest {
    DirectedWeightedGraphAlgorithmsImpl algoGraph;

    {
        algoGraph = new DirectedWeightedGraphAlgorithmsImpl();
    }

    public DirectedWeightedGraph resetGraph(){
        DirectedWeightedGraph graph = Ex2.take_new_graph("G1.json");
        this.algoGraph.init(graph);
        return graph;
    }
    public DirectedWeightedGraph resetGraph(String path){
        DirectedWeightedGraph graph = Ex2.take_new_graph(path);
        this.algoGraph.init(graph);
        return  graph;
    }

    @Test
    void initAndGetGraph() {
        assertNull(this.algoGraph.getGraph());
        DirectedWeightedGraph graph = resetGraph();
        assertNotNull(this.algoGraph.getGraph());
        assertEquals(graph,this.algoGraph.getGraph());
    }

    @Test
    void copy() {
        DirectedWeightedGraph original = resetGraph();
        DirectedWeightedGraph graphCopy = this.algoGraph.copy();
        assertEquals(original.getEdge(2,6).getWeight(), graphCopy.getEdge(2,6).getWeight());
        assertNotEquals(original, graphCopy);
        assertNotEquals(original.getNode(0), graphCopy.getNode(0));
        assertNotEquals(original.getEdge(1,2), graphCopy.getEdge(1,2));
    }

    @Test
    void isConnected() {
        DirectedWeightedGraph graph = resetGraph();
        assertTrue(this.algoGraph.isConnected());
        graph.removeEdge(4,5);
        graph.removeEdge(5,4);
        graph.removeEdge(6,5);
        graph.removeEdge(5,6);
        assertFalse(this.algoGraph.isConnected());
    }

    @Test
    void shortestPathDist() {
        DirectedWeightedGraph graph = resetGraph();
        double dist = this.algoGraph.shortestPathDist(1,7);
        double expected = graph.getEdge(1,2).getWeight();
        expected += graph.getEdge(2,6).getWeight();
        expected += graph.getEdge(6,7).getWeight();
        assertEquals(expected, dist);
        graph.removeEdge(1,2);
        graph.removeNode(6);
        dist = this.algoGraph.shortestPathDist(1,5);
        assertEquals(-1, dist);
    }

    @Test
    void shortestPath() {
        DirectedWeightedGraph graph = resetGraph();
        List<NodeData> path = this.algoGraph.shortestPath(1,7);
        List<NodeData> expectedPath = new LinkedList<>();
        expectedPath.add(graph.getNode(1));
        expectedPath.add(graph.getNode(2));
        expectedPath.add(graph.getNode(6));
        expectedPath.add(graph.getNode(7));
        assertEquals(expectedPath, path);
        graph.removeEdge(1,2);
        graph.removeNode(6);
        assertNull(this.algoGraph.shortestPath(1,5));
    }

    @Test
    void center() {
        resetGraph();
        assertEquals(8,this.algoGraph.center().getKey());
        this.isConnected();
        assertNull(this.algoGraph.center());
    }

    @Test
    void tsp() {
        DirectedWeightedGraph graph = resetGraph();
        LinkedList<NodeData> cities = new LinkedList<>();
        cities.add(graph.getNode(2));
        cities.add(graph.getNode(6));
        cities.add(graph.getNode(3));
        cities.add(graph.getNode(4));
        cities.add(graph.getNode(5));
        List<NodeData> path = this.algoGraph.tsp(cities);
        List<NodeData> expectedPath = new LinkedList<>();
        expectedPath.add(graph.getNode(2));
        expectedPath.add(graph.getNode(6));
        expectedPath.add(graph.getNode(5));
        expectedPath.add(graph.getNode(4));
        expectedPath.add(graph.getNode(3));
        expectedPath.add(graph.getNode(2));
        assertEquals(expectedPath, path);
        graph.removeEdge(2,3);
        graph.removeEdge(3,2);
        graph.removeEdge(3,4);
        graph.removeEdge(4,3);
        assertNull(this.algoGraph.tsp(cities));
    }

    @Test
    void save() {
        DirectedWeightedGraph graph = resetGraph();
        assertNull(graph.getNode(17));
        graph.addNode(new NodeDataImpl(new GeoLocationImpl(1,2,3), 17));
        assertTrue(this.algoGraph.save("G1.json"));
        graph = resetGraph();
        assertNotNull(graph.getNode(17));
        graph.removeNode(17);
        assertTrue(this.algoGraph.save("G1.json"));
    }

    @Test
    void load() {
        this.algoGraph.load("G1.json");
        assertNotNull(this.algoGraph.getGraph().getNode(16));
        this.algoGraph.load("G2.json");
        assertNotNull(this.algoGraph.getGraph().getNode(30));
        this.algoGraph.load("G3.json");
        assertNotNull(this.algoGraph.getGraph().getNode(47));
    }
}
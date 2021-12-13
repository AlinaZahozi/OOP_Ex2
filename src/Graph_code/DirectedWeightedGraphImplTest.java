package Graph_code;

import api.EdgeData;
import api.NodeData;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class DirectedWeightedGraphImplTest {

    DirectedWeightedGraphImpl graph;

    {
        graph = null;
    }

    public void resetGraph(){
        this.graph = (DirectedWeightedGraphImpl) Ex2.take_new_graph("G1.json");
    }
    public void resetGraph(String path){
        this.graph = (DirectedWeightedGraphImpl) Ex2.take_new_graph(path);
    }

    @Test
    void getNode() {
        resetGraph();
        assertEquals(5, this.graph.getNode(5).getKey());
        assertNull(this.graph.getNode(17));
    }

    @Test
    void getEdge() {
        resetGraph();
        assertEquals(1.734311926030133, this.graph.getEdge(5, 6).getWeight());
        assertNull(this.graph.getEdge(1,10));
    }

    @Test
    void addNode() {
        resetGraph();
        assertNull(this.graph.getNode(17));
        this.graph.addNode(new NodeDataImpl(new GeoLocationImpl(1,2,3), 17));
        assertNotNull(this.graph.getNode(17));
    }

    @Test
    void connect() {
        resetGraph();
        assertNull(this.graph.getEdge(3, 6));
        this.graph.connect(3,6, 1.5);
        assertNotNull(this.graph.getEdge(3,6));
    }

    @Test
    void nodeIter() {
        resetGraph();
        Iterator<NodeData> iter = this.graph.nodeIter();
        int key = iter.next().getKey();
        iter.remove();
        assertNull(this.graph.getNode(key));
    }

    @Test
    void edgeIter() {
        resetGraph();
        Iterator<EdgeData> iter = this.graph.edgeIter();
        EdgeData edge = iter.next();
        int src = edge.getSrc();
        int dest = edge.getDest();
        iter.remove();
        assertNull( this.graph.getEdge(src,dest));
    }

    @Test
    void testEdgeIter() {

    }

    @Test
    void edgeSize() {
        this.connect();
        assertEquals(37,this.graph.edgeSize()); // 17 +17 + 2 + 1
    }

    @Test
    void getMC() {
        resetGraph();
        assertEquals(53, this.graph.getMC()); // 17(nodes) + 36(connections)
        this.graph.connect(1,4, 5);
        assertEquals(54, this.graph.getMC());
        this.graph.addNode(new NodeDataImpl(new GeoLocationImpl(1,2,3), 2));
        assertEquals(54, this.graph.getMC());
        this.graph.removeEdge(5,6);
        assertEquals(55, this.graph.getMC());
        this.graph.removeNode(2);
        assertEquals(62, this.graph.getMC()); // + 1(remove node) + 6(remove connected nodes)
    }

    @Test
    void nodeSize() {
        resetGraph();
        assertEquals(17, this.graph.nodeSize());
        resetGraph("G2.json");
        assertEquals(31, this.graph.nodeSize());
        resetGraph("G3.json");
        assertEquals(48, this.graph.nodeSize());
        this.graph.addNode(new NodeDataImpl(new GeoLocationImpl(1,2,3), 48));
        assertEquals(49, this.graph.nodeSize());
        this.graph.removeNode(0);
        assertEquals(48, this.graph.nodeSize());
    }

    @Test
    void removeEdge() {
        resetGraph();
        assertNull(this.graph.removeEdge(2,10));
        EdgeData edge = this.graph.getEdge(2,6);
        assertEquals(edge, this.graph.removeEdge(2,6));
        assertNull(this.graph.removeEdge(2,6));
    }

    @Test
    void removeNode() {
        resetGraph();
        assertNull(this.graph.removeNode(17));
        NodeData node = this.graph.getNode(1);
        assertEquals(node, this.graph.removeNode(1));
        assertNull(this.graph.getEdge(1,2));
        assertNull(this.graph.getEdge(1,0));
        assertNull(this.graph.getEdge(0,1));
        assertNull(this.graph.getEdge(2,1));
    }
}
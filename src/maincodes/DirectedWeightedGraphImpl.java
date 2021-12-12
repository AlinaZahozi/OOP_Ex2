package maincodes;
import java.util.*;
import api.DirectedWeightedGraph;
import api.EdgeData;
import api.NodeData;

public class  DirectedWeightedGraphImpl implements DirectedWeightedGraph {
    private final HashMap<Integer, NodeData> graph_nodes;
    private final HashMap<Integer, unit> Connect;
    private final HashMap<LinkedList<Integer>, EdgeData> graph_edges;
    private int count;

    //DirectedWeightedGraphImpl constructor
    public DirectedWeightedGraphImpl() {
        this.graph_nodes = new HashMap<>();
        this.Connect = new HashMap<>();
        this.graph_edges = new HashMap<>();
        this.count = 0;
    }

    //Returns the NodeData of the relevant Key of the current graph
    @Override
    public NodeData getNode(int key) {
        return this.graph_nodes.get(key);
    }

    //Returns the EdgeData of the relevant edge of the current graph
    @Override
    public EdgeData getEdge(int source, int destination) {
        return this.graph_edges.get(addNewList(source, destination));
    }

    //Adds a new node to the current graph
    @Override
    public void addNode(NodeData node) {
        if (this.graph_nodes.get(node.getKey()) == null) {
            this.graph_nodes.put(node.getKey(), node);
            this.Connect.put(node.getKey(), new unit());
            this.count += 1;
        } else System.out.println("Node " + node.getKey() + "already exists");
    }

    //Connects an edge with weight between node source to node destination
    @Override
    public void connect(int source, int destination, double weight) {
        if (this.getNode(source) != null) {
            if (this.getNode(destination) != null) {
                EdgeData edge = new EdgeDataImpl(source, destination, weight);
                this.Connect.get(source).addOutEdge(edge);
                this.Connect.get(destination).addInEdge(edge);
                this.graph_edges.put(addNewList(source, destination), edge);
                this.count += 1;
            } else System.out.println("Dest node: " + destination + " not exists");
        } else System.out.println("Src node: " + source + " not exists");
    }

    //Returns an Iterator for the collection representing all the nodes in the graph
    @Override
    public Iterator<NodeData> nodeIter() {
        return this.graph_nodes.values().iterator();
    }

    //Returns an Iterator for all the edges in this graph
    @Override
    public Iterator<EdgeData> edgeIter() {
        return this.graph_edges.values().iterator();
    }

    //Returns an Iterator for all the edges in this graph
    @Override
    public Iterator<EdgeData> edgeIter(int nodeKey) {
        return this.Connect.get(nodeKey).edgeOut.values().iterator();
    }

    // Returns the number of edges in the current graph
    @Override
    public int edgeSize() {
        return this.graph_edges.size();
    }

    //Returns the number of changes that were made
    @Override
    public int getMC() {
        return this.count;
    }

    // Returns the number of nodes in the current graph
    @Override
    public int nodeSize() {
        return this.graph_nodes.size();
    }

    //Deletes the edge from the current graph
    @Override
    public EdgeData removeEdge(int source, int destination) {
        LinkedList<Integer> key = addNewList(source, destination);
        EdgeData edge = this.graph_edges.get(key);
        if (edge != null) {
            this.Connect.get(source).removeOutEdge(edge);
            this.Connect.get(destination).removeInEdge(edge);
            this.count += 1;
            return this.graph_edges.remove(key);
        } else System.out.println("Edge from " + source + " to " + destination + " not exists");
        return null;
    }

    // Auxiliary function for creating a new linkedList
    private LinkedList<Integer> addNewList(int source, int destination) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(source);
        linkedList.add(destination);
        return linkedList;
    }

    //Deletes the node (with the given Key) from the current graph
    @Override
    public NodeData removeNode(int key) {
        if (this.getNode(key) != null) {
            unit degree = this.Connect.get(key);
            int count = degree.edgeOut.size();
            LinkedList<EdgeData> edges = new LinkedList<>(degree.edgeOut.values());
            count += degree.edgeIn.size();
            edges.addAll(degree.edgeIn.values());
            for (int i = 0; i < count; i++) {
                EdgeData edge = edges.get(i);
                removeEdge(edge.getSrc(), edge.getDest());
            }
            this.Connect.remove(key);
            this.count += 1;
            return this.graph_nodes.remove(key);
        } else System.out.println("Node " + key + " not exists");
        return null;
    }
}
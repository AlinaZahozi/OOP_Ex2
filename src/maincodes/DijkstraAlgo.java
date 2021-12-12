package maincodes;

import api.DirectedWeightedGraph;
import api.EdgeData;
import api.NodeData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DijkstraAlgo {

    public static final double INFINITY = Double.MAX_VALUE;

    private ArrayList<NodeData> unVisited;
    public HashMap<NodeData, Double> shortestDistFromVertex;
    public HashMap<NodeData, NodeData> previousVertex;

    public DijkstraAlgo(){
        this.unVisited = null;
        this.shortestDistFromVertex = null;
        this.previousVertex = null;
    }

    private void init(DirectedWeightedGraph graph, NodeData vertex){
        this.unVisited = new ArrayList<>();
        this.shortestDistFromVertex = new HashMap<>();
        this.previousVertex = new HashMap<>();
        Iterator<NodeData> nodes = graph.nodeIter();
        while(nodes.hasNext()){
            NodeData node = nodes.next();
            this.unVisited.add(node);
            if(node.getKey() != vertex.getKey()){
                this.shortestDistFromVertex.put(node, INFINITY);
            } else {
                this.shortestDistFromVertex.put(node, 0.0);
            }
        }
    }

    public void doAlgo(DirectedWeightedGraph graph, NodeData vertex){
        this.init(graph, vertex);
        Iterator<EdgeData> edgesIter;
        while(!this.unVisited.isEmpty()){
            NodeData currNode = minDistInUnVisited();
            edgesIter = graph.edgeIter(currNode.getKey());
            while(edgesIter.hasNext()){
                EdgeData edge = edgesIter.next();
                NodeData destNode = graph.getNode(edge.getDest());
                if(this.unVisited.contains(destNode)){
                    if(this.shortestDistFromVertex.get(currNode) + edge.getWeight() < this.shortestDistFromVertex.get(destNode)){
                        this.shortestDistFromVertex.replace(destNode, this.shortestDistFromVertex.get(currNode) + edge.getWeight());
                        this.previousVertex.put(destNode, currNode);
                    }
                }
            }
            this.unVisited.remove(currNode);
        }
    }

    private NodeData minDistInUnVisited(){
        NodeData min = this.unVisited.get(0);
        for(NodeData node: this.unVisited){
            if(this.shortestDistFromVertex.get(node) < this.shortestDistFromVertex.get(min)){
                min = node;
            }
        }
        return min;
    }

    // Note: need to be used only after this graph passed through the algorithm.
    // Return if there is path from the vertex to dest.
    public boolean isTherePath(DirectedWeightedGraph graph, int dest){
        NodeData destNode = graph.getNode(dest);
        return this.shortestDistFromVertex.get(destNode) != INFINITY;
    }
}
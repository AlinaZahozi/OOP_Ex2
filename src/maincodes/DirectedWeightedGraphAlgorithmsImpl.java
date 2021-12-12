package maincodes;
import api.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DirectedWeightedGraphAlgorithmsImpl implements DirectedWeightedGraphAlgorithms {
    private DirectedWeightedGraph graph = null;
    private final DijkstraAlgo DIJKSTRA = new DijkstraAlgo();

    //Initialize the graph on which this set of algorithms operates on
    @Override
    public void init(DirectedWeightedGraph g) {
        graph = g;
    }


     //Returns the underlying graph of which this class works
    @Override
    public DirectedWeightedGraph getGraph() {
        return graph;
    }

    //Computes a deep copy of this weighted graph
    @Override
    public DirectedWeightedGraph copy() {
        DirectedWeightedGraph copy = new DirectedWeightedGraphImpl();
        Iterator<NodeData> node_it = graph.nodeIter();
        if (node_it.hasNext()) {
            while (node_it.hasNext()) {
                NodeData node_c = node_it.next();
                NodeData node_v = new NodeDataImpl(node_c);
                copy.addNode(node_v);
            }
        }
        Iterator<EdgeData> Edge_it = graph.edgeIter();
        if(Edge_it.hasNext()) {
            while (Edge_it.hasNext()) {
                EdgeData edge_c = Edge_it.next();
                copy.connect(edge_c.getSrc(), edge_c.getDest(), edge_c.getWeight());
            }
        }
        return copy;
    }

    //Returns true if and only if (iff) there is a valid path from each node to each other node.
    @Override
    public boolean isConnected() {
        return isStronglyConnected(graph, graph.nodeSize());
    }

    //Method to go through all the nodes of the graph
    private static void Depth_first_search(DirectedWeightedGraph graph, NodeData n, boolean[] visited) {
        visited[n.getKey()] = true;
        Iterator<EdgeData> iter = graph.edgeIter(n.getKey());
        for (Iterator<EdgeData> it3 = iter; it3.hasNext(); ) {
            EdgeData edge = iter.next();
            NodeData nodeSon = graph.getNode(edge.getDest());
            if (!visited[nodeSon.getKey()]) {
                Depth_first_search(graph, nodeSon, visited);
            }
        }
    }

    //Checks to see if the graph is binding
    public static boolean isStronglyConnected(DirectedWeightedGraph graph, int n) {
        Iterator<NodeData> iterNode = graph.nodeIter();
        for (Iterator<NodeData> it = iterNode; it.hasNext(); ) {
            NodeData node = iterNode.next();
            boolean[] visited = new boolean[n];
            Depth_first_search(graph, node, visited);
            for (boolean b : visited) {
                if (!b) {
                    return false;
                }
            }
        }
        return true;
    }

    //Computes the length of the shortest path between src to dest
    @Override
    public double shortestPathDist(int src, int dest) {
        DIJKSTRA.doAlgo(graph, graph.getNode(src));
        if (DIJKSTRA.isTherePath(this.graph, dest)) {
            HashMap<NodeData, Double> pathDistFromSrc = DIJKSTRA.shortestDistFromVertex;
            return pathDistFromSrc.get(graph.getNode(dest));
        }
        return -1;
    }

    //Computes the shortest path between src to dest - as an ordered List of nodes
    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        DIJKSTRA.doAlgo(this.graph, this.graph.getNode(src));
        HashMap<NodeData, NodeData> pathDistFromSrc = DIJKSTRA.previousVertex;
        if(DIJKSTRA.isTherePath(this.graph, dest)){
            Stack<NodeData> pathOppositeDirection= new Stack<>();
            List<NodeData> path = new LinkedList<>();
            NodeData currNode = this.graph.getNode(dest);
            while(currNode.getKey() != src){
                pathOppositeDirection.push(currNode);
                currNode = pathDistFromSrc.get(currNode);
            }
            pathOppositeDirection.push(currNode);
            while(!pathOppositeDirection.isEmpty())
                path.add(pathOppositeDirection.pop());
            return path;
        }
        return null;
    }

    //Finds the NodeData which minimizes the max distance to all the other nodes.
    @Override
    public NodeData center() {
        if (isConnected()) {
            double min = Double.MAX_VALUE;
            for (Iterator<NodeData> it = graph.nodeIter(); it.hasNext(); ) {
                double max = 0;
                NodeData n = it.next();
                for (Iterator<NodeData> it2 = graph.nodeIter(); it2.hasNext(); ) {
                    NodeData e = it2.next();
                    double dist = shortestPathDist(n.getKey(), e.getKey());
                    if (dist > max) {
                        max = dist;
                    }
                }
                if (min > max) {
                    min = max;
                }
            }
            for (Iterator<NodeData> it = graph.nodeIter(); it.hasNext(); ) {
                NodeData n = it.next();
                for (Iterator<NodeData> it2 = graph.nodeIter(); it2.hasNext(); ) {
                    NodeData e = it2.next();
                    double dist = shortestPathDist(n.getKey(), e.getKey());

                    if (dist == min) {
                        return n;
                    }
                }
            }
        }
        return null;
    }

    //Computes a list of consecutive nodes which go over all the nodes in cities.
    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        if(this.isConnected()){
            NodeData currNode = cities.remove(0);
            List<NodeData> bestPath = new LinkedList<>();
            List<NodeData> path = new LinkedList<>();
            double totalDistance = tsp(cities, currNode, path, bestPath);
            System.out.println("Total distance is: " + totalDistance);
            return bestPath;
        }
        System.out.print("There is no path such that go through all the cities");
        return null;
    }

    public Double tsp(List<NodeData> unVisited, NodeData currNode, List<NodeData> path, List<NodeData> bestPath) {
        if(unVisited.isEmpty()){
            List<NodeData> toStart = this.shortestPath(currNode.getKey(), path.get(0).getKey());
            path.addAll(toStart);
            copyPath(path, bestPath);
            return this.shortestPathDist(currNode.getKey(), path.get(0).getKey());
        }
        double min = DijkstraAlgo.INFINITY;
        for(NodeData node : unVisited){
            double distToNode = this.shortestPathDist(currNode.getKey(), node.getKey());
            List<NodeData> toNode = this.shortestPath(currNode.getKey(), node.getKey());
            List<NodeData> copyUnVisited = new LinkedList<>();
            List<NodeData> copyPath = new LinkedList<>();
            copyPath(unVisited, copyUnVisited);
            removeNodes(toNode, copyUnVisited);
            toNode.remove(toNode.size() - 1);
            copyPath(path, copyPath);
            copyPath.addAll(toNode);
            double total = tsp(copyUnVisited, node, copyPath, bestPath) + distToNode;
            if(total < min){
                min = total;
            }
        }
        return min;
    }

    //Performs printing of the List
    public static void printList(List<NodeData> nodes){
        for(NodeData node : nodes){
            System.out.print(node.getKey() + " --> ");
        }
        System.out.println();
    }

    //Performs a copy on Path
    public void copyPath(List<NodeData> from, List<NodeData> to){
        to.clear();
        to.addAll(from);
    }

    //Delete the current node
    public void removeNodes(List<NodeData> from, List<NodeData> to){
        for(NodeData node : from){
            to.remove(node);
        }
    }

    //Saves this weighted (directed) graph to the given
    @Override
    public boolean save(String file) {
        try {
            Writer jsonFile = new FileWriter(file);
            JSONObject File = new JSONObject();
            File.putAll(build(file));
            jsonFile.write(File.toJSONString());
            jsonFile.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //builds the new Json file
    public JSONObject build(String file){
        JSONObject edgeobj = new JSONObject();
        JSONArray array = new JSONArray();
        Iterator<EdgeData> itere = graph.edgeIter();
        for (Iterator<EdgeData> iterator1 = itere; iterator1.hasNext(); ) {
            EdgeData edge = itere.next();
            JSONObject cust = new JSONObject();
            cust.put("src", edge.getSrc()+"");
            cust.put("w", edge.getWeight() + "");
            cust.put("dest", edge.getDest() + "");
            array.add(cust);
        }
        edgeobj.put("Edges", array);
        JSONArray narray = new JSONArray();
        Iterator<NodeData> iterd = graph.nodeIter();
        for (Iterator<NodeData> iterator1 = iterd; iterator1.hasNext(); ) {
            NodeData node = iterd.next();
            GeoLocation pos = node.getLocation();
            JSONObject cust = new JSONObject();
            String pos1 = pos.x() + "," + pos.y() + "," + pos.z();
            cust.put("pos", pos1);
            cust.put("id", node.getKey() + "");
            narray.add(cust);
        }
        edgeobj.put("Nodes", narray);

        return edgeobj;

    }

    //This method loads a graph to this graph algorithm.
    @Override
    public boolean load(String file) {
        try {
            DirectedWeightedGraphImpl load_graph = new DirectedWeightedGraphImpl();
            JSONParser parser = new JSONParser();
            Object str = parser.parse(new FileReader(file));
            JSONObject json_file = (JSONObject) str;
            JSONArray graph_nodes = (JSONArray) json_file.get("Nodes");
            JSONArray graph_edges = (JSONArray) json_file.get("Edges");
            double arr[] = {0,0,0};
            for (Object obj : graph_nodes) {
                JSONObject temp = (JSONObject) obj;
                boolean b = true;
                if ((temp.get("pos") == null) || (temp.get("id") == null)) b = false;
                if(b) {
                    arr = splitPoint(temp.get("pos").toString());
                    GeoLocationImpl p1 = new GeoLocationImpl(arr[0], arr[1], arr[2]);
                    int key = Integer.parseInt(temp.get("id").toString());
                    NodeData n = new NodeDataImpl(p1, key);
                    load_graph.addNode(n);
                }
            }
            for (Object obj : graph_edges) {
                JSONObject temp = (JSONObject) obj;
                boolean b = true;
                if ((temp.get("src") == null) || (temp.get("dest") == null) ||(temp.get("w") == null)) b = false;
                if (b) {
                    int src = Integer.parseInt(temp.get("src").toString());
                    int dest = Integer.parseInt(temp.get("dest").toString());
                    double w = Double.parseDouble(temp.get("w").toString());
                    load_graph.connect(src, dest, w);
                }
            }
            init(load_graph);
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Converts String to the relevant integers
    public double[] splitPoint(String s) {
        double arr[] = {0,0,0};
        String[] arrOfStr = s.split(",");
        arr[0] = Double.parseDouble(arrOfStr[0]);
        arr[1] = Double.parseDouble(arrOfStr[1]);
        arr[2] = Double.parseDouble(arrOfStr[2]);
        return arr;
    }
}
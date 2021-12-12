# Ex.2: Directed and Edge-Weighted Graphs
# introduction:
This task is dedicated to the design and implementation of data structures and algorithms on graphs (directed and weighted).

Directed Graph:

A directed graph is a graph, a set of objects (called vertices or nodes) that are connected together, where all the edges are directed from one vertex to another. A directed graph is sometimes called a digraph or a directed network. 

Edge-Weighted Graphs:

An edge-weighted graph   is a graph in which each edge has been assigned a weight. Similarly, a vertex-weighted graph   is a graph in which each vertex has been assigned a weight. In such graphs, the quantity represented by a weight depends on the application.

the combination of Directed Graphs and Edge-Weighted Graphs is called
Edge-Weighted Digraphs.


Details of the terms:

Vertex – Is a node on a graph. 
Directed Edge – Is a link between two vertices. Directed edge is always pointing the same way. It has a source and a destination. 
Weight – Represents the cost of the edge.

# Algorithm - DirectedWeightedGraphAlgorithmsImpl introduction:
    
The function below receives "g" parameter of the DirectedWeightedGraph type and initializes it within the graph of the algorithm:

    public void init(DirectedWeightedGraph g);
    

The function below returns the graph(DirectedWeightedGraph type) of the algorithm:

    public DirectedWeightedGraph getGraph();
    
    
The function below computes a deep copy of this weighted graph:
    
    public DirectedWeightedGraph copy();
    

The function below returns true if and only if (iff) there is a valid path from each node to each other node:

    public boolean isConnected();

The function below Computes the length of the shortest path between src to dest:

    public double shortestPathDist(int src, int dest);
    
    
The function below Computes the the shortest path between src to dest - as an ordered List of nodes: src--> n1-->n2-->...dest:

    public List<NodeData> shortestPath(int src, int dest);
    
    
The function below finds the NodeData which minimizes the max distance to all the other nodes. Assuming the graph isConnected, elese return null:

    public NodeData center();
    
    
The function below computes a list of consecutive nodes which go over all the nodes in cities.
the sum of the weights of all the consecutive (pairs) of nodes (directed) is the "cost" of the solution - the lower the better:

    public List<NodeData> tsp(List<NodeData> cities);
    

The function below saves this weighted (directed) graph to the given:

    public boolean save(String file);
    
The function below loads a graph to this graph algorithm.if the file was successfully loaded - the underlying graph of this class will be changed (to the loaded one), in case the graph was not loaded the original graph should remain "as is":
    
    public boolean load(String file);
 

 # UML:
 ![צילום מסך 9999999999](https://user-images.githubusercontent.com/93255163/145693560-99a5f07e-a73f-4411-bf94-00278f3838f6.png)


# Report results:
Analysis of the performance of algorithms on graphs of 1000, 10000, 100000, 1000000:

![צילום מסך 2021-12-11 233108](https://user-images.githubusercontent.com/93255163/145692284-4db9ce6f-5b80-45d5-bb24-baf5cdfe241b.png)

# Helpful Links:

OXFORD COLLEGE | Directed and Edge-Weighted Graphs: 
In this site you can find information about Directed and Edge-Weighted Graphs , and the best data structure for it.
link:http://math.oxford.emory.edu/site/cs171/directedAndEdgeWeightedGraphs/

# Credits:
1. Mishell dubovitski.
2. Alina zakhozha.
3. Mark vertenberg.


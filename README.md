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


 # how to run the jar file:
   1.download the zip file.
   
   2.open cmd. and with the help of 'cd' go to the path of the location of the file you downloaded.
   
   3.write 'java -jar Ex2.jar G1.json'
   
   4.click enter, and then the project will open.
   
   
 
<img width="665" alt="cmd" src="https://user-images.githubusercontent.com/93199677/145782915-ba8ffe2b-672d-4486-9742-497c1d60bf80.png">

 # how to use the project:
 the buttons:
 
 graph G1,graph G2 and graph G3
 
 will show you this options:
 
 <img width="908" alt="manu" src="https://user-images.githubusercontent.com/93199677/145783702-ee4bd63b-bf45-42cf-a67e-54452816cdf7.png">

the buttons:

show graph G1,show graph G2 and show graph G3

will show you this options:
<img width="956" alt="graph1" src="https://user-images.githubusercontent.com/93199677/145784150-92c32982-555f-4614-a808-c174311cb0d7.png">


 # UML:
 ![צילום מסך 9999999999](https://user-images.githubusercontent.com/93255163/145693560-99a5f07e-a73f-4411-bf94-00278f3838f6.png)


# Report results:
Analysis of the performance of algorithms on graphs of 1000, 10000, 100000, 1000000:

![צילום מסך 2021-12-11 233108](https://user-images.githubusercontent.com/93255163/145692284-4db9ce6f-5b80-45d5-bb24-baf5cdfe241b.png)

# Helpful Links:

OXFORD COLLEGE | Directed and Edge-Weighted Graphs: 
In this site you can find information about Directed and Edge-Weighted Graphs , and the best data structure for it.
link:http://math.oxford.emory.edu/site/cs171/directedAndEdgeWeightedGraphs/

Explanation of Dijkstra’s algorithm for finding the shortest path between one vertex in a graph and another.
This video helped us to implement our Dijkstra class.
link:https://www.youtube.com/watch?v=pVfj6mxhdMw

Explanation on performing Depth–first search (DFS) to check if A directed graph is strongly connected.
link:https://www.techiedelight.com/check-given-graph-strongly-connected-not/

# Credits:
1. Mishell dubovitski.
2. Alina zakhozha.
3. Mark vertenberg.


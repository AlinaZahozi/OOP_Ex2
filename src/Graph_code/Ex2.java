package Graph_code;
import api.*;

public class Ex2 {
//this functin loads the algo graph
    public static DirectedWeightedGraph take_new_graph(String json_file) {
        DirectedWeightedGraphImpl Initialize_graph = new DirectedWeightedGraphImpl();
        DirectedWeightedGraphAlgorithmsImpl algo_graph = new DirectedWeightedGraphAlgorithmsImpl();
        algo_graph.init(Initialize_graph);
        try{
            algo_graph.load(json_file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return algo_graph.getGraph();
    }
//this fucntion loads the graph
    public static DirectedWeightedGraphAlgorithms take_new_algo_graph(String json_file) {
        DirectedWeightedGraphImpl Initialize_graph = new DirectedWeightedGraphImpl();
        DirectedWeightedGraphAlgorithmsImpl algo_graph = new DirectedWeightedGraphAlgorithmsImpl();
        algo_graph.init(Initialize_graph);
        try {
            algo_graph.load(json_file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return algo_graph;
    }
//paint the graph
    public static void paint_graph(String json_file) {
        DirectedWeightedGraphAlgorithms graphAlgo = take_new_algo_graph(json_file);
        new body(graphAlgo);
    }
//main
    public static void main(String[] args) {
        String json_file = "G1.json";
        paint_graph(json_file);
    }
}
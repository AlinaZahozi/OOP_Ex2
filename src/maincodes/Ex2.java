package maincodes;
import guigraph.*;
import api.*;

public class Ex2 {

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

    public static void paint_graph(String json_file) {
        DirectedWeightedGraphAlgorithms graphAlgo = take_new_algo_graph(json_file);
        new frame(graphAlgo);
    }

    public static void main(String[] args) {
        String json_file = "data/G1.json";
        paint_graph(json_file);
    }
}
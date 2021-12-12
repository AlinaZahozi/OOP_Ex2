package maincodes;
import api.EdgeData;
import java.util.HashMap;

public class unit{
    public final HashMap<Integer, EdgeData> edgeOut;
    public final HashMap<Integer, EdgeData> edgeIn;

    //unit constructor
    public unit() {
        this.edgeOut = new HashMap<>();
        this.edgeIn = new HashMap<>();
    }

    //Adds a new edge to the egdeOut Hashmap
    public void addOutEdge(EdgeData edge){
        this.edgeOut.put(edge.getDest(), edge);
    }

    //Adds a new edge to the egdeIn Hashmap
    public void addInEdge(EdgeData edge){
        this.edgeIn.put(edge.getSrc(), edge);
    }

    //Removes a current edge from the egdeOut Hashmap
    public void removeOutEdge(EdgeData edge){
        this.edgeOut.remove(edge.getDest());
    }

    //Removes a current edge from the egdeIn Hashmap
    public void removeInEdge(EdgeData edge){
        this.edgeIn.remove(edge.getSrc());
    }
}

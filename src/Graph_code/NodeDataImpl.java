package Graph_code;
import api.*;

public class NodeDataImpl implements NodeData {
    private String data;
    private int key;
    private int flag;
    private double weight;
    private GeoLocation location;

    //NodeDataImpl constructor
    public NodeDataImpl(GeoLocation location, int key){
        this.data = null;
        this.key = key;
        this.flag = 0;
        this.weight = 0;
        this.location = location;
    }

    //NodeDataImpl copy-constructor
    public NodeDataImpl(NodeData other) {
        this.data = other.getData();
        this.key = other.getKey();
        this.flag = other.getFlag();
        this.weight = other.getWeight();
        this.location = other.getLocation();
    }

    //Returns Info String
    @Override
    public String getData() {
        return this.data;
    }

    //Returns Key Integer
    @Override
    public int getKey() {
        return this.key;
    }

    //Returns the GeoLocation
    @Override
    public GeoLocation getLocation() {
        return this.location;
    }

    //Returns tag Integer
    @Override
    public int getFlag() {
        return this.flag;
    }

    //Returns the weight
    @Override
    public double getWeight() {
        return this.weight;
    }

   //Sets new Info to the current node
    @Override
    public void setData(String s) {
        this.data = s;
    }

    //Sets new GeoLocation to the current node
    @Override
    public void setLocation(GeoLocation p) {
        this.location = p;
    }

    //Sets new Tag to the current node
    @Override
    public void setFlag(int t) {
        this.flag = t;
    }

    //Sets new Weight to the current node
    @Override
    public void setWeight(double w) {
        this.weight = w;
    }
}
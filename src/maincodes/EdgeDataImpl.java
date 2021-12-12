package maincodes;
import api.EdgeData;

public class EdgeDataImpl implements EdgeData {
    private int destination;
    private String data;
    private int source;
    private int flag;
    private double weight;

    //EdgeDataImpl constructor
    public EdgeDataImpl(int source,int destination,double weight){
        this.source = source;
        this.weight = weight;
        this.destination = destination;
        this.data = null;
        this.flag = 0;
    }

    //EdgeDataImpl copy-constructor
    public EdgeDataImpl(EdgeDataImpl other){
        this.source = other.source;
        this.weight = other.weight;
        this.destination = other.destination;
        this.data = null;
        this.flag = other.flag;
    }

    //Returns destination Integer
    @Override
    public int getDest() {return this.destination;}

    //Returns Info String
    @Override
    public String getData() {return this.data;}

    //Returns source Integer
    @Override
    public int getSrc() {return this.source;}

    //Returns tag Integer
    @Override
    public int getTag() {return this.flag;}

    //Returns the weight
    @Override
    public double getWeight() {return this.weight;}

    //Sets new Info to the current edge
    @Override
    public void setData(String s) {this.data = s;}

    //Sets new Tag to the current edge
    @Override
    public void setTag(int t) {this.flag = t;}
}
package Graph_code;

import api.GeoLocation;
public class GeoLocationImpl implements GeoLocation {
    private double xcoordinate, ycoordinate, zcoordinate;


    //constructor for the x coordiante the y cooridinate and the z coordinate
    public GeoLocationImpl(double xcoordinate, double ycoordinate, double zcoordinate) {
        this.xcoordinate = xcoordinate;
        this.ycoordinate = ycoordinate;
        this.zcoordinate = zcoordinate;
    }

    //returns the x coordinate
    @Override
    public double x() {
        return xcoordinate;
    }

    //returns the y coordinate
    @Override
    public double y() {
        return ycoordinate;
    }

    //returns the z coordinate
    @Override
    public double z() {
        return zcoordinate;
    }

    //return the distance of the coordinates x,y,z
    @Override
    public double distance(GeoLocation g) {
        return Math.sqrt((Math.pow(g.x() - this.xcoordinate, 2) + Math.pow(g.y() - this.ycoordinate, 2) + Math.pow(g.z() - this.zcoordinate, 2)));
    }
}

package Graph_code;
import api.GeoLocation;
import api.NodeData;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;

public class NodeDataTest {
    GeoLocation point1 = new GeoLocationImpl(0.0, 0.0, 0.0);
    GeoLocation point2 = new GeoLocationImpl(10.3, 5.2, 0.0);
    NodeData new_node = new NodeDataImpl(point1, 1);

    @Test
    public void getInfoTest() {
        Assertions.assertEquals(new_node.getData(), null);
    }

    @Test
    public void getKeyTest() {
        Assertions.assertEquals(new_node.getKey(), 1);
    }

    @Test
    public void getLocationTest() {
        Assertions.assertEquals(new_node.getLocation(), point1);
    }

    @Test
    public void getTagTest() {
        Assertions.assertEquals(new_node.getFlag(), 0);
    }

    @Test
    public void getWeightTest() {
        Assertions.assertEquals(new_node.getWeight(), 0.0);
    }

    @Test
    public void setInfoTest() {
        new_node.setData("13");
        Assertions.assertEquals(new_node.getData(), "13");
    }

    @Test
    public void setLocationTest() {
        new_node.setLocation(point2);
        Assertions.assertEquals(new_node.getLocation(), point2);
    }

    @Test
    public void setTagTest() {
        new_node.setFlag(2);
        Assertions.assertEquals(new_node.getFlag(), 2);
    }

    @Test
    public void setWeightTest() {
        new_node.setWeight(0.123456);
        Assertions.assertEquals(new_node.getWeight(), 0.123456);
    }
}

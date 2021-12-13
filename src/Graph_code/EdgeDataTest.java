package Graph_code;
import api.EdgeData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EdgeDataTest {
    EdgeData edge1 = new EdgeDataImpl(1, 7, 0.9876);

    @Test
    public void getDstTest() {
        Assertions.assertEquals(edge1.getDest(), 7);
    }

    @Test
    public void getInfoTest() {
        Assertions.assertEquals(edge1.getData(), null);
    }

    @Test
    public void getSrcTest() {
        Assertions.assertEquals(edge1.getSrc(), 1);
    }

    @Test
    public void getTagTest() {
        Assertions.assertEquals(edge1.getTag(), 0);
    }

    @Test
    public void getWightTest() {
        Assertions.assertEquals(edge1.getWeight(), 0.9876);
    }

    @Test
    public void SetInfoTest() {
        edge1.setData("13");
        Assertions.assertEquals(edge1.getData(), "13");
    }
    @Test
    public void setTagTest() {
        edge1.setTag(2);
        Assertions.assertEquals(edge1.getTag(), 2);
    }

}

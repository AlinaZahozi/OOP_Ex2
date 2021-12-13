package Graph_code;
import api.DirectedWeightedGraph;
import api.EdgeData;
import api.NodeData;
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class board extends JPanel {
    private double smallestvalusey;
    private double sx;
    private double smallestvaluex;
    private double sy;
    private static final Dimension di = new Dimension(1000, 1000);
    private double biggestvaluex;
    private DirectedWeightedGraph g;
    private double biggestvaluey;


    public void sd(NodeData forw){
        double we = Math.min(smallestvaluex, forw.getLocation().x());
        smallestvaluex = we;
        double re = Math.min(smallestvalusey, forw.getLocation().y());
        smallestvalusey = re;
        double gy = Math.max(biggestvaluex, forw.getLocation().x());
        biggestvaluex = gy;
        double yo = Math.max(biggestvaluey, forw.getLocation().y());
        biggestvaluey = yo;
    }
    //board constructor
    public board(DirectedWeightedGraph graph) {
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setBackground(Color.black);
        this.setFocusable(true);
        main(graph);
    }
    public void ed(NodeData forw){
        smallestvaluex = forw.getLocation().x();
        smallestvalusey = forw.getLocation().y();
        biggestvaluex = forw.getLocation().x();
        biggestvaluey = forw.getLocation().y();

    }

    //Realization of graphical interface and visibility
    public void paint(Graphics g) {
        super.paint(g);
        int o = this.getWidth();
        int k = this.getHeight();
        double di = (biggestvaluex - smallestvaluex);
        double po = (biggestvaluey - smallestvalusey);
        double oi = Math.abs(di);
        double ki = Math.abs(po);
        double t = (o / oi);
        double ti = (k / ki);
        sx = (t * 0.888);
        sy = (ti * 0.888);
        Iterator<EdgeData> iter = this.g.edgeIter();
        for (Iterator<EdgeData> it3 = iter; it3.hasNext(); ) {
            EdgeData edge = it3.next();
            double firstx = this.g.getNode(edge.getSrc()).getLocation().x();
            double h = (firstx - smallestvaluex);
            double hi = h*sx;
            firstx = (hi + 10);
            double firsty = this.g.getNode(edge.getSrc()).getLocation().y();
            double pl = (firsty - smallestvalusey);
            double w = pl *sy;
            double q = w +10;
            firsty = q;
            double endx = this.g.getNode(edge.getDest()).getLocation().x();
            double yu = (endx - smallestvaluex);
            double yt = yu * sx;
            endx = (yt + 10);
            double endy = this.g.getNode(edge.getDest()).getLocation().y();
            double qw = (endy - smallestvalusey);
            double xj = (qw*sy);
            endy = (xj + 10);
            g.setColor(Color.orange);
            int distanceofx = (int)endx -(int) firstx;
            int  distancey = (int)endy - (int)firsty;
            double we = (distanceofx * distanceofx);
            double re = (distancey * distancey);
            double distance = Math.sqrt(we + re);
            double dist = (distance - 20);
            double distn = dist;
            double disty = 20;
            double distx = -20 ;
            double p;
            double engles = (distancey / distance);
            double englec = (distanceofx / distance);
            double ys = (dist * englec);
            double tg =(disty * engles);
            double tu = (ys - tg);
            p = (tu + firstx);
            double yp = (dist * engles);
            double cf = (disty * englec);
            double hj = (yp + cf);
            disty = (hj+ firsty);
            dist = p;
            double jo = (distn * englec);
            double pm = (distx * engles);
            double you = (jo - pm);
            p = (you + firstx);
            double wq = (distn * engles);
            double hpo = (distx * englec);
            double tyu = (wq + hpo);
            distx = (tyu + firsty);
            distn = p;
            int reend = (int)endx;
            int redist = (int) dist;
            int redistn = (int) distn;
            int[] xpoints = {reend, redist,redistn};
            int reendy = (int)endy;
            int redisty = (int) disty;
            int redistx = (int) distx;
            int[] ypoints = {reendy, redisty, redistx};
            int refirst = (int)firstx;
            int reendx = (int)endx;
            int refirsty = (int)firsty;
            int reendyo = (int) endy;
            g.drawLine(refirst,refirsty,reendx,reendyo);
            int[] xp = xpoints;
            int [] ypo = ypoints;
            int to3 = 3;
            g.fillPolygon(xp,ypo,to3);
            double omi =  (endx*0.7);
            double oli = (firstx*0.2);
            int first = (int) (omi+oli);
            double wei = (endy*0.7);
            double yui = (firsty*0.2);
            int sec = (int)(wei+yui);
            String s = edge.getWeight() + "";
            g.setColor(Color.blue);
            g.drawString(s,first,sec);
        }
        Iterator<NodeData> iterator = this.g.nodeIter();
        for (Iterator<NodeData> it = iterator; it.hasNext(); ) {
            NodeData n = it.next();
            double x =  ((n.getLocation().x() - smallestvaluex));
            int z = (int) (x* sx);
            double y =  (n.getLocation().y() - smallestvalusey);
            int h =  (int) (y* sy);;
            g.setColor(Color.green);
            g.fillOval(z, h, 30, 30);
            g.setColor(Color.red);
            int w = z +2;
            int l =  h +15;
            String okl = n.getKey()+"";
            g.drawString( okl,w,l);
        }
    }

    //Main run function
    public void main(DirectedWeightedGraph graph) {
        this.g = graph;
        Iterator<NodeData> n = graph.nodeIter();
        NodeData forw = n.next();
        ed (forw);
        for (Iterator<NodeData> iterator1 = n; iterator1.hasNext(); ) {
            forw = n.next();
            sd(forw);
        }
    }






}
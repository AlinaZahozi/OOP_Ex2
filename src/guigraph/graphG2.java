package guigraph;
import api.DirectedWeightedGraphAlgorithms;
import api.NodeData;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class graphG2 extends JFrame implements ActionListener {
    static JFrame k;
    static JButton button;
    static JButton button1;
    static JButton button2;
    static JButton button3;
    static JButton button4;
    static JButton button5;
    static JButton button6;
    static JButton button7;
    static JButton button8;
    static JButton button9;
    static JButton button10;
    private board p;
    private DirectedWeightedGraphAlgorithms Galfo;

    //graphG2 constructor
    graphG2(DirectedWeightedGraphAlgorithms ans){
        super();
        Galfo = ans;
        p = new board(ans.getGraph());
        p.main(Galfo.getGraph());
        p.repaint();
        this.add(p);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
        button = new JButton("get node");
        button1 = new JButton("get edge");
        button2 = new JButton("size of nodes");
        button3= new JButton("is graph connected");
        button4= new JButton("load graph");
        button5 = new JButton("size of edges");
        button6 = new JButton("center");
        button7= new JButton("save");
        button8= new JButton("shortest path");
        button9= new JButton("shortest path dist");
        button10= new JButton("TSP");
        button.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button10.addActionListener(this);
        JPanel p1 = new JPanel();
        p1.add(button);
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(button7);
        p1.add(button8);
        p1.add(button9);
        p1.add(button10);
        add(p1);
    }

    //Executes the command line after the selector is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("get node")) {
            new give_new_node(Galfo.getGraph());
        }
        else if(s.equals("get edge")){
            new give_new_edge(Galfo.getGraph());

        } else if(s.equals("size of nodes")){
            JOptionPane.showMessageDialog(null,"the number Of the Nodes in the graph is: " + Galfo.getGraph().nodeSize());
        } else if(s.equals("size of edges")) {
            JOptionPane.showMessageDialog(null, "the number Of the edges in the graph is: " + Galfo.getGraph().edgeSize());
        }
        else if(s.equals("is graph connected")){
            if(Galfo.isConnected()) {
                JOptionPane.showMessageDialog(null, "the graph is Connected");
            }
            else {
                JOptionPane.showMessageDialog(null, "the graph is not Connected");
            }

        }
        else if(s.equals("load graph")){
            new Loadthegraph(Galfo, p);
        }

        else if(s.equals("save")){
            new Savethegraph(Galfo);
        }
        else if(s.equals("shortest path")){
            new ShortestPathgraph(Galfo);

        }
        else if(s.equals("shortest path dist")) {
            new ShortestPathDistance(Galfo);
        }
        else if(s.equals("TSP")){
            new graph_tsp(Galfo);

        }
        else if(s.equals("center")){
            try {
                NodeData g = Galfo.center();
                int f = g.getKey();
                JOptionPane.showMessageDialog(null, "the center of this graph is " + f + "");
            }
            catch (Exception E){
                JOptionPane.showMessageDialog(null, "something went wrong ");

            }
        }
    }
}

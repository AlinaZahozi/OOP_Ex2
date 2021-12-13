package Graph_code;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import api.DirectedWeightedGraphAlgorithms;
import api.NodeData;

public class graph_tsp extends JFrame implements ActionListener {
    private DirectedWeightedGraphAlgorithms GAlgo;
    private JLabel text;
    private JTextField name;
    private JButton button;

    //graph_tsp constructor
    public graph_tsp(DirectedWeightedGraphAlgorithms graphAlgo) {
        super("tsp algo");
        this.GAlgo = graphAlgo;
        text = new JLabel("write the cities like this 1:2:3..and so on: ");
        button = new JButton("click");
        button.addActionListener(this);
        name = new JTextField(10);
        JPanel p = new JPanel();
        p.add(text);
        p.add(name);
        p.add(button);
        add(p);
        pack();
        setResizable(true);
        setVisible(true);
    }

    //Finds the smallest sum of the Edge weight from node to node
    private void tsp(List<NodeData> n) {
        setVisible(false);
        n = GAlgo.tsp(n);
        if (n != null) {
            String m = "";
            for (NodeData j : n) {
                m = m+ j.getKey() + "----> ";
            }
            JOptionPane.showMessageDialog(null ,m);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null,"no path");
            this.dispose();
            return;
        }
    }

    //Executes the command line after the selector is pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("click")) {
            readNodes();
        }
    }

    //Adds the nodes to the list and runs the tsp
    private void readNodes() {
        try {
            String[] s = name.getText().split(":");
            List<NodeData> citie = new ArrayList<>();
            int t;
            NodeData d;
            for (String k : s) {
                t = Integer.parseInt(k);
                d = GAlgo.getGraph().getNode(t);
                if(d != null) {
                    citie.add(d);
                }
                else {
                    JOptionPane.showMessageDialog(null,"this node " + t + "does not exist in this graph" );
                    this.dispose();
                    return;
                }
            }
            tsp(citie);
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "there is a problem");
        }
    }
}

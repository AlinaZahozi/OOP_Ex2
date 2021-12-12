package guigraph;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import api.DirectedWeightedGraph;
import api.EdgeData;

public class give_new_edge extends JFrame implements ActionListener {
    private DirectedWeightedGraph g;
    private JButton selector;
    private JLabel text_source;
    private JLabel text_destination;
    private JTextField input_source;
    private JTextField input_destination;


    //give_new_edge constructor
    public give_new_edge(DirectedWeightedGraph graph) {
        super("give Edge");
        this.g = graph;
        text_source = new JLabel("write the Src node:");
        text_destination = new JLabel("write the Dest node:");
        selector = new JButton("click");
        selector.addActionListener(this);
        input_source = new JTextField(10);
        input_destination = new JTextField(10);
        JPanel p = new JPanel();
        p.add(text_source);
        p.add(input_source);
        p.add(text_destination);
        p.add(input_destination);
        p.add(selector);
        add(p);
        pack();
        setResizable(true);
        setVisible(true);
    }

    //A function that shows the relevant text
    private void give_new_edge() {
        setVisible(false);
        try {
            EdgeData thedge = g.getEdge(Integer.parseInt(input_source.getText()), Integer.parseInt(input_destination.getText()));
            if (thedge != null) {
                JOptionPane.showMessageDialog(null, "the edge info:Src: " + thedge.getSrc() + ", dest: " + thedge.getDest() + ", weight: " + thedge.getWeight());
            }
            else {
                JOptionPane.showMessageDialog(null, "there is not such edge");
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "something went wrong");
        }
        this.dispose();
    }

    //Executes the command line after the selector is pressed
    public void actionPerformed(ActionEvent act) {
        String s = act.getActionCommand();
        if (s.equals("click")) {
            give_new_edge();
        }
    }
}

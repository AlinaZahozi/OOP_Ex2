package guigraph;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import api.DirectedWeightedGraph;
import api.NodeData;

public class give_new_node extends JFrame implements ActionListener {
    private JTextField key_JText;
    private JButton selector;
    private JLabel text_JLabel;
    private DirectedWeightedGraph g;

    //give_new_node constructor
    public give_new_node(DirectedWeightedGraph graph) {
        super("give Node");
        this.g = graph;
        text_JLabel = new JLabel("write the Node:");
        selector = new JButton("click");
        selector.addActionListener(this);
        key_JText = new JTextField(10);
        JPanel p = new JPanel();
        p.add(text_JLabel);
        p.add(key_JText);
        p.add(selector);
        add(p);
        pack();
        setResizable(true);
        setVisible(true);
    }

    //A function that shows the relevant text
    private void givenode() {
        setVisible(false);
        try {
            NodeData node = g.getNode(Integer.parseInt(key_JText.getText()));
            if (node != null) {
                JOptionPane.showMessageDialog(null, "Node in Key: " + node.getKey() + "\n GEO Location: " + node.getLocation().x()+","+node.getLocation().y()+","+node.getLocation().z());
            }
            else {
                JOptionPane.showMessageDialog(null, "node not found");
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "something went wrong");
        }
        this.dispose();
    }

    //Executes the command line after the selector is pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("click")) {
            givenode();
        }
    }
}

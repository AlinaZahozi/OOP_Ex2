package guigraph;
import api.DirectedWeightedGraphAlgorithms;
import api.NodeData;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
//the class was created to eable to open a windouw and buttuns for the user to chose
// and see the shortest path for his src and dest choosing;
public class ShortestPathgraph extends JFrame implements ActionListener {
    private JTextField first;
    private JTextField last;
    private JButton press;
    private JLabel write;
    private JLabel write2;
    private DirectedWeightedGraphAlgorithms Galgo;
    public ShortestPathgraph(DirectedWeightedGraphAlgorithms g) {
        //implamnting the Jframe
        super("Shortest Path Dist");
        this.Galgo = g;
        write = new JLabel("write the Src node:");
        write2 = new JLabel("write the Dest node:");
        press = new JButton("click");
        press.addActionListener(this);
        first = new JTextField(10);
        last = new JTextField(10);
        JPanel p = new JPanel();
        p.add(write);
        p.add(first);
        p.add(write2);
        p.add(last);
        p.add(press);
        add(p);
        pack();
        setResizable(true);
        setVisible(true);
    }
    //implanting the action preformed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        //if the user press the button click then it goes to the function
        //shortdist
        if (s.equals("click")) {
            shortdist();
        }
    }
    //the function short dist
    private void shortdist() {
        setVisible(false);
        try {
            int src = Integer.parseInt(this.first.getText());
            int dest = Integer.parseInt(this.last.getText());
            List<NodeData> path = Galgo.shortestPath(src, dest);
            if (!path.isEmpty()) {
                String b = "the dist is:";
                String  p ="";
                for (NodeData k : path) {
                    p   = p + k.getKey() + ":";
                }
                JOptionPane.showMessageDialog(null, b+p);

            }
            else {
                JOptionPane.showMessageDialog(null,"no path");

            }
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Something is wrong");
        }
        this.dispose();
    }
}
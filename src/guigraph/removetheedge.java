package guigraph;
import api.DirectedWeightedGraph;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class removetheedge extends JFrame implements ActionListener {
    private JLabel one;
    private JTextField first;
    private JButton press;
    private JTextField last;
    private JLabel sec;
    //the class was created to eable to open a windouw and buttuns for the user to chose
// the edge he want to remove;
    private DirectedWeightedGraph g;
    private board p;
    public removetheedge(DirectedWeightedGraph ga, board pa) {
        super("Remove the Edge");
        this.g = ga;
        this.p = pa;
        sec = new JLabel("write the dest node of the edge:");
        press = new JButton("click");
        first = new JTextField(16);
        press.addActionListener(this);
        one = new JLabel("write the Src node of the edge:");
        last = new JTextField(16);
        JPanel p = new JPanel();
        p.add(one);
        p.add(first);
        p.add(sec);
        p.add(last);
        p.add(press);
        add(p);
        pack();
        setResizable(true);
        setVisible(true);
    }


    //implanting the action preformed

    //if the user press the button click then it goes to the function
    //remove edge
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("click")) {
            remove();
        }
    }
    //the function
    private void remove() {
        setVisible(false);
        try {
            int src = Integer.parseInt(this.first.getText());
            int dest = Integer.parseInt(this.last.getText());
            if (g.removeEdge(src, dest) != null) {
                g.removeEdge(src, dest);
                p.repaint();
            }
            else{
                JOptionPane.showMessageDialog(null,"edge not found");
            }

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "something went wrong");
        }
        this.dispose();
    }
}
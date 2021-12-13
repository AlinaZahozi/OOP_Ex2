package Graph_code;
import api.DirectedWeightedGraphAlgorithms;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//implamnting the Jframe
public class ShortestPathDistance extends JFrame implements ActionListener {
    private JTextField data;
    private JTextField data1;
    private JButton press;
    private JLabel labels;
    private JLabel labeld;
    private DirectedWeightedGraphAlgorithms Galgo;
    //the class was created to eable to open a windouw and buttuns for the user to chose
// and see the shortest path dist for his src and dest choosing;


    public ShortestPathDistance(DirectedWeightedGraphAlgorithms g) {
        super("Shortest path Dist");
        this.Galgo = g;
        labels = new JLabel("write the Src node:");
        labeld = new JLabel("write the Dest node:");
        press = new JButton("click");
        press.addActionListener(this);
        data = new JTextField(10);
        data1 = new JTextField(10);
        JPanel p = new JPanel();
        p.add(labels);
        p.add(data);
        p.add(labeld);
        p.add(data1);
        p.add(press);
        add(p);
        pack();
        setResizable(true);
        setVisible(true);
    }
    //implanting the action preformed

    //if the user press the button click then it goes to the function
    //shortdist

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("click")) {
            shortestpathdist();
        }
    }


    //the function short  path dist

    private void shortestpathdist() {
        setVisible(false);
        try {
            int src = Integer.parseInt(data.getText());
            int dest = Integer.parseInt(data1.getText());
            double dis = Galgo.shortestPathDist(src, dest);
            int j = -1;
            if (dis != j) {
                JOptionPane.showMessageDialog(null,"the distance is " + dis);

            }
            else {
                JOptionPane.showMessageDialog(null,"There is no path");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Something is Wrong ");
        }
        this.dispose();
    }
}
package Graph_code;
import api.DirectedWeightedGraph;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class removethenode extends JFrame implements ActionListener {
    private JTextField data;
    private JLabel type;
    private JButton press;

    private DirectedWeightedGraph g;
    private board p;

    //the class was created to eable to open a windouw and buttuns for the user to chose
// the graph name that he wants to save;
    public removethenode(DirectedWeightedGraph ga, board pa) {
        super("remove");
        this.g = ga;
        data = new JTextField(5);
        this.p = pa;
        press = new JButton("click");
        press.addActionListener(this);
        type = new JLabel("the node you want to remove:");
        JPanel p = new JPanel();
        p.add(type);
        p.add(data);
        p.add(press);
        add(p);
        pack();
        setResizable(true);
        setVisible(true);
    }


    //implanting the action preformed

    //if the user press the button click then it goes to the function
    //remove node
    @Override
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
            int num = Integer.parseInt(data.getText());
            if (g.removeNode(num) != null) {
                g.removeNode(num);
                p.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "node not found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "something is wrong");
        }
        this.dispose();

    }
}
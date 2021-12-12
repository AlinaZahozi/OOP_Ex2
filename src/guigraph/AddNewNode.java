package guigraph;
import api.DirectedWeightedGraph;
import maincodes.GeoLocationImpl;
import maincodes.NodeDataImpl;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewNode extends JFrame implements ActionListener {
    private JTextField intake;
    private JTextField x_JText;
    private JTextField y_JText;
    private JTextField z_JText;
    private JTextField key_JText;
    private JButton selector;
    private JLabel topic;
    private JLabel x_JLabel;
    private JLabel y_JLabel;
    private JLabel z_JLabel;
    private JLabel key_JLabel;
    private DirectedWeightedGraph g;
    private board p;

    //AddNewNode constructor
    public AddNewNode(DirectedWeightedGraph ga, board pa) {
        super("add the Node");
        this.g = ga;
        this.p = pa;
        topic = new JLabel("write the geo location of the node:");
        x_JLabel = new JLabel("x:");
        x_JText =new JTextField(5);
        y_JLabel = new JLabel("y:");
        y_JText =  new JTextField(5);
        z_JLabel = new JLabel("z:");
        z_JText = new JTextField(5);
        selector = new JButton("click");
        key_JLabel = new JLabel("write the key node you want:");
        key_JText = new JTextField(5);
        selector.addActionListener(this);
        JPanel p = new JPanel();
        p.add(topic);
        p.add(x_JLabel);
        p.add(x_JText);
        p.add(y_JLabel);
        p.add(y_JText);
        p.add(z_JLabel);
        p.add(z_JText);
        p.add(key_JLabel);
        p.add(key_JText);
        p.add(selector);
        add(p);
        pack();
        setResizable(true);
        setVisible(true);
    }

    //Executes the command line after the selector is pressed
    public void actionPerformed(ActionEvent act) {
        String s = act.getActionCommand();
        if (s.equals("click")) {
            AddNewNode();
        }
    }

    //Closes the graphical interface window
    private void AddNewNode() {
        setVisible(false);
        try {
            int xf = Integer.parseInt(x_JLabel.getText());
            int yf = Integer.parseInt(y_JLabel.getText());
            int zf = Integer.parseInt(z_JLabel.getText());
            int kf = Integer.parseInt(key_JLabel.getText());
            g.addNode(new NodeDataImpl(new GeoLocationImpl(xf,yf,zf), 17));
            p.repaint();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Something Gets Wrong");
        }
        this.dispose();
    }
}
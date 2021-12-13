package Graph_code;
import api.DirectedWeightedGraph;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class connecting extends JFrame implements ActionListener {
        private JTextField source;
        private JTextField destination;
        private JTextField Weight;
        private JButton selector;
        private JLabel text_source;
        private JLabel text_destination;
        private JLabel text_weight;
        private DirectedWeightedGraph g;
        private board p;

        //connecting constructor
        public connecting(DirectedWeightedGraph g, board p) {
            super("Connect");
            this.g = g;
            this.p = p;
            text_source = new JLabel("write the Src of the node:");
            text_destination = new JLabel("write the Dest of the node:");
            text_weight = new JLabel("write the Weight of the node:");
            selector = new JButton("click");
            selector.addActionListener(this);
            source = new JTextField(10);
            destination = new JTextField(10);
            Weight = new JTextField(10);
            JPanel p_new = new JPanel();
            p_new.add(text_source);
            p_new.add(source);
            p_new.add(text_destination);
            p_new.add(destination);
            p_new.add(text_weight);
            p_new.add(Weight);
            p_new.add(selector);
            add(p_new);
            pack();
            setResizable(true);
            setVisible(true);
        }

        //Executes the command line after the selector is pressed
        public void actionPerformed(ActionEvent act) {
            String s = act.getActionCommand();
            if (s.equals("click")) connect();
        }

        //Connects the source,destination and weight to the current graph
        private void connect() {
            setVisible(false);
            try {
                int source = Integer.parseInt(this.source.getText());
                int destination = Integer.parseInt(this.destination.getText());
                double weight = Double.parseDouble(this.Weight.getText());
                g.connect(source,destination,weight);
                p.repaint();
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "something went wrong");
            }
            this.dispose();
        }
}

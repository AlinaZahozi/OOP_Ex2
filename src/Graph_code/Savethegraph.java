package Graph_code;
import api.DirectedWeightedGraphAlgorithms;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Savethegraph extends JFrame implements ActionListener {
    private JTextField field;
    private JButton press;
    private JLabel label;

    private DirectedWeightedGraphAlgorithms Galgo;
    //the class was created to eable to open a windouw and buttuns for the user to chose
// the graph name that he wants to save;
    public Savethegraph(DirectedWeightedGraphAlgorithms g) {
        super("save graph");
        this.Galgo = g;
        JPanel p = new JPanel();
        label = new JLabel("Name Of The New File:");
        field = new JTextField(10);
        press = new JButton("click");
        press.addActionListener(this);
        p.add(label);
        p.add(field);
        p.add(press);
        add(p);
        pack();
        setResizable(true);
        setVisible(true);
    }
    //implanting the action preformed

    //if the user press the button click then it goes to the function
    //save
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("click")) {
            save();
        }
    }
    //the function
    private void save() {
        setVisible(false);
        try {
            if (Galgo.save(field.getText())) {
                Galgo.save(field.getText());
                JOptionPane.showMessageDialog(null, "the graph was saved");
            }
            else {
                JOptionPane.showMessageDialog(null, "the graph was not saved");
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "something went wrong ");
        }
        this.dispose();
    }
}
package guigraph;
import javax.swing.*;
import api.DirectedWeightedGraphAlgorithms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loadthegraph extends JFrame implements ActionListener {
    private DirectedWeightedGraphAlgorithms G_algo;
    private JButton selector;
    private board board;
    private JLabel test;
    private JTextField name;

    //Loadthegraph constructor
    public Loadthegraph(DirectedWeightedGraphAlgorithms graphAlgo, board panel) {
        super("Load graph");
        this.G_algo = graphAlgo;
        this.board = panel;
        test = new JLabel("write path of the new graph");
        selector = new JButton("click");
        selector.addActionListener(this);
        name = new JTextField(10);
        JPanel p = new JPanel();
        p.add(test);
        p.add(name);
        p.add(selector);
        add(p);
        pack();
        setResizable(true);
        setVisible(true);
    }

    //Executes the command line after the selector is pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("click")) {
            load();
        }
    }

    //Performs a graph upload to the program
    private void load() {
        setVisible(false);
        try {
            if (G_algo.load(name.getText())) {
                board.main(G_algo.getGraph());
                board.repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "path not found");
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(),"something went wrong");
        }
        this.dispose();
    }
}

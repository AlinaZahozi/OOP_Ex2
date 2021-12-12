package guigraph;
import api.DirectedWeightedGraphAlgorithms;
import maincodes.Ex2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame extends JFrame implements ActionListener {
    private board pa;
    static JButton button;
    static JButton button1;
    static JButton button2;
    static JButton button3;
    static JButton button4;
    static JButton button5;
    private boolean needToAddNode = false;

    //frame constructor
    public frame(DirectedWeightedGraphAlgorithms a) {
        super();
        pa = new board(a.getGraph());
        buildTheMenu();
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
    }

    //A function that builds the menu
    private void buildTheMenu() {
        button = new JButton("show graph G3");
        button1 = new JButton("show graph G2");
        button2 = new JButton("show graph G1");
        button3 = new JButton("graphG1");
        button4 = new JButton("graphG2");
        button5 = new JButton("graphG3");
        button.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        JPanel p = new JPanel();
        p.add(button);
        p.add(button1);
        p.add(button2);
        p.add(button3);
        p.add(button4);
        p.add(button5);
        add(p);
    }

    //Executes the command line after the selector is pressed
    @Override
    public void actionPerformed(ActionEvent act) {
        String s = act.getActionCommand();
        if (s.equals("show graph G3")) {
            G3 m = new G3(Ex2.take_new_algo_graph("data/G3.json"));
        } else if (s.equals("show graph G2")) {
            G2 P = new G2(Ex2.take_new_algo_graph("data/G2.json"));
        } else if (s.equals("show graph G1")) {
            G1 m = new G1(Ex2.take_new_algo_graph("data/G1.json"));
        } else if (s.equals("graphG1")) {
            graphG1 m = new graphG1(Ex2.take_new_algo_graph("data/G1.json"));
        } else if (s.equals("graphG2")) {
            graphG2 m = new graphG2(Ex2.take_new_algo_graph("data/G2.json"));
        } else if (s.equals("graphG3")) {
            graphG3 m = new graphG3(Ex2.take_new_algo_graph("data/G3.json"));
        }
    }
}
package guigraph;
import api.DirectedWeightedGraphAlgorithms;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class G1 extends JFrame implements ActionListener  {
    private DirectedWeightedGraphAlgorithms Galgo;
    private board pan;
    private JMenuBar mb;
    private JMenu t;
    private JMenuItem addNode;
    private JMenuItem removeNode;
    private JMenuItem removeEdge;
    private JMenuItem connect;
    private boolean add = false;

    //G1 constructor
    public G1(DirectedWeightedGraphAlgorithms b){
        super();
        Galgo = b;
        pan = new board(b.getGraph());
        manu();
        this.add(pan);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
    }

    //A function that builds the menu
    private void manu() {
        t = new JMenu("click me for more options");
        addNode = new JMenuItem("Add Node");
        addNode.addActionListener(this);
        removeNode = new JMenuItem("Remove Node");
        removeNode.addActionListener(this);
        removeEdge = new JMenuItem("Remove Edge");
        removeEdge.addActionListener(this);
        connect = new JMenuItem("connect");
        connect.addActionListener(this);
        t.add(addNode);
        t.add(removeNode);
        t.add(removeEdge);
        t.add(connect);
        mb = new JMenuBar();
        mb.add(t);
        setJMenuBar(mb);
    }

    //Executes the command line after the selector is pressed
    @Override
    public void actionPerformed(ActionEvent act) {
        if(act.getSource() == removeNode) {
            new removethenode(Galgo.getGraph(), pan);
        }
        else if(act.getSource() == removeEdge) {
            new removetheedge(Galgo.getGraph(), pan);
        }
        else if(act.getSource() == connect){
            new connecting(Galgo.getGraph(), pan);
        }
        else if(act.getSource() == addNode){
            new AddNewNode(Galgo.getGraph(),pan);
        }
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 1400;
    final int PANEL_HEIGHT = 800;

    JPanel leftPanel;
    RightPanel rightPanel;

    JRadioButton n_2;
    JRadioButton n_1_58; // n^1.58
    JRadioButton n_mult;
    JRadioButton n_karat;

    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setLayout(new BorderLayout());

        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200, 200));
        leftPanel.setBackground(Color.blue);
        this.add(leftPanel, BorderLayout.WEST);

        rightPanel = new RightPanel();
        this.add(rightPanel, BorderLayout.EAST);

//        leftPanel.setLayout(new BoxLayout(4, 1));
        n_2 = new JRadioButton("show n^2");
        n_1_58 = new JRadioButton("show n^1.58");
        n_mult = new JRadioButton("show normal multiplication");
        n_karat = new JRadioButton("show karatsuba");

        n_2.addActionListener(this);
        n_1_58.addActionListener(this);
        n_mult.addActionListener(this);
        n_karat.addActionListener(this);

        leftPanel.add(n_2);
        leftPanel.add(n_1_58);
        leftPanel.add(n_mult);
        leftPanel.add(n_karat);
    }


    public void function(){
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

package Milestones.Milestone_2_AlexMurcia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Milestone_2 extends JFrame implements ActionListener {
    public Milestone_2(){
        super("Test Events: Files");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 600));

        JPanel mainPanel= new JPanel(new BorderLayout());


        //ComboBox-Center
        String[] fileTextNames={"java.txt", "python.txt", "c.txt"};
        JComboBox box= new JComboBox(fileTextNames);
        box.addActionListener(this);

        JPanel center= new JPanel();
        center.add(box);


        //Add main panel
        mainPanel.add(center, BorderLayout.CENTER);


        this.add(mainPanel);
        this.pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Milestone_2 m2= new Milestone_2();
    }
}
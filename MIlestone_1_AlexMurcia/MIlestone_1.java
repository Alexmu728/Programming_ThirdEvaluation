package MIlestone_1_AlexMurcia;

import javax.swing.*;
import java.awt.*;

public class MIlestone_1 extends JFrame {
    public MIlestone_1(){
        super("Try yourself");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 400));

        JPanel mainContainer= new JPanel(new BorderLayout());

        //North
        JCheckBox checkBox= new JCheckBox("Katniss");
        JCheckBox checkBox2= new JCheckBox("Peeta");

        FlowLayout flowCenter= new FlowLayout(FlowLayout.CENTER);
        JPanel north= new JPanel();
        north.setLayout(flowCenter);
        north.add(checkBox);
        north.add(checkBox2);


        //South
        JButton button= new JButton("But 1");
        JButton button2= new JButton("But 2");

        FlowLayout flowLeft= new FlowLayout(FlowLayout.LEFT);
        JPanel south= new JPanel();
        south.setLayout(flowLeft);
        south.add(button);
        south.add(button2);


        //East


        //Adding to the main container
        mainContainer.add(north, BorderLayout.NORTH);
        mainContainer.add(south, BorderLayout.SOUTH);

        this.add(mainContainer);
        this.pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        MIlestone_1 m1= new MIlestone_1();
    }
}

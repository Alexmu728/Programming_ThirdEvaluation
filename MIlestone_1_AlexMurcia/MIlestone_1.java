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

        JPanel south= new JPanel();
        south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
        south.setPreferredSize(new Dimension(0, 50));
        south.add(button);
        south.add(button2);


        //East
        JPanel east = new JPanel();
        //I took as a reference the this.setPreferredSize of the beginning
        east.setPreferredSize(new Dimension(250, 0));
        //east.setBackground(Color.BLUE);

        JRadioButton[] radioButton= new JRadioButton[3];
        for(int i=0;i<radioButton.length;i++){
            radioButton[i]= new JRadioButton("OPT "+i);
            east.add(radioButton[i]);
        }
        radioButton[0].setSelected(true);
        ButtonGroup group= new ButtonGroup();
        group.add(radioButton[0]);
        group.add(radioButton[1]);
        group.add(radioButton[2]);


        //


        //Adding to the main container
        mainContainer.add(north, BorderLayout.NORTH);
        mainContainer.add(south, BorderLayout.SOUTH);
        mainContainer.add(east, BorderLayout.EAST);

        this.add(mainContainer);
        this.pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        MIlestone_1 m1= new MIlestone_1();
    }
}

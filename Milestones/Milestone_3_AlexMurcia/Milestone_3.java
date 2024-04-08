package Milestones.Milestone_3_AlexMurcia;

import javax.swing.*;
import java.awt.*;

public class Milestone_3 extends JFrame {
    public Milestone_3(){
        super("Swing - Example 2");
        String password = JOptionPane.showInputDialog("Input password");
        if(password.equals("damocles")){
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setPreferredSize(new Dimension(600, 600));

            JPanel mainPanel= new JPanel(new BorderLayout());

            //North
            JPanel north= new JPanel(new FlowLayout(FlowLayout.LEFT));

            String[] images={"spiderman.jpg", "tlou.jpg", "httyd.jpg"};
            JComboBox box= new JComboBox(images);

            box.setPreferredSize(new Dimension(225, 50));

            north.add(box);




            //Add main panel
            mainPanel.add(north, BorderLayout.NORTH);


            this.add(mainPanel);
            this.pack();
            setVisible(true);
        }else{
            setVisible(false);
            dispose();
        }

    }


    public static void main(String[] args) {
        Milestone_3 m3= new Milestone_3();
    }
}

package Milestones.Milestone_3_AlexMurcia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

            String[] images={"spiderman.jpg", "tlou.jfif", "httyd.jpg"};
            JComboBox box= new JComboBox(images);

            box.setPreferredSize(new Dimension(225, 50));

            /*box.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });*/

            north.add(box);

            //Center
            JPanel center= new JPanel(new FlowLayout(FlowLayout.LEFT));

            JLabel image= new JLabel();

            JCheckBox saveComment= new JCheckBox("Save your comment");


            center.add(image);
            center.add(saveComment);

            //East
            JPanel east= new JPanel(new FlowLayout(FlowLayout.TRAILING));

            JTextField comment= new JTextField();

            comment.setPreferredSize(new Dimension(200, 30));

            east.add(comment);

            //Add main panel
            mainPanel.add(north, BorderLayout.NORTH);
            mainPanel.add(center, BorderLayout.CENTER);
            mainPanel.add(east, BorderLayout.EAST);

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

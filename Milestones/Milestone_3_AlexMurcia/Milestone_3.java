package Milestones.Milestone_3_AlexMurcia;

import javax.swing.*;
import java.awt.*;

public class Milestone_3 extends JFrame {
    public Milestone_3(){
        super("Swing - Example 2");
        String password= JOptionPane.showInputDialog("Input password");
        if(password.equals("damocles")) {
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setPreferredSize(new Dimension(600, 600));


        }else{
            setVisible(false);
            dispose();
        }
        this.pack();
        setVisible(true);
    }


    public static void main(String[] args) {
        Milestone_3 m3= new Milestone_3();
    }
}

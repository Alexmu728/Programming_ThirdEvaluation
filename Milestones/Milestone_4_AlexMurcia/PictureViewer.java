package Milestones.Milestone_4_AlexMurcia;

import javax.swing.*;
import java.awt.*;

public class PictureViewer extends JFrame {
    public PictureViewer() {
        super("Photography");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 300));


        this.pack();
        setVisible(true);
    }


    public static void main(String[] args) {
        PictureViewer pv= new PictureViewer();
    }
}

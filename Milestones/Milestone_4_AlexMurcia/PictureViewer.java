package Milestones.Milestone_4_AlexMurcia;

import javax.swing.*;
import java.awt.*;

public class PictureViewer extends JFrame {
    public PictureViewer() {
        super("Photography");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 300));

        //Grid layout
        JPanel grid1= new JPanel(new GridLayout(2, 2));

        //Area 1
        JComboBox<Photographer>

        this.add(grid1);
        this.pack();
        setVisible(true);
    }


    public static void main(String[] args) {
        PictureViewer pv= new PictureViewer();
    }
}

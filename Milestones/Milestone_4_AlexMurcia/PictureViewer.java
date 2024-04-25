package Milestones.Milestone_4_AlexMurcia;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PictureViewer extends JFrame {
    public PictureViewer() {
        super("Photography");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 300));

        //Grid layout
        JPanel grid1= new JPanel(new GridLayout(2, 2));

        //Area 1
        JLabel comboName= new JLabel("Photographer: ");
        JComboBox<Photographer> comboBox= new JComboBox<>();

        //Area 2
        JLabel dateName= new JLabel("Photos after");
        JXDatePicker date=new JXDatePicker();

        //Area 3
        JList<Picture> list = new JList<>();



        //Adding to grid layout
        grid1.add(comboName);
        grid1.add(comboBox);
        grid1.add(dateName);
        grid1.add(date);


        this.add(grid1);
        this.pack();
        setVisible(true);
    }


    public static void main(String[] args) {
        PictureViewer pv= new PictureViewer();
    }
}

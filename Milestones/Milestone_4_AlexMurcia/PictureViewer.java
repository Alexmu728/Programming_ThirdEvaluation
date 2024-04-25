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
        JPanel area1= new JPanel();
        JLabel comboName= new JLabel("Photographer: ");
        JComboBox<Photographer> comboBox= new JComboBox<>();

        area1.add(comboName);
        area1.add(comboBox);

        //Area 2
        JPanel area2= new JPanel();
        JLabel dateName= new JLabel("Photos after");
        JXDatePicker date=new JXDatePicker();

        area2.add(dateName);
        area2.add(date);

        //Area 3
        JPanel area3= new JPanel();
        //Picture names[] = {"image/anseldams1.jps"};
        JList<Picture> list = new JList<>();


        area3.add(list);

        //Area 4
        JPanel area4= new JPanel();
        JLabel image= new JLabel();

        area4.add(image);


        //Adding to grid layout
        grid1.add(area1);
        grid1.add(area2);
        grid1.add(area3);
        grid1.add(area4);

        this.add(grid1);
        this.pack();
        setVisible(true);
    }


    public static void main(String[] args) {
        PictureViewer pv= new PictureViewer();
    }
}

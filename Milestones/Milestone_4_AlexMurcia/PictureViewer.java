package Milestones.Milestone_4_AlexMurcia;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class PictureViewer extends JFrame implements ItemListener {
    private JXDatePicker date;

    DB_Connection dl= new DB_Connection();

    public PictureViewer() {
        super("Photography");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 300));

        //Grid layout
        JPanel grid1= new JPanel(new GridLayout(2, 2));

        //Area 1
        JPanel area1= new JPanel();
        JLabel comboName= new JLabel("Photographer: ");


        ArrayList<Photographer> photographerList= dl.photographers();

        DefaultComboBoxModel<Photographer> model= new DefaultComboBoxModel<>();
        model.addAll(photographerList);

        JComboBox<Photographer> comboBox= new JComboBox<>(model);
        comboBox.setSelectedIndex(0);

        /*for(Photographer photographer : photographerList){
            comboBox.addItem(photographer);
        }*/

        area1.add(comboName);
        area1.add(comboBox);

        //Area 2
        JPanel area2= new JPanel();
        JLabel dateName= new JLabel("Photos after");
        date=new JXDatePicker();

        date.addActionListener();

        area2.add(dateName);
        area2.add(date);

        //Area 3
        JPanel area3= new JPanel();

        ArrayList<Picture> pictures= dl.pictures();

        DefaultListModel<Picture> listModel= new DefaultListModel<>();

        listModel.addAll(pictures);

        JList<Picture> list = new JList<>(listModel);
        list.setPreferredSize(new Dimension(290,130));

        JScrollPane scroll= new JScrollPane(list);

        scroll.setPreferredSize(new Dimension(290, 130));

        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        area3.add(scroll);

        //Area 4
        JPanel area4= new JPanel();
        JLabel image= new JLabel();

        area4.add(image);


        //Adding to grid layout
        grid1.add(area1);
        grid1.add(area2);
        grid1.add(area3);
        grid1.add(area4);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dl.close();
            }
        });

        this.add(grid1);
        this.pack();
        setVisible(true);
    }

    public JXDatePicker getDate() {
        return date;
    }

    public static void main(String[] args) {
        PictureViewer pv= new PictureViewer();
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {

    }
}

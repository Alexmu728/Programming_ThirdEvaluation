package Milestones.Milestone_5_AlexMurcia;

import Milestones.Milestone_4_AlexMurcia.DB_Connection;
import Milestones.Milestone_4_AlexMurcia.Photographer;
import Milestones.Milestone_4_AlexMurcia.Picture;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class PictureViewer extends JFrame implements ActionListener {
    private JXDatePicker date;
    private JComboBox<Milestones.Milestone_4_AlexMurcia.Photographer> comboBox;
    private Milestones.Milestone_4_AlexMurcia.Photographer selectedPhoto;

    Milestones.Milestone_4_AlexMurcia.DB_Connection dl= new DB_Connection();

    public PictureViewer() {
        super("Photography");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 300));

        //Grid layout
        JPanel grid1= new JPanel(new GridLayout(2, 2));

        //Area 1
        JPanel area1= new JPanel();
        JLabel comboName= new JLabel("Photographer: ");


        ArrayList<Milestones.Milestone_4_AlexMurcia.Photographer> photographerList= dl.photographers();

        DefaultComboBoxModel<Milestones.Milestone_4_AlexMurcia.Photographer> model= new DefaultComboBoxModel<>();
        model.addAll(photographerList);

        comboBox= new JComboBox<>(model);
        comboBox.setSelectedIndex(0);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedPhoto= (Photographer) comboBox.getSelectedItem();
                System.out.println(selectedPhoto);
            }
        });


        area1.add(comboName);
        area1.add(comboBox);

        //Area 2
        JPanel area2= new JPanel();
        JLabel dateName= new JLabel("Photos after");
        date=new JXDatePicker();


        //Area 3
        JPanel area3= new JPanel();

        ArrayList<Milestones.Milestone_4_AlexMurcia.Picture> pictures= dl.pictures();

        DefaultListModel<Milestones.Milestone_4_AlexMurcia.Picture> listModel= new DefaultListModel<>();

        listModel.addAll(pictures);

        JList<Milestones.Milestone_4_AlexMurcia.Picture> list = new JList<>(listModel);
        list.setPreferredSize(new Dimension(290,130));

        JScrollPane scroll= new JScrollPane(list);

        scroll.setPreferredSize(new Dimension(290, 130));

        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        //if a date is selected before a Photographer, it may show an error, but it keeps working
        date.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Date picker=date.getDate();
                System.out.println(picker);
                listModel.clear();

                Iterator<Milestones.Milestone_4_AlexMurcia.Picture> picIterator=pictures.iterator();
                while(picIterator.hasNext()){
                    Milestones.Milestone_4_AlexMurcia.Picture picture= picIterator.next();
                    if(picture.getDate().after(picker) && picture.getPhotographerId()== selectedPhoto.getPhotographerId()){
                        listModel.addElement(picture);
                    }
                }
            }
        });
        area2.add(dateName);
        area2.add(date);

        area3.add(scroll);

        //Area 4
        JPanel area4= new JPanel();
        JLabel image= new JLabel();

        image.setPreferredSize(new Dimension(290, 130));

        area4.add(image);


        list.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if(mouseEvent.getClickCount()==2){
                    Picture selectedPic=list.getSelectedValue();

                    String path=selectedPic.getFile();
                    ImageIcon imageIcon= new ImageIcon(path);

                    Image images= imageIcon.getImage().getScaledInstance(image.getWidth(), image
                            .getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon imageIcon2= new ImageIcon(images);

                    dl.incrementVisits(selectedPic);

                    image.setIcon(imageIcon2);
                }

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }

        });


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


    public static void main(String[] args) {
        PictureViewer pv= new PictureViewer();
    }

    /*public void incrementVisits(Picture p){
        if()
    }*/

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

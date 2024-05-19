package Milestones.Milestone_5_AlexMurcia;

import Milestones.Milestone_5_AlexMurcia.DB_Connection;
import Milestones.Milestone_5_AlexMurcia.Photographer;
import Milestones.Milestone_5_AlexMurcia.Picture;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class PictureViewer extends JFrame implements ActionListener {
    private JXDatePicker date;
    private JComboBox<Photographer> comboBox;
    private Photographer selectedPhoto;

    DB_Connection dl= new DB_Connection();

    public PictureViewer() {
        super("Photography");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 350));

        //Grid layout
        JPanel grid1= new JPanel(new GridLayout(3, 2));


        //Area 1
        JPanel area1= new JPanel();
        JButton award= new JButton("AWARD");
        award.setPreferredSize(new Dimension(290, 100));

        area1.add(award);

        //Area 2
        JPanel area2= new JPanel();
        JButton remove= new JButton("REMOVE");
        remove.setPreferredSize(new Dimension(290, 100));

        area2.add(remove);


        //Area 3
        JPanel area3= new JPanel();
        JLabel comboName= new JLabel("Photographer: ");


        ArrayList<Photographer> photographerList= dl.photographers();

        DefaultComboBoxModel<Milestones.Milestone_5_AlexMurcia.Photographer> model= new DefaultComboBoxModel<>();
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


        area3.add(comboName);
        area3.add(comboBox);

        //Area 4
        JPanel area4= new JPanel();
        JLabel dateName= new JLabel("Photos after");
        date=new JXDatePicker();


        //Area 5
        JPanel area5= new JPanel();

        ArrayList<Picture> pictures=dl.pictures();

        DefaultListModel<Picture> listModel= new DefaultListModel<>();

        listModel.addAll(pictures);

        JList<Picture> list = new JList<>(listModel);
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

                Iterator<Picture> picIterator=pictures.iterator();
                while(picIterator.hasNext()){
                    Picture picture= picIterator.next();
                    if(picture.getDate().after(picker) && picture.getPhotographerId()== selectedPhoto.getPhotographerId()){
                        listModel.addElement(picture);
                    }
                }
            }
        });
        area4.add(dateName);
        area4.add(date);

        area5.add(scroll);

        //Area 6
        JPanel area6= new JPanel();
        JLabel image= new JLabel();

        image.setPreferredSize(new Dimension(290, 130));

        area6.add(image);


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

                    image.setIcon(imageIcon2);

                    dl.incrementVisits(selectedPic);

                    HashMap<Integer, Integer> map= dl.createVisitsMap();
                    System.out.println(map);
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
        grid1.add(area5);
        grid1.add(area6);

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

package Milestones.Milestone_3_AlexMurcia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

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


            String[] images={"spiderman.jpg", "httyd.jpg", "tlou.jfif"};
            JComboBox <String> box= new JComboBox<>(images);
            box.setPreferredSize(new Dimension(225, 50));
           // load_combo(box);


            //Center
            JPanel center= new JPanel(new FlowLayout(FlowLayout.LEFT));

            JLabel image= new JLabel();

            JCheckBox saveComment= new JCheckBox("Save your comment");


            center.add(image);
            center.add(saveComment);



            box.addActionListener(new ComboListener(box, image));

            north.add(box);

            //East
            JPanel east= new JPanel(new FlowLayout(FlowLayout.TRAILING));

            JTextField comment= new JTextField();

            comment.setPreferredSize(new Dimension(200, 30));


            east.add(comment);


            //South
            JPanel south= new JPanel();

            JButton save= new JButton("Save");
            save.addActionListener();

            south.add(save);

            //Add main panel
            mainPanel.add(north, BorderLayout.NORTH);
            mainPanel.add(center, BorderLayout.CENTER);
            mainPanel.add(east, BorderLayout.EAST);
            mainPanel.add(south, BorderLayout.SOUTH);

            this.add(mainPanel);
            this.pack();
            setVisible(true);


        }else{
            setVisible(false);
            dispose();
        }

    }

    /*public void load_combo(JComboBox<String> box){
        String path="images";
        System.out.println("Loading images from: " + path); // Diagnostic
        File folder= new File(path);
        if(folder.exists()){
            File[] files = folder.listFiles();
            if(files != null){
                Iterator<File> fileIterator= Arrays.asList(files).iterator();
                while(fileIterator.hasNext()){
                    File file= fileIterator.next();
                    if(file.isFile()){
                        System.out.println("Adding file to combo: " + file.getName()); // Diagnostic
                        box.addItem(file.getName());
                    }
                }
            } else {
            System.out.println("No files found in directory."); // Diagnostic
        }
    } else {
        System.out.println("Directory not found."); // Diagnostic
        }
    }
*/

    public static void main(String[] args) {
        Milestone_3 m3= new Milestone_3();
    }
}

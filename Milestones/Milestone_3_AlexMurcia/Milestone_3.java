package Milestones.Milestone_3_AlexMurcia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Milestone_3 extends JFrame {
    public Milestone_3(){
        super("Swing - Example 2");
        String password = JOptionPane.showInputDialog("Input password");
        if(password.equals("damocles")){
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setPreferredSize(new Dimension(400, 400));

            JPanel mainPanel= new JPanel(new BorderLayout());

            //North
            JPanel north= new JPanel(new FlowLayout(FlowLayout.LEFT));


            String[] images={"spiderman.jpg", "httyd.jpg", "tlou.jfif"};
            JComboBox <String> box= new JComboBox<>(images);
            box.setPreferredSize(new Dimension(225, 50));

           // load_combo(box);


            //Center
            JPanel center= new JPanel(new BorderLayout());

            JLabel image= new JLabel();

            JCheckBox saveComment= new JCheckBox("Save your comment");


            center.add(image, BorderLayout.CENTER);
            center.add(saveComment, BorderLayout.SOUTH);



            box.addActionListener(new ComboListener(box, image));

            north.add(box);

            //East
            JPanel east= new JPanel(new BorderLayout());

            JTextField comment= new JTextField();

            comment.setPreferredSize(new Dimension(200, 30));


            east.add(comment, BorderLayout.SOUTH);


            //South
            JPanel south= new JPanel();

            JButton save= new JButton("Save");
            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String image= (String) box.getSelectedItem();

                    if(saveComment.isSelected()){
                        String Comment = comment.getText();

                        if(!Comment.isEmpty()){
                            String fileName= image+".txt";

                            try{
                                BufferedWriter bw= new BufferedWriter(new FileWriter(fileName));
                                bw.write(Comment);
                                bw.newLine();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            });

            south.add(save);

            //Add main panel
            mainPanel.add(north, BorderLayout.NORTH);
            mainPanel.add(center, BorderLayout.CENTER);
            mainPanel.add(east, BorderLayout.EAST);
            mainPanel.add(south, BorderLayout.SOUTH);

            this.add(mainPanel);
            this.pack();
            setVisible(true);

            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Bye!");
                }
            });

        }else{
            setVisible(false);
            dispose();
        }

    }

    /*public void load_combo(JComboBox<String> box){
        String path="images";
        File folder= new File(path);
        if(folder.exists()){
            File[] files = folder.listFiles();
            if(files != null){
                Iterator<File> fileIterator= Arrays.asList(files).iterator();
                while(fileIterator.hasNext()){
                    File file= fileIterator.next();
                    if(file.isFile()){
                        box.addItem(file.getName());
                    }
                }
            }
        }
*/

    public static void main(String[] args) {
        Milestone_3 m3= new Milestone_3();
    }
}

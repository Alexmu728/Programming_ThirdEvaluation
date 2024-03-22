package Milestones.Milestone_2_AlexMurcia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Milestone_2 extends JFrame implements ActionListener {
    private JTextArea text;
    public Milestone_2(){
        super("Test Events: Files");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 600));

        JPanel mainPanel= new JPanel(new BorderLayout());


        //ComboBox-Center
        JPanel center= new JPanel();

        String[] fileTextNames={"java.txt", "python.txt", "c.txt"};
        JComboBox box= new JComboBox(fileTextNames);
        box.addActionListener(this);

        box.setPreferredSize(new Dimension(250, 25));

        JButton clear= new JButton("Clear");

        center.add(box);
        center.add(clear);

        //TextArea East
        JPanel east= new JPanel();

        text= new JTextArea();
        JScrollPane scroll= new JScrollPane(text);

        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(400, 500));

        east.add(scroll);


        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
            }
        });


        //Close button south
        JPanel south= new JPanel();

        JButton close= new JButton("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });

        south.add(close);


        //Add main panel
        mainPanel.add(center, BorderLayout.CENTER);
        mainPanel.add(east, BorderLayout.EAST);
        mainPanel.add(south, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox= (JComboBox) e.getSource();
        String fileName= (String) comboBox.getSelectedItem();
        try{
            File file= new File(fileName);
            BufferedReader br= new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!= null){
                text.append(line);
            }
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "File not found","Error message", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Milestone_2 m2= new Milestone_2();
    }
}

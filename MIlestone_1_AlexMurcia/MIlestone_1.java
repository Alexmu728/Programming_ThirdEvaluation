package MIlestone_1_AlexMurcia;

import javax.swing.*;
import java.awt.*;

public class MIlestone_1 extends JFrame {
    public MIlestone_1(){
        super("Try yourself");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 400));

        JPanel mainContainer= new JPanel(new BorderLayout());

        //North
        JCheckBox checkBox= new JCheckBox("Katniss");
        JCheckBox checkBox2= new JCheckBox("Peeta");

        JPanel north= new JPanel();
        north.add(checkBox);
        north.add(checkBox2);

        mainContainer.add(north, BorderLayout.NORTH);


        this.add(mainContainer);
        this.pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        MIlestone_1 m1= new MIlestone_1();
    }
}

package Milestones.Milestone_3_AlexMurcia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboListener implements ActionListener {
    private JComboBox box;
    private JLabel image;

    public ComboListener(JComboBox box, JLabel image){
        this.box=box;
        this.image=image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Image= (String) box.getSelectedItem();
        ImageIcon icon= new ImageIcon(Image);
        image.setIcon(icon);
    }
}

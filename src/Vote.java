import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by zied on 23/01/18.
 */
public class Vote extends JFrame implements ActionListener {

    private int choix;

    public int getChoix() {
        return choix;
    }

    JButton SUBMIT;
    JPanel panel;
    ButtonGroup group;
    JRadioButton un, deux;
    public Vote(){


        SUBMIT=new JButton("SUBMIT");

        panel=new JPanel(new GridLayout(3,1));

         group = new ButtonGroup();
        un = new JRadioButton("Choix 1");
        un.setActionCommand("l'action");
        un.setSelected(false);

        deux = new JRadioButton("Choix 2");
        deux.setActionCommand("l'action");
        deux.setSelected(false);

        group.add(un);
        group.add(deux);
        panel.add(un);
        panel.add(deux);
        panel.add(SUBMIT);
        add(panel,BorderLayout.CENTER);
        SUBMIT.addActionListener(this);
        this.setSize(200,200);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean choix1 = un.isSelected();
        boolean choix2 = deux.isSelected();
        choix=-1;
        if(choix1) choix = 0;
        if (choix2) choix =1;
        System.out.println(choix);
        dispose();
    }
}

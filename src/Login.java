import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zied on 23/01/18.
 */
class Login extends JFrame implements ActionListener
    {
        JButton SUBMIT;
        JPanel panel;
        JLabel label1,label2,label3;
        final JTextField  text1,text2,text3;
        Login()
        {
            label1 = new JLabel();
            label1.setText("Username:");
            text1 = new JTextField(15);

            label2 = new JLabel();
            label2.setText("Id:");
            text2 = new JTextField(15);

            label3 = new JLabel();
            label3.setText("Password:");
            text3 = new JPasswordField(15);

            SUBMIT=new JButton("SUBMIT");

            panel=new JPanel(new GridLayout(4,1));
            panel.add(label1);
            panel.add(text1);
            panel.add(label2);
            panel.add(text2);
            panel.add(label3);
            panel.add(text3);
            panel.add(SUBMIT);
            add(panel,BorderLayout.CENTER);
            SUBMIT.addActionListener(this);
            setTitle("LOGIN FORM");
            this.setSize(300,100);
            this.setVisible(true);
        }
        public void actionPerformed(ActionEvent e)
        {
            String value1=text1.getText();
            String value2=text2.getText();
            String value3=text3.getText();
            int id=Integer.parseInt(value2);
            if (value1.equals(Main.L.get(id).getLogin()) && value3.equals(Main.L.get(id).getPwd()) ) {
                //System.out.println("ok");

            Vote vote = new Vote(value1,value3,id);
                this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dispose();

            }
            else{
                System.out.println("enter the valid username and password");
                JOptionPane.showMessageDialog(this,"Incorrect login or password",
                        "Error",JOptionPane.ERROR_MESSAGE);
            }
        }

    }


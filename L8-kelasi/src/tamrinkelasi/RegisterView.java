package tamrinkelasi;

import tamrinkelasi.model.UserEnti;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JDialog{
    private JTextField usertxt;
    private JTextField passtxt;
    private JButton loginButton;
    private JButton cancleButton;
    private JPanel registerPanel;


    public RegisterView(JFrame frame){
        super(frame);
        setTitle("enter username & password");
        setContentPane(registerPanel);
        setSize(520,480);
        setModal(true);
        setLocationRelativeTo(frame);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserEnti enti = new UserEnti();
                enti.setUsername("ek");
                enti.setPassword("1234");

                if( enti.getPassword().equals(passtxt.getText()) && enti.getUsername().equals(usertxt.getText()))
                {
                    System.out.println("ok...login");
                    InfoForm infoForm = new InfoForm(null);
                    dispose();
                }else {
                    System.out.println("invalid username or password");
                }

            }
        });

        cancleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("exit..end");
                dispose();
            }
        });


        setVisible(true);
    }

}

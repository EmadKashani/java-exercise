package tamrin2;

import tamrin2.model.UserEnti;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JDialog{
    private JTextField usertxt;
    private JTextField passtxt;
    private JButton loginButton;
    private JButton cancelButton;
    private JPanel registerPanel;


    public RegisterForm(JFrame jFrame){
        super(jFrame);
        setTitle("enter username & password");
        setContentPane(registerPanel);
        setSize(520,480);
        setModal(true);
        setLocationRelativeTo(jFrame);


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("exit...end");
                dispose();
            }
        });


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserEnti enti = new UserEnti();
                enti.setUsername("ek");
                enti.setPassword("1234");
                if(enti.getUsername().equals(usertxt.getText()) && enti.getPassword().equals(passtxt.getText())){
                    System.out.println("ok...login");
                    InfoForm infoForm = new InfoForm(null);
                    dispose();
                }else {
                    System.out.println("invalid username or password");
                }

            }
        });


        setVisible(true);

    }

}

package hotel.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckForm extends JDialog{
    private JButton informationButton;
    private JButton reserveButton;
    private JPanel CheckPanel;
    private JButton CancelButton;


    public CheckForm(JFrame jFrame){
        super(jFrame);
        setTitle("WELCOME TO HOTEL");
        setContentPane(CheckPanel);
        setSize(520,480);
        setModal(true);
        setLocationRelativeTo(jFrame);


        //employee information
        informationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterForm registerForm = new RegisterForm(null);
            }
        });

        //Reserve a room
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReserveInfoForm reserveInfoForm = new ReserveInfoForm(null);
            }
        });



        CancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

}

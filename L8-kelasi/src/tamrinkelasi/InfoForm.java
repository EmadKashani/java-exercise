package tamrinkelasi;

import tamrinkelasi.model.UserEnti;
import tamrinkelasi.model.UserServ;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InfoForm extends JDialog{
    private JButton addButton;
    private JTextField nametxt;
    private JTextField emailtxt;
    private JPanel infoPAnel;


    InfoForm(JFrame jFrame){
        super(jFrame);
        setTitle("enter your information");
        setContentPane(infoPAnel);
        setSize(650,520);
        setModal(true);
        setLocationRelativeTo(jFrame);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                UserEnti userEnti = new UserEnti();
                try {
                    UserServ.getInstance().save(new UserEnti().setId(1).setName(nametxt.getText()).setEmail(emailtxt.getText()).setUsername(userEnti.getUsername()));
                }catch (Exception e1){
                    System.out.println("fail to save "+e1.getMessage());
                }

                System.out.println("result=");
                try {
                    List<UserEnti> personList = UserServ.getInstance().report ();
                    for (UserEnti personEnti : personList) {
                        System.out.println(personEnti.getId());
                        System.out.println(personEnti.getName());
                        System.out.println(personEnti.getEmail());
                        System.out.println(personEnti.getUsername());
                    }
                }
                catch (Exception m){
                    System.out.println ("Fail to report!"+m.getMessage ());
                }


            }
        });

        setVisible(true);
    }

}

package tamrin1;

import tamrin1.model.Entity;
import tamrin1.model.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {
    private JButton okButton;
    private JPanel mainPanel;
    private JTextField fname;
    private JTextField lname;
    private JTextField univ;
    private JTextField educ;


    public MainFrame(){
        setContentPane(mainPanel);
        setTitle("Form");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Service.getInstance().save(new Entity().setId(1).setFirstName(fname.getText()).setLastName(lname.getText()).setUniversity(univ.getText()).setEducation(educ.getText()));
                    System.out.println("saved...");
                }catch (Exception h){
                    System.out.println("fail to save..."+h.getMessage());
                }

                System.out.println("result=");
                try {
                    List<Entity> personList = Service.getInstance().report ();
                    for (Entity personEnti : personList) {
                        System.out.println(personEnti.getId());
                        System.out.println(personEnti.getFirstName());
                        System.out.println(personEnti.getLastName());
                        System.out.println(personEnti.getUniversity());
                        System.out.println(personEnti.getEducation());
                    }
                }
                catch (Exception m){
                    System.out.println ("Fail to report!"+m.getMessage ());
                }
            }
        });
    }

}

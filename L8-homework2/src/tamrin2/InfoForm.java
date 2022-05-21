package tamrin2;

import tamrin2.model.UserEnti;
import tamrin2.model.UserServ;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InfoForm extends JDialog{
    private JTextField txtname;
    private JTextField txtage;
    private JTextField txtuser;
    private JTextField txtpass;
    private JButton addButton;
    private JButton cancelButton;
    private JPanel infoPanel;


    public InfoForm(JFrame frame){
        super(frame);
        setTitle("edit your information");
        setContentPane(infoPanel);
        setSize(620,500);
        setModal(true);
        setLocationRelativeTo(frame);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("add");
                try{
                    UserServ.getInstance().edit(new UserEnti().setId(1).setName(txtname.getText()).setAge(txtage.getColumns()).setUsername(txtuser.getText()).setPassword(txtpass.getText()));
                    System.out.println("edited...");
                }catch (Exception m){
                    System.out.println("fail to edit..."+m.getMessage());
                }

                System.out.println("result=");
                try {
                    List<UserEnti> personList = UserServ.getInstance().report ();
                    for (UserEnti personEnti : personList) {
                        System.out.println(personEnti.getId());
                        System.out.println(personEnti.getName());
                        System.out.println(personEnti.getAge());
                        System.out.println(personEnti.getUsername());
                        System.out.println(personEnti.getPassword());
                    }
                }
                catch (Exception h){
                    System.out.println ("Fail to report!"+h.getMessage ());
                }

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cancel edit");
                dispose();
            }
        });

        setVisible(true);
    }

}

package hotel.view;

import hotel.employee.EmployeeEnti;
import hotel.employee.EmployeeServ;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InfoEmpForm extends JDialog{
    private JTextField nametxt;
    private JTextField nationtxt;
    private JTextField phonetxt;
    private JTextField addresstxt;
    private JTextField positiontxt;
    private JTextField incometxt;
    private JButton cancelButton;
    private JButton applyButton;
    private JPanel InfoEmpPanel;

    PreparedStatement preparedStatement;
    Connection connection;
    RegisterForm register;

    public InfoEmpForm(JFrame jFrame2){
        super(jFrame2);
        setTitle("enter your information");
        setContentPane(InfoEmpPanel);
        setSize(650,500);
        setModal(true);
        setLocationRelativeTo(jFrame2);


        //save,edit,delete information
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nationalcode = nationtxt.getText();
                Integer nationC = Integer.valueOf(nationalcode);

                String EmpInc = incometxt.getText();
                Integer IncEmp = Integer.valueOf(EmpInc);

                try {
                    EmployeeServ.getInstance().edit(new EmployeeEnti().setFullName(nametxt.getText()).setIdNumber(nationC).setPhoneNumber(phonetxt.getText()).setPlace(positiontxt.getText()).setAddress(addresstxt.getText()).setSalary(IncEmp));
                }catch (Exception h){
                    System.out.println("fail to insert from view..."+h.getMessage());
                }
                JOptionPane.showMessageDialog(null,"Mission Accomplished","successful",JOptionPane.QUESTION_MESSAGE);
                dispose();
            }
        });


        //cancel
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        setVisible(true);
    }
}

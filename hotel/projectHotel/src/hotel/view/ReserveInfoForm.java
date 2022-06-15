package hotel.view;

import hotel.passengers.PassengersEntity;
import hotel.rooms.RoomEnti;
import hotel.rooms.RoomRepo;
import hotel.rooms.RoomServ;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReserveInfoForm extends JDialog{
    private JComboBox capacitytxt;
    private JTextField daytxt;
    private JComboBox roomtypetxt;
    private JComboBox roomviewtxt;
    private JButton cancelButton;
    private JButton applyButton;
    private JPanel ReserveInfoPanel;

    public ReserveInfoForm(JFrame jFrame3){
        super(jFrame3);
        setTitle("Enter your room information");
        setContentPane(ReserveInfoPanel);
        setSize(620,500);
        setModal(true);
        setLocationRelativeTo(jFrame3);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //apply room info
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer capacity = Integer.valueOf(String.valueOf(capacitytxt.getSelectedItem()));
                String type = String.valueOf(roomtypetxt.getSelectedItem());
                String view = String.valueOf(roomviewtxt.getSelectedItem());
                Integer stayday = Integer.valueOf(daytxt.getText());

                RoomEnti Enti = new RoomEnti(type,view,capacity);

                try {
                    List<RoomEnti> roomEntiList = RoomServ.getInstance().report();
                    for (RoomEnti roomEnti :roomEntiList){
                        System.out.println("id= "+ roomEnti.getId());
                        System.out.println("code= "+ roomEnti.getCode());
                        System.out.println("type = "+ roomEnti.getType());
                        System.out.println("passengers number = "+ roomEnti.getNumber());
                        System.out.println("facilities = "+ roomEnti.getFacilities());
                        System.out.println("salary = "+ roomEnti.getSalary() +'\n');
                        int fullmoney = roomEnti.getSalary()*stayday;
                        System.out.println("your full price = "+fullmoney);
                        System.out.println("your minimum  pay = "+fullmoney/5);
                        PassengersEntity entity = new PassengersEntity(fullmoney , stayday , roomEnti.getNumber());
                    }
                }catch (Exception p){
                    System.out.println("fail to report..."+p.getMessage());

                }

                CheckInForm checkInForm=new CheckInForm(null);
                dispose();
            }
        });

        //cancel room
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}

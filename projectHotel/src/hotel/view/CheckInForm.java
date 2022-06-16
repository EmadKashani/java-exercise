package hotel.view;

import hotel.main.HotelMoney;
import hotel.passengers.PassengersEntity;
import hotel.passengers.PassengersService;
import hotel.reserveRooms.RREntity;
import hotel.reserveRooms.RRService;
import hotel.rooms.RoomEnti;
import hotel.rooms.RoomServ;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CheckInForm extends JDialog{
    private JComboBox nationtxt;
    private JTextField nametxt;
    private JTextField napasstxt;
    private JTextField phonetxt;
    private JTextField costtxt;
    private JButton cancelButton;
    private JButton applyButton;
    private JPanel CheckInPanel;

    public CheckInForm(JFrame jFrame5){

        super(jFrame5);
        setTitle("edit your information");
        setContentPane(CheckInPanel);
        setSize(620,500);
        setModal(true);
        setLocationRelativeTo(jFrame5);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //apply check in and pay
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PassengersEntity passengers = new PassengersEntity();


                Integer money = Integer.valueOf(costtxt.getText());


              if (money<=passengers.getFullprice() && money>=(20*passengers.getFullprice())/100 ){
                  JOptionPane.showMessageDialog(null,"Mission Accomplished","successful",JOptionPane.QUESTION_MESSAGE);
                  try {
                      PassengersService.getInstance().save(new PassengersEntity().setFullnamep(nametxt.getText()).setMelicode(napasstxt.getText()).setPhonenum(phonetxt.getText()).setAdvancepay(money));
                  }catch (Exception b){
                      System.out.println("fail to save passenger..."+b.getMessage());
                  }

                  try {
                      RRService.RRSGetInstance().rRSave(new RREntity().setpFullName(nametxt.getText()).setNationalCode(napasstxt.getText()).setMobileNo(phonetxt.getText()).setInitialPay(money));
                  }catch (Exception d){
                      System.out.println("fail to save reserve"+d.getMessage());
                  }

                  try {
                      RREntity renti =new RREntity();
                      RoomServ.getInstance().remove(renti.getRoomNo());
                  }catch (Exception v){
                      System.out.println("fail to delete"+v.getMessage());
                  }


                  HotelMoney hotelMoney = new HotelMoney();
                  hotelMoney.setIncome(hotelMoney.getIncome()+money -(80000+50000+40000+25000+15000));
                  System.out.println("Hotel income is :"+hotelMoney.getIncome());


                  dispose();
              }else {
                  JOptionPane.showMessageDialog(null, "Money Is Not Matched ", "error", JOptionPane.ERROR_MESSAGE);
              }

            }
        });

        //cancel check in
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}

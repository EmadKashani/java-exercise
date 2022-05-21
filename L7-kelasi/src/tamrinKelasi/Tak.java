package tamrinKelasi;

import tamrinKelasi.model.entity.UserEnti;
import tamrinKelasi.model.service.UserServ;

import java.util.List;
import java.util.Scanner;

public class Tak {

    public static void main(String[] args) {

        UserEnti ueti = new UserEnti();

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter your username=");
        String uName = scanner.nextLine();
        System.out.println("enter your password=");
        String pWord = scanner.nextLine();

        try{
            UserServ.getInstance().save(new UserEnti(). setId(1).setName("emad").setEmail("emad@gmail.com").setUsername("ek").setPassword("1234"));
        }catch (Exception e){
            System.out.println("fail to save..."+e.getMessage());
        }

        try {
            if (uName.equals("ek") && pWord.equals("1234")) {
                List<UserEnti> userEntiList = UserServ.getInstance().report();
                for (UserEnti userEnti : userEntiList){
                    System.out.println(userEnti.getId());
                    System.out.println(userEnti.getName());
                    System.out.println(userEnti.getEmail());
                    System.out.println(userEnti.getUsername());
                }
            } else {
                System.out.println("invalid username or password");
            }
        }catch (Exception e){
            System.out.println("error..."+e.getMessage());
        }


        //if (ueti.getUsername().equals(uName) && ueti.getPassword().equals(pWord))
    }
}

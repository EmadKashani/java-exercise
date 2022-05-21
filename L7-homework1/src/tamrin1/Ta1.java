package tamrin1;

import tamrin1.model.entity.UserEnt;
import tamrin1.model.repository.UserRep;
import tamrin1.model.service.UserSer;

import java.util.List;
import java.util.Scanner;

public class Ta1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserEnt userEnt1 = new UserEnt();

        try {
            UserSer.getInstance().save(new UserEnt().setId(1).setUsername("ek").setPassword("1234").setSalary(10000).setData(3));
        }catch (Exception e){
            System.out.println("fail to save..."+e.getMessage());
        }

        userEnt1.setSalary(10000);
        userEnt1.setData(3);

        System.out.println("enter your username=");
        String uName = scanner.nextLine();
        System.out.println("enter your password=");
        String pWord = scanner.nextLine();

        if(uName.equals("ek") && pWord.equals("1234"))
        {
            System.out.println("ok...choose one:");
            System.out.println("1. 2gb _ 1000t "+'\n'+" 2. 4gb _ 2000t "+'\n'+" 3. 10gb _ 5000t "+'\n'+" 4. 25gb _ 10000t");
            int x = scanner.nextInt();
            switch (x){
                case 1:
                    try {
                        UserSer.getInstance().edit(userEnt1 , 1000 , 2);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        UserSer.getInstance().edit(userEnt1 , 2000 , 4);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        UserSer.getInstance().edit(userEnt1 , 5000 , 10);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        UserSer.getInstance().edit(userEnt1 , 10000 , 25);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("wrong");
                break;
            }

            try {
                List<UserEnt> userEntiList = UserSer.getInstance().report();
                for (UserEnt userEnti : userEntiList){
                    System.out.println(userEnti.getId());
                    System.out.println(userEnti.getSalary());
                    System.out.println(userEnti.getData());
                    System.out.println(userEnti.getUsername());
                }
            }catch (Exception e){
                System.out.println("error..."+e.getMessage());
            }

        }else{
            System.out.println("invalid username or password");
        }


    }
}

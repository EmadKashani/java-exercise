package tamrin2;

import tamrin2.model.entity.CarEnti;
import tamrin2.model.service.CarServ;

import java.util.List;
import java.util.Scanner;

public class Ta2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CarEnti carEnti1 = new CarEnti();

        try{
            CarServ.getInstance().save(new CarEnti().setId(1).setName("nothing").setSalary(210));
        }catch (Exception e){
            System.out.println("fail to save.."+e.getMessage());
        }

        carEnti1.setSalary(210);
        carEnti1.setId(1);
        carEnti1.setName("nothing");

        System.out.println("choose your car");
        System.out.println("1. pride _  200"+'\n'+"2. tiba _ 220"+'\n' +"3. saina _ 190");
        int x = scanner.nextInt();
        switch (x)
        {
            case 1:
                try {
                    CarServ.getInstance().edit(carEnti1, "pride", 200);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try {
                    CarServ.getInstance().edit(carEnti1, "tiba", 220);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                try {
                    CarServ.getInstance().edit(carEnti1, "saina", 190);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
        }


        System.out.println("result=");

        try {
            List<CarEnti> carEntiList = CarServ.getInstance().report();
            for (CarEnti carEnti2 : carEntiList){
                System.out.println("id= "+ carEnti2.getId());
                System.out.println("name= "+ carEnti2.getName());
                System.out.println("salary= "+ carEnti2.getSalary());
            }
        }catch (Exception e){
            System.out.println("error..."+e.getMessage());
        }

    }

}

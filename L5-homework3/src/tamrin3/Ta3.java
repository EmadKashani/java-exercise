package tamrin3;

import java.util.Scanner;

public class Ta3 {

    public static void main(String[] args) {

        System.out.println("CAR 1:");
        Cars car1 = CarFactory.getCar(Cars.Benz);
        System.out.println("your car's name=");
        car1.name();
        System.out.println("your car's power=");
        car1.power();
        System.out.println("your car's speed=");
        car1.speed();

        System.out.println("CAR 2:");
        Cars car2 = CarFactory.getCar(Cars.Bmw);
        System.out.println("your car's name=");
        car2.name();
        System.out.println("your car's power=");
        car2.power();
        System.out.println("your car's speed=");
        car2.speed();

        System.out.println("CAR 3:");
        Cars car3 = CarFactory.getCar(Cars.Lamborghini);
        System.out.println("your car's name=");
        car3.name();
        System.out.println("your car's power=");
        car3.power();
        System.out.println("your car's speed=");
        car3.speed();
    }
}

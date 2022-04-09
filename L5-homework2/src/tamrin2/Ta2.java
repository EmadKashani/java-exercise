package tamrin2;

import java.util.Scanner;

public class Ta2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter your name=");
        SingletonInfo.getInstance().name = scanner.nextLine();
        System.out.println("enter your username=");
        SingletonInfo.getInstance().username = scanner.nextLine();
        System.out.println("enter your password=");
        SingletonInfo.getInstance().password = scanner.nextLine();

        System.out.println("your information :");
        SingletonInfo.getInstance().show();


    }
}

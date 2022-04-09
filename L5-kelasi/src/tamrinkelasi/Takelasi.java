package tamrinkelasi;

import java.util.Scanner;

public class Takelasi {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter your first number=");
        int c = scanner.nextInt();
        System.out.println("enter your second number=");
        int d = scanner.nextInt();
        System.out.println("enter the operation=");
        Calculation calculation = CalcFactory.getCalc(scanner.next().charAt(0));
        System.out.println(calculation.calc(c , d));
    }

}

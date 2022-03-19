package tamrin3;

import java.util.Scanner;

public class Ta3 {

    public static void main(String[] args) {

        float a1,b1;
        char c;
        System.out.print("enter your first number=");
        Scanner numbers = new Scanner(System.in);
        float a = numbers.nextInt();
        System.out.print("enter yout second number=");
        float b = numbers.nextInt();
        if(a>b){
            a1=a;
            b1=b;
        }
        else{
            a1=b;
            b1=a;
        }
        System.out.print("enter what happen=");
        c = numbers.next().charAt(0);

        System.out.print("answer is =");
        switch (c)
        {
            case '+':
                System.out.print(a+b);
                break;
            case '-':
                System.out.print(a1-b1);
                break;
            case '*':
                System.out.print(a*b);
                break;
            case '/':
                System.out.print(a/b);
                break;
            default:
                System.out.print("Wrong");
                break;
        }
    }
}

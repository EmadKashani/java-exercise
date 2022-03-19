package tamrin1;

import java.util.Scanner;

public class Calculation implements Operation{

    Scanner scan = new Scanner(System.in);

    float a,b,m;

    public void number(){
        System.out.print("enter your first number=");
        a = scan.nextFloat();
        System.out.print("enter your second number=");
        b = scan.nextFloat();
    }




    @Override
    public void plus() {
        m = a+b;
        System.out.println("plus answer= "+ m);
    }

    @Override
    public void minus() {
        m = a-b;
        System.out.println("minus answer= "+ m);
    }

    @Override
    public void multipliedBy() {
        m = a*b;
        System.out.println("multiplied answer= "+ m);
    }

    @Override
    public void divide() {
        m = a/b;
        System.out.println("devide answer= "+ m);
    }

}

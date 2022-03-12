package tamrin2;

import java.util.Scanner;

public class Ta2 {

    public static void main(String[] args) {

        try {
            delta();
        }catch (EquationException e){
            System.out.println("delta error");
        }finally {
            System.out.print("Finish");
        }


    }

    public static void delta() throws EquationException{

        double x1,x2,a,b,c;
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter x^2 factor=");
        a = scanner.nextInt();
        if(a==0){
            throw new EquationException("wrong");
        }
        System.out.print("enter x factor=");
        b = scanner.nextInt();
        System.out.print("enter the number=");
        c = scanner.nextInt();

        if(b*b - 4*a*c < 0){
            throw new EquationException("error");
        }
        else {
            x1 = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
            System.out.println("first answer = "+ x1);
            x2 = (-b - Math.sqrt(b*b-4*a*c))/(2*a);
            System.out.println("second answer = "+ x2);
        }

    }

}

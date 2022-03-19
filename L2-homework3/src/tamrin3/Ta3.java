package tamrin3;

import java.util.Scanner;

public class Ta3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("enter your number=");
        int a = scanner.nextInt();

        Number number = new Number();

        if(a==0)
            number.IsZero();

        if(a>0) {
            number.isPossitive();
            if (a % 2 == 0)
                number.isEven();
            else
                number.isOdd();
        }

        if(a<0)
            number.isNegative();

    }
}

package tamrin1;

import java.util.Scanner;

public class Ta1 {

    public static void main(String[] args) {

        int i,j;
        System.out.print("how many stars =");
        Scanner times = new Scanner(System.in);
        int t = times.nextInt();
        for (i = 1; i <= t; i++)
        {
            for (j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

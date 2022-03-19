package tamrin2;

import java.util.Scanner;

public class Ta2 {

    public static void main(String[] args) {

        int i,j,t=0;
        int[] a = new int[1000];
        System.out.print("enter numbers=");
        Scanner max = new Scanner(System.in);
        int n = max.nextInt();
        for(i=0;i<n;i++)
            a[i] = max.nextInt();
        for(j=0;j<n;j++)
        {
            if(a[j]>t)
                t=a[j];
        }//which one is greater?

        System.out.println("answer="+t);
    }
}

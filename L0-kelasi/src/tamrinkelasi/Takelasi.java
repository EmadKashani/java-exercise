package tamrinkelasi;

import java.util.Scanner;

public class Takelasi {

    public static void main(String[] args) {

        int[] a = new int[1000];
        int n,i,j,t=0;
        System.out.print("enter your number=");
        Scanner cheak = new Scanner(System.in);
        int b = cheak.nextInt();
        System.out.print("enter n=");
        n = cheak.nextInt();
        for (i = 0; i < n; i++)
            a[i] = cheak.nextInt();

        for (j = 0; j < n; j++)
        {
            if(a[j] == b)
                t=t+1;
        }
        if(t!=0){
            System.out.println("true");
            System.out.print("times="+t);
        }
        else
            System.out.println("false");
    }
}

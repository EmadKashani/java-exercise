package tamrin3;

import java.util.Scanner;

public class Ta3 {

    public static void main(String[] args) {

        int a,b,c,d,e,f;
        float m;

        Scanner scanner = new Scanner(System.in);

        Moadele moadele1 = new Moadele();
        System.out.print("enter zaribX1=");
        a = moadele1.zaribX = scanner.nextInt();
        System.out.print("enter zaribY1=");
        b = moadele1.zaribY = scanner.nextInt();
        System.out.print("enter javab1=");
        e = moadele1.adad = scanner.nextInt();


        Moadele moadele2 = new Moadele();
        System.out.print("enter zaribX2=");
        c = moadele2.zaribX = scanner.nextInt();
        System.out.print("enter zaribY2=");
        d = moadele2.zaribY = scanner.nextInt();
        System.out.print("enter javab2=");
        f = moadele2.adad = scanner.nextInt();

        m = a*d-b*c;

        if(m == 0)
            System.out.print("this  is insolvable");
        else
        {
            System.out.print( "x= "+ (e*d-b*f)/m );
            System.out.println();
            System.out.print( "y= "+ (a*f-e*c)/m );
        }

        //end
    }
}

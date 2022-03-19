package tamrin2;

import java.util.Scanner;

public class Ta2 {

    public static void main(String[] args) {

        int z = 0;
        int a1,a2,a3;
        float moadel , s;


        Scanner scanner = new Scanner(System.in);

        Lesson math = new Lesson();
        System.out.print("enter your math score=");
        math.score = scanner.nextInt();
        System.out.print("enter your math zarib=");
        math.zarib = scanner.nextInt();
        z = z + math.zarib;
        a1 = math.calculation();


        Lesson physics = new Lesson();
        System.out.print("enter your physics score=");
        physics.score = scanner.nextInt();
        System.out.print("enter your physics zarib=");
        physics.zarib = scanner.nextInt();
        z = z + physics.zarib;
        a2 = physics.calculation();



        Lesson literature = new Lesson();
        System.out.print("enter your literature score=");
        literature.score = scanner.nextInt();
        System.out.print("enter your literature zarib=");
        literature.zarib = scanner.nextInt();
        z = z + literature.zarib;
        a3 = literature.calculation();


        s = a1+a2+a3;
        moadel = s/z;
        System.out.print("grade poin average= "+moadel);
        System.out.println();
        if(moadel>10)
            System.out.print("pass");
        else
            System.out.print("fail");

        //end
    }
}

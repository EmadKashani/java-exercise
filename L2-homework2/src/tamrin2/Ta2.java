package tamrin2;

import java.util.Scanner;

public class Ta2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("what is your lesson:");
        String name = scanner.nextLine();


        Lesson math1 = new Lesson();
        math1.unit = 3;
        math1.pishN = "nothing";
        math1.hamN = "nothing";


        Lesson math2 = new Lesson();
        math2.unit = 3;
        math2.hamN = "differential";
        math2.pishN = "math1";


        Lesson physics1 = new Lesson();
        physics1.unit = 2;
        physics1.pishN = "nothing";
        physics1.hamN = "nothing";


        Lesson physics2 = new Lesson();
        physics2.unit = 2;
        physics2.pishN = "physics1";
        physics2.hamN = "physics Lab";


        Lesson literature = new Lesson();
        literature.unit = 1;
        literature.hamN = "nothing";
        literature.pishN = "nothing";


        if(name.equals("math1"))
            math1.L_math1();
        else if (name.equals("math2"))
            math2.L_math2();
        else if (name.equals("physics1"))
            physics1.L_physics1();
        else if (name.equals("physics2"))
            physics2.L_physics2();
        else if (name.equals("literature"))
            literature.L_literature();
        else
            System.out.println("Error");


    }
}

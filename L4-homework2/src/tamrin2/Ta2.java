package tamrin2;

import java.util.Scanner;

public class Ta2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        User user = new User();
        User copy1 = null;
        User copy2 = null;
        User copy3 = null;

        System.out.print("enter your name=");
        user.setName(scanner.nextLine());
        System.out.print("enter your family name=");
        user.setFamily(scanner.nextLine());
        System.out.print("enter your age=");
        user.setAge(scanner.nextInt());


        try {
            copy1 = (User) user.clone();
        }catch (CloneNotSupportedException e){
            System.out.println("clone 1 not supported");
        }try {
            copy2 = (User) user.clone();
        }catch (CloneNotSupportedException e){
            System.out.println("clone 2 not supported");
        }try {
            copy3 = (User) user.clone();
        }catch (CloneNotSupportedException e){
            System.out.println("clone 3 not supported");
        }

        if(!user.equals(copy1) && !user.equals(copy2) && !user.equals(copy3))
        {

            System.out.println("your information :");

            System.out.println(user);
            System.out.println(copy1);
            System.out.println(copy2);
            System.out.println(copy3);

            System.out.println("name= "+ user.getName());
            System.out.println(copy1.getName());
            System.out.println(copy2.getName());
            System.out.println(copy3.getName());

            System.out.println("family name= "+ user.getFamily());
            System.out.println(copy1.getFamily());
            System.out.println(copy2.getFamily());
            System.out.println(copy3.getFamily());

            System.out.println("age= "+ user.getAge());
            System.out.println(copy1.getAge());
            System.out.println(copy2.getAge());
            System.out.println(copy3.getAge());

        }



    }
}

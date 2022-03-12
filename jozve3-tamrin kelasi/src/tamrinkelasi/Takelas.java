package tamrinkelasi;

import java.util.Scanner;

public class Takelas {

    public static void main(String[] args) {

        try{
            information();
        }catch (UserExeption e){
            System.out.println("the same information");
        }finally {
            System.out.println("** FINISH **");
        }


    }

    public static void information () throws UserExeption
    {

        Scanner scanner = new Scanner(System.in);
        String[] user1= new String[100];
        String[] user2= new String[100];


        System.out.print("enter your name= ");
        user1[0] = scanner.nextLine();
        System.out.print("enter your family name= ");
        user1[1] = scanner.nextLine();
        System.out.print("enter your age= ");
        user1[2] = scanner.nextLine();

        System.out.println("* the next user *");

        System.out.print("enter your name= ");
        user2[0] = scanner.nextLine();
        System.out.print("enter your family name= ");
        user2[1] = scanner.nextLine();
        System.out.print("enter your age= ");
        user2[2] = scanner.nextLine();


        if (user1[0].equals(user2[0]) && user1[1].equals(user2[1]) && user1[2].equals(user2[2])) {
                throw new UserExeption();
            }
        else {
            System.out.println("corect");
        }




    }

}

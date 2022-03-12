package tamrin1;

import java.util.Scanner;

public class Ta1 {

    public static void main(String[] args) {

        try{
            user();
        }catch (InfoException e){
            System.out.println("name or username or pasword is wrong");
        }finally {
            System.out.println("finish");
        }
    }

    public static void user() throws InfoException{

        Scanner scanner = new Scanner(System.in);

        InfoException student = new InfoException();
        student.name = "emad";
        student.username = "kashani";
        student.pasword = 12345;


        System.out.print("enter your name=");
        String name1 = scanner.nextLine();
        System.out.print("enter your username=");
        String username1 = scanner.nextLine();
        System.out.print("enter your pasword=");
        int pasword1 = scanner.nextInt();

        if(!student.name.equals(name1) || !student.username.equals(username1) || student.pasword != pasword1)
        {
            throw new InfoException();
        }
        else
        {
            System.out.println("ok corect");
        }
    }

}

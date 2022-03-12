package tamrin3;

import java.util.Scanner;

public class Ta3 {

    public static void main(String[] args) {

        try {
            stringnumber();
        }catch (StringException e) {
            System.out.println("wrong:there is a number");
        } finally {
            System.out.println("finish");
        }

    }

    public static void stringnumber() throws StringException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("write somthing=");
        String myString = scanner.nextLine();


        if(myString.matches(".*[0-9].*"))
        {
            throw new StringException();
        }
        else
        {
            System.out.println("size of what you write= "+ myString.length());
        }


    }

}

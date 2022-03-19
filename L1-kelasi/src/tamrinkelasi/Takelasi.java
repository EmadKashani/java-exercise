package tamrinkelasi1;

import java.util.Scanner;

public class Takelasi {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Books book1 = new Books();
        book1.name = "differential";
        book1.subject = "math";
        book1.pages = 100;

        book1.giveback();

        Books book2 = new Books();
        book2.name = "physics";
        book2.subject = "sciences";
        book2.pages = 150;

        book2.take();
    }
}

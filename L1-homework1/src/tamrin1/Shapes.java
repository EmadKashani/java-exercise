package tamrin1;

import java.util.Scanner;

public class Shapes {

    int tol;
    int arz;
    int zel;
    Scanner scanner = new Scanner(System.in);


    public void mohitMostatil(){
        System.out.print("mohit Mostatil = "+ 2*(tol+arz));
        System.out.println();
    }

    public void masahatMostatil(){
        System.out.print("masahat Mostatil = "+ tol*arz);
        System.out.println();

    }

    public void mohitMoraba() {
        System.out.print("mohit Moraba = " + 4 * zel);
        System.out.println();
    }

    public void masahatMoraba(){
        System.out.print("masahat Moraba = "+ zel*zel);
    }

}

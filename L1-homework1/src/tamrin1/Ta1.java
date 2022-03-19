package tamrin1;

import java.util.Scanner;

public class Ta1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Shapes mostatil = new Shapes();
        System.out.print("mostatil_tol=");
        mostatil.tol = scanner.nextInt();
        System.out.print("mostatil_arz=");
        mostatil.arz = scanner.nextInt();


        Shapes moraba = new Shapes();
        System.out.print("moraba_zel=");
        moraba.zel = scanner.nextInt();



        mostatil.mohitMostatil();
        mostatil.masahatMostatil();

        moraba.mohitMoraba();
        moraba.masahatMoraba();


    }
}

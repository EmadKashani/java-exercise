package tamrin3;

public class Number implements MyInteger{

    @Override
    public void isEven() {
        System.out.println("your number is even");
    }

    @Override
    public void isOdd() {
        System.out.println("your number is odd");
    }

    @Override
    public void isPossitive() {
        System.out.print("your number is possitive");
        System.out.println();
    }

    @Override
    public void isNegative() {
        System.out.println("your number is negative");
    }

    @Override
    public void IsZero() {
        System.out.println("your number is zero");
    }

}

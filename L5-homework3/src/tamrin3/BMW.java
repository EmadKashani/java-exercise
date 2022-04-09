package tamrin3;

public class BMW implements Cars {

    @Override
    public void name() {
        System.out.println(" bmw");
    }

    @Override
    public void speed() {
        System.out.println(" 80");
    }

    @Override
    public void power() {
        System.out.println(" 60");
    }

}

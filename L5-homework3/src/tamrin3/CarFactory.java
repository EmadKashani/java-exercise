package tamrin3;

public class CarFactory {

    public static Cars getCar(int x){
        switch (x)
        {
            case 1:
                return new BENZ();
            case 2:
                return new BMW();
            case 3:
                return new LAMBORGHINI();
            default:
                return null;
        }
    }
    
}

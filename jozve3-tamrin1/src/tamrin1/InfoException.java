package tamrin1;

public class InfoException extends Exception {

    int pasword;
    String name;
    String username;

    public InfoException(String info){
        super(info);
    }
    public InfoException(){}
}

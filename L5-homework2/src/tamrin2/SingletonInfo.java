package tamrin2;

public class SingletonInfo {

    private static SingletonInfo singletonInfo;
    public synchronized static SingletonInfo getInstance() {
        if(singletonInfo == null)
        {
            singletonInfo = new SingletonInfo();
        }
        return singletonInfo;
    }
    private SingletonInfo(){}

    public String name;
    public String username;
    public String password;

    public void show(){
        System.out.println("your name= "+ name);
        System.out.println("your username= "+ username);
        System.out.println("your password= "+ password);
    }

    //end
}

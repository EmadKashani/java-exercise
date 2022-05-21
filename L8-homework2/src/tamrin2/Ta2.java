package tamrin2;

import tamrin2.model.UserEnti;
import tamrin2.model.UserServ;

public class Ta2 {

    public static void main(String[] args) {
        RegisterForm registerForm = new RegisterForm(null);
        try {
            UserServ.getInstance().save(new UserEnti().setId(1).setName("emad").setAge(18).setUsername("ek").setPassword("1234"));
        }catch (Exception e){
            System.out.println("fail to save..."+e.getMessage());
        }

    }
}

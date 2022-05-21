package tamrinkelasi.model;

import java.util.List;

public class UserServ {

    private static UserServ userServ = new UserServ();

    public static UserServ getInstance(){
        return userServ;
    }


    public void save (UserEnti personEnti) throws Exception {
        try (UserRepo personRepo = new UserRepo ()) {
            personRepo.insert (personEnti);
            personRepo.commit ();
        }
    }

    public List<UserEnti> report() throws Exception{
        List<UserEnti> personEntityList;
        try (UserRepo personRepo=new UserRepo ()){
            personEntityList=personRepo.select ();
        }
        return personEntityList;
    }

}

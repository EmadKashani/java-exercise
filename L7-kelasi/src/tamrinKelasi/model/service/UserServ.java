package tamrinKelasi.model.service;

import tamrinKelasi.model.entity.UserEnti;
import tamrinKelasi.model.repository.UserRepo;

import java.util.List;

public class UserServ {

    private UserServ(){}
    public static UserServ userServ = new UserServ();

    public static UserServ getInstance(){
        return userServ;
    }

    public void save(UserEnti userEnti) throws Exception{
        try(UserRepo uRepo = new UserRepo()) {
            uRepo.insert(userEnti);
            uRepo.commit();
        }
    }

    public List<UserEnti> report() throws Exception{
        List<UserEnti> userEntiList;
        try (UserRepo userRepo = new UserRepo()){
            userEntiList = userRepo.select();
        }
        return userEntiList;
    }

}

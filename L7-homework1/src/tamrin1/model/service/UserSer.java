package tamrin1.model.service;

import tamrin1.model.entity.UserEnt;
import tamrin1.model.repository.UserRep;

import java.util.List;

public class UserSer {

    private UserSer(){}
    private static UserSer userSer = new UserSer();

    public static UserSer getInstance(){
        return userSer;
    }

    public void save(UserEnt userEnt) throws Exception{
        try(UserRep userRep = new UserRep()) {
            userEnt.setSalary(userEnt.getSalary());
            userRep.insert(userEnt);
            userRep.commit();

        }

    }

    public void edit(UserEnt userEnt , int cash , int net) throws Exception{
        try(UserRep userRep = new UserRep()) {
            System.out.println(userEnt.getSalary());
            if (userEnt.getSalary() - cash < 0) {
                System.out.println("can't buy");
            }else {
                userEnt.setSalary(userEnt.getSalary() - cash);
                userEnt.setData(userEnt.getData() + net);
                userRep.update(userEnt);
                userRep.commit();
            }
        }catch (Exception e){
            System.out.println("can't edit..."+ e.getMessage());
        }
    }

    public List<UserEnt> report() throws Exception{
        List<UserEnt> userEntList;
        try(UserRep userRep = new UserRep()) {
            userEntList = userRep.select();
        }
        return userEntList;
    }

}

package tamrin1.model;

import java.util.List;

public class Service {

    private Service(){}

    private static Service userService = new Service();

    public static Service getInstance(){
        return userService;
    }

    public void save (Entity personEnti) throws Exception {
        try (Repository personRepo = new Repository ()) {
            //personEnti.setSalary (personEnti.);
            personRepo.insert (personEnti);
            personRepo.commit ();
        }
    }

    public List<Entity> report() throws Exception{
        List<Entity> personEntityList;
        try (Repository personRepo=new Repository ()){
            personEntityList=personRepo.select ();
        }
        return personEntityList;
    }

}

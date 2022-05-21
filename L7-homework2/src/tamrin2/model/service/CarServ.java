package tamrin2.model.service;

import tamrin2.model.entity.CarEnti;
import tamrin2.model.repository.CarRepo;

import java.util.List;

public class CarServ{

    private static CarServ carServ = new CarServ();

    public static CarServ getInstance(){
        return carServ;
    }

    public void save(CarEnti carEnti) throws Exception{
        try(CarRepo carRepo = new CarRepo()){
            carEnti.setSalary(carEnti.getSalary());
            carEnti.setName(carEnti.getName());
            carRepo.insert(carEnti);
            carRepo.commit();
            System.out.println("save");
        }
    }

    public void edit(CarEnti carEnti,String carname,int cash) throws Exception{
        try (CarRepo carRepo = new CarRepo()){
            if( (carEnti.getSalary() - cash) < 0) {
                System.out.println("can't buy");
            }else {
                carEnti.setSalary(carEnti.getSalary() - cash);
                carEnti.setName(carname);
                carRepo.update(carEnti);
                carRepo.commit();
                System.out.println("edit..");
            }

        }
    }

    public List<CarEnti> report() throws Exception{
        List<CarEnti> carEntiList;
        try(CarRepo carRepo = new CarRepo()){
            carEntiList = carRepo.select();
        }
        return carEntiList;
    }

}

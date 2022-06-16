package hotel.passengers;

import hotel.passengers.PassengersEntity;
import hotel.passengers.PassengersRepository;

import java.util.List;

public class PassengersService {

    private static PassengersService passengersService = new PassengersService ();

    public static PassengersService getInstance () {
        return passengersService;
    }

    public void save (PassengersEntity passsengersEntity) throws Exception {
        try (PassengersRepository passengersRepository = new PassengersRepository ()) {
            //passsengersEntity.setFullprice (roomEnti.getSalary() * passsengersEntity.getStaynum());
            passengersRepository.insert (passsengersEntity);
            passengersRepository.commit ();
        }
    }
    public void edit (PassengersEntity passsengersEntity) throws Exception{
        try (PassengersRepository passengersRepository=new PassengersRepository ()){
            //passsengersEntity.setFullprice (roomEnti.getSalary() * passsengersEntity.getStaynum());
            passengersRepository.update (passsengersEntity);
            passengersRepository.commit ();
        }
    }
    public void remove(String melicode) throws Exception{
        try (PassengersRepository passengersRepository=new PassengersRepository ()){
            passengersRepository.delete (melicode);
            passengersRepository.commit ();
        }
    }
    public List<PassengersEntity> report() throws Exception{
        List<PassengersEntity> passengersEntities;
        try (PassengersRepository passengersRepository=new PassengersRepository ()){
            passengersEntities=passengersRepository.select ();
        }
        return passengersEntities;
    }
}

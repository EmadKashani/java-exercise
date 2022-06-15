package hotel.rooms;

import java.util.List;

public class RoomServ {

    private RoomServ(){}

    private static RoomServ roomServ = new RoomServ();

    public static RoomServ getInstance(){
        return roomServ;
    }


    public void save (RoomEnti roomEnti) throws Exception {
        try (RoomRepo personRepo = new RoomRepo ()) {
            //roomEnti.setSalary (roomEnti.getSalary () - (roomEnti.getSalary () * 10 / 100));
            personRepo.insert (roomEnti);
            personRepo.commit ();
        }
    }

    public void edit (RoomEnti roomEnti) throws Exception{
        try (RoomRepo personRepo=new RoomRepo ()){
            //roomEnti.setSalary (roomEnti.getSalary ()-(roomEnti.getSalary ()*10/100));
            personRepo.update (roomEnti);
            personRepo.commit ();
        }
    }

    public void remove(long id) throws Exception{
        try (RoomRepo roomRepo=new RoomRepo ()){
            roomRepo.delete (id);
            roomRepo.commit ();
        }
    }

    public List<RoomEnti> report() throws Exception{
        List<RoomEnti> roomEntiList;
        try (RoomRepo personRepo=new RoomRepo ()){
            roomEntiList=personRepo.select ();
        }
        return roomEntiList;
    }
}

package hotel.reserveRooms;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RRService {

    private static final RRService rrService = new RRService();

    private RRService() {
    }
    //modified
    public static RRService RRSGetInstance() {
        return rrService;
    }

    public void rRSave(RREntity entity) throws Exception {
        try(ReservedRoomsRepo reservedRoomsRepo = new ReservedRoomsRepo()){

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fo = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm");

            entity.setReservationDateTime(now.format(fo));

            reservedRoomsRepo.rRInsert(entity);
            reservedRoomsRepo.commit();

        }
    }

    //this method gets old info and puts new info instead---- used in old algorithm
    public void rREdit(int oRoomNo, String originalNationalNumber, RREntity entity) throws Exception {

        try( ReservedRoomsRepo reservedRoomsRepo = new ReservedRoomsRepo()){

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fo = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm");

            //below checks if the new room is empty or not i think this should be checked in controller
            //if its checked there we can erase this if statement
            if (isEmpty(entity.getRoomNo()) || entity.getRoomNo() == oRoomNo) {
                entity.setReservationDateTime(now.format(fo));
                reservedRoomsRepo.rRUpdate(entity, originalNationalNumber, oRoomNo);
                reservedRoomsRepo.commit();

            }
        }
    }

    //this method only needs the person (who got the room)'s  nationalcode and the roomNo according to which
    //deletes the record this means other attributes can be empty
    public void rRRemove(RREntity entity) throws Exception {
        try( ReservedRoomsRepo reservedRoomsRepo = new ReservedRoomsRepo()){

            reservedRoomsRepo.rRdelete(entity.getNationalCode(),entity.getRoomNo());
            reservedRoomsRepo.commit();

        }}


    //**explanation:methods below were needed for another algorithm in which to check if the room
    //is empty and you can give it to a new costumer it used date and staying days and calculated if
    //the room is empty or not but instead the team decided to use another algorithm in which the
    //rooms are choosen from a empty rooms table that guarantees the chosen room to be empty

    //this method checks if a specific room is empty or not . it only needs room number
    private boolean isEmpty(int roomNo) throws Exception {
        try( ReservedRoomsRepo reservedRoomsRepo = new ReservedRoomsRepo()){

            DateTimeFormatter fo = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm");
            LocalDateTime current = LocalDateTime.now();
            RREntity dateStuffOnly = reservedRoomsRepo.dateStuffSelect(roomNo);

            if (dateStuffOnly.getReservationDateTime() != null) {
                LocalDateTime dBDateTime = LocalDateTime.parse(dateStuffOnly.getReservationDateTime(), fo);
                LocalDateTime checkOutDate;
                checkOutDate = dBDateTime.plusDays(dateStuffOnly.getReservationDays());
                if (checkOutDate.isAfter(current))
                    return false;
                else
                    return true;
            } else
                return true;

        }
    }

    //should i make this private
    //should be used in controller or service? maybe both- this method checks if there is any empty room and if
    // there is any  returns room number if didn't found any rooms returns -1

//    private int foundAnyEmptyRooms(RoomEnti roomEnti) throws Exception {
//        try(ReservedRoomsRepo reservedRoomsRepo = new ReservedRoomsRepo()){
//
//            List<Integer> searchableRooms = reservedRoomsRepo.suitableRoomsSelect(roomEnti);
//            for (int roomNo : searchableRooms ) {
//                if (isEmpty(roomNo))
//                    return roomNo;
//            }
//            return -1;
//        }
//    }

    //this one
    public List<RREntity> report() throws Exception{
        try(ReservedRoomsRepo reservedRoomsRepo= new ReservedRoomsRepo()){
            List<RREntity> rrEntityList ;
            rrEntityList=reservedRoomsRepo.rRfullSelct();
            return rrEntityList;
        }
    }
}

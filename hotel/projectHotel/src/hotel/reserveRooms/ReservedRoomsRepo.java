package hotel.reserveRooms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservedRoomsRepo implements AutoCloseable{

    private String user="sara";//db username change it if needed
    private String pass="srbz77";// your db password
    private String url="jdbc:oracle:thin:@localhost:1521:xe";
    private Connection con ;
    private PreparedStatement preparedStatement;

    public ReservedRoomsRepo() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con= DriverManager.getConnection(url,user,pass);
        con.setAutoCommit(false);
    }

    public void rRInsert(RREntity entity) throws Exception{
        preparedStatement=con.prepareStatement("insert into  reservedrooms (nationalcode,pfullname,mobile,ipay,resdays,rdatetime,roomno) values (?,?,?,?,?,?,?)");

        preparedStatement.setString(1,entity.getNationalCode());
        preparedStatement.setString(2,entity.getpFullName());
        preparedStatement.setString(3,entity.getMobileNo());
        preparedStatement.setInt(4,entity.getInitialPay());
        preparedStatement.setInt(5,entity.getReservationDays());
        preparedStatement.setString(6,entity.getReservationDateTime());
        preparedStatement.setInt(7,entity.getRoomNo());

        preparedStatement.executeUpdate();
    }

    public  void  rRUpdate(RREntity entity,String originalNationalCode,int originalroomNo) throws Exception{
        preparedStatement=con.prepareStatement("update reservedrooms set nationalcode=?,pfullname=?,mobile=?,ipay=?,resdays=?,rdatetime=?,roomno=? where nationalcode=? and roomno=?");

        preparedStatement.setString(8,originalNationalCode);
        preparedStatement.setInt(9,originalroomNo);
        preparedStatement.setString(1,entity.getNationalCode());
        preparedStatement.setString(2,entity.getpFullName());
        preparedStatement.setString(3,entity.getMobileNo());
        preparedStatement.setInt(4,entity.getInitialPay());
        preparedStatement.setInt(5,entity.getReservationDays());
        preparedStatement.setString(6,entity.getReservationDateTime());
        preparedStatement.setInt(7,entity.getRoomNo());
        preparedStatement.executeUpdate();

    }

    //deleting according to national code
    public void rRdelete(String nationalCode,int roomNo)throws Exception{
        preparedStatement=con.prepareStatement("delete from  reservedrooms where nationalcode=? and roomno=?");
        preparedStatement.setString(1,nationalCode);
        preparedStatement.setInt(2,roomNo);
        preparedStatement.executeUpdate();

    }


    public List<RREntity> rRfullSelct()throws  Exception {
        preparedStatement = con.prepareStatement("select roomno,nationalcode,pfullnamee,mobile,ipay,resdays,rdatetime from reservedrooms");
        ResultSet resultSet= preparedStatement.executeQuery();
        List<RREntity> rRTableListed = new ArrayList<>();

        while(resultSet.next()){
            RREntity rREntity= new RREntity();
            rREntity.setRoomNo(resultSet.getInt("roomno"));
            rREntity.setNationalCode(resultSet.getString("nationalcode"));
            rREntity.setpFullName(resultSet.getString("pfullname"));
            rREntity.setReservationDays(resultSet.getInt("resdays"));
            rREntity.setReservationDateTime(resultSet.getString("rdatetime"));
            rREntity.setMobileNo(resultSet.getString("mobile"));
            rREntity.setInitialPay(resultSet.getInt("ipsy"));

            rRTableListed.add(rREntity);}

        return  rRTableListed;
    }

    public RREntity dateStuffSelect(int roomNo) throws Exception{
        preparedStatement=con.prepareStatement("select  rdatetime,resdays from reservedrooms where roomno=? order by rdatetime desc ");
        preparedStatement.setInt(1,roomNo);
        ResultSet resultSet =preparedStatement.executeQuery();
        RREntity incoRREntity = new RREntity();
        if(resultSet.next()){
            incoRREntity.setReservationDateTime(resultSet.getString("rdatetime"));
            incoRREntity.setReservationDays(resultSet.getInt("resdays"));
        }
        return incoRREntity;

    }

//    public List<Integer> suitableRoomsSelect(RoomEnti roomEnti)throws Exception{
//        preparedStatement= con.prepareStatement("select roomno from rooms where roomtype=? and roomcapacity=? and " +
//                "roomview=?");
//
//        preparedStatement.setString(1,roomEnti.getType());
//        preparedStatement.setInt(2,roomEnti.getNumber());
//        preparedStatement.setString(3,roomEnti.getFacilities());
//
//        ResultSet resultSet =preparedStatement.executeQuery();
//        List<Integer> roomList= new ArrayList<>();
//
//        while(resultSet.next()){
//            int roomNumber;
//            roomNumber=resultSet.getInt("roomno");
//            roomList.add(roomNumber);
//        }
//        return roomList;
//    }


    public void commit() throws Exception {
        con.commit();
    }

    public  void rollback() throws  Exception{
        con.rollback();
    }



    @Override
    public void close() throws Exception {
        preparedStatement.close();
        con.close();

    }
}

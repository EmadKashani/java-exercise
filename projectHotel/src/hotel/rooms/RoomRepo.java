package hotel.rooms;

import hotel.employee.EmployeeEnti;
import hotel.view.CheckInForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomRepo implements AutoCloseable{

    private Connection connection;
    private PreparedStatement preparedStatement;


    public RoomRepo() throws Exception{
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "hotel", "myjava123");
        connection.setAutoCommit (false);
    }

    public void insert(RoomEnti roomEnti) throws Exception{
        preparedStatement=connection.prepareStatement ("insert into rooms(id,code,roomnum,type,facilities,salary) values (?,?,?,?,?,?)");
        preparedStatement.setLong (1,roomEnti.getId());
        preparedStatement.setInt (2,roomEnti.getCode());
        preparedStatement.setInt (3,roomEnti.getNumber());
        preparedStatement.setString (4,roomEnti.getType());
        preparedStatement.setString (5,roomEnti.getFacilities());
        preparedStatement.setInt (6,roomEnti.getSalary());
        preparedStatement.executeUpdate ();
    }

    public void update (RoomEnti roomEnti) throws Exception{
        preparedStatement=connection.prepareStatement ("update rooms set code=?,roomnum=? , type =?, facilities=?, salary=? where id=? ");
        preparedStatement.setInt (1,roomEnti.getCode ());
        preparedStatement.setInt (2,roomEnti.getNumber ());
        preparedStatement.setString (3,roomEnti.getType ());
        preparedStatement.setString(4,roomEnti.getFacilities ());
        preparedStatement.setInt(5,roomEnti.getSalary ());
        preparedStatement.setLong (6,roomEnti.getId ());
        preparedStatement.executeUpdate ();
    }

    public void delete(int code) throws Exception{
        preparedStatement=connection.prepareStatement ("delete from rooms where code=?");
        preparedStatement.setInt (1,code);
        preparedStatement.executeUpdate ();
    }

    public List<RoomEnti> select() throws Exception{
        RoomEnti roomEnti = new RoomEnti();
        preparedStatement=connection.prepareStatement("select * from rooms where roomnum=? and facilities=? and type=?");
        preparedStatement.setInt(1,roomEnti.getNumber());
        preparedStatement.setString(2,roomEnti.getFacilities());
        preparedStatement.setString(3,roomEnti.getType());
        ResultSet resultSet = preparedStatement.executeQuery();
        List<RoomEnti> roomEntisList = new ArrayList<>();
        while ((resultSet.next())){
          roomEnti.setId(resultSet.getLong("id"));
          roomEnti.setNumber(resultSet.getInt("roomnum"));
          roomEnti.setCode(resultSet.getInt("code"));
          roomEnti.setFacilities(resultSet.getString("facilities"));
          roomEnti.setType(resultSet.getString("type"));
          roomEnti.setSalary(resultSet.getInt("salary"));
          roomEntisList.add(roomEnti);
       }


        return roomEntisList;
    }

    public void commit() throws Exception{
        connection.commit ();
    }
    public void rollback() throws Exception{
        connection.rollback ();
    }
    public void close() throws Exception{
        preparedStatement.close ();
        connection.close ();
    }
}

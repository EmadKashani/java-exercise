package hotel.passengers;

import hotel.passengers.PassengersEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PassengersRepository implements AutoCloseable {

    //public class PassengersRepository {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PassengersRepository() throws Exception{
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "hotel", "myjava123");
        connection.setAutoCommit (false);
    }

    public void insert(PassengersEntity passengersEntity) throws Exception{
        preparedStatement=connection.prepareStatement ("INSERT INTO passengers(melicode, fullnamep, phonenum, numofpass, staynum, fullprice, advancepay) VALUES (?,?,?,?,?,?,?)");
        preparedStatement.setString (1,passengersEntity.getMelicode());
        preparedStatement.setString (2,passengersEntity.getFullnamep());
        preparedStatement.setString (3,passengersEntity.getPhonenum());
        preparedStatement.setInt (4,passengersEntity.getNumofpass());
        preparedStatement.setInt (5,passengersEntity.getStaynum());
        preparedStatement.setInt (6,passengersEntity.getFullprice());
        preparedStatement.setInt (7,passengersEntity.getAdvancepay());
        preparedStatement.executeUpdate ();
    }

    public void update (PassengersEntity passengersEntity) throws Exception{
        preparedStatement=connection.prepareStatement ("UPDATE passengers SET mellicode=?, fullnamep =?, phonenum=?,numofpass=?, staynum=?, fullprice=?, advancepay=?, WHERE melicode=? ");
        preparedStatement.setString (1,passengersEntity.getMelicode());
        preparedStatement.setString (2,passengersEntity.getFullnamep());
        preparedStatement.setString (3,passengersEntity.getPhonenum());
        preparedStatement.setInt (4,passengersEntity.getNumofpass());
        preparedStatement.setInt (5,passengersEntity.getStaynum());
        preparedStatement.setInt (6,passengersEntity.getFullprice());
        preparedStatement.setInt (7,passengersEntity.getAdvancepay());
        preparedStatement.executeUpdate ();
    }



    public void delete(String melicode) throws Exception{
        preparedStatement=connection.prepareStatement ("DELETE FROM passengers WHERE melicode=?");
        preparedStatement.setString (1,melicode);
        preparedStatement.executeUpdate ();
    }

    public List<PassengersEntity> select() throws Exception{
        preparedStatement=connection.prepareStatement ("SELECT * FROM passengers");
        ResultSet resultSet=preparedStatement.executeQuery ();
        List<PassengersEntity> passengersEntityList=new ArrayList <> ();
        while (resultSet.next ()){
            PassengersEntity passengersEntity=new PassengersEntity (); // call by reference
            passengersEntity.setMelicode (resultSet.getString ("melicode"));
            passengersEntity.setFullnamep (resultSet.getString ("fullnamep"));
            passengersEntity.setPhonenum (resultSet.getString ("phonenum"));
            passengersEntity.setNumofpass (resultSet.getInt ("numofpass"));
            passengersEntity.setStaynum (resultSet.getInt ("staynum"));
            passengersEntity.setFullprice (resultSet.getInt ("fullprice"));
            passengersEntity.setAdvancepay (resultSet.getInt ("advancepay"));
            passengersEntityList.add (passengersEntity);
        }
        return passengersEntityList;
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

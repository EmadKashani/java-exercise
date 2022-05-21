package tamrin2.model.repository;

import tamrin2.model.entity.CarEnti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarRepo implements AutoCloseable{

    private Connection connection;
    private PreparedStatement preparedStatement;

    public CarRepo() throws Exception{
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "l7tamrin", "myjava123");
        connection.setAutoCommit (false);
    }

    public void insert(CarEnti carEnti) throws Exception{
        preparedStatement = connection.prepareStatement("insert into tak2(id,name,salary) values (?,?,?)");
        preparedStatement.setLong(1,carEnti.getId());
        preparedStatement.setString(2,carEnti.getName());
        preparedStatement.setLong(3,carEnti.getSalary());
        preparedStatement.executeUpdate();
        System.out.println("insert");

    }

    public void update (CarEnti carEnti) throws Exception{
        preparedStatement=connection.prepareStatement ("update tak2 set name =?,salary=? where id=? ");
        preparedStatement.setString (1,carEnti.getName ());
        preparedStatement.setLong (2,carEnti.getSalary ());
        preparedStatement.setLong (3,carEnti.getId ());
        preparedStatement.executeUpdate ();
        System.out.println("updated..");

    }

    public List<CarEnti> select() throws Exception{
        preparedStatement=connection.prepareStatement ("SELECT * FROM tak2 where id=?");
        preparedStatement.setLong(1,1);
        ResultSet resultSet=preparedStatement.executeQuery ();
        List<CarEnti> carEntiList=new ArrayList <> ();
        resultSet.next ();
        CarEnti carEnti=new CarEnti ();
        carEnti.setId (resultSet.getLong ("id"));
        carEnti.setName (resultSet.getString ("name"));
        carEnti.setSalary (resultSet.getInt ("salary"));
        carEntiList.add (carEnti);

        return carEntiList;

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

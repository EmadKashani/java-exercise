package tamrin1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Repository implements AutoCloseable {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public Repository() throws Exception{
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "l8tamrin", "myjava123");
        connection.setAutoCommit (false);
    }

    public void insert(Entity userEnti) throws Exception {
        preparedStatement = connection.prepareStatement("insert into tak1(id,firstname,lastname,university,education) values (?,?,?,?,?)");
        preparedStatement.setLong(1, userEnti.getId());
        preparedStatement.setString(2, userEnti.getFirstName());
        preparedStatement.setString(3, userEnti.getLastName());
        preparedStatement.setString(4, userEnti.getUniversity());
        preparedStatement.setString(5, userEnti.getEducation());
        preparedStatement.executeUpdate();
    }

    public List<Entity> select() throws Exception{
        preparedStatement=connection.prepareStatement ("select * from tak1");
        ResultSet resultSet=preparedStatement.executeQuery ();
        List<Entity> userEntityList=new ArrayList<>();
        while (resultSet.next ()){
            Entity personEnti=new Entity (); // call by reference
            personEnti.setId (resultSet.getLong ("id"));
            personEnti.setFirstName(resultSet.getString ("firstname"));
            personEnti.setLastName(resultSet.getString("lastname"));
            personEnti.setUniversity (resultSet.getString ("university"));
            personEnti.setEducation (resultSet.getString ("education"));
            userEntityList.add (personEnti);
        }
        return userEntityList;
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



package tamrinKelasi.model.repository;

import tamrinKelasi.model.entity.UserEnti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements AutoCloseable{


    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserRepo() throws Exception{
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "l7tamrin", "myjava123");
        connection.setAutoCommit (false);
    }

    public void insert(UserEnti userEnti) throws Exception{
        preparedStatement=connection.prepareStatement ("insert into takk(id,username,password,name,email) values (?,?,?,?,?)");
        preparedStatement.setLong (1,userEnti.getId());
        preparedStatement.setString (2,userEnti.getUsername());
        preparedStatement.setString (3,userEnti.getPassword());
        preparedStatement.setString (4,userEnti.getName());
        preparedStatement.setString (5,userEnti.getEmail());
        preparedStatement.executeUpdate ();

    }

    public List<UserEnti> select() throws Exception{
        preparedStatement = connection.prepareStatement("select * from takk where id=?");
        preparedStatement.setLong(1,1);
        ResultSet resultSet=preparedStatement.executeQuery ();
        List<UserEnti> userEntiList=new ArrayList <> ();
        while (resultSet.next ()){
            UserEnti userEnti=new UserEnti (); // call by reference
            userEnti.setId (resultSet.getLong ("id"));
            userEnti.setUsername (resultSet.getString ("username"));
            userEnti.setPassword (resultSet.getString ("password"));
            userEnti.setName (resultSet.getString ("name"));
            userEnti.setEmail (resultSet.getString ("email"));
            userEntiList.add (userEnti);
        }
        return userEntiList;
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

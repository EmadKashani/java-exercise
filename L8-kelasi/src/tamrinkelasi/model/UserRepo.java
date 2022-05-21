package tamrinkelasi.model;

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
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "l8tamrin" , "myjava123");
        connection.setAutoCommit(false);
    }

    public void insert(UserEnti userEnti) throws Exception {
        preparedStatement = connection.prepareStatement("insert into takk(id,name,email,username) values (?,?,?,?)");
        preparedStatement.setLong(1, userEnti.getId());
        preparedStatement.setString(2, userEnti.getName());
        preparedStatement.setString(3, userEnti.getEmail());
        preparedStatement.setString(4, userEnti.getUsername());
        preparedStatement.executeUpdate();
    }

    public List<UserEnti> select() throws Exception{
        preparedStatement=connection.prepareStatement ("select * from takk");
        ResultSet resultSet=preparedStatement.executeQuery ();
        List<UserEnti> userEntityList=new ArrayList<>();
        while (resultSet.next ()){
            UserEnti personEnti=new UserEnti (); // call by reference
            personEnti.setId (resultSet.getLong ("id"));
            personEnti.setName(resultSet.getString ("name"));
            personEnti.setUsername(resultSet.getString("username"));
            personEnti.setEmail (resultSet.getString ("email"));
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

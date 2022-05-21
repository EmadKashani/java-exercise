package tamrin2.model;

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
        preparedStatement = connection.prepareStatement("insert into tak2(id,name,age,username,password) values (?,?,?,?,?)");
        preparedStatement.setLong(1, userEnti.getId());
        preparedStatement.setString(2, userEnti.getName());
        preparedStatement.setLong(3, userEnti.getAge());
        preparedStatement.setString(4, userEnti.getUsername());
        preparedStatement.setString(5, userEnti.getPassword());
        preparedStatement.executeUpdate();
    }


    public void update(UserEnti userEnti) throws Exception{
        preparedStatement=connection.prepareStatement ("update tak2 set name=? , age=? , username=? , password=? where id=? ");
        preparedStatement.setString (1,userEnti.getName());
        preparedStatement.setLong (2,userEnti.getAge());
        preparedStatement.setString (3,userEnti.getUsername());
        preparedStatement.setString (4,userEnti.getPassword());
        preparedStatement.setLong (5,userEnti.getId ());
        preparedStatement.executeUpdate ();
    }


    public List<UserEnti> select() throws Exception{
        preparedStatement=connection.prepareStatement ("select * from tak2 where id=?");
        preparedStatement.setLong(1,1);
        ResultSet resultSet=preparedStatement.executeQuery ();
        List<UserEnti> personEntiList=new ArrayList <> ();
        while (resultSet.next ()) {
            UserEnti personEnti = new UserEnti(); // call by reference
            personEnti.setId(resultSet.getLong("id"));
            personEnti.setName(resultSet.getString("name"));
            personEnti.setAge(resultSet.getLong("age"));
            personEnti.setUsername(resultSet.getString("username"));
            personEnti.setPassword(resultSet.getString("password"));
            personEntiList.add(personEnti);
            System.out.println("select");
        }
        return personEntiList;
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

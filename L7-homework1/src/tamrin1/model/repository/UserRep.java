package tamrin1.model.repository;

import tamrin1.model.entity.UserEnt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRep implements AutoCloseable{

    private Connection connection;
    private PreparedStatement preparedStatement;


    public UserRep() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "l7tamrin", "myjava123");
        connection.setAutoCommit(false);
    }


    public void insert(UserEnt userEnt) throws Exception{
        preparedStatement = connection.prepareStatement("insert into tak1 (id,salary,data,username,password) values (?,?,?,?,?)");
        preparedStatement.setLong(1,userEnt.getId());
        preparedStatement.setLong(2,userEnt.getSalary());
        preparedStatement.setLong(3,userEnt.getData());
        preparedStatement.setString(4,userEnt.getUsername());
        preparedStatement.setString(5,userEnt.getPassword());
        preparedStatement.executeUpdate();
        System.out.println("insert...");


    }

    public void update (UserEnt userEnt) throws Exception{
        preparedStatement=connection.prepareStatement ("update tak1 set data =?,salary=? where id=? ");
        preparedStatement.setLong (1,userEnt.getData());
        preparedStatement.setLong (2,userEnt.getSalary ());
        preparedStatement.setLong (3,1);
        preparedStatement.executeUpdate ();
        System.out.println("updated...");
    }


    public List<UserEnt> select() throws Exception{
        preparedStatement = connection.prepareStatement("select * from tak1 where id=?");
        preparedStatement.setLong(1,1);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<UserEnt> userEntList = new ArrayList<>();
        while (resultSet.next()){
            UserEnt userEnt = new UserEnt();
            userEnt.setId(resultSet.getLong("id"));
            userEnt.setSalary(resultSet.getLong("salary"));
            userEnt.setData(resultSet.getLong("data"));
            userEnt.setUsername(resultSet.getString("username"));
        }
        return userEntList;


//        preparedStatement=connection.prepareStatement ("SELECT * FROM person");
//        ResultSet resultSet=preparedStatement.executeQuery ();
//        List<PersonEnti> personEntiList=new ArrayList <> ();
//        while (resultSet.next ()){
//            PersonEnti personEnti=new PersonEnti (); // call by reference
//            personEnti.setId (resultSet.getLong ("id"));
//            personEnti.setName (resultSet.getString ("name"));
//            personEnti.setFamily (resultSet.getString ("family"));
//            personEnti.setSalary (resultSet.getInt ("salary"));
//            personEntiList.add (personEnti);
//        }
//        return personEntiList;


    }


    public void commit() throws Exception{
        connection.commit();
    }

    public void rollback() throws Exception{
        connection.rollback();
    }


    public void close() throws Exception{
        preparedStatement.close();
        connection.close();
    }


}

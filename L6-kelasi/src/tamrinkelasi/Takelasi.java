package tamrinkelasi;

import java.sql.*;
import java.util.Scanner;

public class Takelasi {

    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);
        String uName;
        String pWord;

        try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "l6tamrin1" , "myjava123")){

            Class.forName("oracle.jdbc.driver.OracleDriver");

            PreparedStatement preparedStatement1 = connection.prepareStatement("insert into takk(id,name,username,password,email) values (?,?,?,?,?)");
            preparedStatement1.setLong(1,1);
            preparedStatement1.setString(2,"emad");
            preparedStatement1.setString(3,"ek");
            preparedStatement1.setString(4,"1234");
            preparedStatement1.setString(5,"emad@gmail.com");
            System.out.println ("Insert into DB: "+preparedStatement1.executeUpdate());

            System.out.println("enter username=");
            uName = scanner.nextLine();
            System.out.println("enter password=");
            pWord = scanner.nextLine();

            if(uName.equals("ek") && pWord.equals("1234")) {
                PreparedStatement preparedStatement4 = connection.prepareStatement("select * from takk where id>=?");
                preparedStatement4.setLong(1, 1);
                ResultSet resultSet = preparedStatement4.executeQuery();
                System.out.println("Select results are as follows:");
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getLong("ID"));
                    System.out.println("UserName: " + resultSet.getString("username"));
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Email: " + resultSet.getString("email"));
                }
            }
            else
                System.out.println("invalid username or password");


        }catch (SQLException e){
            System.out.println("error "+e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

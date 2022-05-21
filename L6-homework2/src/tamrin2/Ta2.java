package tamrin2;

import java.sql.*;
import java.util.Scanner;

public class Ta2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "l6tamrin1" , "myjava123")){

            Class.forName("oracle.jdbc.driver.OracleDriver");

            PreparedStatement preparedStatement1 = connection.prepareStatement("insert into tak2(id,name,code,fatherName,duty,salary,history) values (?,?,?,?,?,?,?)");
            preparedStatement1.setLong(1,1);
            preparedStatement1.setString(2,"emad");
            preparedStatement1.setLong(3,1234);
            preparedStatement1.setString(4,"kamran");
            preparedStatement1.setString(5,"employee");
            preparedStatement1.setLong(6,1000);
            preparedStatement1.setLong(7,5);
            System.out.println ("Insert into DB: "+preparedStatement1.executeUpdate());

            System.out.println("1.delete"+'\n'+"2.continue");
            int x = scanner.nextInt();
            switch (x){
                case 1: {
                    System.out.println("enter your id=");
                    int idcode = scanner.nextInt();
                    PreparedStatement preparedStatement2 = connection.prepareStatement("delete from tak2 where id=?");
                    preparedStatement2.setLong(1, idcode);
                    System.out.println("delete: " + preparedStatement2.executeUpdate());
                }
                break;
                case 2:
                    System.out.println("ok...continue");
                    break;
                default:
                    System.out.println("wrong");
                    break;
            }


            PreparedStatement preparedStatement4 = connection.prepareStatement("select * from tak2 where id>=?");
            preparedStatement4.setLong(1,1);
            ResultSet resultSet = preparedStatement4.executeQuery();
            System.out.println ("Select results are as follows:");
            while (resultSet.next()) {
                System.out.println("ID: "+resultSet.getLong("id"));
                System.out.println("Name: "+resultSet.getString("name"));
                System.out.println("code: "+resultSet.getLong("code"));
                System.out.println("fatherName: "+resultSet.getString("fatherName"));
                System.out.println("duty: "+resultSet.getString("duty"));
                System.out.println("salary: "+resultSet.getLong("salary"));
                System.out.println("history: "+resultSet.getLong("history"));
            }

        }catch (SQLException e){
            System.out.println("error "+ e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("DB Driver Not Exist!!");
        }

    }
}

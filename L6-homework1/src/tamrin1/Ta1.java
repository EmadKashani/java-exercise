package tamrin1;

import java.sql.*;
import java.util.Scanner;

public class Ta1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "l6tamrin1",
                "myjava123")) {
            Class.forName("oracle.jdbc.driver.OracleDriver");// for old versions of JDBC

            System.out.println("1.show your info"+'\n'+"2.update");
            int x = scanner.nextInt();

            switch (x){
                case 1:
                {
                    PreparedStatement preparedStatement1 = connection.prepareStatement("insert into tak1 (id,username,password,email,age,education) values (?,?,?,?,?,?)");
                    preparedStatement1.setLong(1, 1);
                    preparedStatement1.setString(2, "emad");
                    preparedStatement1.setString(3, "kashani");
                    preparedStatement1.setString(4, "emad@gmail");
                    preparedStatement1.setLong(5, 19);
                    preparedStatement1.setString(6, "diploma");
                    System.out.println ("Insert into DB: "+preparedStatement1.executeUpdate());
                }
                break;
                case 2:
                {
                    PreparedStatement preparedStatement2 = connection.prepareStatement("update tak1 set username=?,password=?,email=?,age=?,education=? where id=?");
                    preparedStatement2.setString(1, "ek");
                    preparedStatement2.setString(2, "1234");
                    preparedStatement2.setString(3, "emad@gmail.com");
                    preparedStatement2.setLong(4, 20);
                    preparedStatement2.setString(5, "nothing");
                    preparedStatement2.setLong(6, 1);
                    System.out.println ("Update inside DB: "+preparedStatement2.executeUpdate());
                }
                break;

                default:
                    System.out.println("wrong");
                    break;

            }


            PreparedStatement preparedStatement4 = connection.prepareStatement("select * from tak1 where id=?");
            preparedStatement4.setLong(1,1);
            ResultSet resultSet = preparedStatement4.executeQuery();
            System.out.println ("Select results are as follows:");
            while (resultSet.next()) {
                System.out.println("ID: "+resultSet.getLong("ID"));
                System.out.println("userName: "+resultSet.getString("username"));
                System.out.println("password: "+resultSet.getString("password"));
                System.out.println("email: "+resultSet.getString("email"));
                System.out.println("age: "+resultSet.getLong("age"));
                System.out.println("education: "+resultSet.getString("education"));
            }

        } catch (ClassNotFoundException e)// if no lib files are added
        {
            System.out.println("DB Driver Not Exist!!");
        } catch (SQLException e)
        {
            System.out.println("DB ERROR " + e.getMessage());
        }


    }
}

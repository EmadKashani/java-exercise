package tamrin3;

import java.sql.*;
import java.util.Scanner;

public class Ta3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "l6tamrin1","myjava123")){

            Class.forName("oracle.jdbc.driver.OracleDriver");

            PreparedStatement preparedStatement1 = connection.prepareStatement("insert into tak3(id,code,name,year,score) values (?,?,?,?,?)");
            preparedStatement1.setLong(1,1);
            preparedStatement1.setLong(2,1234);
            preparedStatement1.setString(3,"emad");
            preparedStatement1.setLong(4,1400);
            preparedStatement1.setLong(5,17);
            System.out.println ("Insert into DB: "+preparedStatement1.executeUpdate());

            System.out.println("1.continue"+'\n'+"2.update"+'\n'+"3.delete");
            int x = scanner.nextInt();
            switch (x){
                case 1: {
                    System.out.println("ok...continue");


                }
                break;
                case 2:
                {
                    PreparedStatement preparedStatement2 = connection.prepareStatement("update tak3 set code=? , name=? , year=? , score=? where id=?");
                    preparedStatement2.setLong(1,4321 );
                    preparedStatement2.setString(2, "emad");
                    preparedStatement2.setLong(3, 1401);
                    preparedStatement2.setLong(4, 18);
                    preparedStatement2.setLong(5, 1);
                    System.out.println ("Update inside DB: "+preparedStatement2.executeUpdate());

                }
                break;
                case 3:
                {
                    PreparedStatement preparedStatement3 = connection.prepareStatement("delete from tak3 where id=?");
                    preparedStatement3.setLong(1, 1);
                    System.out.println ("Delete from DB: "+preparedStatement3.executeUpdate());
                }
                break;
                default:
                    System.out.println("wrong");
                    break;





            }

            PreparedStatement preparedStatement4 = connection.prepareStatement("select * from tak3 where id>=?");
            preparedStatement4.setLong(1, 1);
            ResultSet resultSet = preparedStatement4.executeQuery();
            System.out.println("Select results are as follows:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getLong("ID"));
                System.out.println("Code: " + resultSet.getLong("code"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Year: " + resultSet.getLong("year"));
                System.out.println("Score: " + resultSet.getLong("score"));
            }



        }catch (SQLException e){
            System.out.println("error "+ e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

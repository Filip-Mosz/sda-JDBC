import java.math.BigDecimal;
import java.sql.*;

public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello JDBC :)");
//
//         }


    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_company?serverTimezone=Europe/Warsaw";
    private static final String USER = "root";
    private static final String PASSWORD = "nornwaith";

    public static void main(String[] args) throws SQLException{
        Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
        while(resultSet.next()) {
            //first_name, last_name, gender, position, salary, id
            String title= resultSet.getString(5);
            String firstName = resultSet.getString(1);
            String lastName = resultSet.getString(2);
            String gender = resultSet.getString(3);
            String salary = resultSet.getString(4);
            System.out.print(String.format("Stanowisko: %s; ", title));
            System.out.print(String.format("Imię i Nazwisko: %s %s; ", firstName, lastName));
            System.out.print(String.format("Płeć: %s; ", gender));
            System.out.println(String.format("Wysokość wynagrodzenia: %s; ", salary));
        }
        statement.close();
        connection.close();
    }

}

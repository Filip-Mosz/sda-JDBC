import java.sql.*;

public class Main {


    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_company?serverTimezone=Europe/Warsaw";
    private static final String USER = "root";
    private static final String PASSWORD = "nornwaith";

    public static void main(String[] args) throws SQLException{
        Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee ORDER BY position");
        while(resultSet.next()) {
            String title= resultSet.getString(5);
            String firstName = resultSet.getString(1);
            String lastName = resultSet.getString(2);
            String gender = resultSet.getString(3);
            String salary = resultSet.getString(4);
            String id = resultSet.getString(6);
            System.out.print(String.format("ID: %3s; ", id));
            System.out.print(String.format("Stanowisko: %-24s; ", title));
            System.out.print(String.format("Imię i Nazwisko: %-10s %-16s; ", firstName, lastName));
            System.out.print(String.format("Płeć: %s; ", gender));
            System.out.println(String.format("Wysokość wynagrodzenia: %5s; ", salary));
        }
        statement.close();
        connection.close();
    }

}

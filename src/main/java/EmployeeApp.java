import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class EmployeeApp {
    private static final String url = "jdbc:mysql://localhost:3306/jdbc_company?serverTimezone=Europe/Warsaw";
    private static final String password = "nornwaith";
    private static final String user = "root";



    public static void main(String[] args) throws SQLException {


        Scanner scan = new Scanner(System.in);
//        System.out.println("Creating Connection/n User name_");
//        String user = scan.nextLine();
//        System.out.println("Password_");
//        String password = scan.nextLine();
        Connection connection = DriverManager.getConnection(url, user, password);

        Employee emp1= new Employee("Jan",
                "Kaczmarek",
                "M",
                BigDecimal.valueOf(3000),
                "Literally No one",
                LocalDate.of(2020,02,02));
        EmployeeDAO empDao = new EmployeeDAO(connection);
        System.out.println(empDao.create(emp1));
        Employee empRead = empDao.read(6);
        System.out.println(empRead);

        emp1.setName("Jacek");
        emp1.setSurname("Kaczmarski");
        emp1.setPosition("Bard");
        empDao.update(11,emp1);
    }
}

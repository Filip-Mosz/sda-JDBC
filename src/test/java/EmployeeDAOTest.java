import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeDAOTest {

    //utworzyć baze danych, pustą

    //utworzyc polaczenie
    private static final String url = "jdbc:mysql://localhost:3306/jdbc_company_test?serverTimezone=Europe/Warsaw";
    private static final String password = "nornwaith";
    private static final String user = "root";
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    Employee testEmployee = new Employee.Builder()
            .withName("Jacek")
            .withGender("M")
            .withHireDate(LocalDate.of(2010, 8, 22))
            .withPosition("Literally No One")
            .withSalary(BigDecimal.ZERO)
            .withSurname("kowal")
            .build();
    EmployeeDAO testDao = new EmployeeDAO(connection);

    EmployeeDAOTest() throws SQLException {
    }


    @Test
    void createAndRead() {
        testDao.create(testEmployee);

        assertEquals(testDao.read(1), testEmployee);
        assertTrue(testEmployee.getSurname().equals(testDao.read(1).getSurname()));
        assertTrue(testEmployee.getHireDate().equals(testDao.read(1).getHireDate()));
        assertTrue(testEmployee.getSalary().equals(testDao.read(1).getSalary()));
        assertTrue(testEmployee.getPosition().equals(testDao.read(1).getPosition()));
        assertTrue(testEmployee.getGender().equals(testDao.read(1).getGender()));
    }

    @Test
    void update() { //testDao.read zwraca nulle
        System.out.println("before " + testEmployee);
        testEmployee.setSurname("Kaczmarski");
        testEmployee.setPosition("Bard");
        testEmployee.setSalary(BigDecimal.valueOf(10000));

        System.out.println(testDao.update(1, testEmployee));
        System.out.println("after " + testEmployee);
        System.out.println("testDao " + testDao.read(1));

        System.out.println("nejm" + testDao.read(1).getName());

        assertTrue(testEmployee.getName().equals(testDao.read(1).getName()));
        assertTrue(testEmployee.getSurname().equals(testDao.read(1).getSurname()));
        assertTrue(testEmployee.getHireDate().equals(testDao.read(1).getHireDate()));
        assertTrue(testEmployee.getSalary().equals(testDao.read(1).getSalary()));
        assertTrue(testEmployee.getPosition().equals(testDao.read(1).getPosition()));
        assertTrue(testEmployee.getGender().equals(testDao.read(1).getGender()));
    }

    @Test
    void delete() {
    }

//    @AfterAll
//    public static void truncate() {
//        Statement truncate = null;
//        try {
//            truncate = connection.createStatement();
//            truncate.execute("TRUNCATE TABLE employee;");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
}
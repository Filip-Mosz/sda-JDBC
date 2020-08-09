import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class EmployeeDAO implements AutoCloseable{

    private String name;
    private String surname;
    private GenderEnum gender;
    private BigDecimal salary;
    private String position;
    private LocalDate hireDate;

    private  Connection dbConnection;

    public EmployeeDAO(Connection connection) throws SQLException {
        this.dbConnection = connection;

    }

    public boolean create(Employee emp){//works
        try {
            PreparedStatement statement= dbConnection.prepareStatement(
                    "INSERT INTO employee (first_name, last_name, gender, position, salary, id, hire_date)" +
                    "VALUES ?,?,?,?,?,?,?");
            statement.setString(1,emp.getName());
            statement.setString(2,emp.getSurname());
            statement.setString(3,emp.getGender());
            statement.setString(4,emp.getPosition());
            statement.setInt(5,Integer.parseInt(emp.getSalary().toString()));
            statement.setString(7,emp.getHireDate().toString());

        } catch (SQLException throwables) {
            return false;
        }
        return true;
    }

    public boolean read(Employee emp){
        try {
            PreparedStatement statement= dbConnection.prepareStatement(
                    "INSERT INTO employee (first_name, last_name, gender, position, salary, id, hire_date)" +
                    "VALUES ?,?,?,?,?,?,?");
            statement.setString(1,emp.getName());
            statement.setString(2,emp.getSurname());
            statement.setString(3,emp.getGender());
            statement.setString(4,emp.getPosition());
            statement.setInt(5,Integer.parseInt(emp.getSalary().toString()));
            statement.setString(7,emp.getHireDate().toString());

        } catch (SQLException throwables) {
            return false;
        }
        return true;
    }

    @Override
    public void close() throws Exception {

    }
}
//create przyjmij obiekt pracownik i wrzuć do bazy
//read przeczytaj rekord(id) i stwórz obiekt pracownik
//update zmień rekord na podstawie zmian obiektu
//delete usuń obiekt pracownik i rekord

    //Employee
//EmployeeDao employeeDao = new EmployeeDAO(connection);
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class EmployeeDAO implements AutoCloseable {

    private String name;
    private String surname;
    private String gender;
    private BigDecimal salary;
    private String position;
    private LocalDate hireDate;

    private Connection dbConnection;

    public EmployeeDAO(Connection connection) throws SQLException {
        this.dbConnection = connection;

    }

    public boolean create(Employee emp) {//works
        try {
            PreparedStatement statement = dbConnection.prepareStatement(
                    "INSERT INTO employee (first_name, last_name, gender, position, salary, hire_date)" +
                            "VALUES (?,?,?,?,?,?);");
            statement.setString(1, emp.getName());
            statement.setString(2, emp.getSurname());
            statement.setString(3, emp.getGender());
            statement.setString(4, emp.getPosition());
            statement.setInt(5, Integer.parseInt(emp.getSalary().toString()));
            statement.setString(6, emp.getHireDate().toString());
            statement.executeUpdate();//ZAJEBISCIE WAZNA LINIJKA!!!!!

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Employee read(int id) {
        try {
            PreparedStatement statement = dbConnection.prepareStatement(
                    "SELECT * FROM employee\n" +
                            "WHERE id=?;");
            statement.setInt(1, id);
            statement.execute();//ZAJEBISCIE WAZNA LINIJKA!!!!!

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                this.name = resultSet.getString(1);
                this.surname = resultSet.getString(2);
                this.gender = resultSet.getString(3);
                this.salary = BigDecimal.valueOf(Long.parseLong(resultSet.getString(4)));
                this.position = resultSet.getString(5);
                this.hireDate = LocalDate.parse(resultSet.getString(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return new Employee(".", ".", ".", BigDecimal.ZERO, ".", LocalDate.of(0, 1, 1));
        }
        return new Employee(this.name,
                this.surname,
                this.gender,
                this.salary,
                this.position,
                this.hireDate);
    }

    public boolean update(int id, Employee emp) { //wypadałoby przeładować dla każdej kolumny

        Employee empOld = read(id); //przypisanie "starych" danych do obiektu, będę porównywał z mowym obiektem


        try {
            PreparedStatement statement = dbConnection.prepareStatement(
                    "UPDATE employee " +
                        "SET first_name = ?," +
                            "last_name = ?," +
                            "gender = ?," +
                            "position = ?," +
                            "salary = ?," +
                            "hire_date = ?" +
                        "WHERE id = ?;");
            statement.setString(1, emp.getName());
            statement.setString(2, emp.getSurname());
            statement.setString(3, emp.getGender());
            statement.setString(4, emp.getPosition());
            statement.setInt(5, Integer.parseInt(emp.getSalary().toString()));
            statement.setString(6, emp.getHireDate().toString());
            statement.setInt(7, id);
            statement.executeUpdate();//ZAJEBISCIE WAZNA LINIJKA!!!!!

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean delete(int id){
        try {
            PreparedStatement statement = dbConnection.prepareStatement(
                    "DELETE FROM employee\n" +
                            "WHERE id=?;");
            statement.setInt(1, id);
            statement.execute();//ZAJEBISCIE WAZNA LINIJKA!!!!!

//            ResultSet resultSet = statement.getResultSet();
//            while (resultSet.next()) {
//                this.name = resultSet.getString(1);
//                this.surname = resultSet.getString(2);
//                this.gender = resultSet.getString(3);
//                this.salary = BigDecimal.valueOf(Long.parseLong(resultSet.getString(4)));
//                this.position = resultSet.getString(5);
//                this.hireDate = LocalDate.parse(resultSet.getString(6));
//            }

        } catch (SQLException e) {
            e.printStackTrace();
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
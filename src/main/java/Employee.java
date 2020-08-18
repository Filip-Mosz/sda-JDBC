import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
//todo zrobić na szkielecie Buildera

@Getter
@Setter
public class Employee {

    private String name;
    private String surname;
    private String gender;
    private BigDecimal salary;
    private String position;
    private LocalDate hireDate;

    public Employee(String name, String surname, String gender, BigDecimal salary, String position, LocalDate hireDate) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.salary = salary;
        this.position = position;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}

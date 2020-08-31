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

    public Employee() {
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

    public static class Builder extends Employee{
        private String name;
        private String surname;
        private String gender;
        private BigDecimal salary;
        private String position;
        private LocalDate hireDate;

        public Builder(String name, String surname, String gender, BigDecimal salary, String position, LocalDate hireDate) {
            super(name, surname, gender, salary, position, hireDate);
        }
        public Builder() {
            super();
        }

        public Builder withName(String name){
            this.name=name;
            return this;
        }

        public Builder withSurname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder withGender(String gender){
            this.gender = gender;
            return this;
        }

        public Builder withSalary(BigDecimal salary){
            this.salary = salary;
            return this;
        }

        public Builder withPosition(String position){
            this.position = position;
            return this;
        }

        public Builder withHireDate(LocalDate hireDate){
            this.hireDate = hireDate;
            return this;
        }

        public Employee build(){
            return new Employee (name, surname, gender, salary, position, hireDate);
        }
    }

}

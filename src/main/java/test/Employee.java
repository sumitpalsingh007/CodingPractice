package test;

import java.util.Objects;

public class Employee {

    private String firstName;

    private String lastName;

    private Integer age;

    private Integer empId;

    public Employee(final String firstName, final String lastName, final Integer age, final Integer empId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.empId = empId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(age, employee.age) && Objects.equals(empId, employee.empId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, empId);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(final Integer empId) {
        this.empId = empId;
    }


}

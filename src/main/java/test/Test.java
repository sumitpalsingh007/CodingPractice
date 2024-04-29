package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args){

        Employee e1 = new Employee("Sumit", "Singh", 27, 1);
        Employee e2 = new Employee("Sumit", "Singh", 27, 2);
        Employee e3 = new Employee("Sumit", "Singh", 27, 3);
        Employee e4 = new Employee("Sumit", "Singh", 27, 1);

        var list = new ArrayList<Employee>();
        var set = new HashSet<>(list);

        set.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .sorted(Comparator.comparing(Employee::getEmpId))
                .collect(Collectors.toList());
    }
}

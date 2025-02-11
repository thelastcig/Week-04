import java.util.*;

class Employee {
    String name;
    String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupEmployeesByDepartment {
    public static void main(String[] args) {
       
        List<Employee> employees = Arrays.asList(
            new Employee("Sonu", "HR"),
            new Employee("Aman", "IT"),
            new Employee("Vikash", "HR"),
            new Employee("Saurabh", "IT"),
            new Employee("Monu", "Finance")
        );

     
        Map<String, List<Employee>> groupedEmployees = groupByDepartment(employees);

        
        for (Map.Entry<String, List<Employee>> entry : groupedEmployees.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        for (Employee emp : employees) {
          
            departmentMap.putIfAbsent(emp.department, new ArrayList<>());
            
            
            departmentMap.get(emp.department).add(emp);
        }

        return departmentMap;
    }
}

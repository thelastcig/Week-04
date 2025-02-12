import java.io.*;
import java.util.ArrayList;
import java.util.List;


class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

   
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

  
    public void displayEmployee() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: $" + salary);
    }
}

public class EmployeeSerialization {
    private static final String FILE_NAME = "employees.dat"; 

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Sonu", "IT", 60000));
        employees.add(new Employee(2, "Saurabh", "HR", 50000));
        employees.add(new Employee(3, "Aman", "Finance", 55000));

        
        serializeEmployees(employees);

       
        List<Employee> retrievedEmployees = deserializeEmployees();
        System.out.println("\nRetrieved Employees from file:");
        for (Employee emp : retrievedEmployees) {
            emp.displayEmployee();
        }
    }

    
    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    
    private static List<Employee> deserializeEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error retrieving employees: " + e.getMessage());
        }
        return employees;
    }
}

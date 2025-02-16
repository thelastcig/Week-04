import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class ClassInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the fully qualified class name: ");
        String className = scanner.nextLine();
        scanner.close();

        try {
            
            Class<?> clazz = Class.forName(className);
            
          
            System.out.println("Class: " + clazz.getName());
        
            System.out.println("\nFields:");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            
            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
            
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }
            
            
            if (className.equals("Person")) {
                Person person = new Person(25);
                person.displayAge();
                
                Field ageField = clazz.getDeclaredField("age");
                ageField.setAccessible(true);
                ageField.set(person, 30);
                
                System.out.println("Modified Age: " + ageField.get(person));
                person.displayAge();
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Error accessing field: " + e.getMessage());
        }
    }
}

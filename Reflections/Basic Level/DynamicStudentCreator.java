import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class Student {
    private String name;

 
    public Student() {
        this.name = "Default Student";
    }

   
    public Student(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicStudentCreator {
    public static void main(String[] args) {
        try {
            
            Class<?> clazz = Class.forName("Student");

           
            Constructor<?> constructor = clazz.getDeclaredConstructor();

           
            Object studentObj = constructor.newInstance();

            
            Method method = clazz.getMethod("display");
            method.invoke(studentObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

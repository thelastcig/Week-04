import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement user authentication", assignedTo = "Sonu", priority = "HIGH")
    public void userAuthentication() {
        System.out.println("Auth feature is under development...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Aman")
    public void optimizeDatabase() {
        System.out.println("Database optimization is pending...");
    }

    @Todo(task = "Add unit tests", assignedTo = "Saurabh", priority = "LOW")
    public void addTests() {
        System.out.println("Unit tests need to be added...");
    }
}

public class TodoTracker {
    public static void main(String[] args) {
        Method[] methods = Project.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Task: " + annotation.task());
                System.out.println("Assigned To: " + annotation.assignedTo());
                System.out.println("Priority: " + annotation.priority());
                System.out.println("--------------------------");
            }
        }
    }
}

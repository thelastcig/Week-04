import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Sonu Sharma")
    public void completeTask() {
        System.out.println("Task completed!");
    }
}

public class AnnotationProcessor {
    public static void main(String[] args) {
        try {
            Method method = TaskManager.class.getMethod("completeTask");
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo task = method.getAnnotation(TaskInfo.class);
                System.out.println("Priority: " + task.priority());
                System.out.println("Assigned To: " + task.assignedTo());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

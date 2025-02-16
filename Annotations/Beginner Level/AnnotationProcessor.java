import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Service {
    @ImportantMethod
    public void criticalOperation() {
        System.out.println("Executing critical operation...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void regularOperation() {
        System.out.println("Executing regular operation...");
    }

    public void normalMethod() {
        System.out.println("This method is not marked as important.");
    }
}

public class AnnotationProcessor {
    public static void main(String[] args) {
        Method[] methods = Service.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Importance Level: " + annotation.level());
            }
        }
    }
}

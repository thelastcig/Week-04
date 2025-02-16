import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class PerformanceTester {
    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Fast method running...");
    }

    @LogExecutionTime
    public void slowMethod() {
        System.out.println("Slow method running...");
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ExecutionLogger {
    public static void main(String[] args) throws Exception {
        PerformanceTester tester = new PerformanceTester();
        Method[] methods = PerformanceTester.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(tester);
                long endTime = System.nanoTime();
                System.out.println("Execution time for " + method.getName() + ": " + (endTime - startTime) / 1_000_000.0 + " ms");
                System.out.println("--------------------------");
            }
        }
    }
}

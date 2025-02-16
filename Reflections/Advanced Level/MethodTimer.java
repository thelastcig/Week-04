import java.lang.reflect.Method;

class Task {
    public void fastMethod() {
        System.out.println("Fast method executed.");
    }

    public void slowMethod() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Slow method executed.");
    }
}

public class MethodTimer {
    public static void executeWithTiming(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            long startTime = System.nanoTime();
            method.invoke(obj);
            long endTime = System.nanoTime();
            System.out.println(methodName + " execution time: " + (endTime - startTime) / 1_000_000.0 + " ms");
        } catch (Exception e) {
            System.out.println("Error executing method: " + methodName);
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        executeWithTiming(task, "fastMethod");
        executeWithTiming(task, "slowMethod");
    }
}

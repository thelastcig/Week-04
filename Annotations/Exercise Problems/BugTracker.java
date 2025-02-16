import java.lang.annotation.*;
import java.lang.reflect.Method;

@Repeatable(BugReports.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class Software {
    @BugReport(description = "Null pointer exception when input is null")
    @BugReport(description = "Performance issue when handling large data")
    public void process() {
        System.out.println("Processing data...");
    }
}

public class BugTracker {
    public static void main(String[] args) {
        try {
            Method method = Software.class.getMethod("process");
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReport[] reports = method.getAnnotationsByType(BugReport.class);
                for (BugReport report : reports) {
                    System.out.println("Bug: " + report.description());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

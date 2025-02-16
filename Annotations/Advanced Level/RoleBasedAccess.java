import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed successfully!");
    }
}

class AccessControl {
    private String currentUserRole;

    public AccessControl(String role) {
        this.currentUserRole = role;
    }

    public void invokeMethod(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(RoleAllowed.class)) {
                String requiredRole = method.getAnnotation(RoleAllowed.class).value();

                if (!currentUserRole.equals(requiredRole)) {
                    System.out.println("Access Denied! You need " + requiredRole + " role to execute this method.");
                    return;
                }
            }

            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class RoleBasedAccess {
    public static void main(String[] args) {
        SecureService service = new SecureService();

        AccessControl adminAccess = new AccessControl("ADMIN");
        adminAccess.invokeMethod(service, "adminTask");

        AccessControl userAccess = new AccessControl("USER");
        userAccess.invokeMethod(service, "adminTask");  
    }
}

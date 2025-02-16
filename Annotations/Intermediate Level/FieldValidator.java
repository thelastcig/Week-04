import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validateMaxLength();
    }

    private void validateMaxLength() {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                int maxLength = field.getAnnotation(MaxLength.class).value();
                if (username.length() > maxLength) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength + " characters.");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

public class FieldValidator {
    public static void main(String[] args) {
        try {
            User user1 = new User("sonu123");  
            System.out.println("User created: " + user1.getUsername());

            User user2 = new User("SuperLongUsername");  
            System.out.println("User created: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

import java.lang.reflect.Field;
import java.util.Map;

class User {
    private String name;
    private int age;
    private String email;

    public User() {}

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}

public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                try {
                    Field field = clazz.getDeclaredField(entry.getKey());
                    field.setAccessible(true);

                    if (field.getType().isAssignableFrom(entry.getValue().getClass())) {
                        field.set(instance, entry.getValue());
                    } else if (field.getType() == int.class && entry.getValue() instanceof Number) {
                        field.set(instance, ((Number) entry.getValue()).intValue());
                    } else if (field.getType() == double.class && entry.getValue() instanceof Number) {
                        field.set(instance, ((Number) entry.getValue()).doubleValue());
                    } else if (field.getType() == long.class && entry.getValue() instanceof Number) {
                        field.set(instance, ((Number) entry.getValue()).longValue());
                    } else if (field.getType() == boolean.class && entry.getValue() instanceof Boolean) {
                        field.set(instance, entry.getValue());
                    } else {
                        field.set(instance, entry.getValue().toString());
                    }
                } catch (NoSuchFieldException e) {
                    System.out.println("Warning: No field found for key '" + entry.getKey() + "'");
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Error creating object", e);
        }
    }

    public static void main(String[] args) {
        Map<String, Object> userData = Map.of(
            "name", "Sonu Sharma",
            "age", 21,
            "email", "sonu@example.com"
        );

        User user = toObject(User.class, userData);
        System.out.println(user);
    }
}

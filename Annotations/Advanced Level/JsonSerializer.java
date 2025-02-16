import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String toJson() {
        Map<String, String> jsonMap = new HashMap<>();

        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true);
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    jsonMap.put(annotation.name(), field.get(this).toString());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return jsonMap.toString().replace("=", ": ").replace("{", "{ ").replace("}", " }");
    }
}

public class JsonSerializer {
    public static void main(String[] args) {
        User user = new User("Sonu", 21);
        String json = user.toJson();
        System.out.println(json);
    }
}

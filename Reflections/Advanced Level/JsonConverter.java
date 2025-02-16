import java.lang.reflect.Field;
import java.util.*;

public class JsonConverter {
    public static String toJson(Object obj) {
        if (obj == null) return "null";
        StringBuilder json = new StringBuilder("{");

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        List<String> jsonPairs = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                String jsonValue = formatValue(value);
                jsonPairs.add("\"" + field.getName() + "\":" + jsonValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append(String.join(",", jsonPairs)).append("}");
        return json.toString();
    }

    private static String formatValue(Object value) {
        if (value == null) return "null";
        if (value instanceof String || value instanceof Character) return "\"" + value + "\"";
        if (value instanceof Number || value instanceof Boolean) return value.toString();
        if (value.getClass().isArray()) return formatArray(value);
        if (value instanceof Collection) return formatCollection((Collection<?>) value);
        if (value instanceof Map) return formatMap((Map<?, ?>) value);
        return toJson(value);
    }

    private static String formatArray(Object array) {
        int length = java.lang.reflect.Array.getLength(array);
        List<String> elements = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            elements.add(formatValue(java.lang.reflect.Array.get(array, i)));
        }
        return "[" + String.join(",", elements) + "]";
    }

    private static String formatCollection(Collection<?> collection) {
        List<String> elements = new ArrayList<>();
        for (Object item : collection) {
            elements.add(formatValue(item));
        }
        return "[" + String.join(",", elements) + "]";
    }

    private static String formatMap(Map<?, ?> map) {
        List<String> entries = new ArrayList<>();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            String key = "\"" + entry.getKey().toString() + "\"";
            String value = formatValue(entry.getValue());
            entries.add(key + ":" + value);
        }
        return "{" + String.join(",", entries) + "}";
    }

    public static void main(String[] args) {
        class User {
            private String name = "Sonu Sharma";
            private int age = 25;
            private boolean active = true;
            private List<String> hobbies = List.of("Reading", "Gaming");
            private Map<String, Object> preferences = Map.of("theme", "dark", "notifications", true);
        }

        User user = new User();
        System.out.println(toJson(user));
    }
}

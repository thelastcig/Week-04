import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

// Define @Inject annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

// Service interface and implementation
interface Service {
    void perform();
}

class ServiceImpl implements Service {
    public void perform() {
        System.out.println("Service is performing...");
    }
}

// Class with dependency
class Client {
    @Inject
    private Service service;

    public void execute() {
        service.perform();
    }
}

// Simple DI container
class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public DIContainer() {
        register(Service.class, new ServiceImpl());
    }

    public void register(Class<?> type, Object instance) {
        instances.put(type, instance);
    }

    public <T> T createInstance(Class<T> clazz) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            injectDependencies(instance);
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Error creating instance of " + clazz.getName(), e);
        }
    }

    private void injectDependencies(Object instance) {
        for (Field field : instance.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Object dependency = instances.get(field.getType());
                if (dependency == null) throw new RuntimeException("No registered dependency for " + field.getType());
                field.setAccessible(true);
                try {
                    field.set(instance, dependency);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to inject dependency into " + field.getName(), e);
                }
            }
        }
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        DIContainer container = new DIContainer();
        Client client = container.createInstance(Client.class);
        client.execute();
    }
}

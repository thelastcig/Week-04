import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            
            Calculator calc = new Calculator();

            
            Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

           
            method.setAccessible(true);

            
            int result = (int) method.invoke(calc, 5, 4);

           
            System.out.println("Result of multiplication: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

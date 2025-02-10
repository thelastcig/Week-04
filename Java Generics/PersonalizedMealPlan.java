import java.util.*;


interface MealPlan {
    void displayMeal();
}

class VegetarianMeal implements MealPlan {
    public void displayMeal() { System.out.println("Vegetarian Meal: Grilled Tofu with Vegetables"); }
}

class VeganMeal implements MealPlan {
    public void displayMeal() { System.out.println("Vegan Meal: Quinoa Salad with Avocado"); }
}

class KetoMeal implements MealPlan {
    public void displayMeal() { System.out.println("Keto Meal: Grilled Chicken with Avocado"); }
}

class HighProteinMeal implements MealPlan {
    public void displayMeal() { System.out.println("High-Protein Meal: Salmon with Quinoa"); }
}

class Meal<T extends MealPlan> {
    T mealType;
    
    Meal(T mealType) { this.mealType = mealType; }

    void display() { mealType.displayMeal(); }
}

class MealPlanGenerator {
    static <T extends MealPlan> void generateMealPlan(T meal) {
        System.out.println("Generated Meal Plan:");
        meal.displayMeal();
    }
}

public class PersonalizedMealPlan {
    public static void main(String[] args) {
        Meal<VeganMeal> vegan = new Meal<>(new VeganMeal());
        Meal<KetoMeal> keto = new Meal<>(new KetoMeal());

        
        MealPlanGenerator.generateMealPlan(vegan.mealType);
        MealPlanGenerator.generateMealPlan(keto.mealType);
    }
}

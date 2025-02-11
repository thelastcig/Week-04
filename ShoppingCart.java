import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPriceMap = new HashMap<>(); 
    private LinkedHashMap<String, Integer> cartItems = new LinkedHashMap<>(); 
    private TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();
    public void addProduct(String product, double price) {
     
        productPriceMap.put(product, price);

       
        cartItems.put(product, cartItems.getOrDefault(product, 0) + 1);

        updateSortedByPrice(product, price);
    }

    private void updateSortedByPrice(String product, double price) {
       
        sortedByPrice.values().forEach(list -> list.remove(product));


        sortedByPrice.putIfAbsent(price, new ArrayList<>());
        sortedByPrice.get(price).add(product);
    }

    public void displayCartItems() {
        System.out.println("Cart Items (In order of addition):");
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            System.out.println(entry.getKey() + " - Quantity: " + entry.getValue() + " - Price: $" + productPriceMap.get(entry.getKey()));
        }
    }

    public void displayItemsSortedByPrice() {
        System.out.println("Items Sorted by Price:");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " - Price: $" + entry.getKey());
            }
        }
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            total += productPriceMap.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

       
        cart.addProduct("Apple", 1.50);
        cart.addProduct("Banana", 0.99);
        cart.addProduct("Orange", 1.25);
        cart.addProduct("Milk", 3.99);
        cart.addProduct("Apple", 1.50); 

       
        cart.displayCartItems();
        System.out.println();

       
        cart.displayItemsSortedByPrice();
        System.out.println("\nTotal Price: $" + cart.getTotalPrice());
    }
}

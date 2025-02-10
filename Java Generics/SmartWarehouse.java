import java.util.*;

abstract class WarehouseItem {
    String name;
    WarehouseItem(String name) { this.name = name; }
    abstract void display();
}

class Electronics extends WarehouseItem {
    Electronics(String name) { super(name); }
    void display() { System.out.println("Electronics: " + name); }
}

class Groceries extends WarehouseItem {
    Groceries(String name) { super(name); }
    void display() { System.out.println("Groceries: " + name); }
}

class Furniture extends WarehouseItem {
    Furniture(String name) { super(name); }
    void display() { System.out.println("Furniture: " + name); }
}


class Storage<T extends WarehouseItem> {
    List<T> items = new ArrayList<>();
    void addItem(T item) { items.add(item); }
    List<T> getItems() { return items; }
}

class WarehouseUtils {
    static void displayItems(List<? extends WarehouseItem> items) {
        items.forEach(WarehouseItem::display);
    }
}

public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<Electronics> electronics = new Storage<>();
        electronics.addItem(new Electronics("Laptop"));
        
        Storage<Groceries> groceries = new Storage<>();
        groceries.addItem(new Groceries("Milk"));

        Storage<Furniture> furniture = new Storage<>();
        furniture.addItem(new Furniture("Chair"));

        WarehouseUtils.displayItems(electronics.getItems());
        WarehouseUtils.displayItems(groceries.getItems());
        WarehouseUtils.displayItems(furniture.getItems());
    }
}

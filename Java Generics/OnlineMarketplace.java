import java.util.*;


interface Category {
    String getCategoryName();
}


enum BookCategory implements Category {
    FICTION, NON_FICTION;
    public String getCategoryName() { return name(); }
}

enum ClothingCategory implements Category {
    MENS_WEAR, WOMENS_WEAR;
    public String getCategoryName() { return name(); }
}

enum GadgetCategory implements Category {
    MOBILE, LAPTOP;
    public String getCategoryName() { return name(); }
}


class Product<T extends Category> {
    String name;
    double price;
    T category;

    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    void display() {
        System.out.println(name + " (" + category.getCategoryName() + ") - $" + price);
    }
}


class MarketplaceUtils {
    static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.price -= product.price * (percentage / 100);
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Harry Potter", 20.0, BookCategory.FICTION);
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 15.0, ClothingCategory.MENS_WEAR);
        Product<GadgetCategory> phone = new Product<>("iPhone", 999.0, GadgetCategory.MOBILE);

        List<Product<?>> catalog = Arrays.asList(book, shirt, phone);

      
        MarketplaceUtils.applyDiscount(book, 10);
        MarketplaceUtils.applyDiscount(shirt, 5);
        MarketplaceUtils.applyDiscount(phone, 15);

  
        catalog.forEach(Product::display);
    }
}

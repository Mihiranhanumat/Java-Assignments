import java.util.*;

public class InventoryManager {

    // Singleton instance
    private static InventoryManager instance = new InventoryManager();

    // List of products
    private List<Product> productList;

    // Private constructor
    private InventoryManager() {
        productList = new ArrayList<>();
    }

    // Get instance
    public static InventoryManager getInstance() {
        return instance;
    }

    // Add product
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Iterator
    public Iterator<Product> returnInventory() {
        return productList.iterator();
    }
}
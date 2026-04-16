import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        // Singleton instance
        InventoryManager manager = InventoryManager.getInstance();

        // New Products
        manager.addProduct(new NewProduct("Laptop"));
        manager.addProduct(new NewProduct("Phone"));

        // Legacy Products (using Adapter)
        LegacyItem old1 = new LegacyItem(101, "Old Printer");
        LegacyItem old2 = new LegacyItem(102, "Old Scanner");

        manager.addProduct(new ProductAdapter(old1));
        manager.addProduct(new ProductAdapter(old2));

        // Iterator
        Iterator<Product> it = manager.returnInventory();

        while (it.hasNext()) {
            Product p = it.next();
            p.displayDetails();
            System.out.println();
        }
    }
}
public class Main {

    public static void main(String[] args) {

        RestaurantCRUD obj = new RestaurantCRUD();

        obj.insertData();

        System.out.println("\n--- Price <=100 ---");
        obj.selectCheapItems();

        System.out.println("\n--- Cafe Java Items ---");
        obj.selectCafeJavaItems();

        obj.updateItems();

        System.out.println("\n--- After Update ---");
        obj.selectCheapItems();

        obj.deleteItems();

        System.out.println("\n--- After Delete ---");
        obj.selectCheapItems();
    }
}
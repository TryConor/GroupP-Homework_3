package edu.mu.mediaProduct;

import edu.mu.mediaProduct.MediaProduct;
import edu.mu.products.CDRecordProduct;
import edu.mu.products.Genre;
import edu.mu.products.TapeRecordProduct;
import edu.mu.products.VinylRecordProduct;
import edu.mu.stockManager.StockManagerSingleton;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create an instance of StockManagerSingleton
        StockManagerSingleton stockManager = StockManagerSingleton.getInstance();
        stockManager.initializeStock();
        
        

        // Create some MediaProduct objects
        MediaProduct productA = new MediaProduct("CD", "Product A", 19.99, 2023, Genre.ROCK);
        MediaProduct productB = new MediaProduct("Vinyl", "Product B", 29.99, 2024, Genre.POP);
        
//        // Test addItem method
        System.out.println("Adding products to the inventory:");
        boolean addItemResult1 = stockManager.addItem(productA);
        boolean addItemResult2 = stockManager.addItem(productB);
        System.out.println("Add item result 1: " + addItemResult1); // Should be true
        System.out.println("Add item result 2: " + addItemResult2); // Should be true

        //Test updateItemPrice method
        System.out.println("\nUpdating the price of Product A:");
        boolean updatePriceResult = stockManager.updateItemPrice(productA, 24.99);
        System.out.println("Update price result: " + updatePriceResult); // Should be true

        // Test removeItem method
//        System.out.println("\nRemoving Product B from the inventory:");
//        boolean removeItemResult = stockManager.removeItem(productB);
//        System.out.println("Remove item result: " + removeItemResult); // Should be true
        
        //Test getMediaProductBelowPrice method
        System.out.println("Here is get price below");
        stockManager.getMediaProductBelowPrice(25);

        // Print the updated inventory
        System.out.println("\nUpdated inventory:");
        for (MediaProduct product : stockManager.getInventory()) {
            System.out.println(product);
        }
        // Convert the inventory List to an ArrayList
        List<MediaProduct> inventoryList = stockManager.getInventory();
        ArrayList<MediaProduct> inventoryArrayList = new ArrayList<>(inventoryList);

        // Test getVinylRecordList method
        ArrayList<VinylRecordProduct> vinylRecordList = stockManager.getVinylRecordList(inventoryArrayList);
        System.out.println("\nVinyl Record List:");
        stockManager.printListOfMediaProduct(vinylRecordList);

        // Test getCDRecordsList method
        ArrayList<CDRecordProduct> cdRecordList = stockManager.getCDRecordsList(inventoryArrayList);
        System.out.println("\nCD Record List:");
        stockManager.printListOfMediaProduct(cdRecordList);

        // Test getTapeRecordList method
        ArrayList<TapeRecordProduct> tapeRecordList = stockManager.getTapeRecordList(inventoryArrayList);
        System.out.println("\nTape Record List:");
        stockManager.printListOfMediaProduct(tapeRecordList);

    }
}

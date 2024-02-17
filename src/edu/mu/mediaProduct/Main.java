package edu.mu.mediaProduct;

import java.util.ArrayList;
import java.util.List;

import edu.mu.products.CDRecordProduct;
import edu.mu.products.Genre;
import edu.mu.products.TapeRecordProduct;
import edu.mu.products.VinylRecordProduct;
import edu.mu.stockManager.StockManagerSingleton;

public class Main {

    public static void main(String[] args) {
        // Create an instance of StockManagerSingleton
        StockManagerSingleton stockManager = StockManagerSingleton.getInstance();
        
        stockManager.printListOfMediaProduct(stockManager.getMediaProductBelowPrice(25));
        System.out.println(" ");
        
        //Create some MediaProduct objects
        MediaProduct productA = new MediaProduct("CD", "Product A", 19.99, 2023, Genre.ROCK);
        MediaProduct productB = new MediaProduct("Vinyl", "Product B", 29.99, 2024, Genre.POP);
        MediaProduct productC = new MediaProduct("Tape", "Product C", 14.99, 2022, Genre.JAZZ);

        // Test adding products to the inventory
        System.out.println("Adding products to the inventory:");
        boolean addItemResult1 = stockManager.addItem(productA);
        boolean addItemResult2 = stockManager.addItem(productB);
        boolean addItemResult3 = stockManager.addItem(productC);
        System.out.println("Add item result 1: " + addItemResult1); // Should be true
        System.out.println("Add item result 2: " + addItemResult2); // Should be true
        System.out.println("Add item result 3: " + addItemResult3); // Should be true
//
        // Test updating the price of Product A
        System.out.println("\nUpdating the price of Product A:");
        boolean updatePriceResult = stockManager.updateItemPrice(productA, 24.99);
        System.out.println("Update price result: " + updatePriceResult); // Should be true
//
//        // Test removing Product B from the inventory
        System.out.println("\nRemoving Product B from the inventory:");
        boolean removeItemResult = stockManager.removeItem(productB);
        System.out.println("Remove item result: " + removeItemResult); // Should be true
//        
        
<<<<<<< Updated upstream
        //Test getMediaProductBelowPrice method
        stockManager.printListOfMediaProduct(stockManager.getMediaProductBelowPrice(25));

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
=======
        // Print ArrayList of Vinyl Record Products
        List<MediaProduct> vinylRecordsList = stockManager.getInventory();
        ArrayList<VinylRecordProduct> vinylRecords = stockManager.getVinylRecordList(vinylRecordsList);
>>>>>>> Stashed changes
        System.out.println("\nVinyl Record List:");
        stockManager.printListOfMediaProduct(vinylRecords);

        // Print ArrayList of CD Record Products
        List<MediaProduct> cdRecordsList = stockManager.getInventory();
        ArrayList<CDRecordProduct> cdRecords = stockManager.getCDRecordsList(cdRecordsList);
        System.out.println("\nCD Record List:");
        stockManager.printListOfMediaProduct(cdRecords);

     // Print ArrayList of Tape Record Products
        List<MediaProduct> tapeRecordsList = stockManager.getInventory();
        ArrayList<TapeRecordProduct> tapeRecords = stockManager.getTapeRecordList(tapeRecordsList);
        System.out.println("\nTape Record List:");
        stockManager.printListOfMediaProduct(tapeRecords);

    }
}

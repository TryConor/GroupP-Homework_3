package edu.mu.stockManager;

import edu.mu.mediaProduct.MediaProduct;
import edu.mu.products.CDRecordProduct;
import edu.mu.products.Genre;
import edu.mu.products.TapeRecordProduct;
import edu.mu.products.VinylRecordProduct;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class StockManagerSingleton {

	private final String inventoryFilePath = "files/inventory.csv";
	private List<MediaProduct> inventory = new ArrayList<>();
	private static StockManagerSingleton instance = null;
	
	
	
	private StockManagerSingleton() {
		
	}
	    // Method to get the singleton instance
	    public static StockManagerSingleton getInstance() {
	        if (instance == null) {
	            instance = new StockManagerSingleton();
	        }
	        return instance;
	}
	
	//reads initial inventory data from CSV file
	//parses csv file to create media product objects
	//adds objects to inventory
	    public boolean initializeStock() {
	        try (Scanner fileReader = new Scanner(new FileInputStream(inventoryFilePath))) {
	            
	        	String dataSkip = fileReader.nextLine();
	        	while (fileReader.hasNextLine()) {
	                String data = fileReader.nextLine();
	          
	                String[] mediaStockValues = data.split(",");
	                if (mediaStockValues.length == 5) {
	                    String type = mediaStockValues[0];
	                    String title = mediaStockValues[1];
	                    double price = Double.parseDouble(mediaStockValues[2]);
	                    int year = Integer.parseInt(mediaStockValues[3]);
	                    String genreString = mediaStockValues[4];

	                    // Validate genreString to prevent null pointer exception
	                    if (genreString != null) {
	                        Genre genre = null;
	                        try {
	                            genre = Genre.valueOf(genreString);
	                        } catch (IllegalArgumentException e) {
	                            System.out.println("Invalid genre: " + genreString);
	                            continue; // Skip this entry
	                        }

	                        // Create MediaProduct based on type
	                        MediaProduct product = null;
	                        switch (type) {
	                            case "CD":
	                                product = new CDRecordProduct(title, price, year, genre);
	                                break;
	                            case "Vinyl":
	                                product = new VinylRecordProduct(title, price, year, genre);
	                                break;
	                            case "Tape":
	                                product = new TapeRecordProduct(title, price, year, genre);
	                                break;
	                            default:
	                                System.out.println("Invalid media type: " + type);
	                                continue; // Skip this entry
	                        }

	                        // Add product to inventory
	                        if (product != null) {
	                            inventory.add(product);
	                        }
	                    } else {
	                        System.out.println("Genre missing for product: " + title);
	                    }
	                } else {
	                    System.out.println("Data is not in the correct format: " + data);
	                }
	            }
	            return true;
	        } catch (IOException e) {
	            System.out.println("Error reading file: " + e.getMessage());
	            return false;
	        }
	    }

	
	//method to get the inventory
    public List<MediaProduct> getInventory() {
        return inventory;
    }
	
	//updates price of given media
 // Updates the price of a given media product in the inventory
    public boolean updateItemPrice(MediaProduct product, double newPrice) {
        // Check if the product is not null
        if (product != null) {
            // Iterate through the inventory to find the product
            for (MediaProduct item : inventory) {
                // Check if the product matches by comparing using the equals method
                if (item.equals(product)) {
                    // Update the price of the matching product
                    item.setPrice(newPrice);
                    // Write the updated inventory to the CSV file
                    if (saveStock()) {
                        return true; // Return true if the update and save operation succeed
                    } else {
                        // Revert the price change if saving fails
                        item.setPrice(product.getPrice());
                        return false; // Return false if saving fails
                    }
                }
            }
        }
        // Return false if the product is not found or null
        return false;
    }



	// Adds new media product to inventory and updates the CSV file
    public boolean addItem(MediaProduct product) {
        // Check if the product is not null
        if (product != null) {
            // Check if a product with the same title already exists in the inventory
            for (MediaProduct item : inventory) {
                if (item.getTitle().equals(product.getTitle())) {
                    // Update the existing product's price and return true
                    item.setPrice(product.getPrice());
                    return true;
                }
            }
            
            // If the product does not exist, add it to the inventory
            inventory.add(product);
            
            // Write the new product to the CSV file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(inventoryFilePath, true))) {
                // Format the product data
                String productData = String.format("%s,%s,%.2f,%d,%s%n", product.getType(), product.getTitle(), 
                        product.getPrice(), product.getYear(), product.getGenre().toString());

                // Write the product data to the CSV file
                writer.write(productData);
            } catch (IOException e) {
                // Handle the IOException
                e.printStackTrace();
                return false; // Return false if writing to the file fails
            }

            // Return true to indicate successful addition
            return true;
        } else {
            // If the product is null, return false to indicate failure
            return false;
        }
    }

	
	//removes given media product from inventory
    public boolean removeItem(MediaProduct product) {
        // Check if the product is not null
        if (product != null) {
            // Iterate through the inventory to find the product
            Iterator<MediaProduct> iterator = inventory.iterator();
            while (iterator.hasNext()) {
                MediaProduct item = iterator.next();
                // Check if the product matches by comparing using the equals method
                if (item.equals(product)) {
                    iterator.remove(); // Remove the product from the inventory
                    // Save the updated inventory to the CSV file
                    saveStock();
                    // Return true to indicate successful removal
                    return true;
                }
            }
        }
        // If the product is not found or null, return false
        return false;
    }


	
	//saves updated inventory back to csv file
    public boolean saveStock() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inventoryFilePath, true))) {
            for (MediaProduct product : inventory) {
                String line = String.format("%s,%s,%.2f,%d,%s", product.getType(), product.getTitle(), product.getPrice(), product.getYear(), product.getGenre().toString());
                writer.write(line);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error writing inventory to CSV file: " + e.getMessage());
            return false;
        }
    }

	
	
	//gets media products that are below given maxPrice and returns MediaProduct ArrayList
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice){
		ArrayList<MediaProduct> belowMaxPriceProducts = new ArrayList<MediaProduct>();
		
		//if inventory isn't empty search for products below max price
		if(inventory.size() !=0) {
			for(MediaProduct product: inventory) {
		        if (product.getPrice()< Double.valueOf(maxPrice)) {    
		        	belowMaxPriceProducts.add(product);
		                }
				}
			}
		else {
			System.out.println("There are no products below the max price of $" + maxPrice);
		}
		return belowMaxPriceProducts;
	}
		
	//prints given media product list
	public void printListOfMediaProduct(List<? extends MediaProduct> productList) {
		for (MediaProduct product : productList) {
			System.out.println(product);
		}
	}

	
	//gets media products as an ArrayList
	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList) {
		ArrayList<VinylRecordProduct> vinylRecordList = new ArrayList<>();
		for (MediaProduct product : productList) {
			if (product instanceof VinylRecordProduct) {
				vinylRecordList.add((VinylRecordProduct) product);
			}
		}
		return vinylRecordList;
	}
	
	//filters CD records and returns ArrayList
	public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList) {
		ArrayList<CDRecordProduct> cdRecordList = new ArrayList<>();
		for (MediaProduct product : productList) {
			if (product instanceof CDRecordProduct) {
				cdRecordList.add((CDRecordProduct) product);
				System.out.println(product.toString());
			}
		}
		return cdRecordList;
	}
	
	//filters tape records
	public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList) {
		ArrayList<TapeRecordProduct> tapeRecordList = new ArrayList<>();
		for (MediaProduct product : productList) {
			if (product instanceof TapeRecordProduct) {
				tapeRecordList.add((TapeRecordProduct) product);
			}
		}
		return tapeRecordList;
	}
}
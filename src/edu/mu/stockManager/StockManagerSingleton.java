package edu.mu.stockManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.mu.mediaProduct.MediaProduct;
import edu.mu.products.CDRecordProduct;
import edu.mu.products.Genre;
import edu.mu.products.TapeRecordProduct;
import edu.mu.products.VinylRecordProduct;

public class StockManagerSingleton {
	
	
	private final String inventoryFilePath = "files/inventory.csv";
		
	private StockManagerSingleton() {
			
	}
	
	//reads initial inventory data from CSV file
	//parses csv file to create media product objects
	//adds objects to inventory
	public boolean initializeStock(String fileName) {	
		try (Scanner fileReader = new Scanner(new FileInputStream(fileName))) {
			while(fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
					
				String[] mediaStockValues = data.split(",");
				if(mediaStockValues.length == 5) {
					String type = mediaStockValues[0];
					String title = mediaStockValues[1];
					double price = Double.parseDouble(mediaStockValues[2]);
					int year = Integer.parseInt(mediaStockValues[3]);
					String genreString =mediaStockValues[4];
					//how should I convert this string to an enum??
					//switch case? I might change this to a series of if/else if			
					switch(genreString) {
						case "ROCK":
							Genre genre = Genre.ROCK;
							MediaProduct product = new MediaProduct(title, price, year, Genre.ROCK);
							break;
						case "POP":
							MediaProduct product1 = new MediaProduct(title, price, year, Genre.POP);
							break;
						case "JAZZ":
							MediaProduct product2 = new MediaProduct(title, price, year, Genre.JAZZ);
							break;
						case "CLASSICAL":
							MediaProduct product3 = new MediaProduct(title, price, year, Genre.CLASSICAL);
							break;
						case "HIP_HOP":
							MediaProduct product4 = new MediaProduct(title, price, year, Genre.HIP_HOP);
							break;
						case "ELECTRONIC":								
							MediaProduct product5 = new MediaProduct(title, price, year, Genre.ELECTRONIC);
							break;
						case "CHILDREN":
							MediaProduct product6 = new MediaProduct(title, price, year, Genre.CHILDREN);
							break;
						
						default:
							
							break;
					}
						
							
					
						
					}
					else {
						System.out.println("Data is not in the correct format, individual data could not be read");
					}
				}
			}
			catch(IOException e){
				System.out.println("Error: "+ e);
			}
			
		
			return true;
	}
	
	//updates price of given media
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
		return true;
	}
	
	//adds new media product to inventory
	public boolean addItem(MediaProduct product) {
		return true;
	}
	
	//removes given media product from inventory
	public boolean removeItem(MediaProduct product) {
		return true;
	}
	
	//saves updated inventory back to csv file
	public boolean saveStock() {
		return true;
	}
	
	
	//gets media products that are below given maxPrice
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice){
		return null;
	}
	
	//prints given media product list
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
		
	}
	
	//gets media products as an ArrayList
	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList){
		return null;
	}
	
	//filters CD records and returns ArrayList
	public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList){
		return null;
	}
	
	//filters tape records
	public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList){
		return null;
	}
	
}

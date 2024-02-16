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
